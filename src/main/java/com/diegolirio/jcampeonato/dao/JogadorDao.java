package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Jogador;
import com.diegolirio.jcampeonato.model.Time;

@Repository("jogadorDao")
public class JogadorDao extends AbstractGenericDao<Jogador> {

	/**
	 * Busca jogadores por time
	 * @param time
	 * @return list jogadores
	 */
	public List<Jogador> getListByTime(Time time) {
		@SuppressWarnings("unchecked")
		TypedQuery<Jogador> query = (TypedQuery<Jogador>) super.manager.createQuery("from Jogador j JOIN j.times t where t.id = :timeId");
		query.setParameter("timeId", time.getId());
		return query.getResultList();
	}

}
