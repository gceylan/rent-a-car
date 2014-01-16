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
						"�ubeler",
						"T�m �ubeler",
						"�irkete ba�l� �ubeler a�a��da listelenmektedir. �ube detaylar�n� inceleyebilirsiniz. Yeni �ube ekleyebilir, mevcut �ube �zerinde de�i�ikler yapabilirsiniz",
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
				
				/* �ubeler men�s� */
				/* dikkat, alt men�ler eklenmezse, gidilen uri nin men�s� bulunamaz */
				ArrayList<SubMenu> branchsSubMenu = new ArrayList<SubMenu>();
				branchsSubMenu.add(new SubMenu("", "Yeni �ube Ekle", "admin/branchs/new"));
				branchsSubMenu.add(new SubMenu("", "�ube G�r�ny�le", "admin/branchs/show"));
				branchsSubMenu.add(new SubMenu("", "�ube G�ncelle", "admin/branchs/edit"));
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
										shortDesc = "Yeni �ube Ekle";
										desc = "Yeni �ube Eklemek i�in, �ube ile ilgili bilgileri ve �ube m�d�r� ile ilgili bilgileri eksiksiz giriniz.";
									} else if (subMenuUrl.contains("/show")) {
										shortDesc = "�ube G�r�nt�leniyor";
										desc = "�ube Bilgilerini G�r�nt�leniyor";
									} else if (subMenuUrl.contains("/edit")) {
										shortDesc = "�ube G�ncelleniyor";
										desc = "�ube Bilgilerini G�ncelle�tirin";
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
						"�al��anlar",
						"T�m �al��anlar",
						"Yeni �al��an Ekle/Sil/G�ncelle",
						"branch/employees/list"
						);
				Menu mServicePoints = new Menu(
						"icon-road",
						"Hizmet Noktalar�",
						"T�m Hizmet Noktalar�",
						"Yeni Hizmet Noktas� Ekle/Sil/G�ncelle",
						"branch/service-points/list"
						);
				Menu mCars = new Menu(
						"icon-truck",
						"Ara�lar",
						"T�m Ara�lar",
						"Yeni Bir Ara� Kayd� Ekleyebilirsiniz...",
						"branch/cars/list"
						);
				Menu mNowDoingRentals = new Menu(
						"icon-comment-alt",
						"�u Anda Ger�ekle�enler",
						"�u Anda Ger�ekle�en Rezervasyonlar",
						"�u Anda Ger�ekle�en Rezervasyonlar",
						"branch/reservations/now-doing"
						);
				Menu mNotConfirmedReservations = new Menu(
						"icon-comment-alt",
						"Onay Bekleyenler",
						"Onaylaman�z Gereken Rezervasyonlar",
						"Dikkatli inceleyin",
						"branch/reservations/not-confirmed"
						);
				Menu mConfirmedReservations = new Menu(
						"icon-calendar",
						"G�n� Yakla�anlar",
						"G�n� Yakla�an Rezervasyonlar",
						"Dikkatli inceleyin",
						"branch/reservations/confirmed"
						);
				Menu mCompletedRentals = new Menu(
						"icon-check",
						"Tamamlanm��",
						"Tamamlanm�� Kiralamalar",
						"Ge�mi�e d�n�k bilgiler bulabilirsiniz",
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
				
				// �ube �al��anlar� men�s�
				ArrayList<SubMenu> employeeSubMenus = new ArrayList<SubMenu>();
				employeeSubMenus.add(new SubMenu("", "Yeni �al��an Ekle", "branch/employees/new"));
				employeeSubMenus.add(new SubMenu("", "Kullan�c� G�ncelle", "branch/employees/edit"));
				employeeSubMenus.add(new SubMenu("", "Profil Bilgileri", "branch/employees/profile"));
				employeeSubMenus.add(new SubMenu("", "Profil Ayarlar�", "branch/employees/settings"));
				
				Navigation navEmployees = new Navigation(mEmployees, employeeSubMenus);
				
				// hizmet noktalar� men�s�
				ArrayList<SubMenu> servicePointSubMenus = new ArrayList<SubMenu>();
				servicePointSubMenus.add(new SubMenu("", "Yeni Hizmet Noktas� Ekle", "branch/service-points/new"));
				servicePointSubMenus.add(new SubMenu("", "Hizmet Noktas� G�ncelle", "branch/service-points/edit"));
				
				Navigation navLocations = new Navigation(mServicePoints, servicePointSubMenus);
				
				// ara�lar men�s�
				ArrayList<SubMenu> carSubMenus = new ArrayList<SubMenu>();
				carSubMenus.add(new SubMenu("", "Yeni Bir Ara� Ekle", "branch/cars/new"));
				carSubMenus.add(new SubMenu("", "Ara� Bilgilerini G�ncelle", "branch/cars/edit"));
				carSubMenus.add(new SubMenu("", "Ara� Bilgilerini G�r�nt�le", "branch/cars/show"));
				Navigation navCars = new Navigation(mCars, carSubMenus);
				
				ArrayList<SubMenu> nowDoingRentalsSubMenus = new ArrayList<SubMenu>();
				Navigation navNowDoingRentals = new Navigation(mNowDoingRentals, nowDoingRentalsSubMenus);
				
				// onaylanmam�� rezervasyonlar
				ArrayList<SubMenu> notConfirmedReservationSubMenus = new ArrayList<SubMenu>();
				notConfirmedReservationSubMenus.add(new SubMenu("", "Rezervasyonu G�ncelle", "branch/reservations/edit"));
				notConfirmedReservationSubMenus.add(new SubMenu("", "", "branch/reservations/confirm"));
				notConfirmedReservationSubMenus.add(new SubMenu("", "", "branch/reservations/delete"));
				Navigation navNotConfirmedReservation = new Navigation(mNotConfirmedReservations, notConfirmedReservationSubMenus);
				
				// onaylanmam�� rezervasyonlar
				ArrayList<SubMenu>confirmedReservationSubMenu = new ArrayList<SubMenu>();
				confirmedReservationSubMenu.add(new SubMenu("", "Rezervasyonu G�ncelle (Onays�z)", "branch/reservations/edit"));
				confirmedReservationSubMenu.add(new SubMenu("", "", "branch/reservations/delete"));
				Navigation navConfirmedReservation = new Navigation(mConfirmedReservations, confirmedReservationSubMenu);
				
				// tamamlanm�� rezervasyonlar
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
										shortDesc = "Yeni �al��an Ekle";
										desc = "�al��an i�in gerekli bilgileri doldurun";
									} else if (subMenuUrl.contains("/edit")) {
										shortDesc = "�al��an Bilgileri G�ncelleniyor";
										desc = "�al��an Bilgilerini G�ncelleniyor";
									} else if (subMenuUrl.contains("/profile")) {
										shortDesc = "Profil";
										desc = "Ki�isel Bilgileri";
									} else if (subMenuUrl.contains("/settings")) {
										shortDesc = "Profil Ayarlar�";
										desc = "Ki�isel Bilgilerinizi De�i�tirebilirsiniz";
									}
								} else if (subMenuUrl.contains("/service-points")) {
									if (subMenuUrl.contains("/new")) {
										shortDesc = "Hizmet Noktas� Ekle";
										desc = "Hizmet Noktas� i�in gerekli bilgileri doldurun";
									} else if (subMenuUrl.contains("/edit")) {
										shortDesc = "Hizmet Noktas� G�ncelleniyor";
										desc = "Hizmet Noktas� G�ncelleniyor";
									}
								} else if (subMenuUrl.contains("/cars")) {
									if (subMenuUrl.contains("/new")) {
										shortDesc = "Yeni Bir Ara� Ekle";
										desc = "Yeni Ara� Ekle";
									} else if (subMenuUrl.contains("/edit")) {
										shortDesc = "Ara� G�ncelle";
										desc = "Ara� G�ncelle";
									} else if (subMenuUrl.contains("/show")) {
										shortDesc = "Ara� G�r�nt�leniyor";
										desc = "Ara� G�r�nt�leniyor";
									}
								} else if (subMenuUrl.contains("/reservations")) {
									if (subMenuUrl.contains("/edit")) {
										String from = request.getParameter("from");
										if (from != null) {
											if (from.contains("/not-confirmed")) {
												shortDesc = "Rezervasyonu G�ncelle";
												desc = "Rezervasyonu G�ncelle | Arac� de�i�tirebilirsiniz | onaylanmam�� bir rezervasyon g�ncelleniyor";
												uri = "/json-not-confirmed";
											}
											else if (from.contains("/confirmed")) {
												shortDesc = "Rezervasyonu G�ncelle";
												desc = "Rezervasyonu G�ncelle | Arac� de�i�tirebilirsiniz | onaylanm�� bir rezervasyon g�ncelleniyor";
												uri = "/json-confirmed";
											}
											else if (from.contains("/now-doing")) {
												shortDesc = "Rezervasyonu G�ncelle";
												desc = "Rezervasyonu G�ncelle | �u Anda Ger�ekle�en bir rezervasyonu g�ncellemeye �al���yorsunuz";
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
