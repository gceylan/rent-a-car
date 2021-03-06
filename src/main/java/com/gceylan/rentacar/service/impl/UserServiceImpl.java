package com.gceylan.rentacar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gceylan.rentacar.dao.UserDao;
import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.User;
import com.gceylan.rentacar.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Transactional
	public void deleteUser(Integer userId) {
		userDao.deleteUser(userId);
	}

	@Transactional
	public User getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}

	@Transactional
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	
	@Transactional
	public List<User> getAllManagers(Branch branch) {
		return userDao.getAllManagers(branch);
	}
	
	@Transactional
	public List<User> getAllEmployees(Branch branch) {
		return userDao.getAllEmployees(branch);
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
