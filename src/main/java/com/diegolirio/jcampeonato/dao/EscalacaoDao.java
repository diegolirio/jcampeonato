package com.diegolirio.jcampeonato.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Escalacao;
import com.diegolirio.jcampeonato.model.Jogo;

@Repository("escalacaoDao")
public class EscalacaoDao extends AbstractGenericDao<Escalacao> {

	public Escalacao getByJogo(Jogo jogo) {
		TypedQuery<Escalacao> query = super.manager.createQuery("from Escalacao e where e.jogo = :jogo", Escalacao.class);
		query.setParameter("jogo", jogo);
		try {
			return query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

}
