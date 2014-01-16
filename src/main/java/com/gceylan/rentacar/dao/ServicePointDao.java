package com.gceylan.rentacar.dao;

import java.util.List;

import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.ServicePoint;

public interface ServicePointDao {
	
	public void addServicePoint(ServicePoint servicePoint);
	
	public ServicePoint getServicePointById(Integer servicePointId);
	
	public void updateServicePoint(ServicePoint servicePoint);
	
	public void deleteServicePoint(Integer servicePointId);
	
	public List<ServicePoint> getAllServicePoints();
	
	public List<ServicePoint> getAllServicePoints(Branch branch);

}
