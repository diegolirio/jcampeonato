package com.diegolirio.jcampeonato.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Classificacao;
import com.diegolirio.jcampeonato.service.ClassificacaoService;

@Controller
@RequestMapping("classificacao")
public class ClassificacaoController {

	@Autowired
	private ClassificacaoService classificacaoService;

	@RequestMapping(value="/novo", method=RequestMethod.GET)
	public String pageNovo() {
		return "classificacao/form";
	}	
	
	/**
	 * Save
	 * @param classificacao
	 * @return JSON
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<String> save(@RequestBody Classificacao classificacao) {
		try {
			this.classificacaoService.save(classificacao);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(classificacao), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}