package com.anabatic.sandbox.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anabatic.sandbox.model.Lesson;
import com.anabatic.sandbox.model.Room;
import com.anabatic.sandbox.service.LessonManager;
import com.anabatic.sandbox.service.RoomManager;
import com.anabatic.sandbox.service.SectionManager;
import com.anabatic.sandbox.model.Section;

@Controller
@RequestMapping("/section-manager")
public class SectionController extends BaseFormController {
	public static final String URL="/section-manager";
	public static final String VIEW_PATH="section/";
	private SectionManager sectionManager;
	@Autowired
	public void setRoomManager(SectionManager roomManager) {
		this.sectionManager = roomManager;
	}

	@RequestMapping(value="",method=RequestMethod.GET)
	public String home(){
		return "redirect:"+URL+"/list";
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getListLessonPage(Model model){
		List<Section> sectionList=sectionManager.getAll();
		model.addAttribute("sectionList",sectionList);
		return VIEW_PATH+"/list-section";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String getAddLesonPage(Section section,Model model){
		model.addAttribute("section",section);
		return VIEW_PATH+"/form-section";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String postAddLesonPage(Section section,Model model,@RequestParam("date") Date date){
		
				sectionManager.save(section);
		return "redirect:"+URL+"/";
	}
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String getEditLesonPage(@PathVariable("id")int id,Lesson lesson,Model model){
		model.addAttribute("section",this.sectionManager.get(id));
		model.addAttribute("isEdit",true);
		return VIEW_PATH+"/form-section";
	}
	@RequestMapping(value="/do-edit/{id}",method=RequestMethod.POST)
	public String postEditLesonPage(@PathVariable("id")int id,Section section,Model model){
		section.setId(id);
		sectionManager.save(section);
		return "redirect:"+URL+"/";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String getDeleteLesonPage(@PathVariable("id")int id,Model model){
		sectionManager.remove(id);
		
		return "redirect:"+URL+"/";
	}
	
	
}
