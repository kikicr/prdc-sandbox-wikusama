package com.anabatic.sandbox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anabatic.sandbox.dao.RoleDao;
import com.anabatic.sandbox.model.Role;
import com.anabatic.sandbox.service.RoleManager;
@Service
public class RoleManagerImpl extends GenericManagerImpl<Role,Integer> implements RoleManager {
	private RoleDao roleDao;
	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
		this.dao=roleDao;
	}
}
