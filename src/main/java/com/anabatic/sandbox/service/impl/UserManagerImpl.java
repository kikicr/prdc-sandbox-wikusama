package com.anabatic.sandbox.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.relation.RoleResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.anabatic.sandbox.dao.RoleDao;
import com.anabatic.sandbox.dao.TrainerDao;
import com.anabatic.sandbox.dao.UserDao;
import com.anabatic.sandbox.dto.RoleDto;
import com.anabatic.sandbox.dto.UserDto;
import com.anabatic.sandbox.enumeration.GenderEnum;
import com.anabatic.sandbox.helper.EncryptHelper;
import com.anabatic.sandbox.helper.PagenationModel;

import com.anabatic.sandbox.model.Role;
import com.anabatic.sandbox.model.Trainer;
import com.anabatic.sandbox.model.User;
import com.anabatic.sandbox.service.UserManager;
@Service
public class UserManagerImpl extends GenericManagerImpl<User,String> implements UserManager{

	
	private UserDao userDao;
	private TrainerDao trainerDao;
	
	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	private RoleDao roleDao;
	
	public User findByUserName(String name) {
		// TODO Auto-generated method stub
		return this.userDao.findUserByUserName(name);
	}
	public UserDao getUserDao() {
		return userDao;
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		this.dao=userDao;
	}
	
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Role> getRoleList() {
		try{
			return roleDao.getAll();
		}catch(Exception e){ 
			e.printStackTrace();
		}
		return new ArrayList<Role>(0);
	}
	
	public PagenationModel<User> getUserListByLimit(String condition) {
		// TODO Auto-generated method stub
		 return userDao.getUserListByLimit(condition);
	}
	
	public List<User> getUserListByRole(int roleId) {
		// TODO Auto-generated method stub
		return userDao.getUserByRole(roleId);
	}
	@Override
	public void registerUserFromList(List<Map<String, Object>> list) {
		for(Map<String,Object> map:list){
			
			
			User user=new User();
			user.setName((String)map.get("name"));
			user.setEmail((String)map.get("email"));
			user.setAddress((String)map.get("address"));
			user.setEnabled(true);
			System.out.println(map.get("email"));
			user.setPassword(EncryptHelper.md5((String)map.get("password")));
			user.setId((String)map.get("id"));
			Set<Role> role=new HashSet<Role>();
			role.add(roleDao.getRoleByName((String)map.get("role")));
			user.setRole(role);
			if(((String)map.get("gender")).equalsIgnoreCase("male")){
			user.setGender(GenderEnum.MALE);
			}else{
				user.setGender(GenderEnum.FEMALE);
			}
			user.setPicture("");
			userDao.save(user);
		}
		
	}
	
}
