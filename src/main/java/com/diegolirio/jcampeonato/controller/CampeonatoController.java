package com.diegolirio.jcampeonato.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.service.CampeonatoService;

@Controller
@RequestMapping("/campeonato")
public class CampeonatoController {

	@Autowired
	private CampeonatoService campeonatoService;


//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView pageHome() {
//		ModelAndView mv = new ModelAndView("_base");
//		mv.addObject("content_import", "edicao-list");
//		return mv;
//	}
//	
	
	/*
	 * Pages
	 */
	
	@RequestMapping(value="/novo", method=RequestMethod.GET)
	public String pageForm() {
		return "campeonato/form";
	}
	
	
	/*
	 * Rest Full
	 */
	
	/**
	 * Salvar Campeonato
	 * @param campeonato
	 * @return JSON
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<String> save(@RequestBody Campeonato campeonato) {
		try {
			campeonatoService.save(campeonato);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(campeonato), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
