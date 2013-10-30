package com.gceylan.rentacar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/locations")
public class LocationController {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showAllLocations(ModelAndView model) {
		return new ModelAndView("admin/locations/list");
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newLocation(ModelAndView model) {
		return new ModelAndView("admin/locations/new");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editLocationPage(ModelAndView model) {
		return new ModelAndView("admin/locations/edit");
	}

}
