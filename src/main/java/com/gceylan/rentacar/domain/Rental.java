package com.gceylan.rentacar.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "rental")
public class Rental {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "reservation_code")
	private String reservationCode;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "reservation_date")
	private Date reservationDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "pickup_date")
	private Date pickupDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "return_date")
	private Date returnDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pickup_location_id")
	private Location pickupLocation;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "return_location_id")
	private Location returnLocation;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "car_id")
	private Car car;
	
	@Column(name = "rent_pay")
	private float rentPay;
	
	@Column(name = "confirmed")
	private boolean confirmed;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_surname")
	private String customerSurname;
	
	@Column(name = "customer_phone")
	private String customerPhone;
	
	@Column(name = "customer_email")
	private String customerEmail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReservationCode() {
		return reservationCode;
	}

	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Location getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(Location pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Location getReturnLocation() {
		return returnLocation;
	}

	public void setReturnLocation(Location returnLocation) {
		this.returnLocation = returnLocation;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public float getRentPay() {
		return rentPay;
	}

	public void setRentPay(float rentPay) {
		this.rentPay = rentPay;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

}
