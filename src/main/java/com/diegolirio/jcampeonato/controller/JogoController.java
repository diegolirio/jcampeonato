package com.diegolirio.jcampeonato.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Jogo;
import com.diegolirio.jcampeonato.service.JogoService;

@Controller
@RequestMapping("jogo")
public class JogoController {

	@Autowired @Qualifier("jogoService")
	private JogoService jogoService;

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

	/**
	 * pagina resulta/placar do jogo e escalacao
	 * @return
	 */
	@RequestMapping(value="/resultado")
	public String pageResultado() {
		return "jogo/resultado";
	}
	
	
	/*
	 * RestFull
	 */
	
	/**
	 * Busca lista de locais por Edicao
	 * @param edicaoId
	 * @return lista de jogos JSON
	 */
	@RequestMapping(value="/get/lista/por/edicao/{edicaoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListaPorEdicao(@PathVariable("edicaoId") long edicaoId) {
		try {
			List<Jogo> jogos = this.jogoService.getListByEdicao(new Edicao(edicaoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogos), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	};	
	
	/**
	 * pega o jogo por id
	 * @param id
	 * @return jogo JSON
	 */
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> get(@PathVariable("id") long id) {
		try {
			Jogo jogo = this.jogoService.get(Jogo.class, id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogo), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Salva Jogo
	 * @param jogo
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<String> save(@RequestBody Jogo jogo) {
		try {
			this.jogoService.save(jogo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogo), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * delete jogo
	 * @param id
	 * @return HttpStatus
	 */
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		this.jogoService.delete(Jogo.class, id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	/**
	 * finaliza o Jogo e calcula classificacao e artilharia
	 * @param id
	 * @return jogo JSON
	 */
	@RequestMapping(value="/{id}/finalizar", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<String> finalizar(@PathVariable("id") long id) {
		try {
			Jogo jogo = this.jogoService.get(Jogo.class, id);
			this.jogoService.finalizar(jogo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogo ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
