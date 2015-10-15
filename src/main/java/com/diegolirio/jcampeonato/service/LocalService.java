package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.LocalDao;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Local;

@Service("localService")
public class LocalService extends AbstractGenericService<Local> {

	@Autowired @Qualifier("localDao")
	private LocalDao localDao;

	public List<Local> getListaPorEdicao(Edicao edicao) {
		return this.localDao.getListaPorEdicao(edicao);
	}

	
	
}
