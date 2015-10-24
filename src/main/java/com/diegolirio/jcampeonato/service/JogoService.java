package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Jogo;
import com.diegolirio.jcampeonato.service.jogo.FinalizaJogo;

@Service("jogoService")
public class JogoService extends AbstractGenericService<Jogo> {


	@Autowired @Qualifier("finalizaJogoFaseGrupoMata")
	private FinalizaJogo finalizaJogo;// = new FinalizaJogoFaseGrupoMata();
	
	public List<Jogo> getListByEdicao(Edicao edicao) {
		return this.getList(Jogo.class);
	}

	/**
	 * finalizar jogo e calc
	 * @param jogo
	 */
	public void finalizar(Jogo jogo) {
		if(jogo.getStatus().getId() != 2)
			throw new RuntimeException("Jogo nao encontra-se em andamento.");
		// se tipo edicao for fase grupo mata-mata
		if(jogo.getGrupo().getEdicao().getTipoEdicao().getId() == 1) {
			//FinalizaJogo finalizaJogo = new FinalizaJogoFaseGrupoMata();
			finalizaJogo.execute(jogo);
		} else {
			throw new RuntimeException("Em desenvolvimento");
		}
	}

	
	
}
