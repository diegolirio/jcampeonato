package com.diegolirio.jcampeonato.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Posicao;
import com.diegolirio.jcampeonato.service.PosicaoService;

@Controller
@RequestMapping("posicao")
public class PosicaoController {

	@Autowired @Qualifier("posicaoService")
	private PosicaoService posicaoService;

	/*
	 * RestFull
	 */
	
	/**
	 * pega todas as posicoes
	 * @return lista de posicoes JSON
	 */
	@RequestMapping(value="/get/list", method=RequestMethod.GET, produces="application/json; charset-UTF-8")
	public ResponseEntity<String> getList() {
		try {
			List<Posicao> posicoes = this.posicaoService.getList(Posicao.class);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(posicoes ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
