package com.diegolirio.jcampeonato.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Status;

@Repository("edicaoDao")
public class EdicaoDao extends AbstractGenericDao<Edicao> {

	@SuppressWarnings("unchecked")
	public List<Edicao> getListPorStatus(Status status) {
		List<Edicao> list = (List<Edicao>) super.manager.createQuery("Select e from Edicao e where e.status.id = :idStatus")
					 									.setParameter("idStatus", status.getId())
					 									.getResultList();
		return list;
	}


	
}
