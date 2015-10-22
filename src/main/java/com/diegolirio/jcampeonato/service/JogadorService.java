package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.JogadorDao;
import com.diegolirio.jcampeonato.model.Jogador;
import com.diegolirio.jcampeonato.model.Time;

@Service("jogadorService")
public class JogadorService extends AbstractGenericService<Jogador> {

	@Autowired @Qualifier("jogadorDao")
	private JogadorDao jogadorDao;

	public List<Jogador> getListByTime(Time time) {
		return this.jogadorDao.getListByTime(time);
	}

}
