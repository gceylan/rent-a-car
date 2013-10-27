package com.gceylan.rentacar;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/admin")
@SessionAttributes("navigation")
public class AdminController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String adminRedirect(ModelMap model, HttpSession session) {
		return "redirect:/admin/main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		
		return "admin/main";
	}
	
	@RequestMapping(value = "/charts", method = RequestMethod.GET)
	public String adminCharts(ModelMap model) {
		return "admin/charts";
	}
	
	@RequestMapping(value = "/tables", method = RequestMethod.GET)
	public String adminTables(ModelMap model) {
		return "admin/tables";
	}
	
	@RequestMapping(value = "/forms", method = RequestMethod.GET)
	public String adminForms(ModelMap model) {
		return "admin/forms";
	}
	
	@RequestMapping(value = "/typography", method = RequestMethod.GET)
	public String adminTypography(ModelMap model) {
		return "admin/typography";
	}
	
	@RequestMapping(value = "/bootstrap-elements", method = RequestMethod.GET)
	public String adminBootstrapElements(ModelMap model) {
		return "admin/bootstrap-elements";
	}
	
	@RequestMapping(value = "/bootstrap-grid", method = RequestMethod.GET)
	public String adminBootstrapGrid(ModelMap model) {
		return "admin/bootstrap-grid";
	}
	
	@RequestMapping(value = "/blank-page", method = RequestMethod.GET)
	public String adminBlankPage(ModelMap model) {
		return "admin/blank-page";
	}

}
