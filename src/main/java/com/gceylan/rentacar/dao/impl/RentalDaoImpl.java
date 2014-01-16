package com.gceylan.rentacar.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gceylan.rentacar.dao.RentalDao;
import com.gceylan.rentacar.domain.Rental;

@Repository
public class RentalDaoImpl implements RentalDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void addRental(Rental rental) {
		getSession().save(rental);
	}

	public void updateRental(Rental rental) {
		getSession().update(rental);
	}

	public void deleteRental(Integer rentalId) {
		getSession().delete(getRentalById(rentalId));
	}

	public Rental getRentalById(Integer rentalId) {
		return (Rental) getSession().get(Rental.class, rentalId);
	}

	public Rental getRentalByReservationCode(String reservationCode) {
		return (Rental) getSession().createCriteria(Rental.class)
				.add(Restrictions.eq("reservationCode", reservationCode))
				.uniqueResult();
	}

	/* tüm kiralamalarý getir */
	@SuppressWarnings("unchecked")
	public List<Rental> getAllRentals() {
		return (List<Rental>) getSession().createCriteria(Rental.class).list();
	}

	/* araca ait kiralamalarý getir */
	@SuppressWarnings("unchecked")
	public List<Rental> getAllRentals(Integer carId) {
		Query query = getSession().createQuery("from Rental where car.id = :carId order by pickupDate asc");
		query.setParameter("carId", carId);
		List<Rental> list = query.list();
		
		return list;
	}

	/* onaylanmýþ ya da onaylanmamýþ rezervasyonlarý getir */
	@SuppressWarnings("unchecked")
	public List<Rental> getAllConfirmed(boolean confirmed) {
		Query query = getSession().createQuery("from Rental where confirmed = :confirmed "
				+ "order by pickupDate asc");
		query.setParameter("confirmed", confirmed);
		List<Rental> list = query.list();

		return list;
	}

	/* seçilen bir aracýn, onaylanmýþ ya da onaylanmamýþ kiralamalarýný getir */
	@SuppressWarnings("unchecked")
	public List<Rental> getAllConfirmed(Integer carId, boolean confirmed) {
		Query query = getSession().createQuery("from Rental where car.id = :carId and "
				+ "confirmed = :confirmed "
				+ "order by pickupDate asc");
		query.setParameter("carId", carId);
		query.setParameter("confirmed", confirmed);
		List<Rental> list = query.list();
		
		return list;
	}

	/* seçilen bir aracýn, tamamlanmýþ ya da tamamlanmamýþ kiralamalarýný getir */
	@SuppressWarnings("unchecked")
	public List<Rental> getAllCompleted(Integer carId, boolean completed) {
		Query query = getSession().createQuery("from Rental where car.id = :carId and "
				+ "completed = :completed "
				+ "order by pickupDate asc");
		query.setParameter("carId", carId);
		query.setParameter("completed", completed);
		List<Rental> list = query.list();
		
		return list;
	}

	/* onaylanmýþ, fakat tamamlanmamýþ kitalamalarý getir, (günü yaklaþan kiralamalar) (branchId) */
	@SuppressWarnings("unchecked")
	public List<Rental> getAllConfirmedAndCompleted(boolean confirmed, boolean completed) {
		Query query = getSession().createQuery("from Rental where confirmed = :confirmed "
				+ "and completed = :completed "
				+ "order by pickupDate asc");
		query.setParameter("confirmed", confirmed);
		query.setParameter("completed", completed);
		List<Rental> list = query.list();

		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rental> getAllNotConfirmedResv(Integer branchId) {
		Query query = getSession().createQuery("from Rental where pickupLocationBranch.id = :branchId "
				+ "order by pickupDate asc");
		query.setParameter("branchId", branchId);
		List<Rental> list = query.list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rental> getAllConfirmedAndCompleted(Integer branchId, boolean confirmed, boolean completed) {
		Query query = getSession().createQuery("from Rental r where r.pickupLocationBranch.id = :branchId "
				+ "and r.confirmed = :confirmed "
				+ "and r.completed = :completed "
				+ "order by r.pickupDate asc");
		query.setParameter("branchId", branchId);
		query.setParameter("confirmed", confirmed);
		query.setParameter("completed", completed);
		List<Rental> list = query.list();

		return list;
	}
	
	/* dashboard için bazý istatistikler */
	public Integer getRentalCount(Integer branchId, boolean confirmed, boolean completed) {
		Query query = getSession().createQuery("select count(r) from Rental r where "
				+ "r.pickupLocationBranch.id = :branchId "
				+ "and r.confirmed = :confirmed "
				+ "and r.completed = :completed");
		query.setParameter("branchId", branchId);
		query.setParameter("confirmed", confirmed);
		query.setParameter("completed", completed);

		return ((Long) query.uniqueResult()).intValue();
	}
	
	public Integer getNowRentalCount(Integer branchId) {
		Query query = getSession().createQuery("select count(r) from Rental r where "
				+ "r.pickupLocationBranch.id = :branchId "
				+ "and r.pickupDate <= current_timestamp() "
				+ "and current_timestamp() <= r.returnDate "
				+ "and completed = false");
		query.setParameter("branchId", branchId);
		
		return ((Long) query.uniqueResult()).intValue();
	}
	
	/* + "and current_timestamp() <= r.returnDate " silinen satýr.
	 * alýþ tarihi þimdiyi geçmiþ tüm kiralamalarý listele, 
	 * teslim tarihi de þimdi yi geçenlere tamamla butonu koy */
	@SuppressWarnings("unchecked")
	public List<Rental> getNowDoingRentals(Integer branchId) {
		Query query = getSession().createQuery("from Rental r where "
				+ "r.pickupLocationBranch.id = :branchId "
				+ "and r.pickupDate <= current_timestamp() "
				+ "and confirmed = true "
				+ "and completed = false "
				+ "order by r.pickupDate desc");
		query.setParameter("branchId", branchId);
		
		return (List<Rental>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Rental> getNotCompletedRentals(Integer branchId) {
		Query query = getSession().createQuery("from Rental r where "
				+ "r.pickupLocationBranch.id = :branchId "
				+ "and current_timestamp() < r.pickupDate and current_timestamp() < r.returnDate "
				+ "and r.confirmed = true "
				+ "and r.completed = false");
		query.setParameter("branchId", branchId);
		List<Rental> rentals = query.list();
		
		return rentals;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
