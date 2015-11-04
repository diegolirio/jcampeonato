package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.UsuarioPerfilCampeonatoDao;
import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Usuario;
import com.diegolirio.jcampeonato.model.UsuarioPerfilCampeonato;

@Service("/usuarioPerfilCampeonatoService")
public class UsuarioPerfilCampeonatoService extends AbstractGenericService<UsuarioPerfilCampeonato> {

	@Autowired @Qualifier("usuarioPerfilCampeonatoDao")
	private UsuarioPerfilCampeonatoDao usuarioPerfilCampeonatoDao;

	public UsuarioPerfilCampeonato getByUsuarioAndCampeonato(Usuario usuario, Campeonato campeonato) {
		return this.usuarioPerfilCampeonatoDao.getByUsuarioAndCampeonato(usuario, campeonato);
	}

	public List<UsuarioPerfilCampeonato> getListByUsuario(Usuario usuario) {
		return this.usuarioPerfilCampeonatoDao.getListByUsuario(usuario); 
	}

}
