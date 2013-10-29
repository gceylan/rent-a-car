package com.gceylan.rentacar.dao;

import java.util.List;

import com.gceylan.rentacar.domain.User;

public interface UserDao {
	
	public void addUser(User user);
	
	public List<User> getAllUsers();
	
	public void updateUser(User user);
	
	public void deleteUser(Integer userId);
	
	public User getUserById(Integer userId);
	
	public User getUserByUsername(String username);

}
