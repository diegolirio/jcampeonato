package com.diegolirio.jcampeonato.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Local;
import com.diegolirio.jcampeonato.service.LocalService;

@Controller
@RequestMapping("local")
public class LocalController {

	@Autowired @Qualifier("localService")
	private LocalService localService;

	/**
	 * Busca lista de locais por Edicao
	 * @param edicaoId
	 * @return lista de locais JSON
	 */
	@RequestMapping(value="/get/lista/por/edicao/{edicaoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListaPorEdicao(@PathVariable("edicaoId") long edicaoId) {
		try {
			List<Local> locais = this.localService.getListaPorEdicao(new Edicao(edicaoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(locais), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	};

	
}
