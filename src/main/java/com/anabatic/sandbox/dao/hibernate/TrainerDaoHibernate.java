package com.anabatic.sandbox.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.anabatic.sandbox.dao.TrainerDao;
import com.anabatic.sandbox.model.Trainer;
@Repository
public class TrainerDaoHibernate extends GenericDaoHibernate<Trainer,Integer> implements TrainerDao {

	public TrainerDaoHibernate() {
		super(Trainer.class);
		// TODO Auto-generated constructor stub
	}

}
