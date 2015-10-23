package com.diegolirio.jcampeonato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.EscalacaoDao;
import com.diegolirio.jcampeonato.model.Escalacao;
import com.diegolirio.jcampeonato.model.Jogo;

@Service("escalacaoService")
public class EscalacaoService extends AbstractGenericService<Escalacao> {

	@Autowired @Qualifier("escalacaoDao")
	private EscalacaoDao escalacaoDao;

	public Escalacao getByJogo(Jogo jogo) {
		return this.escalacaoDao.getByJogo(jogo);
	}

}
