package com.diegolirio.jcampeonato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.EventoDao;
import com.diegolirio.jcampeonato.model.Evento;

@Service("eventoService")
public class EventoService extends AbstractGenericService<Evento> {

	@Autowired
	private EventoDao eventoDao;

	public Evento getByDescricao(String descricao) {
		return this.eventoDao.getByDescricao(descricao);
	}


}
