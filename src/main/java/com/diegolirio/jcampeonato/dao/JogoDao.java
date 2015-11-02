package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Grupo;
import com.diegolirio.jcampeonato.model.Jogador;
import com.diegolirio.jcampeonato.model.Jogo;
import com.diegolirio.jcampeonato.model.Time;

@Repository("jogoDao")
public class JogoDao extends AbstractGenericDao<Jogo> {
	
	public List<Jogo> getListByGrupoAndRodada(Grupo grupo, int rodada) {
		String jpql = "from Jogo j where j.grupo = :grupo and j.rodada = :rodada";
		TypedQuery<Jogo> query = super.manager.createQuery(jpql , Jogo.class);
		query.setParameter("grupo", grupo);
		query.setParameter("rodada", rodada);
		return query.getResultList();
	}

	/**
	 * pega lista de jogos por time
	 * @param time
	 * @return lista de jogos
	 */
	public List<Jogo> getListByTime(Time time) {
		return super.manager.createQuery("Select j from Jogo j where j.timeA.id = :timeAId or j.timeB.id = :timeBId", Jogo.class)
				         	.setParameter("timeAId", time.getId())
				         	.setParameter("timeBId", time.getId())
				         	.getResultList();
	}

	public List<Jogo> getListJogadorWithGols(Jogador jogador) {
		return super.manager.createQuery("Select distinct j from Escalacao e JOIN e.jogo j JOIN e.jogadoresEscalados je JOIN je.eventos ev where ev.id = 1 and je.jogador.id = :jogadorId", Jogo.class)
				         	.setParameter("jogadorId", jogador.getId())
				         	.getResultList();
	}

}
