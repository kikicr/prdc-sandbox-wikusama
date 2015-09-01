package com.anabatic.sandbox.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.engine.Cascade;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="t_lesson")
public class Lesson {
	private int id;
	private String name;
	private String description;
	
	@Id
	@GeneratedValue
	@Column(name="lesson_id",length=10)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@NotEmpty
	@Column(name="lesson_name",length=100,nullable=false)
	public String getName() {
		return name;
	}
	@NotEmpty
	@Column(name="lesson_desc",nullable=false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
