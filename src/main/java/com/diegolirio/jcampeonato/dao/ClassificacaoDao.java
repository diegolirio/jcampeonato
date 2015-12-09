package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Classificacao;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Grupo;
import com.diegolirio.jcampeonato.model.Time;

@Repository("classificacaoDao")
public class ClassificacaoDao extends AbstractGenericDao<Classificacao> {

	public List<Classificacao> getClassificacoesByGrupo(Grupo grupo) {
		Query query = this.manager.createQuery("Select c from Classificacao c where c.grupo.id = :idGrupo order by c.colocacao");
		query.setParameter("idGrupo", grupo.getId());
		@SuppressWarnings("unchecked")
		List<Classificacao> list = query.getResultList();
		return list;
	}

	public List<Classificacao> getClassificacoesByEdicao(Edicao edicao) {
		Query query = this.manager.createQuery("Select c from Classificacao c where c.grupo.edicao.id = :idEdicao order by c.colocacao");
		query.setParameter("idEdicao", edicao.getId());
		@SuppressWarnings("unchecked")
		List<Classificacao> list = query.getResultList();
		return list;
	}

	/**
	 * Busca Classificacao do time
	 * @param edicao
	 * @param time
	 * @return classificacao
	 */
	public Classificacao getByEdicaoAndTime(Edicao edicao, Time time) {
		Query query = this.manager.createQuery("Select c from Classificacao c where c.grupo.edicao.id = :edicaoId and c.time.id = :timeId");
		query.setParameter("edicaoId", edicao.getId());
		query.setParameter("timeId", time.getId());
		try {
			return (Classificacao) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}	

}
