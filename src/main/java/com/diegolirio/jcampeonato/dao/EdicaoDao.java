package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Status;
import com.diegolirio.jcampeonato.model.Usuario;

@Repository("edicaoDao")
public class EdicaoDao extends AbstractGenericDao<Edicao> {

	@SuppressWarnings("unchecked")
	public List<Edicao> getListPorStatus(Status status) {
		List<Edicao> list = (List<Edicao>) super.manager.createQuery("Select e from Edicao e where e.status.id = :idStatus")
					 									.setParameter("idStatus", status.getId())
					 									.getResultList();
		return list;
	}

	/**
	 * pega lista de edicao por status e usuario administrador
	 * @param status
	 * @param usuario
	 * @return lista de edicao
	 */
	public List<Edicao> getListByStatusAndUsuarioAdm(Status status, Usuario usuario) {
		String jpql = "select e from Edicao e JOIN e.campeonato c JOIN c.usuariosPerfisCampeonatos upc " +
						" where upc.campeonato = c and e.status.id = :statusId and upc.perfil.id = 1 and upc.usuario.id = :usuarioId";
		System.out.println(jpql);
		TypedQuery<Edicao> query = super.manager.createQuery(jpql, Edicao.class);
		query.setParameter("statusId", status.getId());
		query.setParameter("usuarioId", usuario.getId());
		return query.getResultList();
	}

	/**
	 * pega lista de edicoes por Campeonato
	 * @param campeonato
	 * @return lista de edicao
	 */
	public List<Edicao> getListByCampeonato(Campeonato campeonato) {
		return super.manager.createQuery("from Edicao e where e.campeonato = :campeonato", Edicao.class)
				        	.setParameter("campeonato", campeonato)
				        	.getResultList();
	}

	/**
	 * pega lista de edicao com Status Em Andamento e Finalizado
	 * @return list edicao
	 */
	public List<Edicao> getListStatusEmAndamentoAndFinalizado() {
		return super.manager.createQuery("Select e from Edicao e where e.status.id In (2,3)", Edicao.class)
							.getResultList();
	}


	
}
