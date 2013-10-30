package com.gceylan.rentacar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gceylan.rentacar.domain.Location;
import com.gceylan.rentacar.service.LocationService;

@Controller
@RequestMapping("/admin/locations")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showAllLocations(ModelAndView model) {
		return new ModelAndView("admin/locations/list", "locations", 
				locationService.getAllLocations());
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newLocation(ModelMap model) {
		model.addAttribute("location", new Location());
		return "admin/locations/new";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addLocation(@Valid Location location, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			return "admin/locations/new";
		}
		
		locationService.addLocation(location);
		return "redirect:/admin/locations/list";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editLocationPage(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("location", locationService.getLocationById(id));
		return "admin/locations/edit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editLocation(@PathVariable("id") Integer id, @Valid Location location, BindingResult result) {
		
		if (result.hasErrors()) {
			return "admin/locations/edit";
		}
		
		locationService.updateLocation(location);
		
		return "redirect:/admin/locations/list";
	}
	
	@RequestMapping(value = "/delete/{locationId}", method = RequestMethod.GET)
	public String deleteLocation(@PathVariable("locationId") Integer locationId) {
		locationService.deleteLocation(locationId);
		return "redirect:/admin/locations/list";
	}
	
	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

}
