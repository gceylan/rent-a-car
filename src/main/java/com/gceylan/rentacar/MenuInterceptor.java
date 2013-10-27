package com.gceylan.rentacar;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gceylan.rentacar.util.Menu;
import com.gceylan.rentacar.util.Navigation;
import com.gceylan.rentacar.util.SubMenu;

public class MenuInterceptor implements HandlerInterceptor {

	ArrayList<Navigation> navigations = null;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// System.out.println("Pre-handle");

		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		String uri = request.getRequestURI();

		if (uri.contains("/admin")) {
			request.setAttribute("test", "gceylan");

			if (request.getSession().getAttribute("navigation") == null) {
				navigations = new ArrayList<Navigation>();

				Menu m1 = new Menu(
						"icon-dashboard",
						"Dashboard",
						"Statistics Overview",
						"Welcome to SB Admin by Start Bootstrap! Feel free to use this template for your admin needs! We are using a few different plugins to handle the dynamic tables and charts, so make sure you check out the necessary documentation links provided.",
						"admin/main");
				Menu m2 = new Menu(
						"icon-bar-chart",
						"Charts",
						"Display Your Data",
						"There are two options for charts: Flot charts and morris.js. Choose which one best suits your needs, and make sure to master the documentation to get the most out of these charts!",
						"admin/charts");
				Menu m3 = new Menu(
						"icon-table",
						"Tables",
						"Sort Your Data",
						"We're using Tablesorter 2.0 for the sort function on the tables. Read the documentation for more customization options or feel free to use something else!",
						"admin/tables");
				Menu m4 = new Menu(
						"icon-edit",
						"Forms",
						"Enter Your Data",
						"Visit Bootstrap's Form Documentation for more information.",
						"admin/forms");
				Menu m5 = new Menu(
						"icon-font",
						"Typography",
						"Text and Headers",
						"Visit Bootstrap's Typography Documentation for more information.",
						"admin/typography");
				Menu m6 = new Menu(
						"icon-desktop",
						"Bootstrap Elements",
						"Built-In Bootstrap Elements",
						"Start Bootstrap recommends that you have an in-depth understanding of the Bootstrap framework before working with this template. Visit http://getbootstrap.com/ for complete documentation.",
						"admin/bootstrap-elements");
				Menu m7 = new Menu(
						"icon-wrench",
						"Bootstrap Grid",
						"Built-In Bootstrap Grid",
						"Be sure to visit Bootstrap's grid documentation for more information.",
						"admin/bootstrap-grid");
				Menu m8 = new Menu("icon-file-alt", "Blank Page",
						"A Blank Slate", "", "admin/blank-page");

				Navigation nav1 = new Navigation(m1, new ArrayList<SubMenu>());
				Navigation nav2 = new Navigation(m2, new ArrayList<SubMenu>());
				Navigation nav3 = new Navigation(m3, new ArrayList<SubMenu>());
				Navigation nav4 = new Navigation(m4, new ArrayList<SubMenu>());
				Navigation nav5 = new Navigation(m5, new ArrayList<SubMenu>());
				Navigation nav6 = new Navigation(m6, new ArrayList<SubMenu>());
				Navigation nav7 = new Navigation(m7, new ArrayList<SubMenu>());
				Navigation nav8 = new Navigation(m8, new ArrayList<SubMenu>());

				navigations.add(nav1);
				navigations.add(nav2);
				navigations.add(nav3);
				navigations.add(nav4);
				navigations.add(nav5);
				navigations.add(nav6);
				navigations.add(nav7);
				navigations.add(nav8);
				
				Navigation selectedNav = navigations.get(0);
				
				for (Navigation nav : navigations) {
					if (uri.contains(nav.getMenu().getUrl())) {
						selectedNav = navigations.get(navigations.indexOf(nav));
					}
				}
				
				request.setAttribute("selectedNav", selectedNav);
				request.setAttribute("navigations", navigations);
			}
		}

		// System.out.println("Post-handle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// System.out.println("After completion handle");
	}

}
