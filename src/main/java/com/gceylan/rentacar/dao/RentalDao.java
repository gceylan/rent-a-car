package com.gceylan.rentacar.dao;

import java.util.List;

import com.gceylan.rentacar.domain.Rental;

public interface RentalDao {
	
	public void addRental(Rental rental);
	
	public void updateRental(Rental rental);
	
	public void deleteRental(Integer rentalId);
	
	public Rental getRentalById(Integer rentalId);
	
	public Rental getRentalByReservationCode(String reservationCode);
	
	public List<Rental> getAllRentals();
	
	public List<Rental> getAllRentals(Integer carId);
	
	public List<Rental> getAllConfirmed(boolean confirmed);
	
	/* þubeye ait onaylanmamýþ rezervasyonlarý getir */
	public List<Rental> getAllNotConfirmedResv(Integer branchId);
	
	public List<Rental> getAllConfirmed(Integer carId, boolean confirmed);
	
	public List<Rental> getAllCompleted(Integer carId, boolean completed);
	
	public List<Rental> getAllConfirmedAndCompleted(boolean confirmed, boolean completed);
	
	public List<Rental> getAllConfirmedAndCompleted(Integer branchId, boolean confirmed, boolean completed);
	
	public Integer getRentalCount(Integer branchId, boolean confirmed, boolean completed);
	
	/* onaylanmýþ, tamamlanmamýþ kiralamalarý getir, þu anda gerçekleþenler hariç */
	public List<Rental> getNotCompletedRentals(Integer branchId);
	
	/* þu anda gerçekleþen kiralamalar */
	public List<Rental> getNowDoingRentals(Integer branchId);
	
	public Integer getNowRentalCount(Integer branchId);
	
}
