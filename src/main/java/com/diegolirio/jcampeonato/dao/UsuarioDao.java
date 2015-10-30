package com.diegolirio.jcampeonato.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.diegolirio.jcampeonato.model.Usuario;

@Repository("usuarioDao")
public class UsuarioDao extends AbstractGenericDao<Usuario> {


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

	public Usuario getByEmail(String email) {
		try {
			Usuario usuario = super.manager.createQuery("Select u from Usuario u where u.email = :email", Usuario.class)
					.setParameter("email", email)
					.getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			return null;	
		}
		
	}

	public boolean login(Usuario usuario) {
		try {
			Usuario u = super.manager.createQuery("from Usuario u where u.email = :email and u.senha = :senha", Usuario.class)
					 				 				 .setParameter("email", usuario.getEmail())
					 				 				 .setParameter("senha", usuario.getSenha())
					 				 				 .getSingleResult();
			return u.getId() > 0;
		} catch(NoResultException e) {
			return false;
		}
	} 
	
}
