package com.gceylan.rentacar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginLogoutController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage() {
		return "login";
	}
	
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginFailed(ModelMap model) {
		model.addAttribute("error", true);
		return "login";
	}
	
	@RequestMapping(value = "/error/403", method = RequestMethod.GET)
	public String accessDenied() {
		return "error/403";
	}

}
