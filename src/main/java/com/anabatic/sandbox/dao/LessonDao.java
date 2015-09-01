package com.anabatic.sandbox.dao;

import java.util.List;

import com.anabatic.sandbox.model.Lesson;

public interface LessonDao extends GenericDao<Lesson,Integer> {
	public List<Lesson> getAllLessonWithTrainer();
	
}
