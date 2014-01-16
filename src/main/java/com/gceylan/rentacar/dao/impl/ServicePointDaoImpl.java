package com.gceylan.rentacar.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gceylan.rentacar.dao.ServicePointDao;
import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.ServicePoint;

@Repository
public class ServicePointDaoImpl implements ServicePointDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void addServicePoint(ServicePoint servicePoint) {
		getSession().save(servicePoint);
	}

	public ServicePoint getServicePointById(Integer servicePointId) {
		return (ServicePoint) getSession().get(ServicePoint.class, servicePointId);
	}

	public void updateServicePoint(ServicePoint servicePoint) {
		getSession().update(servicePoint);
	}

	public void deleteServicePoint(Integer servicePointId) {
		getSession().delete(getServicePointById(servicePointId));
	}
	
	@SuppressWarnings("unchecked")
	public List<ServicePoint> getAllServicePoints(Branch branch) {
		return (List<ServicePoint>) getSession().createCriteria(ServicePoint.class)
				.add(Restrictions.eq("branch", branch)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ServicePoint> getAllServicePoints() {
		return (List<ServicePoint>) getSession().createCriteria(ServicePoint.class).list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
