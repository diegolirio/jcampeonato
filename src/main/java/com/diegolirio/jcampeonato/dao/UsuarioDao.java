package com.diegolirio.jcampeonato.dao;

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
	
}
