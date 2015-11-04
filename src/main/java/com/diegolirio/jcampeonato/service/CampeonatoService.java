package com.diegolirio.jcampeonato.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.CampeonatoDao;
import com.diegolirio.jcampeonato.dao.UsuarioDao;
import com.diegolirio.jcampeonato.dao.UsuarioPerfilCampeonatoDao;
import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Perfil;
import com.diegolirio.jcampeonato.model.Usuario;
import com.diegolirio.jcampeonato.model.UsuarioPerfilCampeonato;

@Service("campeonatoService")
public class CampeonatoService extends AbstractGenericService<Campeonato> {

	@Autowired
	private CampeonatoDao campeonatoDao;

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private UsuarioPerfilCampeonatoDao usuarioPerfilCampeonatoDao;

	public List<Campeonato> getListPorUsuario(Usuario usuario) {
		return this.campeonatoDao.getListPorUsuario(usuario);
	}

	public List<Campeonato> getListByUsuarioAdm(Usuario usuario) {
		return this.campeonatoDao.getListByUsuarioAdm(usuario);
	}

	
	/**
	 * Grava campeoanto, se for um novo insere perfil como admistrador
	 * @param campeonato
	 * @param usuarioId
	 */
	public void save(Campeonato campeonato, long usuarioId) {
		super.save(campeonato);
		if(campeonato.getId() == 0) {
			// busca usuario
			Usuario usuario = this.usuarioDao.get(Usuario.class, usuarioId);
			// criar o perfil como adm
			UsuarioPerfilCampeonato usuPerfilCamp = new UsuarioPerfilCampeonato();			
			usuPerfilCamp.setCampeonato(campeonato);
			usuPerfilCamp.setUsuario(usuario);
			usuPerfilCamp.setPerfil(new Perfil(1l, "Administrador"));
			this.usuarioPerfilCampeonatoDao.save(usuPerfilCamp);
		}
	}
	
	
}
