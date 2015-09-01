package com.anabatic.sandbox.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.anabatic.sandbox.enumeration.GenderEnum;

@Entity
@Table(name = "t_user")
public class User {
	private String id;
	private String name;
	private String email;
	private GenderEnum gender;
	private String address;
	private String password;
	private boolean enabled;
	private String picture;
	@Column(name="picture",nullable=false)
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	private Set<Role> role = new HashSet<Role>();

	@Column(name = "user_enabled", nullable = false)
	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Id
	@Column(name = "user_id", length = 12)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty
	@Column(name = "name", length = 100,nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotEmpty
	@Column(name = "email", length = 100,nullable=false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "gender", length = 1,nullable=false)
	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	@NotEmpty
	@Column(name = "address", length = 255,nullable=false)
	public String getAddress() {
		return address;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "t_role_user", 
		joinColumns = { @JoinColumn(name = "id_user") }, 
		inverseJoinColumns = @JoinColumn(name = "id_login") )
	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@NotEmpty
	@Column(name = "password", length = 100,nullable=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
