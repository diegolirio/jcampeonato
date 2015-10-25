package com.diegolirio.jcampeonato.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Evento;
import com.diegolirio.jcampeonato.service.EventoService;

@Controller
@RequestMapping("evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;

	//private EventoService eventoService;
	
	/*
	 * Pages
	 */
	
	@RequestMapping(value="/add/jogo")
	public String eventoAddJogo() {
		return "evento/add-jogo";
	}

	/*
	 * RestFull
	 */
	
	/**
	 * pega lista de eventos por escalacao
	 * @param escalacaoId
	 * @return lista de evento JSON
	 */
	@RequestMapping(value="/get/by/escalacao/{escalacaoId}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getByEscalacao(@PathVariable("escalacaoId") long escalacaoId) {
		try {
			List<Evento> eventos = null;
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(eventos), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * pega evento por id
	 * @param id
	 * @return evento JSON
	 */
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> get(@PathVariable("id") long id) {
		try {
			Evento evento = this.eventoService.get(Evento.class, id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(evento), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
