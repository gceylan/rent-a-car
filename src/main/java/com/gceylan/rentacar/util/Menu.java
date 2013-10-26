package com.gceylan.rentacar.util;

import java.util.ArrayList;

public class Menu {

	private String icon;
	private String name;
	private String shortDescription;
	private String description;
	private String url;
	private ArrayList<SubMenu> subMenus;

	public Menu() {
	}

	public Menu(String icon, String name, String shortDescription,
			String description, String url) {
		this.icon = icon;
		this.name = name;
		this.shortDescription = shortDescription;
		this.description = description;
		this.url = url;
	}

	public Menu(String icon, String name, String shortDescription,
			String description, String url, ArrayList<SubMenu> subMenus) {
		this.icon = icon;
		this.name = name;
		this.shortDescription = shortDescription;
		this.description = description;
		this.url = url;
		this.subMenus = subMenus;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(ArrayList<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

}
