package com.anabatic.sandbox.dao;

import java.util.List;

import com.anabatic.sandbox.helper.PagenationModel;
import com.anabatic.sandbox.model.User;

public interface UserDao extends GenericDao<User,String>{
	public User findUserByUserName(String name);
	public PagenationModel<User> getUserListByLimit(String condition);
	public List<User> getUserByRole(int roleId);
}
