package com.gceylan.rentacar.service;

import java.util.List;

import com.gceylan.rentacar.domain.Car;

public interface CarService {
	
public void addCar(Car car);
	
	public List<Car> getAllCars();
	
	public void updateCar(Car car);
	
	public void deleteCar(Integer carId);
	
	public Car getCarById(Integer carId);

}
