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
import com.anabatic.sandbox.model.Trainer;
import com.anabatic.sandbox.service.TrainerManager;;


@Controller
@RequestMapping("/trainer-manager")
public class TrainerController extends BaseFormController {
	public static final String URL="/trainer-manager";
	public static final String VIEW_PATH="trainer/";
	private TrainerManager trainerManager;
	@Autowired
	public void setTrainerManager(TrainerManager tm) {
		this.trainerManager = tm;
	}

	@RequestMapping(value="",method=RequestMethod.GET)
	public String home(){
		return "redirect:"+URL+"/list";
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getListLessonPage(Model model){
		List<Trainer> lessonList=trainerManager.getAll();
		model.addAttribute("trainerList",lessonList);
		return VIEW_PATH+"/list-trainer";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String getAddLesonPage(Trainer trainer,Model model){
		model.addAttribute("listUser",trainerManager.getListUser());
		model.addAttribute("trainer",trainer);
		return VIEW_PATH+"/form-trainer";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String postAddLesonPage(Trainer trainer,Model model){
		trainerManager.save(trainer);
		return "redirect:"+URL+"/";
	}
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String getEditLesonPage(@PathVariable("id")int id,Model model){
		model.addAttribute("trainer",this.trainerManager.get(id));
		model.addAttribute("listUser",trainerManager.getListUser());
		model.addAttribute("isEdit",true);
		return VIEW_PATH+"/form-trainer";
	}
	@RequestMapping(value="/do-edit/{id}",method=RequestMethod.POST)
	public String postEditLesonPage(@PathVariable("id")int id,Trainer trainer,Model model){
		trainer.setId(id);
		trainerManager.save(trainer);
		return "redirect:"+URL+"/";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String getDeleteLesonPage(@PathVariable("id")int id,Lesson lesson,Model model){
		trainerManager.remove(id);
		
		return "redirect:"+URL+"/";
	}
	
	
}
