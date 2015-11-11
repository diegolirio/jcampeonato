package com.diegolirio.jcampeonato.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Fase;

@Repository("faseDao")
public class FaseDao extends AbstractGenericDao<Fase> {

	public Fase getBySigla(char sigla) {
		try {
			return super.manager.createQuery("from Fase f where f.sigla = :sigla", Fase.class).setParameter("sigla", sigla).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
