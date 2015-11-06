package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Edicao;
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

	/**
	 * TODO: entender porque eu passo o jogador como param
	 * @param jogador
	 * @return
	 */
	public List<Jogo> getListJogadorWithGols(Jogador jogador) {
		return super.manager.createQuery("Select distinct j from Escalacao e JOIN e.jogo j JOIN e.jogadoresEscalados je JOIN je.eventos ev where ev.id = 1 and je.jogador.id = :jogadorId", Jogo.class)
				         	.setParameter("jogadorId", jogador.getId())
				         	.getResultList();
	}

	/**
	 * pega ultima rodada 
	 * @param edicao
	 * @return int (rodada)
	 */
	public int getLastRodadaByEdicao(Edicao edicao) {
		try {
			TypedQuery<Integer> query = super.manager.createQuery("select Max(j.rodada) from Jogo j where j.grupo.edicao.id = :edicaoId", Integer.class);
			query.setParameter("edicaoId", edicao.getId());
			return query.getSingleResult();
		} catch(NoResultException e) {
			return 1;
		} catch (NullPointerException e) {
			return 1;
		}
	}

	/**
	 * pega ultima rodada 
	 * @param edicao  
	 * @return int (rodada)
	 */
	public int getLastSequenciaByRodada(int rodada) {
		try {
			String jpql = "select max(j.sequencia) from Jogo j " +
						  " where j.rodada = :rodada ";
			TypedQuery<Integer> query = super.manager.createQuery(jpql , Integer.class);
			query.setParameter("rodada", rodada);
			return query.getSingleResult();
		} catch(NoResultException e) { 
			return 0;
		} catch (NullPointerException e) {
			return 0;
		}
	}
	
	public Jogo getNextJogo(Jogo jogo) {
		Jogo nextjogo = null;
		String jpql = "Select count(j.id) from Jogo j where j.grupo.edicao = :edicao and j.rodada = :rodada and j.sequencia > :sequencia";
		Long qtdeProximoRodada = super.manager.createQuery(jpql, Long.class)
											 .setParameter("edicao", jogo.getGrupo().getEdicao())
											 .setParameter("rodada", jogo.getRodada())
											 .setParameter("sequencia", jogo.getSequencia())
											 .getSingleResult();
		if(qtdeProximoRodada > 0) {
			String jpqlProxDaRodada = "Select j " +
										"from Jogo j " +
										" where j.grupo.edicao = :edicao " +
										"   and j.rodada = :rodada " +
										"   and j.sequencia > :sequencia " +
										"   and j.sequencia = (select min(jj.sequencia) " +
										" 						from Jogo jj " +
										"						where jj.rodada = j.rodada " +
										"						  and jj.sequencia > :sequencia " +
										"                         and jj.grupo.edicao = j.grupo.edicao)";
			nextjogo = super.manager.createQuery(jpqlProxDaRodada, Jogo.class)
								 .setParameter("edicao", jogo.getGrupo().getEdicao())
								 .setParameter("rodada", jogo.getRodada())
					 			 .setParameter("sequencia", jogo.getSequencia())
					 			 .getSingleResult();
		} else {
			try {
				/**
				 * Select j.*
					  from Jogo j
					  where j.rodada > 1
					    and j.rodada = (Select min(jj.rodada)
											 from Jogo jj
											 where jj.rodada > 1)
						and j.sequencia = (Select min(jj.sequencia)
						                     from Jogo jj
											 where jj.rodada = j.rodada)					 
				 */
				//String jpqlMenorJogoProximaRodada = "Select j from Jogo j where j.rodada = :rodada and j.sequencia < (select jj.sequencia from Jogo jj where jj.id = j.id)";
				
				String jpqlMenorJogoProximaRodada = "Select j " +
												    "from Jogo j " +
												    "where j.grupo.edicao = :edicao " +
												    "  and j.rodada > :rodada " +
												    "  and j.rodada = (Select min(jj.rodada) " +
												    				   " from Jogo jj " +
												    				   " where jj.rodada > :rodada " +
												    				   "   and jj.grupo.edicao = j.grupo.edicao) " +
											        "  and j.sequencia = (Select min(jj.sequencia) " +
											        					  " from Jogo jj " +
											        					  " where jj.rodada = j.rodada " +
											        					  "   and jj.grupo.edicao = j.grupo.edicao) ";
				nextjogo = super.manager.createQuery(jpqlMenorJogoProximaRodada, Jogo.class)
									 .setParameter("edicao", jogo.getGrupo().getEdicao())
									 .setParameter("rodada", jogo.getRodada())
						 			 .getSingleResult();
			} catch(NoResultException e) {
				// Caso caia aqui pega o primeiro Jogo da edicao 
				String firstJogo = "Select j from Jogo j where j.grupo.edicao = :edicao and j.rodada = (select min(jj.rodada) from Jogo jj where jj.grupo.edicao = j.grupo.edicao)" +
																					  " and j.sequencia = (select min(jj.sequencia) from Jogo jj where jj.grupo.edicao = j.grupo.edicao)";
				nextjogo = super.manager.createQuery(firstJogo, Jogo.class)
						 .setParameter("edicao", jogo.getGrupo().getEdicao())
			 			 .getSingleResult();				
			}
		}
		return nextjogo;
	}

}
