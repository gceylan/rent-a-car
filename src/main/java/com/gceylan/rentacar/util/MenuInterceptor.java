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
			
			if (request.getSession().getAttribute("logonUser") == null) {
				System.out.println("user yok!");
				
				response.sendRedirect(request.getContextPath() + "/admin");
				return;
			}
			
			if (request.getSession().getAttribute("navigation") == null) {
				navigations = new ArrayList<Navigation>();
				Menu m1 = new Menu(
						"icon-dashboard",
						"Dashboard",
						"Statistics Overview",
						"Welcome to SB Admin by Start Bootstrap! Feel free to use this template for your admin needs! We are using a few different plugins to handle the dynamic tables and charts, so make sure you check out the necessary documentation links provided.",
						"admin/main");
				Menu mBranchs = new Menu(
						"icon-dashboard",
						"Þubeler",
						"Tüm Þubeler",
						"Þirkete baðlý þubeler aþaðýda listelenmektedir. Þube detaylarýný inceleyebilirsiniz. Yeni Þube ekleyebilir, mevcut þube üzerinde deðiþikler yapabilirsiniz",
						"admin/branchs/list");
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
				Menu m8 = new Menu("icon-file-alt", "Blank Page", "A Blank Slate", "", "admin/blank-page");

				Navigation nav1 = new Navigation(m1, new ArrayList<SubMenu>());
				
				/* Þubeler menüsü */
				/* dikkat, alt menüler eklenmezse, gidilen uri nin menüsü bulunamaz */
				ArrayList<SubMenu> branchsSubMenu = new ArrayList<SubMenu>();
				branchsSubMenu.add(new SubMenu("", "Yeni Þube Ekle", "admin/branchs/new"));
				branchsSubMenu.add(new SubMenu("", "Þube Görünyüle", "admin/branchs/show"));
				branchsSubMenu.add(new SubMenu("", "Þube Güncelle", "admin/branchs/edit"));
				Navigation navBranchs = new Navigation(mBranchs, branchsSubMenu);
				
				Navigation nav2 = new Navigation(m2, new ArrayList<SubMenu>());
				Navigation nav3 = new Navigation(m3, new ArrayList<SubMenu>());
				Navigation nav4 = new Navigation(m4, new ArrayList<SubMenu>());
				Navigation nav5 = new Navigation(m5, new ArrayList<SubMenu>());
				Navigation nav6 = new Navigation(m6, new ArrayList<SubMenu>());
				Navigation nav7 = new Navigation(m7, new ArrayList<SubMenu>());
				Navigation nav8 = new Navigation(m8, new ArrayList<SubMenu>());

				navigations.add(nav1);
				navigations.add(navBranchs);
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
								String shortDesc = "";
								String desc = "";
								
								if (subMenuUrl.contains("/branchs")) {
									if (subMenuUrl.contains("/new")) {
										shortDesc = "Yeni Þube Ekle";
										desc = "Yeni Þube Eklemek için, þube ile ilgili bilgileri ve þube müdürü ile ilgili bilgileri eksiksiz giriniz.";
									} else if (subMenuUrl.contains("/show")) {
										shortDesc = "Þube Görüntüleniyor";
										desc = "Þube Bilgilerini Görüntüleniyor";
									} else if (subMenuUrl.contains("/edit")) {
										shortDesc = "Þube Güncelleniyor";
										desc = "Þube Bilgilerini Güncelleþtirin";
									}
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
		
		else if (uri.contains("/branch") && !uri.contains("/admin")) {

			if (request.getSession().getAttribute("navigation") == null) {
				navigations = new ArrayList<Navigation>();

				Menu m1 = new Menu(
						"icon-dashboard",
						"Dashboard",
						"Statistics Overview",
						"Welcome to SB Admin by Start Bootstrap! Feel free to use this template for your admin needs! We are using a few different plugins to handle the dynamic tables and charts, so make sure you check out the necessary documentation links provided.",
						"branch/main");
				Menu mEmployees = new Menu(
						"icon-user",
						"Çalýþanlar",
						"Tüm Çalýþanlar",
						"Yeni Çalýþan Ekle/Sil/Güncelle",
						"branch/employees/list"
						);
				Menu mServicePoints = new Menu(
						"icon-road",
						"Hizmet Noktalarý",
						"Tüm Hizmet Noktalarý",
						"Yeni Hizmet Noktasý Ekle/Sil/Güncelle",
						"branch/service-points/list"
						);
				Menu mCars = new Menu(
						"icon-truck",
						"Araçlar",
						"Tüm Araçlar",
						"Yeni Bir Araç Kaydý Ekleyebilirsiniz...",
						"branch/cars/list"
						);
				Menu mNowDoingRentals = new Menu(
						"icon-comment-alt",
						"Þu Anda Gerçekleþenler",
						"Þu Anda Gerçekleþen Rezervasyonlar",
						"Þu Anda Gerçekleþen Rezervasyonlar",
						"branch/reservations/now-doing"
						);
				Menu mNotConfirmedReservations = new Menu(
						"icon-comment-alt",
						"Onay Bekleyenler",
						"Onaylamanýz Gereken Rezervasyonlar",
						"Dikkatli inceleyin",
						"branch/reservations/not-confirmed"
						);
				Menu mConfirmedReservations = new Menu(
						"icon-calendar",
						"Günü Yaklaþanlar",
						"Günü Yaklaþan Rezervasyonlar",
						"Dikkatli inceleyin",
						"branch/reservations/confirmed"
						);
				Menu mCompletedRentals = new Menu(
						"icon-check",
						"Tamamlanmýþ",
						"Tamamlanmýþ Kiralamalar",
						"Geçmiþe dönük bilgiler bulabilirsiniz",
						"branch/reservations/completed"
						);
				Menu m2 = new Menu(
						"icon-bar-chart",
						"Charts",
						"Display Your Data",
						"There are two options for charts: Flot charts and morris.js. Choose which one best suits your needs, and make sure to master the documentation to get the most out of these charts!",
						"branch/charts");
				Menu m3 = new Menu(
						"icon-table",
						"Tables",
						"Sort Your Data",
						"We're using Tablesorter 2.0 for the sort function on the tables. Read the documentation for more customization options or feel free to use something else!",
						"branch/tables");
				Menu m4 = new Menu(
						"icon-edit",
						"Forms",
						"Enter Your Data",
						"Visit Bootstrap's Form Documentation for more information.",
						"branch/forms");
				Menu m5 = new Menu(
						"icon-font",
						"Typography",
						"Text and Headers",
						"Visit Bootstrap's Typography Documentation for more information.",
						"branch/typography");
				Menu m6 = new Menu(
						"icon-desktop",
						"Bootstrap Elements",
						"Built-In Bootstrap Elements",
						"Start Bootstrap recommends that you have an in-depth understanding of the Bootstrap framework before working with this template. Visit http://getbootstrap.com/ for complete documentation.",
						"branch/bootstrap-elements");
				Menu m7 = new Menu(
						"icon-wrench",
						"Bootstrap Grid",
						"Built-In Bootstrap Grid",
						"Be sure to visit Bootstrap's grid documentation for more information.",
						"branch/bootstrap-grid");
				Menu m8 = new Menu("icon-file-alt", "Blank Page",
						"A Blank Slate", "", "branch/blank-page");

				Navigation nav1 = new Navigation(m1, new ArrayList<SubMenu>());
				
				// þube çalýþanlarý menüsü
				ArrayList<SubMenu> employeeSubMenus = new ArrayList<SubMenu>();
				employeeSubMenus.add(new SubMenu("", "Yeni Çalýþan Ekle", "branch/employees/new"));
				employeeSubMenus.add(new SubMenu("", "Kullanýcý Güncelle", "branch/employees/edit"));
				employeeSubMenus.add(new SubMenu("", "Profil Bilgileri", "branch/employees/profile"));
				employeeSubMenus.add(new SubMenu("", "Profil Ayarlarý", "branch/employees/settings"));
				
				Navigation navEmployees = new Navigation(mEmployees, employeeSubMenus);
				
				// hizmet noktalarý menüsü
				ArrayList<SubMenu> servicePointSubMenus = new ArrayList<SubMenu>();
				servicePointSubMenus.add(new SubMenu("", "Yeni Hizmet Noktasý Ekle", "branch/service-points/new"));
				servicePointSubMenus.add(new SubMenu("", "Hizmet Noktasý Güncelle", "branch/service-points/edit"));
				
				Navigation navLocations = new Navigation(mServicePoints, servicePointSubMenus);
				
				// araçlar menüsü
				ArrayList<SubMenu> carSubMenus = new ArrayList<SubMenu>();
				carSubMenus.add(new SubMenu("", "Yeni Bir Araç Ekle", "branch/cars/new"));
				carSubMenus.add(new SubMenu("", "Araç Bilgilerini Güncelle", "branch/cars/edit"));
				carSubMenus.add(new SubMenu("", "Araç Bilgilerini Görüntüle", "branch/cars/show"));
				Navigation navCars = new Navigation(mCars, carSubMenus);
				
				ArrayList<SubMenu> nowDoingRentalsSubMenus = new ArrayList<SubMenu>();
				Navigation navNowDoingRentals = new Navigation(mNowDoingRentals, nowDoingRentalsSubMenus);
				
				// onaylanmamýþ rezervasyonlar
				ArrayList<SubMenu> notConfirmedReservationSubMenus = new ArrayList<SubMenu>();
				notConfirmedReservationSubMenus.add(new SubMenu("", "Rezervasyonu Güncelle", "branch/reservations/edit"));
				notConfirmedReservationSubMenus.add(new SubMenu("", "", "branch/reservations/confirm"));
				notConfirmedReservationSubMenus.add(new SubMenu("", "", "branch/reservations/delete"));
				Navigation navNotConfirmedReservation = new Navigation(mNotConfirmedReservations, notConfirmedReservationSubMenus);
				
				// onaylanmamýþ rezervasyonlar
				ArrayList<SubMenu>confirmedReservationSubMenu = new ArrayList<SubMenu>();
				confirmedReservationSubMenu.add(new SubMenu("", "Rezervasyonu Güncelle (Onaysýz)", "branch/reservations/edit"));
				confirmedReservationSubMenu.add(new SubMenu("", "", "branch/reservations/delete"));
				Navigation navConfirmedReservation = new Navigation(mConfirmedReservations, confirmedReservationSubMenu);
				
				// tamamlanmýþ rezervasyonlar
				ArrayList<SubMenu> completedRentalsSubMenu = new ArrayList<SubMenu>();
				Navigation navCompletedRentals = new Navigation(mCompletedRentals, completedRentalsSubMenu);
				
				Navigation nav2 = new Navigation(m2, new ArrayList<SubMenu>());
				Navigation nav3 = new Navigation(m3, new ArrayList<SubMenu>());
				Navigation nav4 = new Navigation(m4, new ArrayList<SubMenu>());
				Navigation nav5 = new Navigation(m5, new ArrayList<SubMenu>());
				Navigation nav6 = new Navigation(m6, new ArrayList<SubMenu>());
				Navigation nav7 = new Navigation(m7, new ArrayList<SubMenu>());
				Navigation nav8 = new Navigation(m8, new ArrayList<SubMenu>());

				navigations.add(nav1);
				navigations.add(navEmployees);
				navigations.add(navCars);
				navigations.add(navLocations);
				navigations.add(navNotConfirmedReservation);
				navigations.add(navConfirmedReservation);
				navigations.add(navNowDoingRentals);
				navigations.add(navCompletedRentals);
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
								String shortDesc = "";
								String desc = "";
								
								if (subMenuUrl.contains("/employees")) {
									if (subMenuUrl.contains("/new")) {
										shortDesc = "Yeni Çalýþan Ekle";
										desc = "Çalýþan için gerekli bilgileri doldurun";
									} else if (subMenuUrl.contains("/edit")) {
										shortDesc = "Çalýþan Bilgileri Güncelleniyor";
										desc = "Çalýþan Bilgilerini Güncelleniyor";
									} else if (subMenuUrl.contains("/profile")) {
										shortDesc = "Profil";
										desc = "Kiþisel Bilgileri";
									} else if (subMenuUrl.contains("/settings")) {
										shortDesc = "Profil Ayarlarý";
										desc = "Kiþisel Bilgilerinizi Deðiþtirebilirsiniz";
									}
								} else if (subMenuUrl.contains("/service-points")) {
									if (subMenuUrl.contains("/new")) {
										shortDesc = "Hizmet Noktasý Ekle";
										desc = "Hizmet Noktasý için gerekli bilgileri doldurun";
									} else if (subMenuUrl.contains("/edit")) {
										shortDesc = "Hizmet Noktasý Güncelleniyor";
										desc = "Hizmet Noktasý Güncelleniyor";
									}
								} else if (subMenuUrl.contains("/cars")) {
									if (subMenuUrl.contains("/new")) {
										shortDesc = "Yeni Bir Araç Ekle";
										desc = "Yeni Araç Ekle";
									} else if (subMenuUrl.contains("/edit")) {
										shortDesc = "Araç Güncelle";
										desc = "Araç Güncelle";
									} else if (subMenuUrl.contains("/show")) {
										shortDesc = "Araç Görüntüleniyor";
										desc = "Araç Görüntüleniyor";
									}
								} else if (subMenuUrl.contains("/reservations")) {
									if (subMenuUrl.contains("/edit")) {
										String from = request.getParameter("from");
										if (from != null) {
											if (from.contains("/not-confirmed")) {
												shortDesc = "Rezervasyonu Güncelle";
												desc = "Rezervasyonu Güncelle | Aracý deðiþtirebilirsiniz | onaylanmamýþ bir rezervasyon güncelleniyor";
												uri = "/json-not-confirmed";
											}
											else if (from.contains("/confirmed")) {
												shortDesc = "Rezervasyonu Güncelle";
												desc = "Rezervasyonu Güncelle | Aracý deðiþtirebilirsiniz | onaylanmýþ bir rezervasyon güncelleniyor";
												uri = "/json-confirmed";
											}
											else if (from.contains("/now-doing")) {
												shortDesc = "Rezervasyonu Güncelle";
												desc = "Rezervasyonu Güncelle | Þu Anda Gerçekleþen bir rezervasyonu güncellemeye çalýþýyorsunuz";
												uri = "/json-now-doing";
											}
										}
									}
								}
								
								selectedNav.getMenu().setShortDescription(shortDesc);
								selectedNav.getMenu().setDescription(desc);
							}
						}
					}
					
					if (uri.contains(nav.getMenu().getUrl()))
						selectedNav = nav;
				}
				
				// /admin/reservations/json-not-confirmed
				if (uri.contains("/json-not-confirmed")) {
					selectedNav = navNotConfirmedReservation;
				} else if (uri.contains("/json-confirmed")) {
					selectedNav = navConfirmedReservation;
				} else if (uri.contains("/json-completed")) {
					selectedNav = navCompletedRentals;
				} else if (uri.contains("/json-now-doing")) {
					selectedNav = navNowDoingRentals;
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
