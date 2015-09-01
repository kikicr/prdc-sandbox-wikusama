package com.anabatic.sandbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAdminHomePage(Model model) {
		return "admin/home";
	}
	@RequestMapping(value = "/{url}", method = RequestMethod.GET)
	public String getPageWithMp(Model model,@PathVariable("url") String url) {
		model.addAttribute("view",url);
		return "admin/master-page";
	}

}
