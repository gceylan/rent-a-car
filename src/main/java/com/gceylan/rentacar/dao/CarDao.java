package com.gceylan.rentacar.dao;

import java.util.List;

import com.gceylan.rentacar.domain.Car;

public interface CarDao {
	
	public void addCar(Car car);
	
	public List<Car> getAllCars();
	
	public void updateCar(Car car);
	
	public void deleteCar(Integer carId);
	
	public Car getCarById(Integer carId);

}
