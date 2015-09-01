package com.anabatic.sandbox.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.anabatic.sandbox.dao.UserDao;
import com.anabatic.sandbox.model.Role;
import com.anabatic.sandbox.model.User;

public class SpringSecurityImp implements UserDetailsService {
	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		User user = userDao.findUserByUserName(arg0);

		java.util.List<GrantedAuthority> authorities = buildUserAuthority(user
				.getRole());

		return buildUserForAuthentication(user, authorities);
	}

	private org.springframework.security.core.userdetails.User buildUserForAuthentication(
			User user, java.util.List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(
				user.getId(), user.getPassword(), user.getEnabled(), true,
				true, true, authorities);
	}

	private java.util.List<GrantedAuthority> buildUserAuthority(
			Set<Role> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		for (Role coreRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(coreRole.getName()));
		}
		java.util.List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);
		return Result;
	}

}
