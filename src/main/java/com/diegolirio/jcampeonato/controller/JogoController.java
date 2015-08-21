package com.diegolirio.jcampeonato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
