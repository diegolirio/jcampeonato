package com.diegolirio.jcampeonato.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Podium;

@Repository("podiumDao")
public class PodiumDao extends AbstractGenericDao<Podium> {

	/**
	 * pega podium por edicao
	 * @param edicao
	 * @return podium
	 */
	public Podium getByEdicao(Edicao edicao) {
		try  {
			return super.manager.createQuery("Select p from Podium p where p.edicao.id = :edicaoId", Podium.class)
						 .setParameter("edicaoId", edicao.getId())
						 .getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

}
