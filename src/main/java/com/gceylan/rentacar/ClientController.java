package com.gceylan.rentacar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gceylan.rentacar.domain.Rental;
import com.gceylan.rentacar.service.LocationService;

@Controller
public class ClientController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String clientIndex(ModelMap model) {
		
		model.addAttribute("rental", new Rental());
		model.addAttribute("locations", locationService.getAllLocations());

		return "client/index";
	}
	
	/*
	 * asagidaki request param ları bir class ile alip, validation yaptır
	 * 1. form, uygun arac bul, 2. form müsteri bilgileri al 
	 * 
	 * */
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchCar(@RequestParam("pickupLocationId") Integer pickupLocationId,
			@RequestParam("returnLocationId") Integer returnLocationId, 
			@RequestParam("pickupDateString") String pickupDateString, 
			@RequestParam("returnDateString") String returnDateString, 
			@ModelAttribute("rental") Rental rental, BindingResult result, 
			ModelMap model) {
		
		if (pickupLocationId < 0 || returnLocationId < 0)
			return "redirect:/";
		
		if (result.hasErrors())
			return "client/index";
		
		System.out.println(" Alış Tarihi: " + pickupDateString);
		System.out.println("Dönüş Tarihi: " + returnDateString);
		System.out.println("   Alış Yeri: " + locationService.getLocationById(pickupLocationId));
		System.out.println("  Dönüş Yeri: " + locationService.getLocationById(returnLocationId));
		
		return "redirect:/";
	}
	
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

}
