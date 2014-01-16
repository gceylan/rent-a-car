package com.gceylan.rentacar.branch;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.ServicePoint;
import com.gceylan.rentacar.service.ServicePointService;

@Controller
@RequestMapping("/branch/service-points")
public class ServicePointController {

	@Autowired
	private ServicePointService servicePointService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showAllServicePoint(HttpSession session, Model model) {
		Branch branch = (Branch) session.getAttribute("branch");
		
		model.addAttribute("allServicePoints", servicePointService.getAllServicePoints(branch));
		
		return "branch/service-points/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newServicePoint(ModelMap model) {
		model.addAttribute("servicePoint", new ServicePoint());
		return "branch/service-points/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addServicePoint(@Valid ServicePoint servicePoint,
			BindingResult result, ModelMap model, HttpSession session) {

		if (result.hasErrors()) {
			return "branch/service-points/new";
		}
		
		Branch branch = (Branch) session.getAttribute("branch");
		servicePoint.setBranch(branch);
		servicePointService.addServicePoint(servicePoint);
		
		return "redirect:/branch/service-points/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editServicePointPage(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("servicePoint", servicePointService.getServicePointById(id));
		return "branch/service-points/edit";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editServicePoint(@Valid ServicePoint servicePoint, BindingResult result, 
			@PathVariable("id") Integer id, HttpSession session) {

		if (result.hasErrors()) {
			return "branch/service-points/edit";
		}
		
		Branch branch = (Branch) session.getAttribute("branch");
		servicePoint.setBranch(branch);
		servicePointService.updateServicePoint(servicePoint);

		return "redirect:/branch/service-points/list";
	}

	@RequestMapping(value = "/delete/{servicePointId}", method = RequestMethod.GET)
	public String deleteServicePoint(@PathVariable("servicePointId") Integer servicePointId) {
		servicePointService.deleteServicePoint(servicePointId);
		return "redirect:/branch/service-points/list";
	}

	public void setServicePointService(ServicePointService servicePointService) {
		this.servicePointService = servicePointService;
	}
}
