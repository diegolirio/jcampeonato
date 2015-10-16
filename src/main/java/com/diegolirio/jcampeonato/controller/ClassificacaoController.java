package com.diegolirio.jcampeonato.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Classificacao;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Grupo;
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
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Classificacao classificacao) {
		try {
			this.classificacaoService.save(classificacao);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(classificacao), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Delete
	 * @param classificacaoId
	 * @return Response 
	 */
	@RequestMapping(value="/delete/{classificacaoId}", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> delete(@PathVariable("classificacaoId") long classificacaoId) {
		try {
			this.classificacaoService.delete(Classificacao.class, classificacaoId);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	/**
	 * 
	 * @param grupoId
	 * @return
	 */
	@RequestMapping(value="/get/list/by/grupo/{grupoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListByGrupo(@PathVariable("grupoId") long grupoId) {
		try {
			List<Classificacao> classificacoes = this.classificacaoService.getClassificacoesByGrupo(new Grupo(grupoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(classificacoes), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 
	 * @param edicaoId
	 * @return JSON
	 */
	@RequestMapping(value="/get/list/by/edicao/{edicaoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListByEdicao(@PathVariable("edicaoId") long edicaoId) {
		try {
			List<Classificacao> classificacoes = this.classificacaoService.getClassificacoesByEdicao(new Edicao(edicaoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(classificacoes), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
