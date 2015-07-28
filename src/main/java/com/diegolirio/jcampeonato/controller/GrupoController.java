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

import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Grupo;
import com.diegolirio.jcampeonato.service.GrupoService;

@Controller
@RequestMapping(value="grupo")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;

	@RequestMapping(value="/novo", method=RequestMethod.GET)
	public String pageNovo() {
		return "grupo/form";
	}

	/**
	 * Salvar Grupo
	 * @param grupo
	 * @return JSON
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<String> save(@RequestBody Grupo grupo) {
		try {
			this.grupoService.save(grupo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(grupo), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
	}	
	
	@RequestMapping(value="/get/lista/por/edicao_", method=RequestMethod.GET, consumes="application/json", produces="application/json")
	public ResponseEntity<String> getListaPorEdicao(@RequestBody Edicao edicao) {
		try {
			List<Grupo> grupos = this.grupoService.getListaPorEdicao(edicao);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(grupos), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

	/**
	 * 
	 * @param edicaoId
	 * @return
	 */
	@RequestMapping(value="/get/lista/por/edicao/{edicaoId}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getListaPorEdicao(@PathVariable("edicaoId") long edicaoId) {
		try {
			List<Grupo> grupos = this.grupoService.getListaPorEdicao(new Edicao(edicaoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(grupos), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	/**
	 * Exclui Grupo
	 * @param grupo
	 * @return JSON
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		try {
			this.grupoService.delete(Grupo.class, id);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
	}		
	
}
