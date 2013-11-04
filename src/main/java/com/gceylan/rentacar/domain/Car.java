package com.gceylan.rentacar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@NotEmpty
	@Column(name = "license_plate")
	private String licensePlate;

	@Column(name = "img_url")
	private String imgUrl;

	@NotEmpty
	@Column(name = "brand")
	private String brand;

	@NotEmpty
	@Column(name = "model")
	private String model;

	@NotEmpty
	@Column(name = "color")
	private String color;
	
	@Column(name = "available")
	private boolean available;

	@NotEmpty
	@Column(name = "owner")
	private String owner;

	@NotEmpty @Email
	@Column(name = "owner_email")
	private String ownerEmail;

	@NotEmpty
	@Column(name = "owner_phone")
	private String ownerPhone;

	@NotNull
	@Column(name = "price_per_day")
	private Integer pricePerDay;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public Integer getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Integer pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

}
