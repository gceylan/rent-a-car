package com.gceylan.rentacar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gceylan.rentacar.service.LocationService;

@Controller
public class ClientController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String clientIndex(ModelMap model) {
		model.addAttribute("locations", locationService.getAllLocations());

		return "client/index";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchCar(ModelMap model) {

		return "client/index";
	}
	
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

}
