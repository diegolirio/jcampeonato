package com.diegolirio.jcampeonato.dao;

import javax.persistence.NoResultException;

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

}
