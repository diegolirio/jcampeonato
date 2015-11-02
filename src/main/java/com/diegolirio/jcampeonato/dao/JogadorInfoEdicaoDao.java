package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Jogador;
import com.diegolirio.jcampeonato.model.JogadorInfoEdicao;

@Repository("jogadorInfoEdicaoDao")
public class JogadorInfoEdicaoDao extends AbstractGenericDao<JogadorInfoEdicao> {

	/**
	 * pega jogadorInfoEdicao por jogador e edicao
	 * @param jogador
	 * @param edicao
	 * @return jogadorInfoEdicao
	 */
	public JogadorInfoEdicao getByJogadorAndEdicao(Jogador jogador, Edicao edicao) {
		String jpql = "from JogadorInfoEdicao jie where jie.jogador = :jogador and jie.edicao = :edicao";
		TypedQuery<JogadorInfoEdicao> query = super.manager.createQuery(jpql, JogadorInfoEdicao.class);
		query.setParameter("jogador", jogador);
		query.setParameter("edicao", edicao);
		try {
			return query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

	/**
	 * pega lista de jogadorInfoEdicao por edicao
	 * @param edicao
	 * @return lista de jogadorInfoEdicao
	 */
	public List<JogadorInfoEdicao> getByEdicao(Edicao edicao) {
		String jpql = "from JogadorInfoEdicao jie where jie.edicao = :edicao order by jie.gols desc";
		TypedQuery<JogadorInfoEdicao> query = super.manager.createQuery(jpql, JogadorInfoEdicao.class);
		query.setParameter("edicao", edicao);
		return query.getResultList();
	}

	/**
	 * pega jogadorInfoEdicao por edicao e jogador
	 * @param edicao
	 * @param jogador
	 * @return
	 */
	public JogadorInfoEdicao getByEdicaoAndJogador(Edicao edicao, Jogador jogador) {
		try {
			return super.manager.createQuery("Select jie from JogadorInfoEdicao jie where jie.edicao = :edicao and jie.jogador = :jogador", JogadorInfoEdicao.class)
					        	.setParameter("edicao", edicao)
					        	.setParameter("jogador", jogador)
					        	.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

}
