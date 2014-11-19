package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("dao")
public class AbstractGenericDao<T> {

	@PersistenceContext(name="mysql_q")
	private EntityManager manager;
	
	public T get(Class<T> typeClass, long id) {
		return this.manager.find(typeClass, id);
	}
	
	public List<T> getList(Class<T> typeClass) {
		String hql = "Select t from " + typeClass.getName() + " t";
		return this.manager.createQuery(hql, typeClass).getResultList();
	}	
	
	@Transactional 
	public void save(T object) {
		this.manager.persist(object);
	}
 
	@Transactional
	public void delete(Class<T> typeClass, long id) {
		T t = (T) this.manager.find(typeClass, id); 
		this.manager.remove(t); 
	}
	
	@Transactional
	public void update(T object) {
		this.manager.merge(object);
	}	
	
}
