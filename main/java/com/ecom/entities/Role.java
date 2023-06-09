package com.ecom.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;


@Entity
public class Role {

	@Id
	private int id;
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users =new HashSet<>();
	
	
	public Role(int id, String name, Set<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	
	
	
}
