package com.anabatic.sandbox.service;

import java.util.List;

import com.anabatic.sandbox.model.Lesson;
import com.anabatic.sandbox.model.Room;
import com.anabatic.sandbox.model.Schedule;
import com.anabatic.sandbox.model.Section;
import com.anabatic.sandbox.model.Trainer;

public interface ScheduleService extends GenericManager<Schedule,Integer>{
	public List<Lesson> getLessonList();
	public List<Trainer> getTrainerList();
	public List<Room> getRoomList();
	public List<Section> getSectionList();
}
