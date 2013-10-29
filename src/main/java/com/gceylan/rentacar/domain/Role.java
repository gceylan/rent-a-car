package com.gceylan.rentacar.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

	@ManyToMany(mappedBy = "roles")
	private List<User> users;

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	/*
	 * eğer toString metoduna, users nesne değişkenini de eklemek istersem,
	 * toString çağrıldığında hibernate bağırır. çünkü users nesne değişkeni
	 * @ManyToMany ve @ManyToMany varsayılanda FetchType' ı LAZY dir. Yani, bir
	 * role nesnesini veritabanından çekersem, users listesinin içi dolmaz. User
	 * nesneleri veritabanında join ile bağlanıp getirilmez!!!
	 */

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

}
