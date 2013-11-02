package com.gceylan.rentacar.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@OneToMany
	@JoinTable(
		name = "user_role",
		joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") },
		inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id")})
	private Set<User> users;

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}
