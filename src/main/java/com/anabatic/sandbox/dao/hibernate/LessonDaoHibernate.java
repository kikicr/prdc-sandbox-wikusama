package com.anabatic.sandbox.dao.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.anabatic.sandbox.dao.LessonDao;
import com.anabatic.sandbox.model.Lesson;
@Repository
public class LessonDaoHibernate extends GenericDaoHibernate<Lesson,Integer> implements LessonDao {

	public LessonDaoHibernate() {
		super(Lesson.class);
		// TODO Auto-generated constructor stub
	}

	public List<Lesson> getAllLessonWithTrainer() {
		
		return null;
	}

	

}
