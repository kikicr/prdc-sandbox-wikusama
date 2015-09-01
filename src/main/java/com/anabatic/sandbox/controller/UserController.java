package com.anabatic.sandbox.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.anabatic.sandbox.dto.UserDto;
import com.anabatic.sandbox.enumeration.GenderEnum;
import com.anabatic.sandbox.helper.EncryptHelper;
import com.anabatic.sandbox.helper.PagenationModel;
import com.anabatic.sandbox.helper.Upload;
import com.anabatic.sandbox.model.Role;
import com.anabatic.sandbox.model.Trainer;
import com.anabatic.sandbox.model.User;
import com.anabatic.sandbox.service.ExcelImportService;
import com.anabatic.sandbox.service.RoleManager;
import com.anabatic.sandbox.service.TrainerManager;
import com.anabatic.sandbox.service.impl.UserManagerImpl;

@Controller
@RequestMapping("/user-manager")
public class UserController extends BaseFormController {
	public static final String VIEW_PATH = "user";
	@Autowired
	private UserManagerImpl userManager;
	@Autowired
	private RoleManager roleManager;
	@Autowired
	private ExcelImportService excelImportService;

	@RequestMapping(value = "/add-user/", method = RequestMethod.GET)
	public String getAddUserFormPage(User user, Model model) {

		model.addAttribute("user", user);

		model.addAttribute("gender", GenderEnum.values());
		model.addAttribute("roleList", userManager.getRoleList());
		return VIEW_PATH + "/form-user";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getListUserPage(Model model) {
		return "redirect:/user-manager/list-user/10/1";
	}

	@RequestMapping(value = "list-user/{limit}/{page}", method = RequestMethod.GET)
	public String getListUserPage(@PathVariable("page") int page,
			@PathVariable("limit") int limit, Model model) {
		PagenationModel<User> pg = userManager.getUserListByLimit("");
		pg.setPageLimit(limit);
		model.addAttribute("pageLimit", limit);
		model.addAttribute("totalPage", pg.getTotalPage());
		model.addAttribute("userList", pg.getPage(page));
		return VIEW_PATH + "/list-user";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") String id, Model model) {
		userManager.remove(id);
		return "redirect:/user-manager/list-user/1";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String getEditPage(@PathVariable("id") String id, Model model,
			User user) {
		user = userManager.get(id);
		int roleId = 0;
		for (Role role : user.getRole()) {
			roleId = role.getId();
		}
		model.addAttribute("gender", GenderEnum.values());
		model.addAttribute("roleList", userManager.getRoleList());
		model.addAttribute("roleId", roleId);
		model.addAttribute("user", user);
		model.addAttribute("isEdit", true);
		return VIEW_PATH + "/form-user";
	}
	@RequestMapping(value="/import/",method=RequestMethod.POST)
	public String postAddUserFromExcel(
			@RequestParam("excel") MultipartFile multipartFile) {
		try {
			List<Map<String, Object>> listFromExcel = excelImportService
					.getMapListFromSheet(multipartFile.getInputStream(), 0);
			userManager.registerUserFromList(listFromExcel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/user-manager/";
	}

	@RequestMapping(value = "/do-add-user", method = RequestMethod.POST)
	public String doAddUser(
			@RequestParam(value = "roleList", required = false) Integer[] roleList,
			User user, HttpServletRequest request,
			HttpServletResponse response, BindingResult errors, Model model,
			@RequestParam("photo") MultipartFile photo) {
		try {

			if (request.getParameter("cancel") != null) {
				return "redirect:/user-manager/form-user";
			} else {

				HashSet<Role> roleSet = new HashSet<Role>();
				for (Integer roleId : roleList) {
					Role role = new Role();
					role.setId(roleId);
					roleSet.add(role);
				}

				user.setRole(roleSet);
				String enc = EncryptHelper.md5(user.getPassword());
				user.setPassword(enc);
				user.setPicture(Upload.fileUpload(user.getId() + ".jpeg", photo));

				enc = null;
				return "redirect:/user-manager/list-user/5/1";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = "/do-edit-user/{id}", method = RequestMethod.POST)
	public String doEditUser(
			@PathVariable("id") String id,
			@RequestParam("photo") MultipartFile photo,
			@RequestParam(value = "roleList", required = false) Integer[] roleList,
			User user, HttpServletRequest request,
			HttpServletResponse response, BindingResult errors, Model model) {
		try {
			System.out.println("mlebu");
			if (request.getParameter("cancel") != null) {
				return "redirect:/user-manager/form-user";
			} else {
				User tempUserData = userManager.get(id);
				if (user.getPassword().length() < 1) {
					user.setPassword(tempUserData.getPassword());

				} else {
					String enc = EncryptHelper.md5(user.getPassword());
					user.setPassword(enc);
					enc = null;
				}
				HashSet<Role> roleSet = new HashSet<Role>();
				for (Integer roleId : roleList) {
					Role role = new Role();
					role.setId(roleId);
					roleSet.add(role);
				}
				user.setRole(roleSet);
				user.setPicture(Upload.fileUpload(user.getId() + ".jpeg", photo));
				userManager.save(user);

				return "redirect:/user-manager/list-user/5/1";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
