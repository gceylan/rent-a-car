package com.gceylan.rentacar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gceylan.rentacar.dao.ServicePointDao;
import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.ServicePoint;
import com.gceylan.rentacar.service.ServicePointService;

@Service
public class ServicePointServiceImpl implements ServicePointService {
	
	@Autowired
	private ServicePointDao servicePointDao;

	@Transactional
	public void addServicePoint(ServicePoint servicePoint) {
		servicePointDao.addServicePoint(servicePoint);
	}

	@Transactional
	public ServicePoint getServicePointById(Integer servicePointId) {
		return servicePointDao.getServicePointById(servicePointId);
	}

	@Transactional
	public void updateServicePoint(ServicePoint servicePoint) {
		servicePointDao.updateServicePoint(servicePoint);
	}

	@Transactional
	public void deleteServicePoint(Integer servicePointId) {
		servicePointDao.deleteServicePoint(servicePointId);
	}

	@Transactional
	public List<ServicePoint> getAllServicePoints(Branch branch) {
		return servicePointDao.getAllServicePoints(branch);
	}
	
	@Transactional
	public List<ServicePoint> getAllServicePoints() {
		return servicePointDao.getAllServicePoints();
	}
	
	public void setServicePointDao(ServicePointDao servicePointDao) {
		this.servicePointDao = servicePointDao;
	}

}
