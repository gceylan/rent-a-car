package com.gceylan.rentacar;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * Tiles Test
	 * */
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminRedirect() {
		return "redirect:/admin/main";
	}
	
	@RequestMapping(value = "/admin/main", method = RequestMethod.GET)
	public String adminPage() {
		return "admin/main";
	}
	
	@RequestMapping(value = "/admin/charts", method = RequestMethod.GET)
	public String adminCharts() {
		return "admin/charts";
	}
	
	@RequestMapping(value = "/admin/tables", method = RequestMethod.GET)
	public String adminTables() {
		return "admin/tables";
	}
	
	@RequestMapping(value = "/admin/forms", method = RequestMethod.GET)
	public String adminForms() {
		return "admin/forms";
	}
	
	@RequestMapping(value = "/admin/typography", method = RequestMethod.GET)
	public String adminTypography() {
		return "admin/typography";
	}
	
	@RequestMapping(value = "/admin/bootstrap-elements", method = RequestMethod.GET)
	public String adminBootstrapElements() {
		return "admin/bootstrap-elements";
	}
	
	@RequestMapping(value = "/admin/bootstrap-grid", method = RequestMethod.GET)
	public String adminBootstrapGrid() {
		return "admin/bootstrap-grid";
	}
	
	@RequestMapping(value = "/admin/blank-page", method = RequestMethod.GET)
	public String adminBlankPage() {
		return "admin/blank-page";
	}
}
