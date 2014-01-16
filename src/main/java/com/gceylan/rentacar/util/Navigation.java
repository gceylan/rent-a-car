package com.gceylan.rentacar.util;

import java.io.Serializable;
import java.util.ArrayList;

public class Navigation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
