package com.diegolirio.jcampeonato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.CampeonatoDao;
import com.diegolirio.jcampeonato.model.Time;

@Service("timeService")
public class TimeService extends AbstractGenericService<Time> {

	//@Autowired @Qualifier("timeDao")
	//private TimeDao timeDao;
	
	@Autowired @Qualifier("campeonatoDao")
	private CampeonatoDao campeonatoDao;

}
