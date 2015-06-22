package com.diegolirio.jcampeonato.dao;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Usuario;
import com.diegolirio.jcampeonato.service.UsuarioService;

@Repository("usuarioDao")
public class UsuarioDao extends AbstractGenericDao<Usuario> {

	@Qualifier("usuarioService")
	@Autowired
	private UsuarioService usuarioService;

	public boolean existeUsuarioEmail(String email) {
		try {
			Usuario usuario = (Usuario) super.manager.createQuery("Select u from Usuario u where u.email = :email")
													 .setParameter("email", email)
													 .getSingleResult();
			return usuario != null;
		} catch (NoResultException e) {
			return false;	
		}
		
	} 
	
}
