package com.gceylan.rentacar.util;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class CustomerInformationForRental {

	@NotBlank
	private String name;

	@NotBlank
	private String surname;

	@NotBlank
	@Size(min = 10, max = 14)
	private String phone;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerInformationForRental [name=" + name + ", surname="
				+ surname + ", phone=" + phone + ", email=" + email
				+ ", address=" + address + "]";
	}

}
