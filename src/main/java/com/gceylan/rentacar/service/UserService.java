package com.gceylan.rentacar.service;

import java.util.List;

import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.User;

public interface UserService {
	
	public void addUser(User user);
	
	public List<User> getAllUsers();
	
	public void updateUser(User user);
	
	public void deleteUser(Integer userId);
	
	public User getUserById(Integer userId);
	
	public User getUserByUsername(String username);
	
	public List<User> getAllManagers(Branch branch);
	
	public List<User> getAllEmployees(Branch branch);

}
