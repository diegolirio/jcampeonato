package com.diegolirio.jcampeonato.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.JogadorInfoEdicao;
import com.diegolirio.jcampeonato.service.EdicaoService;
import com.diegolirio.jcampeonato.service.JogadorInfoEdicaoService;

@Controller
@RequestMapping("jogadorinfoedicao")
public class JogadorInfoEdicaoController {

	@Autowired
	private EdicaoService edicaoService;
	
	@Autowired
	private JogadorInfoEdicaoService jogadorInfoEdicaoService;

	/*
	 * pages
	 */
	
	@RequestMapping(value="/artilharia")
	public String pageArtilharia() {
		return "jogador-info/artilharia";
	}
	
	/*
	 * RestFull
	 */
	
	/**
	 * pega lista de jogadorInfoEdicao
	 * @param edicaoId
	 * @return lista jogadorInfoEdicao JSON
	 */
	@RequestMapping(value="/get/by/edicao/{edicaoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> pageArtilharia(@PathVariable("edicaoId") long edicaoId) {
		try {
			Edicao edicao = this.edicaoService.get(Edicao.class, edicaoId);
			List<JogadorInfoEdicao> jogadoresInfoEdicao = this.jogadorInfoEdicaoService.getByEdicao(edicao);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogadoresInfoEdicao), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}
