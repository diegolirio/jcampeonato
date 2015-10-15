package com.diegolirio.jcampeonato.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Local;

@Repository("localDao")
public class LocalDao extends AbstractGenericDao<Local> {

	public List<Local> getListaPorEdicao(Edicao edicao) {
		return this.getList(Local.class);
		//return super.manager.createQuery("Select h from Harbito h").;
	}

}
