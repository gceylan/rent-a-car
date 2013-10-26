package com.gceylan.rentacar.helper;

import java.util.ArrayList;

public class Navigation {

	private Menu menu;
	private ArrayList<SubMenu> subMenus;

	public Navigation(Menu menu, ArrayList<SubMenu> subMenus) {
		super();
		this.menu = menu;
		this.subMenus = subMenus;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public ArrayList<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(ArrayList<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

}
