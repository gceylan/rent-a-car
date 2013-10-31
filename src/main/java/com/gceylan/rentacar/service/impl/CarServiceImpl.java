package com.gceylan.rentacar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gceylan.rentacar.dao.CarDao;
import com.gceylan.rentacar.domain.Car;
import com.gceylan.rentacar.service.CarService;

@Service
@Transactional
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDao carDao;

	@Transactional
	public void addCar(Car car) {
		carDao.addCar(car);
	}

	@Transactional
	public List<Car> getAllCars() {
		return carDao.getAllCars();
	}

	@Transactional
	public void updateCar(Car car) {
		carDao.updateCar(car);
	}

	@Transactional
	public void deleteCar(Integer carId) {
		carDao.deleteCar(carId);
	}

	@Transactional
	public Car getCarById(Integer carId) {
		return carDao.getCarById(carId);
	}
	
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

}
