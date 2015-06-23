package com.diegolirio.jcampeonato.dao;

import java.util.List;

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

	
	
}
