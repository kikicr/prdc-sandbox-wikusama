package com.anabatic.sandbox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anabatic.sandbox.dao.RoomDao;
import com.anabatic.sandbox.model.Room;
import com.anabatic.sandbox.service.RoomManager;
@Service
public class RoomManagerImpl extends GenericManagerImpl<Room,Integer> implements RoomManager {
	private RoomDao roomDao;
	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
		this.dao=roomDao;
	}
	
	
	
}
