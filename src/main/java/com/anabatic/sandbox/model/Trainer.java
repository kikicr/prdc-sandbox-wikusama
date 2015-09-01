package com.anabatic.sandbox.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_trainer")
public class Trainer {
	private int id;
	private String workAt;
	private String quote;
	@Column(name="workAt",nullable=false)
	public String getWorkAt() {
		return workAt;
	}
	public void setWorkAt(String workAt) {
		this.workAt = workAt;
	}
	@Column(name="quote",nullable=false)
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	private User user;
	
	@Id
	@GeneratedValue
	@Column(name="trainer_id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
