package com.anabatic.sandbox.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anabatic.sandbox.model.Lesson;
import com.anabatic.sandbox.model.Room;
import com.anabatic.sandbox.model.Schedule;
import com.anabatic.sandbox.service.LessonManager;
import com.anabatic.sandbox.service.RoomManager;
import com.anabatic.sandbox.service.ScheduleService;

@Controller
@RequestMapping("/schedule-manager")
public class ScheduleController extends BaseFormController {
	public static final String URL="/schedule-manager";
	public static final String VIEW_PATH="schedule/";
	private ScheduleService scheduleService;
	
	
@Autowired
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	@RequestMapping(value="",method=RequestMethod.GET)
	public String home(){
		return "redirect:"+URL+"/list";
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getListLessonPage(Model model){
		List<Schedule> scheduleList=scheduleService.getAll();
		model.addAttribute("scheduleList",scheduleList);
		return VIEW_PATH+"/list-schedule";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String getAddLesonPage(Schedule schedule,Model model){
		model.addAttribute("roomList",scheduleService.getRoomList());
		model.addAttribute("lessonList",scheduleService.getLessonList());
		model.addAttribute("trainerList",scheduleService.getTrainerList());
		model.addAttribute("sectionList",scheduleService.getSectionList());
		model.addAttribute("schedule",schedule);
		return VIEW_PATH+"/form-schedule";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String postAddLesonPage(Schedule schedule,Model model){
		scheduleService.save(schedule);
		return "redirect:"+URL+"/";
	}
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String getEditLesonPage(@PathVariable("id")int id,Lesson lesson,Model model){
		model.addAttribute("roomList",scheduleService.getRoomList());
		model.addAttribute("lessonList",scheduleService.getLessonList());
		model.addAttribute("trainerList",scheduleService.getTrainerList());
		model.addAttribute("sectionList",scheduleService.getSectionList());
		model.addAttribute("schedule",scheduleService.get(id));
		model.addAttribute("isEdit",true);
		return VIEW_PATH+"/form-schedule";
	}
	@RequestMapping(value="/do-edit/{id}",method=RequestMethod.POST)
	public String postEditLesonPage(@PathVariable("id")int id,Schedule schedule,Model model){
		schedule.setId(id);
		scheduleService.save(schedule);
		return "redirect:"+URL+"/";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String getDeleteLesonPage(@PathVariable("id")int id,Model model){
		scheduleService.remove(id);
		
		return "redirect:"+URL+"/";
	}
	
	
}
