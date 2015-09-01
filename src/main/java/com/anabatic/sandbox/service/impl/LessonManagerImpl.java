package com.anabatic.sandbox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anabatic.sandbox.dao.LessonDao;
import com.anabatic.sandbox.model.Lesson;
import com.anabatic.sandbox.service.LessonManager;
@Service
public class LessonManagerImpl extends GenericManagerImpl<Lesson,Integer> implements LessonManager {
	private LessonDao lessonDao;
	@Autowired
	public void setLessonDao(LessonDao lessonDao) {
		this.lessonDao = lessonDao;
		this.dao=lessonDao;
	}


}
