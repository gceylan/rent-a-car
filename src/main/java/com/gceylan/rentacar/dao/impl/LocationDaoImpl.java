package com.gceylan.rentacar.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gceylan.rentacar.dao.LocationDao;
import com.gceylan.rentacar.domain.Location;

@Repository
public class LocationDaoImpl implements LocationDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void addLocation(Location location) {
		getSession().save(location);
	}

	public Location getLocationById(Integer locationId) {
		return (Location) getSession().get(Location.class, locationId);
	}

	public Location getLocationByName(String name) {
		return (Location) getSession().createCriteria(Location.class)
				.add(Restrictions.eq("name", name))
				.uniqueResult();
	}

	public void updateLocation(Location location) {
		getSession().update(location);
	}

	public void deleteLocation(Integer locationId) {
		getSession().delete(getLocationById(locationId));
	}

	@SuppressWarnings("unchecked")
	public List<Location> getAllLocations() {
		return (List<Location>) getSession().createCriteria(Location.class).list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
