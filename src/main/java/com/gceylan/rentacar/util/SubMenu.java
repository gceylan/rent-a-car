package com.gceylan.rentacar.util;

import java.io.Serializable;

public class SubMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 295740335981542180L;
	
	private String icon;
	private String name;
	private String url;

	public SubMenu() {
	}

	public SubMenu(String icon, String name, String url) {
		super();
		this.icon = icon;
		this.name = name;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "SubMenu [icon=" + icon + ", name=" + name + ", url=" + url
				+ "]";
	}

}
