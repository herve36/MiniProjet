package com.adaming.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.utils.DaoGeneric;
import com.adaming.utils.ServiceGeneric;

@Service
@Transactional
public class ServiceGenericImpl<T> implements ServiceGeneric<T> {

	@Autowired
	@Qualifier(value="daoGen")
	private DaoGeneric<T> daoGeneric;

	//A SUPP
    /*public void setDaoGeneric(DaoGeneric<T> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}*/

	public void create(T obj) {
		daoGeneric.create(obj);
	}

	public void update(T obj) {
		daoGeneric.update(obj);
	}

	public void delete(T obj) {
		daoGeneric.delete(obj);

	}

	public T getById(Class<T> obj, Long id) {
		return daoGeneric.getById(obj, id);
	}

	public List<T> find(Class<T> obj) {
		return daoGeneric.find(obj);
	}

}
