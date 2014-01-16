package com.gceylan.rentacar.branch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.Car;
import com.gceylan.rentacar.domain.Rental;
import com.gceylan.rentacar.domain.ServicePoint;
import com.gceylan.rentacar.service.CarService;
import com.gceylan.rentacar.service.RentalService;
import com.gceylan.rentacar.service.ServicePointService;

@Controller
@RequestMapping("/branch/reservations")
public class ReservationController {
	
	@Autowired
	private RentalService rentalService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private ServicePointService servicePointService;

	@RequestMapping(value = "/not-confirmed", method = RequestMethod.GET)
	public String notConfirmedReservationsPage(ModelMap model) {
		return "branch/reservations/not-confirmed";
	}
	
	@RequestMapping(value = "/json-not-confirmed", method = RequestMethod.GET, 
			produces="application/json;charset=utf-8")
	public @ResponseBody List<Rental> getNotConfirmedReservations(HttpSession session) {
		Branch branch = (Branch) session.getAttribute("branch");
		List<Rental> reservations = rentalService.getAllConfirmedAndCompleted(branch.getId(), false, false);
		return reservations;
	}
	
	@RequestMapping(value = "/confirmed", method = RequestMethod.GET)
	public String confirmedReservationPage(ModelMap model) {
		return "branch/reservations/confirmed";
	}
	
	@RequestMapping(value = "/json-confirmed", method = RequestMethod.GET,
			produces="application/json;charset=utf-8")
	public @ResponseBody List<Rental> getConfirmedReservations(HttpSession session) {
		Branch branch = (Branch) session.getAttribute("branch");
		return rentalService.getNotCompletedRentals(branch.getId());
	}
	
	@RequestMapping(value = "/completed", method = RequestMethod.GET)
	public String complatedRentalPage(ModelMap model) {
		return "branch/reservations/completed";
	}
	
	@RequestMapping(value = "/json-completed", method = RequestMethod.GET,
			produces="application/json;charset=utf-8")
	public @ResponseBody List<Rental> getComplatedRentals(HttpSession session) {
		Branch branch = (Branch) session.getAttribute("branch");
		return rentalService.getAllConfirmedAndCompleted(branch.getId(), true, true);
	}
	
	@RequestMapping(value = "/now-doing", method = RequestMethod.GET)
	public String nowDoingRentalPage(ModelMap model) {
		return "branch/reservations/now-doing";
	}
	
	@RequestMapping(value = "/json-now-doing", method = RequestMethod.GET,
			produces="application/json;charset=utf-8")
	public @ResponseBody List<Rental> getNowDoingRentals(HttpSession session) {
		Branch branch = (Branch) session.getAttribute("branch");
		return rentalService.getNowDoingRentals(branch.getId());
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public @ResponseBody void deleteReservation(@PathVariable int id) {
		rentalService.deleteRental(id);
	}
	
	@RequestMapping(value="/confirm/{id}", method=RequestMethod.GET)
	public @ResponseBody void confirmReservation(@PathVariable int id) {
		Rental res = rentalService.getRentalById(id);
		res.setConfirmed(true);
		rentalService.updateRental(res);
	}
	
	@RequestMapping(value="/complete/{id}", method=RequestMethod.GET)
	public @ResponseBody void completeReservation(@PathVariable int id) {
		Rental res = rentalService.getRentalById(id);
		res.setCompleted(true);
		rentalService.updateRental(res);
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editReservation(@PathVariable int id, @RequestParam("from") String fromPath,
			HttpSession session, ModelMap model) {
		
		Rental rental = rentalService.getRentalById(id);
		Branch branch = (Branch) session.getAttribute("branch");
		
		model.addAttribute("rental", rental);
		model.addAttribute("locations", servicePointService.getAllServicePoints());

		List<Car> rentableCarList = carService.getAvailableCarForRental(branch, rental.getReturnLocationBranch(), rental.getPickupDate(), rental.getReturnDate());
		rentableCarList.add(rental.getCar());
		
//		/* müþterinin seçtiði tarihler arasýndaki, diðer müsait araçlarý getir */
		model.addAttribute("cars", rentableCarList);
		model.addAttribute("from", fromPath);
		return "branch/reservations/edit";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
	public String editRental(@PathVariable int id,
			@RequestParam("pickupLocationId") Integer pickupLocationId,
			@RequestParam("returnLocationId") Integer returnLocationId,
			@RequestParam("pickupDateString") String pickupDateString,
			@RequestParam("returnDateString") String returnDateString,
			@RequestParam("selectedCarId") int selectedCarId, 
			@RequestParam("path") String path, 
			HttpServletRequest req, HttpServletResponse resp, final RedirectAttributes redirectAttributes) {
		
		Rental rentalToUpdate = rentalService.getRentalById(id);
		
		if (pickupLocationId < 0 || returnLocationId < 0
				|| pickupDateString.length() == 0
				|| returnDateString.length() == 0) {
			redirectAttributes.addFlashAttribute("message", "Bilgileri Eksiksiz Girin!");
			return "redirect:/branch/reservations/edit/" + id + "?from=" + path;
		}
		
		pickupDateString = pickupDateString.substring(0, 17) + "00";
		returnDateString = returnDateString.substring(0, 17) + "00";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date pickupDate = formatter.parse(pickupDateString);
			Date returnDate = formatter.parse(returnDateString);

			if (pickupDate.compareTo(returnDate) > 0 || pickupDate.compareTo(returnDate) == 0) {
				redirectAttributes.addFlashAttribute("message",
					"Hatalý girdi! Teslim Tarihi Alýþ Tarihinden daha önce bir tarih olmak zorunda!");
				return "redirect:/branch/reservations/edit/" + id + "?from=" + path;
			}
			
			ServicePoint pickupLocation = servicePointService.getServicePointById(pickupLocationId);
			ServicePoint returnLocation = servicePointService.getServicePointById(returnLocationId);
			
			/* önemli ilk 7 bilgi set edildi */
			rentalToUpdate.setPickupDate(pickupDate);
			rentalToUpdate.setReturnDate(returnDate);
			rentalToUpdate.setPickupLocation(pickupLocation);
			rentalToUpdate.setReturnLocation(returnLocation);
			rentalToUpdate.setPickupLocationBranch(pickupLocation.getBranch());
			rentalToUpdate.setReturnLocationBranch(returnLocation.getBranch());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (rentalToUpdate.getCar().getId() != selectedCarId) {

			/* þu id li araç, þu þu tarihlerde kiralamaya müsait mi ? */
			Car c = carService.isAvailableForRental(selectedCarId, rentalToUpdate.getPickupDate(), rentalToUpdate.getReturnDate());
			
			if (c == null) {
				redirectAttributes.addFlashAttribute("message", "Araç Deðiþtirilemedi! Kiralama Güncellenemedi!"
						+ " Seçilen Aracýn Girilen Tarihler arasýnda baþka bir kiralamasý var!");
				
				return "redirect:/branch/reservations/edit/" + id + "?from=" + path;
			}
			
			rentalToUpdate.setCar(c);
		}
		
		rentalService.updateRental(rentalToUpdate);
		
		/*
		 * admin hangi sayfadan geldiyse, ona geri dön
		 * bu metodu 2 sayfa çaðýrabilir
		 * path: gideceðim sayfa url'i
		 * */
		
		return "redirect:/" + path;
	}
	
	@RequestMapping(value = "/alerts", method = RequestMethod.GET, 
			produces="application/json;charset=utf-8")
	public @ResponseBody List<Rental> alerts(HttpSession session) {
		Branch branch = (Branch) session.getAttribute("branch");
		List<Rental> reservations = rentalService.getNotCompletedRentals(branch.getId());
		return reservations;
	}
	
	public void setRentalService(RentalService rentalService) {
		this.rentalService = rentalService;
	}
	
	public void setCarService(CarService carService) {
		this.carService = carService;
	}
	
	public void setServicePointService(ServicePointService servicePointService) {
		this.servicePointService = servicePointService;
	}
	
}
