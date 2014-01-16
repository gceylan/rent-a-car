package com.gceylan.rentacar.service;

import java.util.Date;
import java.util.List;

import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.Car;

public interface CarService {
	
	public void addCar(Car car);
	
	public Car getCarById(Integer carId);
	
	public void updateCar(Car car);
	
	public void deleteCar(Integer carId);
	
	public List<Car> getAllCars(Branch branch);
	
	public void isAvailable(Integer carId, Integer value);
	
	public List<Car> getAvailableCarForRental(Branch alýsSube, Branch teslimSube, Date pickupDate, Date returnDate);
	
	public Car isAvailableForRental(int selectedCarId, Date pickupDate, Date returnDate);

	public List<Car> donusYerineGoreGetir(Branch pickupBranch, Branch returnBranch);
}
