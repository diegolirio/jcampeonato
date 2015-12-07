package com.diegolirio.jcampeonato.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Podium;
import com.diegolirio.jcampeonato.service.PodiumService;

@Controller
@RequestMapping("podium")
public class PodiumController {

	@Autowired
	private PodiumService podiumService;

	/**
	 * pega podium por edicao
	 * @param edicaoId
	 * @return podium
	 */
	@RequestMapping(value="/get/by/edicao/{edicaoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getByEdicao(@PathVariable("edicaoId") long edicaoId) {
		try {
			Podium podium = this.podiumService.getByEdicao(new Edicao(edicaoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(podium), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
