package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.ClassificacaoDao;
import com.diegolirio.jcampeonato.model.Classificacao;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Grupo;
import com.diegolirio.jcampeonato.model.Time;

@Service("classificacaoService")
public class ClassificacaoService extends AbstractGenericService<Classificacao> {

	@Autowired
	private ClassificacaoDao classificacaoDao;

	public List<Classificacao> getClassificacoesByGrupo(Grupo grupo) {
		return this.classificacaoDao.getClassificacoesByGrupo(grupo);
	}

	public List<Classificacao> getClassificacoesByEdicao(Edicao edicao) {
		return this.classificacaoDao.getClassificacoesByEdicao(edicao);
	}
	
	public Classificacao getByEdicaoAndTime(Edicao edicao, Time time) {
		return this.classificacaoDao.getByEdicaoAndTime(edicao, time);
	}

}
