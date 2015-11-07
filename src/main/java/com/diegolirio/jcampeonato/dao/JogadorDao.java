package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Escalacao;
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
		TypedQuery<Jogador> query = super.manager.createQuery("select j from Jogador j JOIN j.times t where t = :time order by j.posicao.id", Jogador.class);
		query.setParameter("time", time);
		return query.getResultList();
	}

	public List<Jogador> getListByCampeonato(Campeonato campeonato) {
		TypedQuery<Jogador> query = super.manager.createQuery("from Jogador j where j.campeonato.id = :campeonatoId", Jogador.class);
		query.setParameter("campeonatoId", campeonato.getId());
		return query.getResultList();
	}

	/**
	 * lista jogadores nao escalados
	 * @param escalacao
	 * @return lista
	 */
	public List<Jogador> getListNotEscalacao(Escalacao escalacao) {
		String sql = "select j from Jogador j where j.id not In ( select je.jogador.id from JogadorEscalado je" +
																   " where je.escalacao.id = :escalcaoId )" +
					 " order by j.posicao.id";
		TypedQuery<Jogador> query = this.manager.createQuery(sql, Jogador.class);
		query.setParameter("escalcaoId", escalacao.getId());
		return query.getResultList();
	}

}
