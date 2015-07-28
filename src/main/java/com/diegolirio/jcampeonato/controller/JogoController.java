package com.diegolirio.jcampeonato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("jogo")
public class JogoController {

	@RequestMapping(value="/novo", method=RequestMethod.GET)
	public String pageNovo() {
		return "jogo/form";
	}	
	
}
