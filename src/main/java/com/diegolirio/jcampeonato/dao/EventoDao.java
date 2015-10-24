package com.diegolirio.jcampeonato.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Evento;

@Repository("eventoDao")
public class EventoDao extends AbstractGenericDao<Evento> {

	public Evento getByDescricao(String descricao) {
		try {
			return super.manager.createQuery("from Evento e where e.descricao = :descricao", Evento.class)
					            .setParameter("descricao", descricao)
					            .getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	
}
