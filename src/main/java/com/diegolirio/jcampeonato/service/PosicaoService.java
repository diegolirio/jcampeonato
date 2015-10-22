package com.diegolirio.jcampeonato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.PosicaoDao;
import com.diegolirio.jcampeonato.model.Posicao;

@Service("posicaoService")
public class PosicaoService extends AbstractGenericService<Posicao> {

	@Autowired
	private PosicaoDao posicaoDao;

	public Posicao getBySigla(String sigla) {
		return this.posicaoDao.getBySigla(sigla);
	}

	
	
}
