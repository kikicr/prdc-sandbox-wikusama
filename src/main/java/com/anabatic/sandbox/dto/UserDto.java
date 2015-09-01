package com.anabatic.sandbox.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.anabatic.sandbox.enumeration.GenderEnum;



public class UserDto {
	private int id;
	private String name;
	private String email;
	private GenderEnum gender;
	private String address;
	private String password;
	private boolean enabled;
	private RoleDto roleDto;
	
	public UserDto(int id, String name, String email, GenderEnum gender,
			String address, String password, boolean enabled, RoleDto roleDto) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.password = password;
		this.enabled = enabled;
		this.roleDto = roleDto;
	}

	public RoleDto getRoleDto() {
		return roleDto;
	}

	public void setRoleDto(RoleDto roleDto) {
		this.roleDto = roleDto;
	}

	public boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public GenderEnum getGender() {
		return gender;
	}
	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
		public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	 
}
