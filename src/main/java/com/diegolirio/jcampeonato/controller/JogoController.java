package com.diegolirio.jcampeonato.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Jogo;

@Controller
@RequestMapping("jogo")
public class JogoController {

	/*
	 * Pages
	 */
	
	
	/**
	 * Retorna Form Jogo
	 * @return String
	 */
	@RequestMapping(value="/novo")
	public String novo() {
		return "jogo/form";
	}
	
	
	/*
	 * RestFull
	 */
	
	/**
	 * Salva Jogo
	 * @param jogo
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<String> save(@RequestBody Jogo jogo) {
		return null;
	}
	
}
