package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.CampeonatoDao;
import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Usuario;

@Service("campeonatoService")
public class CampeonatoService extends AbstractGenericService<Campeonato> {

	@Autowired
	private CampeonatoDao campeonatoDao;

	public List<Campeonato> getListPorUsuario(Usuario usuario) {
		return this.campeonatoDao.getListPorUsuario(usuario);
	}

	
	
}
