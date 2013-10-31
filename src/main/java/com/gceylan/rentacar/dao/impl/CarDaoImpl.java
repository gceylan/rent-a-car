package com.gceylan.rentacar.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gceylan.rentacar.dao.CarDao;
import com.gceylan.rentacar.domain.Car;

@Repository
public class CarDaoImpl implements CarDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void addCar(Car car) {
		getSession().save(car);
	}

	@SuppressWarnings("unchecked")
	public List<Car> getAllCars() {
		return (List<Car>) getSession().createCriteria(Car.class).list();
	}

	public void updateCar(Car car) {
		getSession().update(car);
	}

	public void deleteCar(Integer carId) {
		getSession().delete(getCarById(carId));
	}

	public Car getCarById(Integer carId) {
		return (Car) getSession().get(Car.class, carId);
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
