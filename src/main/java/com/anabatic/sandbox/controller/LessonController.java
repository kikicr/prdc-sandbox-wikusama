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
import com.anabatic.sandbox.service.LessonManager;

@Controller
@RequestMapping("/lesson-manager")
public class LessonController extends BaseFormController {
	public static final String URL="/lesson-manager";
	public static final String VIEW_PATH="lesson/";
	private LessonManager lessonManager;
	@Autowired
	public void setLessonManager(LessonManager lessonManager) {
		this.lessonManager = lessonManager;
	}

	@RequestMapping(value="",method=RequestMethod.GET)
	public String home(){
		return "redirect:"+URL+"/list";
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getListLessonPage(Model model){
		List<Lesson> lessonList=lessonManager.getAll();
		model.addAttribute("LessonList",lessonList);
		return VIEW_PATH+"/list-lesson";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String getAddLesonPage(Lesson lesson,Model model){
		model.addAttribute("lesson",lesson);
		return VIEW_PATH+"/form-lesson";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String postAddLesonPage(Lesson lesson,Model model){
		lessonManager.save(lesson);
		return "redirect:"+URL+"/";
	}
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String getEditLesonPage(@PathVariable("id")int id,Lesson lesson,Model model){
		model.addAttribute("lesson",this.lessonManager.get(id));
		model.addAttribute("isEdit",true);
		return VIEW_PATH+"/form-lesson";
	}
	@RequestMapping(value="/do-edit/{id}",method=RequestMethod.POST)
	public String postEditLesonPage(@PathVariable("id")int id,Lesson lesson,Model model){
		lesson.setId(id);
		lessonManager.save(lesson);
		return "redirect:"+URL+"/";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String getDeleteLesonPage(@PathVariable("id")int id,Lesson lesson,Model model){
		lessonManager.remove(id);
		
		return "redirect:"+URL+"/";
	}
	
	
}
