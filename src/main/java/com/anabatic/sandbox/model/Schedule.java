package com.anabatic.sandbox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_schedule")
public class Schedule {
	private int id;
	private Lesson lesson;
	private Trainer trainer;
	
	@ManyToOne
	@JoinColumn(name="trainer_id")
	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	private Room room;
	private Section section;
	@Id
	@GeneratedValue
	@Column(name="schedule_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="lesson_id")
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	@ManyToOne
	@JoinColumn(name="room_id")
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	@ManyToOne
	@JoinColumn(name="section_id")
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
}
