package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.CampeonatoDao;
import com.diegolirio.jcampeonato.dao.TimeDao;
import com.diegolirio.jcampeonato.model.Jogador;
import com.diegolirio.jcampeonato.model.Time;

@Service("timeService")
public class TimeService extends AbstractGenericService<Time> {

	@Autowired @Qualifier("timeDao")
	private TimeDao timeDao;
	
	@Autowired @Qualifier("campeonatoDao")
	private CampeonatoDao campeonatoDao;

	@Autowired @Qualifier("jogadorService")
	private JogadorService jogadorService;

	/**
	 * Add jogador ao time
	 * @param time
	 * @param jogador
	 */
	public void addJogador(Time time, Jogador jogador) {
		List<Jogador> jogadores = this.jogadorService.getListByTime(time);
		jogadores.add(jogador);
		time.setJogadores(jogadores);
		this.timeDao.save(time);		
	}
	
	
	/**
	 * remove jogador do time
	 * @param time
	 * @param jogador
	 */
	public void removeJogador(Time time, Jogador jogador) {
		time.setJogadores(this.jogadorService.getListByTime(time));
		if(time.getJogadores().remove(jogador))
			this.timeDao.save(time);	
		else throw new RuntimeException("Não foi possivel remover Jogador");
	}

}
