package com.diegolirio.jcampeonato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.PodiumDao;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Podium;

@Service("podium")
public class PodiumService {

	@Autowired
	private PodiumDao podiumDao;

	/**
	 * pega podium por edicao
	 * @param edicao
	 * @return podium
	 */
	public Podium getByEdicao(Edicao edicao) {
		return this.podiumDao.getByEdicao(edicao);
	}

}
