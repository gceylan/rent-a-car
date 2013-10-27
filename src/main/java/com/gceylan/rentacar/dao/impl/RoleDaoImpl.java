package com.gceylan.rentacar.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gceylan.rentacar.dao.RoleDao;
import com.gceylan.rentacar.domain.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession(); 
	}

	public void addRole(Role role) {
		getSession().save(role);
	}

	@SuppressWarnings("unchecked")
	public List<Role> getAllRoles() {
		return (List<Role>) getSession().createCriteria(Role.class).list();
	}

	public void deleteRole(Integer roleId) {
		getSession().delete(getRoleById(roleId));
	}

	public Role getRoleById(Integer roleId) {
		return (Role) getSession().get(Role.class, roleId);
	}

	public Role getRoleByName(String name) {
		return (Role) getSession().createCriteria(Role.class)
				.add(Restrictions.eq("name", name))
				.uniqueResult();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
