package com.anabatic.sandbox.dao;

import com.anabatic.sandbox.model.Role;

public interface RoleDao extends GenericDao<Role,Integer> {
	public Role getRoleByName(String name);
}
