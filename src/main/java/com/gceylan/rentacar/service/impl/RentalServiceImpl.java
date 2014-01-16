package com.gceylan.rentacar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gceylan.rentacar.dao.RentalDao;
import com.gceylan.rentacar.domain.Rental;
import com.gceylan.rentacar.service.RentalService;

@Service
public class RentalServiceImpl implements RentalService {
	
	@Autowired
	private RentalDao rentalDao;

	@Transactional
	public void addRental(Rental rental) {
		rentalDao.addRental(rental);
	}

	@Transactional
	public void updateRental(Rental rental) {
		rentalDao.updateRental(rental);
	}

	@Transactional
	public void deleteRental(Integer rentalId) {
		rentalDao.deleteRental(rentalId);
	}

	@Transactional
	public Rental getRentalById(Integer rentalId) {
		return rentalDao.getRentalById(rentalId);
	}

	@Transactional
	public Rental getRentalByReservationCode(String reservationCode) {
		return rentalDao.getRentalByReservationCode(reservationCode);
	}

	@Transactional
	public List<Rental> getAllRentals() {
		return rentalDao.getAllRentals();
	}

	@Transactional
	public List<Rental> getAllRentals(Integer carId) {
		return rentalDao.getAllRentals(carId);
	}

	@Transactional
	public List<Rental> getAllConfirmed(boolean confirmed) {
		return rentalDao.getAllConfirmed(confirmed);
	}

	@Transactional
	public List<Rental> getAllConfirmed(Integer carId, boolean confirmed) {
		return rentalDao.getAllConfirmed(carId, confirmed);
	}

	@Transactional
	public List<Rental> getAllCompleted(Integer carId, boolean completed) {
		return rentalDao.getAllCompleted(carId, completed);
	}

	@Transactional
	public List<Rental> getAllConfirmedAndCompleted(boolean confirmed, boolean completed) {
		return rentalDao.getAllConfirmedAndCompleted(confirmed, completed);
	}
	
	@Transactional
	public List<Rental> getAllNotConfirmedResv(Integer branchId) {
		return rentalDao.getAllNotConfirmedResv(branchId);
	}
	
	@Transactional
	public List<Rental> getAllConfirmedAndCompleted(Integer branchId, boolean confirmed, boolean completed) {
		return rentalDao.getAllConfirmedAndCompleted(branchId, confirmed, completed);
	}
	
	@Transactional
	public Integer getRentalCount(Integer branchId, boolean confirmed, boolean completed) {
		return rentalDao.getRentalCount(branchId, confirmed, completed);
	}
	
	@Transactional
	public List<Rental> getNowDoingRentals(Integer branchId) {
		return rentalDao.getNowDoingRentals(branchId);
	}
	
	@Transactional
	public Integer getNowRentalCount(Integer branchId) {
		return rentalDao.getNowRentalCount(branchId);
	}
	
	@Transactional
	public List<Rental> getNotCompletedRentals(Integer branchId) {
		return rentalDao.getNotCompletedRentals(branchId);
	}
	
	public void setRentalDao(RentalDao rentalDao) {
		this.rentalDao = rentalDao;
	}

}
