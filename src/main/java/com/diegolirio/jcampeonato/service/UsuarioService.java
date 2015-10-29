package com.diegolirio.jcampeonato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.UsuarioDao;
import com.diegolirio.jcampeonato.model.Usuario;

@Service("usuarioService")
public class UsuarioService extends AbstractGenericService<Usuario> {

	@Autowired
	private UsuarioDao usuarioDao;

	public boolean existeUsuarioEmail(String email) {
		return this.usuarioDao.existeUsuarioEmail(email);
	}

	public Usuario getByEmail(String email) {
		return this.usuarioDao.getByEmail(email);
	}

	
}
