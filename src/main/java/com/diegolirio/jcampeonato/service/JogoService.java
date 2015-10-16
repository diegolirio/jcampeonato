package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Jogo;

@Service("jogoService")
public class JogoService extends AbstractGenericService<Jogo> {

	public List<Jogo> getListaPorEdicao(Edicao edicao) {
		return this.getList(Jogo.class);
	}

	
	
}
