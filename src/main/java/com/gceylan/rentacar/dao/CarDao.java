package com.gceylan.rentacar.dao;

import java.util.List;

import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.Car;

public interface CarDao {
	
	public void addCar(Car car);
	
	public Car getCarById(Integer carId);
	
	public void updateCar(Car car);
	
	public void deleteCar(Integer carId);
	
	public List<Car> getAllCars(Branch branch);

	public List<Car> getAvailableCars(Branch branch);
	
	public List<Car> donusYerineGoreGetir(Branch pickupBranch, Branch returnBranch);
	
}
