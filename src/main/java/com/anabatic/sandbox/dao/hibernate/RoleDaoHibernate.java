package com.anabatic.sandbox.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.anabatic.sandbox.dao.RoleDao;
import com.anabatic.sandbox.model.Role;

@Repository
public class RoleDaoHibernate extends GenericDaoHibernate<Role, Integer>
		implements RoleDao {

	public RoleDaoHibernate() {
		super(Role.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Role getRoleByName(String name) {

		return (Role) getEntityManager()
				.createQuery("select a from Role a where a.name=:name")
				.setParameter("name", name).getSingleResult();
	}

}
