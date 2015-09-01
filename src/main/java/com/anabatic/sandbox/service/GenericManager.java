package com.anabatic.sandbox.service;

import java.io.Serializable;
import java.util.List;

public interface GenericManager<T, PK extends Serializable> {
	
	T get(PK id);
	
	T save(T model);
	
	List<T> getAll();
	
	void remove(PK id);
}
