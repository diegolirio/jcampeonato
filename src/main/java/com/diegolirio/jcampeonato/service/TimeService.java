package com.diegolirio.jcampeonato.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.CampeonatoDao;
import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Time;

@Service("timeService")
public class TimeService extends AbstractGenericService<Time> {

	//@Autowired @Qualifier("timeDao")
	//private TimeDao timeDao;
	
	@Autowired @Qualifier("campeonatoDao")
	private CampeonatoDao campeonatoDao;

	/**
	 * Salva time, se ainda não persistido salva o time e vincula ao campeonato
	 * @param time
	 * @param campeonato
	 */
	public void save(Time time, Campeonato campeonato) {
		this.save(time);
		List<Time> times = new ArrayList<Time>();
		times.add(time);
		campeonato.setTimes(times );
		this.campeonatoDao.save(campeonato);
	}

}
