package com.diegolirio.jcampeonato.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Usuario;
import com.diegolirio.jcampeonato.model.UsuarioPerfilCampeonato;

@Repository("usuarioPerfilCampeonatoDao")
public class UsuarioPerfilCampeonatoDao extends AbstractGenericDao<UsuarioPerfilCampeonato> {

	public UsuarioPerfilCampeonato getByUsuarioAndCampeonato(Usuario usuario, Campeonato campeonato) {
		String jpql = "from UsuarioPerfilCampeonato upc where upc.campeonato = :campeonato and upc.usuario = :usuario";
		try {
			return super.manager.createQuery(jpql, UsuarioPerfilCampeonato.class)
							    .setParameter("usuario", usuario)
							    .setParameter("campeonato", campeonato)
							    .getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

	/**
	 * pega lista de campeonato por usuario
	 * @param usuario
	 * @return lista de campeonato
	 */
	public List<Campeonato> getListByUsuario(Usuario usuario) {
		String jpql = "Select upc from UsuarioPerfilCampeonato upc where upc.usuario.id = :usuarioId";
		TypedQuery<Campeonato> query = super.manager.createQuery(jpql , Campeonato.class);
		query.setParameter("usuarioId", usuario.getId());
		return query.getResultList();
	}
	
}
