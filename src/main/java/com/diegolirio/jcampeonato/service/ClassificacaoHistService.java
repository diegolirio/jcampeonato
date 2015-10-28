package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.ClassificacaoHistDao;
import com.diegolirio.jcampeonato.model.ClassificacaoHist;
import com.diegolirio.jcampeonato.model.Grupo;

@Service("classificacaoHistService")
public class ClassificacaoHistService extends AbstractGenericService<ClassificacaoHist> {

	@Autowired
	private ClassificacaoHistDao classificacaoHistDao;

	public int getNumberHistLastRodada(Grupo grupo) {
		return this.classificacaoHistDao.getNumberHistLastRodada(grupo);
	}

	public List<ClassificacaoHist> getHistListByRodada(int rodada, Grupo grupo) {
		return this.classificacaoHistDao.getHistListByRodada(rodada, grupo);
	}

}
