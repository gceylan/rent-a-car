package com.gceylan.rentacar.dao;

import java.util.List;

import com.gceylan.rentacar.domain.Location;

public interface LocationDao {
	
	public void addLocation(Location location);
	
	public Location getLocationById(Integer locationId);
	
	public Location getLocationByName(String name);
	
	public void updateLocation(Location location);
	
	public void deleteLocation(Integer locationId);
	
	public List<Location> getAllLocations();

}
