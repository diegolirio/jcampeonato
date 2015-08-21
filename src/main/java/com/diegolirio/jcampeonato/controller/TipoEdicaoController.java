package com.diegolirio.jcampeonato.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.TipoEdicao;
import com.diegolirio.jcampeonato.service.TipoEdicaoService;

@Controller
@RequestMapping("tipo_edicao")
public class TipoEdicaoController {

	@Autowired
	private TipoEdicaoService tipoEdicaoService;

	@RequestMapping(value="/get/list", method=RequestMethod.GET, produces="applicatin/json; chartset=UTF-8")
	public ResponseEntity<String> getList() {
		try {
			List<TipoEdicao> tipos = this.tipoEdicaoService.getList(TipoEdicao.class);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(tipos), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
