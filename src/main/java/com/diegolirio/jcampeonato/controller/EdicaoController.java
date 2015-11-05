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

import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Status;
import com.diegolirio.jcampeonato.model.Usuario;
import com.diegolirio.jcampeonato.service.EdicaoService;

@Controller
@RequestMapping("edicao")
public class EdicaoController {
	
	@Autowired
	private EdicaoService edicaoService;

	/*
	 * Pages
	 */

	@RequestMapping(value="/novo", method=RequestMethod.GET)
	public String pageForm() {
		return "edicao/form";
	}	

	@RequestMapping(value="/confirma/conclusao", method=RequestMethod.GET)
	public String pageConfirmaConclusao() {
		return "edicao/confirma-conclusao";
	}	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String pageList() {
		return "edicao/list";
	}

	@RequestMapping(value="/classificacao", method=RequestMethod.GET)
	public String pageClassificacao() {
		return "edicao/classificacao";
	}
	
	
	/*
	 * Rest Full
	 */
	
	/**
	 * Pega as edicoes por Status
	 * @param idStatus
	 * @return
	 */
	@RequestMapping(value="/get/list/por/status/{idStatus}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListPorStatus(@PathVariable("idStatus") long idStatus) {
		try {
			List<Edicao> edicoes = this.edicaoService.getListPorStatus(new Status(idStatus));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(edicoes ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * pega lista de edicao por status e usuario administrador
	 * @param idStatus
	 * @return
	 */
	@RequestMapping(value="/get/list/by/status/{statusId}/and/usuario/adm/{usuarioAdmId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListByStatusAndusuarioAdm(@PathVariable("statusId") long statusId, @PathVariable("usuarioAdmId") long usuarioAdmId) {
		try {
			List<Edicao> edicoes = this.edicaoService.getListByStatusAndUsuarioAdm(new Status(statusId), new Usuario(usuarioAdmId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(edicoes ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Pega a Edicao por ID
	 * @param id
	 * @return JSON
	 */
	@RequestMapping(value="/get/por/id/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getPorId(@PathVariable("id") long id) {
		try {
			Edicao edicao = this.edicaoService.get(Edicao.class, id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(edicao ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Pega lista de Edicao por Campeonato
	 * @param campeonatoId
	 * @return lista de edicao JSON
	 */
	@RequestMapping(value="/get/list/by/campeonato/{campeonatoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getByCampeonato(@PathVariable("campeonatoId") long campeonatoId) {
		try {
			List<Edicao> edicoes = this.edicaoService.getListByCampeonato(new Campeonato(campeonatoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(edicoes ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Salvar Edicao
	 * @param edicao
	 * @return JSON
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Edicao edicao) {
		try {
			this.edicaoService.save(edicao);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(edicao), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
	}
	
}
