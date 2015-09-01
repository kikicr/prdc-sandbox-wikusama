package com.anabatic.sandbox.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_role")
public class Role {
	private int id;
	private String name;
	private Set<User> user;
	
	@ManyToMany(mappedBy="role")
	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Id
	@GeneratedValue
	@Column(name="role_id",nullable=false)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="role_name",nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
