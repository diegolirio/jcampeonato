package com.diegolirio.jcampeonato.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Time;
import com.diegolirio.jcampeonato.service.CampeonatoService;
import com.diegolirio.jcampeonato.service.TimeService;

@Controller
@RequestMapping("/time")
public class TimeController {

	@Autowired
	private TimeService timeService;
	
	@Autowired @Qualifier("campeonatoService")
	private CampeonatoService campeonatoService;

	@RequestMapping(value="/get/list", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getList() {
		try {
			List<Time> times = this.timeService.getList(Time.class);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(times ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 
	 * @param campeonatoId
	 * @param time
	 * @return time (JSON)
	 */
	@RequestMapping(value="/save/from/campeonato/{campeonatoId}", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@PathVariable("campeonatoId") long campeonatoId, @RequestBody Time time) {
		try {
			System.out.println(time);
			Campeonato campeonato = this.campeonatoService.get(Campeonato.class, campeonatoId);
			this.timeService.save(time, campeonato);
			System.out.println(time);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(time), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
