package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Classificacao;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Grupo;

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

}
