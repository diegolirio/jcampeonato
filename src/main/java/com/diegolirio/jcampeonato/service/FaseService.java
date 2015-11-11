package com.diegolirio.jcampeonato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.FaseDao;
import com.diegolirio.jcampeonato.model.Fase;

@Service("faseService")
public class FaseService extends AbstractGenericService<Fase> {

	@Autowired
	private FaseDao faseDao;

	public Fase getBySigla(char sigla) {
		return this.faseDao.getBySigla(sigla);
	}

}
