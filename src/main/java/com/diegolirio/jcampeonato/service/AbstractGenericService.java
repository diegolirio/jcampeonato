package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.AbstractGenericDao;

@Service
public abstract class AbstractGenericService<T> {

	@Qualifier("dao")
	@Autowired
	private AbstractGenericDao<T> dao;
	
	public T get(Class<T> typeClass, long id) {
		return this.dao.get(typeClass, id);
	}
	
	public List<T> getList(Class<T> typeClass) {
		return this.dao.getList(typeClass);
	}	
	
	public void save(T object) {
		this.dao.save(object);
	}
 
	public void delete(Class<T> typeClass, long id) {
		this.dao.delete(typeClass, id); 
	}
	
	public void update(T object) {
		this.dao.update(object);
	}		
	
}
