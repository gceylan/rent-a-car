package com.gceylan.rentacar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gceylan.rentacar.dao.RoleDao;
import com.gceylan.rentacar.domain.Role;
import com.gceylan.rentacar.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Transactional
	public void addRole(Role role) {
		roleDao.addRole(role);
	}

	@Transactional
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

	@Transactional
	public void deleteRole(Integer roleId) {
		roleDao.deleteRole(roleId);
	}

	@Transactional
	public Role getRoleById(Integer roleId) {
		return roleDao.getRoleById(roleId);
	}

	@Transactional
	public Role getRoleByName(String name) {
		return roleDao.getRoleByName(name);
	}
	
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
