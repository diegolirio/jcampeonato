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
import com.diegolirio.jcampeonato.model.Jogador;
import com.diegolirio.jcampeonato.model.JogadorInfoEdicao;
import com.diegolirio.jcampeonato.service.EdicaoService;
import com.diegolirio.jcampeonato.service.JogadorInfoEdicaoService;
import com.diegolirio.jcampeonato.service.JogadorService;

@Controller
@RequestMapping("jogadorinfoedicao")
public class JogadorInfoEdicaoController {

	@Autowired
	private EdicaoService edicaoService;
	
	@Autowired
	private JogadorInfoEdicaoService jogadorInfoEdicaoService;

	@Autowired
	private JogadorService jogadorService;

	/*
	 * pages
	 */
	
	@RequestMapping(value="/artilharia")
	public String pageArtilharia() {
		return "jogador-info/artilharia";
	}

	@RequestMapping(value="/jogadores")
	public String pageJogadores() {
		return "jogador-info/jogadores";
	}
	
	
	@RequestMapping(value="/page")
	public String pageInfo() {
		return "jogador-info/page";
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
	public ResponseEntity<String> getListByEdicao(@PathVariable("edicaoId") long edicaoId) {
		try {
			Edicao edicao = this.edicaoService.get(Edicao.class, edicaoId);
			List<JogadorInfoEdicao> jogadoresInfoEdicao = this.jogadorInfoEdicaoService.getByEdicao(edicao);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogadoresInfoEdicao), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * pega lista de jogadorInfoEdicao (artilharia)
	 * @param edicaoId
	 * @return lista jogadorInfoEdicao JSON
	 */
	@RequestMapping(value="/get/by/edicao/{edicaoId}/artilharia", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListByEdicaoArtilharia(@PathVariable("edicaoId") long edicaoId) {
		try {
			Edicao edicao = this.edicaoService.get(Edicao.class, edicaoId);
			List<JogadorInfoEdicao> jogadoresInfoEdicao = this.jogadorInfoEdicaoService.getByEdicaoArtilharia(edicao);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogadoresInfoEdicao), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	/**
	 * pega jogadorInfoEdicao por edicao e jogador
	 * @param edicaoId
	 * @param jogadorId
	 * @return jogadorInfoEdicao JSON
	 */ 
	@RequestMapping(value="/get/by/edicao/{edicaoId}/jogador/{jogadorId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getByEdicaoAndJogador(@PathVariable("edicaoId") long edicaoId, @PathVariable("jogadorId") long jogadorId) {
		try {
			Edicao edicao = this.edicaoService.get(Edicao.class, edicaoId);
			Jogador jogador = this.jogadorService.get(Jogador.class, jogadorId);
			JogadorInfoEdicao jogadorInfoEdicao = this.jogadorInfoEdicaoService.getByEdicaoAndJogador(edicao, jogador);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogadorInfoEdicao), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
