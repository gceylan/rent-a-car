package com.gceylan.rentacar.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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

		// example uri: /rentacar/admin/users/list
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
				Menu users = new Menu(
						"icon-user",
						"Kullanıcılar",
						"Tüm Kullanıcılar",
						"Yeni Kullanıcı Ekle/Sil/Güncelle",
						"admin/users/list"
						);
				Menu locations = new Menu(
						"icon-road",
						"Hizmet Noktaları",
						"Tüm Hizmet Noktaları",
						"Yeni Hizmet Noktası Ekle/Sil/Güncelle",
						"admin/locations/list"
						);
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
				
				// kullanıcılar menüsü
				ArrayList<SubMenu> navUserSubMenus = new ArrayList<SubMenu>();
				navUserSubMenus.add(new SubMenu("", "Yeni Kullanıcı Ekle", "admin/users/new"));
				navUserSubMenus.add(new SubMenu("", "Kullanıcı Güncelle", "admin/users/edit"));
				navUserSubMenus.add(new SubMenu("", "Profil Bilgileri", "admin/users/profil"));
				
				Navigation navUsers = new Navigation(users, navUserSubMenus);
				
				// hizmet noktaları menüsü
				ArrayList<SubMenu> navLocationSubMenus = new ArrayList<SubMenu>();
				navLocationSubMenus.add(new SubMenu("", "Yeni Hizmet Noktası Ekle", "admin/locations/new"));
				navLocationSubMenus.add(new SubMenu("", "Hizmet Noktası Güncelle", "admin/locations/edit"));
				
				Navigation navLocations = new Navigation(locations, navLocationSubMenus);
				
				Navigation nav2 = new Navigation(m2, new ArrayList<SubMenu>());
				Navigation nav3 = new Navigation(m3, new ArrayList<SubMenu>());
				Navigation nav4 = new Navigation(m4, new ArrayList<SubMenu>());
				Navigation nav5 = new Navigation(m5, new ArrayList<SubMenu>());
				Navigation nav6 = new Navigation(m6, new ArrayList<SubMenu>());
				Navigation nav7 = new Navigation(m7, new ArrayList<SubMenu>());
				Navigation nav8 = new Navigation(m8, new ArrayList<SubMenu>());

				navigations.add(nav1);
				navigations.add(navUsers);
				navigations.add(navLocations);
				navigations.add(nav2);
				navigations.add(nav3);
				navigations.add(nav4);
				navigations.add(nav5);
				navigations.add(nav6);
				navigations.add(nav7);
				navigations.add(nav8);
				
				Navigation selectedNav = navigations.get(0);
				
				System.out.println("URI: " + uri);
				
				for (Navigation nav : navigations) {
					if (nav.getSubMenus().size() != 0) {
						for (SubMenu subMenu : nav.getSubMenus()) {
							if (uri.contains(subMenu.getUrl())) {
								selectedNav = nav;
								
								String subMenuUrl = subMenu.getUrl();
								
								/*
								 * request /admin/users/new ise,
								 * seçilen menü users menüsü, ve sub-menu.jsp de
								 * görüntülenecek bilgilendirme metini,
								 * Yeni Kullanıcı Ekle olarak güncellenecek.
								 * 
								 * selectedNav request' e eklendiğinden,
								 * varsayılan değeri "Tüm Kullanıcılar olacaktır"
								 * 
								 * */
								
								/*
								 * Aslında bu işlem her requestin gittiği controllerda da
								 * yapılabilirdi. controler' ı daha sade tutmak için böyle
								 * yapıldı.
								 * 
								 * */
								String shortDesc = "";
								String desc = "";
								
								if (subMenuUrl.contains("/users/new")) {
									shortDesc = "Yeni Kullanıcı Ekle";
									desc = "Yeni Kullanıcı İçin Aşağıdaki Bilgileri Doldurun";
								} else if (subMenuUrl.contains("/users/edit")) {
									shortDesc = "Kullanıcı Güncelleniyor";
									desc = "Kullanıcı Bilgilerini Değiştirebilirsiniz";
								} else if (subMenuUrl.contains("/users/profil")) {
									shortDesc = "Profil Detayları";
									desc = "";
								} else if (subMenuUrl.contains("/locations/new")) {
									shortDesc = "Hizmet Noktası Ekle";
									desc = "Hizmet Noktası için gerekli bilgileri doldurun";
								} else if (subMenuUrl.contains("/locations/edit")) {
									shortDesc = "Hizmet Noktası Güncelleniyor";
									desc = "Hizmet Noktası Güncelleniyor";
								}
								
								selectedNav.getMenu().setShortDescription(shortDesc);
								selectedNav.getMenu().setDescription(desc);
							}
						}
					}
					
					if (uri.contains(nav.getMenu().getUrl()))
						selectedNav = nav;
				}
				
				System.out.println("selected nav url: " + selectedNav.getMenu().getUrl());
				
				request.setAttribute("selectedNav", selectedNav);
				request.getSession().setAttribute("navigations", navigations);
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
