package com.gceylan.rentacar.domain;

import java.io.Serializable;
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

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "rental")
public class Rental implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "reservation_code")
	private String reservationCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reservation_date")
	private Date reservationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pickup_date")
	private Date pickupDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "return_date")
	private Date returnDate;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "pickup_sp_id")
	private ServicePoint pickupLocation;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "pickup_sp_branch_id")
	private Branch pickupLocationBranch;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "return_sp_id")
	private ServicePoint returnLocation;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "return_sp_branch_id")
	private Branch returnLocationBranch;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "car_id")
	private Car car;

	@Column(name = "rent_pay")
	private float rentPay;

	@Column(name = "confirmed")
	private boolean confirmed = false;

	@Column(name = "completed")
	private boolean completed = false;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_surname")
	private String customerSurname;

	@Column(name = "customer_phone")
	private String customerPhone;

	@Column(name = "customer_email")
	private String customerEmail;

	@Column(name = "address_detail")
	private String addressDetail;

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

	public ServicePoint getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(ServicePoint pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Branch getPickupLocationBranch() {
		return pickupLocationBranch;
	}

	public void setPickupLocationBranch(Branch pickupLocationBranch) {
		this.pickupLocationBranch = pickupLocationBranch;
	}

	public ServicePoint getReturnLocation() {
		return returnLocation;
	}

	public void setReturnLocation(ServicePoint returnLocation) {
		this.returnLocation = returnLocation;
	}

	public Branch getReturnLocationBranch() {
		return returnLocationBranch;
	}

	public void setReturnLocationBranch(Branch returnLocationBranch) {
		this.returnLocationBranch = returnLocationBranch;
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

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
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

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	@Override
	public String toString() {
		return "Rental [id=" + id + ", reservationCode=" + reservationCode
				+ ", reservationDate=" + reservationDate + ", pickupDate="
				+ pickupDate + ", returnDate=" + returnDate + ", car=" + car
				+ ", rentPay=" + rentPay + ", confirmed=" + confirmed
				+ ", completed=" + completed + ", customerName=" + customerName
				+ ", customerSurname=" + customerSurname + ", customerPhone="
				+ customerPhone + ", customerEmail=" + customerEmail
				+ ", addressDetail=" + addressDetail + "]";
	}

}
