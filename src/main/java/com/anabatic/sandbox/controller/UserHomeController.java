package com.anabatic.sandbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anabatic.sandbox.model.Schedule;
import com.anabatic.sandbox.model.User;
import com.anabatic.sandbox.service.ScheduleService;
import com.anabatic.sandbox.service.UserManager;

@Controller
@RequestMapping("/me")
public class UserHomeController {
	private UserManager userManager;
	private ScheduleService scheduleService;
	@Autowired
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	@RequestMapping(value="" ,method=RequestMethod.GET)
	public String home(Model model){
		return "usermain/home";
	}
	@RequestMapping(value="/look-class" ,method=RequestMethod.GET)
	public List<Schedule> lookClass(Model model){
		return scheduleService.getAll(); 
	}
	@RequestMapping(value="/profile/{id}" ,method=RequestMethod.GET)
	public String lookProfile(Model model,@PathVariable("id") String id){
		User userPrincipal=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userPrincipal.getEmail()==id){
		model.addAttribute("profile",userManager.get(id));}else{
			return "redirect:/error/403";
		}
		return "usermain/look-profile";
	}
}
