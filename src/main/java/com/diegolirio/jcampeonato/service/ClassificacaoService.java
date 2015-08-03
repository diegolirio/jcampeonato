package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.ClassificacaoDao;
import com.diegolirio.jcampeonato.model.Classificacao;
import com.diegolirio.jcampeonato.model.Grupo;

@Service("classificacaoService")
public class ClassificacaoService extends AbstractGenericService<Classificacao> {

	@Autowired
	private ClassificacaoDao classificacaoDao;

	public List<Classificacao> getClassificacoesByGrupo(Grupo grupo) {
		return this.classificacaoDao.getClassificacoesByGrupo(grupo);
	}

}
