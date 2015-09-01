package com.anabatic.sandbox.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
	
	public T get(PK id);
	
	public T save(T model);
	
	public List<T> getAll();
	
	public void remove(PK id);
}
