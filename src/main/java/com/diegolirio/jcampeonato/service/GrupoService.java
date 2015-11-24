package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.GrupoDao;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Fase;
import com.diegolirio.jcampeonato.model.Grupo;
import com.diegolirio.jcampeonato.model.Status;

@Service("grupoService")
public class GrupoService extends AbstractGenericService<Grupo> {

	@Autowired
	private GrupoDao grupoDao;

	public List<Grupo> getListaPorEdicao(Edicao edicao) {
		return this.grupoDao.getListaPorEdicao(edicao);
	}

	public List<Grupo> getListSegundaFaseByEdicao(Edicao edicao) {
		return this.grupoDao.getListSegundaFaseByEdicao(edicao);
	}

	public void updateSetStatusFinalizado(List<Grupo> grupos) {
		for (Grupo grupo : grupos) {
			if(grupo.getStatus().getId() == 2) {
				grupo.setStatus(new Status(3l));
				this.grupoDao.save(grupo);
			}
		}
	}

	public List<Grupo> getListByEdicaoAndFase(Edicao edicao, Fase fase) {
		return this.grupoDao.getListByEdicaoAndFase(edicao, fase);
	}


	
}
