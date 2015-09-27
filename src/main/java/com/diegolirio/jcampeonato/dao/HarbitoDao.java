package com.diegolirio.jcampeonato.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Harbito;

@Repository("harbitoDao")
public class HarbitoDao extends AbstractGenericDao<Harbito> {

	public List<Harbito> getListaPorEdicao(Edicao edicao) {
		return this.getList(Harbito.class);
		//return super.manager.createQuery("Select h from Harbito h").;
	}

}
