package com.gceylan.rentacar.client;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.Car;
import com.gceylan.rentacar.domain.Rental;
import com.gceylan.rentacar.domain.ServicePoint;
import com.gceylan.rentacar.service.BranchService;
import com.gceylan.rentacar.service.CarService;
import com.gceylan.rentacar.service.RentalService;
import com.gceylan.rentacar.service.ServicePointService;
import com.gceylan.rentacar.util.CustomerInformationForRental;
import com.gceylan.rentacar.util.MailService;

@Controller
@SessionAttributes("rental")
public class ClientController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private RentalService rentalService;
	
	@Autowired
	private ServicePointService servicePointService;
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private MailService mailService;
	
	SecureRandom random = new SecureRandom();

	@RequestMapping(value = { "/", "/main" }, method = RequestMethod.GET)
	public String clientIndex(HttpSession session, ModelMap model) {
		Rental rental = (Rental) session.getAttribute("rental");

		if (rental == null) {
			rental = new Rental();
			String resCode = new BigInteger(130, random).toString(32).substring(0, 8).toUpperCase();
			rental.setReservationCode(resCode);
			System.out.println("resCode: " + resCode);

			model.addAttribute("rental", rental);
		}
		
		model.addAttribute("servicePoints", getAllServicePoints());

		return "client/main";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchCar(
			@RequestParam("pickupLocationId") Integer pickupLocationId,
			@RequestParam("returnLocationId") Integer returnLocationId,
			@RequestParam("pickupDateString") String pickupDateString,
			@RequestParam("returnDateString") String returnDateString,
			HttpSession session, ModelMap model, final RedirectAttributes redirectAttributes) {

		if (pickupLocationId < 0 || returnLocationId < 0
				|| pickupDateString.length() == 0
				|| returnDateString.length() == 0) {
			redirectAttributes.addFlashAttribute("message", "Bilgileri Eksiksiz Girin!");
			return "redirect:/";
		}
		
		Rental rental = (Rental) session.getAttribute("rental");

		System.out.println(" Alýþ Tarihi: " + pickupDateString);
		System.out.println("Dönüþ Tarihi: " + returnDateString);
		System.out.println("   Alýþ Yeri: " + servicePointService.getServicePointById(pickupLocationId));
		System.out.println("  Dönüþ Yeri: " + servicePointService.getServicePointById(returnLocationId));

		pickupDateString = pickupDateString.substring(0, 17) + "00";
		returnDateString = returnDateString.substring(0, 17) + "00";

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date pickupDate = formatter.parse(pickupDateString);
			Date returnDate = formatter.parse(returnDateString);

			if (pickupDate.compareTo(returnDate) > 0 || pickupDate.compareTo(returnDate) == 0) {
				redirectAttributes.addFlashAttribute("message",
					"Hatalý girdi! Teslim Tarihi Alýþ Tarihinden daha önce bir tarih olmak zorunda!");
				return "redirect:/";
			}
			
			ServicePoint pickupLocation = servicePointService.getServicePointById(pickupLocationId);
			ServicePoint returnLocation = servicePointService.getServicePointById(returnLocationId);
			
			/* önemli ilk 7 bilgi set edildi */
			rental.setPickupDate(pickupDate);
			rental.setReturnDate(returnDate);
			rental.setPickupLocation(pickupLocation);
			rental.setReturnLocation(returnLocation);
			rental.setPickupLocationBranch(pickupLocation.getBranch());
			rental.setReturnLocationBranch(returnLocation.getBranch());
			rental.setReservationDate(new Date());
			
			/*
			 * kiralamaya uygun araçlarýn listesini requeste ekle
			 * */
			List<Car> rentableCarList = carService.getAvailableCarForRental(
					servicePointService.getServicePointById(pickupLocationId).getBranch(),
					servicePointService.getServicePointById(returnLocationId).getBranch(),
					pickupDate, returnDate);
			
			model.addAttribute("rentableCarList", rentableCarList);
			model.addAttribute("servicePoints", getAllServicePoints());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "client/car-select";
	}
	
	@RequestMapping(value = "/car/{carId}", method = RequestMethod.GET)
	public String selectCar(@PathVariable("carId") Integer carId, 
			HttpSession session, ModelMap model) {
		
		Rental rental = (Rental) session.getAttribute("rental");
		
		rental.setCar(carService.getCarById(carId));
		
		return "redirect:/customer-information";
	}
	
	@RequestMapping(value = "/customer-information", method = RequestMethod.GET)
	public String showCustomerInfPage(ModelMap model) {
		/* son aþamada müþteri bilgilerini al */
		model.addAttribute("customerInf", new CustomerInformationForRental());
		model.addAttribute("servicePoints", getAllServicePoints());
		return "client/customer-information";
	}
	
	@RequestMapping(value = "/add-rental", method = RequestMethod.POST)
	public String addRental(@ModelAttribute("customerInf") @Valid CustomerInformationForRental custInf, 
			BindingResult result, ModelMap model, 
			HttpSession session, final RedirectAttributes redirectAttributes) {
		
		/* bu kontrol tüm client iþlemlerinde gerekli */
		if (session.getAttribute("rental") == null)
			return "redirect:/";
		
		if (result.hasErrors())
			return "client/customer-information";
		
		Rental r = (Rental) session.getAttribute("rental");
		
		/* kiralama tamamlandýktan sonra geri gelip, tekrar kirala yapýlýrsa, toslasýn */
		if (r.getCar() != null && r.getPickupLocation() != null) {
		
			r.setCustomerName(custInf.getName());
			r.setCustomerSurname(custInf.getSurname());
			r.setCustomerPhone(custInf.getPhone());
			r.setCustomerEmail(custInf.getEmail());
			r.setAddressDetail(custInf.getAddress());
			
			rentalService.addRental(r);
			
			StringBuffer message = new StringBuffer();
			message.append("<p>Sayýn, <b>" + r.getCustomerName() + " " + r.getCustomerSurname() + "</b></p>");
			message.append(r.getPickupDate() + " - " + r.getReturnDate() + " tarihleri arasýndaki ");
			message.append(r.getPickupLocation().getName() + " - " + r.getReturnLocation().getName() + " rezervasyonunuz ");
			message.append(" iletilmiþtir. En kýsa sürede onayýmýzdan geçip, rezervasyon kodunuz size iletilecektir.");
			message.append("<p>Ýyi günler dileriz...</p>");
			
//			mailService.sendMail("gokhan.ceylan@bil.omu.edu.tr", "gokhan.ceylan@bil.omu.edu.tr", "test", message.toString());
			
			redirectAttributes.addFlashAttribute("rentalInf", r);
			
			System.out.println("Kiralama tamamlandý!");
			session.invalidate();
		}
		
		/* her halükarda session ý öldür, ayný kayýtýn eklenmesini önler*/
//		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/cancel-reservation", method = RequestMethod.POST)
	public @ResponseBody void cancelReservation(@RequestParam("resCode") String resCode, 
			HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("text/html");
		
		StringBuffer sb = new StringBuffer();
		
		if (resCode.trim().length() != 0) {
			Rental res = rentalService.getRentalByReservationCode(resCode);
			
			if (res != null) {
				rentalService.deleteRental(res.getId());
				sb.append("Sayýn <b>" + res.getCustomerName() + " " + res.getCustomerSurname() + "</b>,<br>");
				sb.append(res.getPickupDate() + " tarihine yapmýþ olduðunuz rezervasyon <b>iptal edilmiþtir.</b>");
			}
		}
		
		response.getWriter().write((sb.toString().length() != 0) ? sb.toString() : "Böyle bir rezervasyon yok!");
	}
	
	private Map<Branch, List<ServicePoint>> getAllServicePoints() {
		Map<Branch, List<ServicePoint>> branchServicePoints = new HashMap<Branch, List<ServicePoint>>();
		
		for (Branch b : branchService.getAllBranchs()) {
			List<ServicePoint> bServPoints = servicePointService.getAllServicePoints(b);
			branchServicePoints.put(b, bServPoints);
		}
		
		return branchServicePoints;
	}
	
	public void setCarService(CarService carService) {
		this.carService = carService;
	}
	
	public void setRentalService(RentalService rentalService) {
		this.rentalService = rentalService;
	}
	
	public void setServicePointService(ServicePointService servicePointService) {
		this.servicePointService = servicePointService;
	}
	
	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}
	
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
}