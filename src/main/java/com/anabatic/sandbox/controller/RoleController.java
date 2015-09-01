package com.anabatic.sandbox.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anabatic.sandbox.model.Role;
import com.anabatic.sandbox.service.RoleManager;

@Controller
@RequestMapping("/role-manager")
public class RoleController extends BaseFormController {
	public static final String URL = "/role-manager";
	public static final String VIEW_PATH = "/role";
	private RoleManager roleManager;

	@Autowired
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home() {
		return "redirect:" + URL + "/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getRoleListPage(Model model) {
		List<Role> roleList = roleManager.getAll();
		model.addAttribute("roleList", roleList);
		return VIEW_PATH + "/list-role";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddRolePage(Model model, Role role, HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("role", role);
		if(request.getParameter("cancel")!=null){
			return "redirect:" + URL + "/list";
		}
		return VIEW_PATH + "/form-role";
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String doDelete(@PathVariable("id") int id){
		roleManager.remove(id);
		return "redirect:"+URL+"/list-role";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String doAddRole(Model model, Role role, HttpServletRequest request,
			HttpServletResponse response) {
		
			this.roleManager.save(role);
		
		return "redirect:" + URL + "/list";

	}
}
