package com.gceylan.rentacar.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gceylan.rentacar.dao.UserDao;
import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void addUser(User user) {
		getSession().save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return (List<User>) getSession().createCriteria(User.class).list();
	}
	
	public void updateUser(User user) {
		getSession().update(user);
	}

	public void deleteUser(Integer userId) {
		getSession().delete(getUserById(userId));
	}

	public User getUserById(Integer userId) {
		return (User) getSession().get(User.class, userId);
	}

	public User getUserByUsername(String username) {
		return (User) getSession().createCriteria(User.class)
				.add(Restrictions.eq("username", username))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllManagers(Branch branch) {
		return (List<User>) getSession().createCriteria(User.class)
				.add(Restrictions.eq("branch", branch))
				.add(Restrictions.eq("role.id", 2))
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllEmployees(Branch branch) {
		return (List<User>) getSession().createCriteria(User.class)
				.add(Restrictions.eq("branch", branch))
				.list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
