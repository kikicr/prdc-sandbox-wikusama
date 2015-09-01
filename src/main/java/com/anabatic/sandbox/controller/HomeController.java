package com.anabatic.sandbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ViewMethodReturnValueHandler;

@Controller
public class HomeController {
	@RequestMapping(value="",method=RequestMethod.GET)
	public String toLogin(){
		return "redirect:/login";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginPage(){
		return "home/login";
	}
	@RequestMapping(value="/error/{type}",method=RequestMethod.GET)
	public ModelAndView getErrorPage(@PathVariable("type") int type){
		String responseMsg="";
		String response="";
		switch (type) {
		case 403:
			response="Forbiden Page 403";
			 responseMsg="sorry you doesn't have permission to access this page";
			break;

		default:
			break;
		}
		ModelAndView mv=new ModelAndView("home/error");
		mv.addObject("errorMsg",responseMsg);
		mv.addObject("error", response);
		return mv;
	}
	
}
