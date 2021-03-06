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

import com.diegolirio.jcampeonato.model.Jogador;
import com.diegolirio.jcampeonato.model.Time;
import com.diegolirio.jcampeonato.service.CampeonatoService;
import com.diegolirio.jcampeonato.service.JogadorService;
import com.diegolirio.jcampeonato.service.TimeService;

@Controller
@RequestMapping("/time")
public class TimeController {

	@Autowired
	private TimeService timeService;
	
	@Autowired @Qualifier("campeonatoService")
	private CampeonatoService campeonatoService;

	@Autowired @Qualifier("jogadorService")
	private JogadorService jogadorService;

	/*
	 * pages
	 */
	
	/**
	 * Pagina form
	 * @return pagina form time
	 */
	@RequestMapping(value="/page")
	public String pagePage() {
		return "time/page"; 
	}
	
	/**
	 * Pagina form
	 * @return pagina form time
	 */
	@RequestMapping(value="/form")
	public String pageForm() {
		return "time/form"; 
	}
	
	/*
	 * RestFull
	 */
	
	/**
	 * pega o time por id
	 * @param id
	 * @return time JSON
	 */
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> get(@PathVariable("id") long id) {
		try {
			Time time = this.timeService.get(Time.class, id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(time), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * 
	 * @return
	 */
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
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Time time) {
		try {
			this.timeService.save(time);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(time), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Add jogador ao time
	 * @param timeId
	 * @param jogadorId
	 * @return
	 */
	@RequestMapping(value="/{timeId}/add/jogador/{jogadorId}", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> addJogador(@PathVariable("timeId") long timeId, @PathVariable("jogadorId") long jogadorId) {
		try {
			Jogador jogador = this.jogadorService.get(Jogador.class, jogadorId);
			Time time = this.timeService.get(Time.class, timeId);
			timeService.addJogador(time, jogador);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogador ), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Remove jogador do time
	 * @param timeId
	 * @param jogadorId
	 * @return
	 */
	@RequestMapping(value="/{timeId}/remove/jogador/{jogadorId}", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> removeJogador(@PathVariable("timeId") long timeId, @PathVariable("jogadorId") long jogadorId) {
		try {
			Jogador jogador = this.jogadorService.get(Jogador.class, jogadorId);
			Time time = this.timeService.get(Time.class, timeId);
			timeService.removeJogador(time, jogador);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
}
