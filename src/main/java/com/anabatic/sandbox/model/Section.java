package com.anabatic.sandbox.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="t_section")
public class Section {
	private int id;
	private String name;
	private Date date;
	@Column(name="date",nullable=false)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	private String startAt;
	private String endAt;
	@Id
	@Column(name="SectionId",length=10)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@NotEmpty
	@Column(name="section_name",length=20,nullable=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@NotEmpty
	@Column(name="section_startAt",length=20,nullable=false)
	public String getStartAt() {
		return startAt;
	}
	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}
	@NotEmpty
	@Column(name="section_endAt",length=20,nullable=false)
	public String getEndAt() {
		return endAt;
	}
	public void setEndAt(String endAt) {
		this.endAt = endAt;
	}
	
}
