package com.anabatic.sandbox.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.anabatic.sandbox.dao.ScheduleDao;
import com.anabatic.sandbox.dao.SectionDao;
import com.anabatic.sandbox.model.Schedule;
@Repository
public class SheduleDaoHibernate extends GenericDaoHibernate<Schedule,Integer> implements ScheduleDao {

	public SheduleDaoHibernate() {
		super(Schedule.class);
		// TODO Auto-generated constructor stub
	}

}
