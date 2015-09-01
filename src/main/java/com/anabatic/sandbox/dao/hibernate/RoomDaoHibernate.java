package com.anabatic.sandbox.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.anabatic.sandbox.dao.RoomDao;
import com.anabatic.sandbox.model.Room;

@Repository
public class RoomDaoHibernate extends GenericDaoHibernate<Room, Integer> implements RoomDao {

	public RoomDaoHibernate() {
		super(Room.class);
		// TODO Auto-generated constructor stub
	}

}
