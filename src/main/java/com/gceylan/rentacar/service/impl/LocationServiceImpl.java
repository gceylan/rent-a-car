package com.gceylan.rentacar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gceylan.rentacar.dao.LocationDao;
import com.gceylan.rentacar.domain.Location;
import com.gceylan.rentacar.service.LocationService;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationDao locationDao;

	@Transactional
	public void addLocation(Location location) {
		locationDao.addLocation(location);
	}

	@Transactional
	public Location getLocationById(Integer locationId) {
		return locationDao.getLocationById(locationId);
	}

	@Transactional
	public Location getLocationByName(String name) {
		return locationDao.getLocationByName(name);
	}

	@Transactional
	public void updateLocation(Location location) {
		locationDao.updateLocation(location);
	}

	@Transactional
	public void deleteLocation(Integer locationId) {
		locationDao.deleteLocation(locationId);
	}

	@Transactional
	public List<Location> getAllLocations() {
		return locationDao.getAllLocations();
	}
	
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

}
