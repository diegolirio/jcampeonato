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
import com.diegolirio.jcampeonato.model.Escalacao;
import com.diegolirio.jcampeonato.model.Jogador;
import com.diegolirio.jcampeonato.model.Time;
import com.diegolirio.jcampeonato.service.JogadorService;

@Controller
@RequestMapping("jogador")
public class JogadorController {

	@Autowired @Qualifier("jogadorService")
	private JogadorService jogadorService;

	/*
	 * RestFull
	 */

	/**
	 * pega jogador por id
	 * @param id
	 * @return jogador JSON
	 */
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> get(@PathVariable("id") long id) {
		try {
			Jogador jogador = this.jogadorService.get(Jogador.class, id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogador), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * pega lista de jogadores por time
	 * @param timeId
	 * @return
	 */
	@RequestMapping(value="/get/list/by/time/{timeId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListByTime(@PathVariable("timeId") long timeId) {
		try {
			List<Jogador> jogadores = this.jogadorService.getListByTime(new Time(timeId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogadores), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * pega lista de jogadores por campeonato
	 * @param timeId
	 * @return
	 */
	@RequestMapping(value="/get/list/by/campeonato/{campeonatoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListByCampeonato(@PathVariable("campeonatoId") long campeonatoId) {
		try {
			List<Jogador> jogadores = this.jogadorService.getListByCampeonato(new Campeonato(campeonatoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogadores), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * pega lista de jogadores nao escalados
	 * @param timeId
	 * @return lista de jogadores nao escalados
	 */
	@RequestMapping(value="/get/list/not/escalacao/{escalacaoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListNotEscalacao(@PathVariable("escalacaoId") long escalacaoId) {
		try {
			List<Jogador> jogadores = this.jogadorService.getListNotEscalacao(new Escalacao(escalacaoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogadores), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * salvar jogador
	 * @param jogador
	 * @return jogador JSON
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Jogador jogador) {
		try {
			this.jogadorService.save(jogador);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogador), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
