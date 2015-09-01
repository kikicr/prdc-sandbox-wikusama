package com.anabatic.sandbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anabatic.sandbox.dao.TrainerDao;
import com.anabatic.sandbox.dao.UserDao;
import com.anabatic.sandbox.model.Trainer;
import com.anabatic.sandbox.model.User;
import com.anabatic.sandbox.service.TrainerManager;
@Service
public class TrainerManagerImpl extends GenericManagerImpl<Trainer,Integer> implements TrainerManager{
		private TrainerDao tr;
		private UserDao usr;
		
	

		@Autowired
		public void setUsr(UserDao usr) {
			this.usr = usr;
		}


		@Autowired
		public void setTr(TrainerDao tr) {
			this.tr = tr;
			this.dao=tr;
		}


		@Override
		public List<User> getListUser() {
			// TODO Auto-generated method stub
			return usr.getAll();
		}
		
}
