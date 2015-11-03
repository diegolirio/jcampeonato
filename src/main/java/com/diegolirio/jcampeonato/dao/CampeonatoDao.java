package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Usuario;

@Repository("campeonatoDao")
public class CampeonatoDao extends AbstractGenericDao<Campeonato> {

	public List<Campeonato> getListPorUsuario(Usuario usuario) {
		String sql = "Select c from Campeonato c, UsuarioPerfilCampeonato upc where c.id = upc.campeonato.id and upc.usuario.id = :idUsuario";
		@SuppressWarnings("unchecked")
		List<Campeonato> list = (List<Campeonato>) super.manager.createQuery(sql )
																.setParameter("idUsuario", usuario.getId())
																.getResultList();
		return list;
	}

	/**
	 * pega lista de campeonato por usuario, onde o usuario contem perfil administrador.
	 * @param usuario
	 * @return lista de campeonato
	 */
	public List<Campeonato> getListByUsuarioAdm(Usuario usuario) {
		String jpql = "Select c from Campeonato c JOIN c.usuariosPerfisCampeonatos upc where upc.perfil.id = 1 and upc.usuario.id = :usuarioId";
		TypedQuery<Campeonato> query = super.manager.createQuery(jpql , Campeonato.class);
		query.setParameter("usuarioId", usuario.getId());
		return query.getResultList();
	}

	
}
