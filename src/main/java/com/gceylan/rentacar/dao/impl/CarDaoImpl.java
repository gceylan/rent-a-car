package com.gceylan.rentacar.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gceylan.rentacar.dao.CarDao;
import com.gceylan.rentacar.domain.Branch;
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

	public Car getCarById(Integer carId) {
		return (Car) getSession().get(Car.class, carId);
	}

	public void updateCar(Car car) {
		getSession().update(car);
	}

	public void deleteCar(Integer carId) {
		getSession().delete(getCarById(carId));
	}

	@SuppressWarnings("unchecked")
	public List<Car> getAllCars(Branch branch) {
		return (List<Car>) getSession().createCriteria(Car.class)
				.add(Restrictions.eq("branch", branch)).list();
	}
	
	
	/* seçilen þubeye ait, müsait araçlarý getir */
	@SuppressWarnings("unchecked")
	public List<Car> getAvailableCars(Branch branch) {
		return (List<Car>) getSession().createCriteria(Car.class)
				.add(Restrictions.eq("branch", branch))
				.add(Restrictions.eq("available", true)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Car> donusYerineGoreGetir(Branch pickupBranch, Branch returnBranch) {
		Query query = getSession().createQuery("select r.car from Rental r "
				+ "where "
				+ "r.pickupLocationBranch = :pickupBranch and "
				+ "r.returnLocationBranch = :returnBranch and "
				+ "r.completed = false");
		query.setParameter("pickupBranch", pickupBranch);
		query.setParameter("returnBranch", returnBranch);
		/* Dönüþ yerine göre tüm kiralamalarý getir */
		List<Car> list = query.list();
		
		return list;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
