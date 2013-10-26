package com.gceylan.rentacar;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gceylan.rentacar.util.Menu;
import com.gceylan.rentacar.util.Navigation;
import com.gceylan.rentacar.util.SubMenu;

@Controller
@RequestMapping("/admin")
@SessionAttributes("navigation")
public class AdminController {
	
	ArrayList<Navigation> navigation = null;
	
	/**
	 * Tiles Test
	 * */
	
	@RequestMapping(method = RequestMethod.GET)
	public String adminRedirect(ModelMap model, HttpSession session) {
		
		/*
		 * menüler statik
		 * 
		 * */
		
		if (session.getAttribute("navigation") == null) {
			navigation = new ArrayList<Navigation>();
			
			Menu m1 = new Menu("icon-dashboard", "Dashboard", "Statistics Overview", "Welcome to SB Admin by Start Bootstrap! Feel free to use this template for your admin needs! We are using a few different plugins to handle the dynamic tables and charts, so make sure you check out the necessary documentation links provided.", "main");
			Menu m2 = new Menu("icon-bar-chart", "Charts", "Display Your Data", "There are two options for charts: Flot charts and morris.js. Choose which one best suits your needs, and make sure to master the documentation to get the most out of these charts!", "charts");
			Menu m3 = new Menu("icon-table", "Tables", "Sort Your Data", "We're using Tablesorter 2.0 for the sort function on the tables. Read the documentation for more customization options or feel free to use something else!", "tables");
			Menu m4 = new Menu("icon-edit", "Forms", "Enter Your Data", "Visit Bootstrap's Form Documentation for more information.", "forms");
			Menu m5 = new Menu("icon-font", "Typography", "Text and Headers", "Visit Bootstrap's Typography Documentation for more information.", "typography");
			Menu m6 = new Menu("icon-desktop", "Bootstrap Elements", "Built-In Bootstrap Elements", "Start Bootstrap recommends that you have an in-depth understanding of the Bootstrap framework before working with this template. Visit http://getbootstrap.com/ for complete documentation.", "bootstrap-elements");
			Menu m7 = new Menu("icon-wrench", "Bootstrap Grid", "Built-In Bootstrap Grid", "Be sure to visit Bootstrap's grid documentation for more information.", "bootstrap-grid");
			Menu m8 = new Menu("icon-file-alt", "Blank Page", "A Blank Slate", "", "blank-page");
			
			Navigation nav1 = new Navigation(m1, new ArrayList<SubMenu>());
			Navigation nav2 = new Navigation(m2, new ArrayList<SubMenu>());
			Navigation nav3 = new Navigation(m3, new ArrayList<SubMenu>());
			Navigation nav4 = new Navigation(m4, new ArrayList<SubMenu>());
			Navigation nav5 = new Navigation(m5, new ArrayList<SubMenu>());
			Navigation nav6 = new Navigation(m6, new ArrayList<SubMenu>());
			Navigation nav7 = new Navigation(m7, new ArrayList<SubMenu>());
			Navigation nav8 = new Navigation(m8, new ArrayList<SubMenu>());
			
			navigation.add(nav1);
			navigation.add(nav2);
			navigation.add(nav3);
			navigation.add(nav4);
			navigation.add(nav5);
			navigation.add(nav6);
			navigation.add(nav7);
			navigation.add(nav8);
			
			model.addAttribute("navigation", navigation);
		}
		
		return "redirect:/admin/main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		Navigation selectedNav = navigation.get(0);
		model.addAttribute("selectedNav", selectedNav);
		
		return "admin/main";
	}
	
	@RequestMapping(value = "/charts", method = RequestMethod.GET)
	public String adminCharts(ModelMap model) {
		Navigation selectedNav = navigation.get(1);
		model.addAttribute("selectedNav", selectedNav);
		
		return "admin/charts";
	}
	
	@RequestMapping(value = "/tables", method = RequestMethod.GET)
	public String adminTables(ModelMap model) {
		Navigation selectedNav = navigation.get(2);
		model.addAttribute("selectedNav", selectedNav);
		
		return "admin/tables";
	}
	
	@RequestMapping(value = "/forms", method = RequestMethod.GET)
	public String adminForms(ModelMap model) {
		Navigation selectedNav = navigation.get(3);
		model.addAttribute("selectedNav", selectedNav);
		
		return "admin/forms";
	}
	
	@RequestMapping(value = "/typography", method = RequestMethod.GET)
	public String adminTypography(ModelMap model) {
		Navigation selectedNav = navigation.get(4);
		model.addAttribute("selectedNav", selectedNav);
		
		return "admin/typography";
	}
	
	@RequestMapping(value = "/bootstrap-elements", method = RequestMethod.GET)
	public String adminBootstrapElements(ModelMap model) {
		Navigation selectedNav = navigation.get(5);
		model.addAttribute("selectedNav", selectedNav);
		
		return "admin/bootstrap-elements";
	}
	
	@RequestMapping(value = "/bootstrap-grid", method = RequestMethod.GET)
	public String adminBootstrapGrid(ModelMap model) {
		Navigation selectedNav = navigation.get(6);
		model.addAttribute("selectedNav", selectedNav);
		
		return "admin/bootstrap-grid";
	}
	
	@RequestMapping(value = "/blank-page", method = RequestMethod.GET)
	public String adminBlankPage(ModelMap model) {
		Navigation selectedNav = navigation.get(7);
		model.addAttribute("selectedNav", selectedNav);
		
		return "admin/blank-page";
	}

}
