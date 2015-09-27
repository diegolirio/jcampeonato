package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.HarbitoDao;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Harbito;

@Service("harbitoService")
public class HarbitoService {

	@Autowired @Qualifier("harbitoDao")
	private HarbitoDao harbitoDao;

	public List<Harbito> getListaPorEdicao(Edicao edicao) {
		return this.harbitoDao.getListaPorEdicao(edicao);
	}

}
