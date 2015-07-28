package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.GrupoDao;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Grupo;

@Service("grupoService")
public class GrupoService extends AbstractGenericService<Grupo> {

	@Autowired
	private GrupoDao grupoDao;

	public List<Grupo> getListaPorEdicao(Edicao edicao) {
		return this.grupoDao.getListaPorEdicao(edicao);
	}


	
}
