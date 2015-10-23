package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Campeonato;
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
		TypedQuery<Jogador> query = super.manager.createQuery("select j from Jogador j JOIN j.times t where t = :time", Jogador.class);
		query.setParameter("time", time);
		return query.getResultList();
	}

	public List<Jogador> getListByCampeonato(Campeonato campeonato) {
		TypedQuery<Jogador> query = super.manager.createQuery("from Jogador j where j.campeonato.id = :campeonatoId", Jogador.class);
		query.setParameter("campeonatoId", campeonato.getId());
		return query.getResultList();
	}

}
