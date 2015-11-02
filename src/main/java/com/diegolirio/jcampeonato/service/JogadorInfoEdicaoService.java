package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.JogadorInfoEdicaoDao;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Jogador;
import com.diegolirio.jcampeonato.model.JogadorInfoEdicao;

@Service("jogadorInfoEdicaoService")
public class JogadorInfoEdicaoService extends AbstractGenericService<JogadorInfoEdicao>{

	@Autowired
	private JogadorInfoEdicaoDao jogadorInfoEdicaoDao;

	public List<JogadorInfoEdicao> getByEdicao(Edicao edicao) {
		return this.jogadorInfoEdicaoDao.getByEdicao(edicao);
	}

	public JogadorInfoEdicao getByEdicaoAndJogador(Edicao edicao, Jogador jogador) {
		return this.jogadorInfoEdicaoDao.getByEdicaoAndJogador(edicao, jogador);
	}

}
