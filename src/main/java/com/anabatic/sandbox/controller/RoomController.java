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
import com.anabatic.sandbox.service.LessonManager;
import com.anabatic.sandbox.service.RoomManager;

@Controller
@RequestMapping("/room-manager")
public class RoomController extends BaseFormController {
	public static final String URL="/room-manager";
	public static final String VIEW_PATH="room/";
	private RoomManager roomManager;
	@Autowired
	public void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}

	@RequestMapping(value="",method=RequestMethod.GET)
	public String home(){
		return "redirect:"+URL+"/list";
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getListLessonPage(Model model){
		List<Room> roomList=roomManager.getAll();
		model.addAttribute("roomList",roomList);
		return VIEW_PATH+"/list-room";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String getAddLesonPage(Room room,Model model){
		model.addAttribute("room",room);
		return VIEW_PATH+"/form-room";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String postAddLesonPage(Room room,Model model){
		roomManager.save(room);
		return "redirect:"+URL+"/";
	}
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String getEditLesonPage(@PathVariable("id")int id,Model model){
		model.addAttribute("room",this.roomManager.get(id));
		model.addAttribute("isEdit",true);
		return VIEW_PATH+"/form-room";
	}
	@RequestMapping(value="/do-edit/{id}",method=RequestMethod.POST)
	public String postEditLesonPage(@PathVariable("id")int id,Room room,Model model){
		room.setId(id);
		roomManager.save(room);
		return "redirect:"+URL+"/";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String getDeleteLesonPage(@PathVariable("id")int id,Model model){
		roomManager.remove(id);
		
		return "redirect:"+URL+"/";
	}
	
	
}
