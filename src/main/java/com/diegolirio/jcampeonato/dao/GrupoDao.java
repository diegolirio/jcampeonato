package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Fase;
import com.diegolirio.jcampeonato.model.Grupo;

@Repository("grupoDao")
public class GrupoDao extends AbstractGenericDao<Grupo> {

	/**
	 * pega lista de grupos por edicao
	 * @param edicao
	 * @return lista de grupos
	 */
	public List<Grupo> getListaPorEdicao(Edicao edicao) {
		return super.manager.createQuery("Select g from Grupo g where g.edicao.id = :edicaoId", Grupo.class)
                    		.setParameter("edicaoId", edicao.getId())
                    		.getResultList();
	}


	/**
	 * pega lista de grupos da segunda fase por edicao
	 * @param edicao
	 * @return lista de grupos
	 */
	public List<Grupo> getListSegundaFaseByEdicao(Edicao edicao) {
		TypedQuery<Grupo> query = super.manager.createQuery("Select g from Grupo g where g.edicao.id = :edicaoId and g.fase.sigla = '2'", Grupo.class);
		query.setParameter("edicaoId", edicao.getId());
		return query.getResultList();  
	}


	/**
	 * pega lista de grupos por edicao e por fase
	 * @param edicao
	 * @param fase
	 * @return
	 */
	public List<Grupo> getListByEdicaoAndFase(Edicao edicao, Fase fase) {
		TypedQuery<Grupo> query = super.manager.createQuery("Select g from Grupo g where g.edicao.id = :edicaoId and g.fase.id = :faseId", Grupo.class);
		query.setParameter("edicaoId", edicao.getId());
		query.setParameter("faseId", fase.getId());
		return query.getResultList(); 
	}

}
