package com.adaming.utils;

import java.util.List;

public interface DaoGeneric<T> {

	public void create(T obj);

	public void update(T obj);

	public void delete( T obj);

	public T getById(Class<T> obj, Long id);

	public List<T> find(Class<T> obj);
	
	public List<T> findAll(Class<T> obj);

}
