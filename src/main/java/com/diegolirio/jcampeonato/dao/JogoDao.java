package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Grupo;
import com.diegolirio.jcampeonato.model.Jogo;

@Repository("jogoDao")
public class JogoDao extends AbstractGenericDao<Jogo> {
	
	public List<Jogo> getListByGrupoAndRodada(Grupo grupo, int rodada) {
		String jpql = "from Jogo j where j.grupo = :grupo and j.rodada = :rodada";
		TypedQuery<Jogo> query = super.manager.createQuery(jpql , Jogo.class);
		query.setParameter("grupo", grupo);
		query.setParameter("rodada", rodada);
		return query.getResultList();
	}

}
