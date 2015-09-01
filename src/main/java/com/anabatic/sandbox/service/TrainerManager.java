package com.anabatic.sandbox.service;

import java.util.List;

import com.anabatic.sandbox.model.Trainer;
import com.anabatic.sandbox.model.User;

public interface TrainerManager extends GenericManager<Trainer,Integer> {
	public List<User> getListUser();
}
