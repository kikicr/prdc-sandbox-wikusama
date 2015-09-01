package com.anabatic.sandbox.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.anabatic.sandbox.dto.RoleDto;
import com.anabatic.sandbox.dto.UserDto;
import com.anabatic.sandbox.helper.PagenationModel;
import com.anabatic.sandbox.model.Role;
import com.anabatic.sandbox.model.User;

public interface UserManager extends GenericManager<User,String> {
	public User findByUserName(String name);
	public void registerUserFromList(List<Map<String,Object>> list);
	
	public List<Role> getRoleList();
	public PagenationModel<User> getUserListByLimit(String condition);
	public List<User> getUserListByRole(int roleId);
}
