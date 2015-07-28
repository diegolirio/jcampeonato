package com.diegolirio.jcampeonato.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Grupo;

@Repository("grupoDao")
public class GrupoDao extends AbstractGenericDao<Grupo> {

	@SuppressWarnings("unchecked")
	public List<Grupo> getListaPorEdicao(Edicao edicao) {
		List<Grupo> grupos = (List<Grupo>) super.manager.createQuery("Select g from Grupo g where g.edicao.id = :edicaoId")
				                                		.setParameter("edicaoId", edicao.getId())
				                                		.getResultList();
		return grupos;
	}

}
