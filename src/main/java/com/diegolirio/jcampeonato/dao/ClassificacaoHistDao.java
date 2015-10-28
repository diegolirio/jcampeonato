package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.ClassificacaoHist;
import com.diegolirio.jcampeonato.model.Grupo;
import com.diegolirio.jcampeonato.model.Time;

@Repository("classificacaoHistDao")
public class ClassificacaoHistDao extends AbstractGenericDao<ClassificacaoHist> {

	/**
	 * pega o numero da ultima rodada da classificacao hist
	 * @param grupo
	 * @return ultima rodada (int)
	 */
	public int getNumberHistLastRodada(Grupo grupo) {
		String jpql = "Select max(h.rodada) from ClassificacaoHist h where h.grupo.id = :grupoId";
		TypedQuery<Integer> query = this.manager.createQuery(jpql , Integer.class);
		query.setParameter("grupoId", grupo.getId());
		try {
			return query.getSingleResult();
		} catch(Exception e) {
			return -1;
		}
	}

	public ClassificacaoHist getByTimeAndGrupoAndRodada(Time time, Grupo grupo, int rodada) {
		String jpql = "Select h from ClassificacaoHist h where h.time = :time and h.grupo = :grupo and h.rodada = :rodada";
		TypedQuery<ClassificacaoHist> query = this.manager.createQuery(jpql, ClassificacaoHist.class);
		query.setParameter("time", time);
		query.setParameter("grupo", grupo);
		query.setParameter("rodada", rodada);
		try {
			return query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	
	}

	public List<ClassificacaoHist> getHistListByRodada(int rodada, Grupo grupo) {
		String jpql = "Select h from ClassificacaoHist h where h.rodada = :rodada and h.grupo.id = :grupoId";
		TypedQuery<ClassificacaoHist> query = super.manager.createQuery(jpql, ClassificacaoHist.class);
		query.setParameter("rodada", rodada);
		query.setParameter("grupoId", grupo.getId());
		return query.getResultList();
	}	

	
}
