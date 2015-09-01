package com.anabatic.sandbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anabatic.sandbox.dao.LessonDao;
import com.anabatic.sandbox.dao.RoomDao;
import com.anabatic.sandbox.dao.ScheduleDao;
import com.anabatic.sandbox.dao.SectionDao;
import com.anabatic.sandbox.dao.TrainerDao;
import com.anabatic.sandbox.model.Lesson;
import com.anabatic.sandbox.model.Room;
import com.anabatic.sandbox.model.Schedule;
import com.anabatic.sandbox.model.Section;
import com.anabatic.sandbox.model.Trainer;
import com.anabatic.sandbox.service.ScheduleService;
import com.anabatic.sandbox.service.SectionManager;

@Service
public class ScheduleManagerImpl extends GenericManagerImpl<Schedule,Integer> implements ScheduleService {
	private ScheduleDao scheduleDao;
	private LessonDao lessonDao;
	private TrainerDao trainerDao;
	private RoomDao roomDao;
	private SectionDao sectionDao;
	@Autowired
	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
		this.dao=scheduleDao;
	}
	@Autowired
	public void setLessonDao(LessonDao lessonDao) {
		this.lessonDao = lessonDao;
	}
	@Autowired
	public void setTrainerDao(TrainerDao trainerDao) {
		this.trainerDao = trainerDao;
	}
	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	@Autowired

	public void setSectionDao(SectionDao sectionDao) {
		this.sectionDao = sectionDao;
	}

	@Override
	public List<Lesson> getLessonList() {
		// TODO Auto-generated method stub
		return lessonDao.getAll();
	}

	@Override
	public List<Trainer> getTrainerList() {
		// TODO Auto-generated method stub
		return trainerDao.getAll();
	}

	@Override
	public List<Room> getRoomList() {
		// TODO Auto-generated method stub
		return roomDao.getAll();
	}

	@Override
	public List<Section> getSectionList() {
		// TODO Auto-generated method stub
		return sectionDao.getAll();
	}
	
}
