package com.diegolirio.jcampeonato.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Posicao;

@Repository("posicaoDao")
public class PosicaoDao extends AbstractGenericDao<Posicao> {

	/**
	 * pega posicao por sigla
	 * @param sigla
	 * @return posicao
	 */
	public Posicao getBySigla(String sigla) {
		try {
			return this.manager.createQuery("from Posicao p where p.sigla = :sigla", Posicao.class)
	    					   .setParameter("sigla", sigla)
			    	 		   .getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
			
	}

	
	
}
