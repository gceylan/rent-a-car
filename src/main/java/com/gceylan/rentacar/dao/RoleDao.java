package com.gceylan.rentacar.dao;

import java.util.List;

import com.gceylan.rentacar.domain.Role;

public interface RoleDao {
	
	public void addRole(Role role);
	
	public List<Role> getAllRoles();
	
	public void deleteRole(Integer roleId);
	
	public Role getRoleById(Integer roleId);
	
	public Role getRoleByName(String name);

}
