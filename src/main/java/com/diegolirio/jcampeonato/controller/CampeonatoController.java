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
import com.diegolirio.jcampeonato.model.Usuario;
import com.diegolirio.jcampeonato.service.CampeonatoService;
import com.diegolirio.jcampeonato.service.UsuarioPerfilCampeonatoService;
import com.diegolirio.jcampeonato.service.UsuarioService;

@Controller
@RequestMapping("/campeonato")
public class CampeonatoController {

	@Autowired
	private CampeonatoService campeonatoService;
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioPerfilCampeonatoService usuarioPerfilCampeonatoService;


//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView pageHome() {
//		ModelAndView mv = new ModelAndView("_base");
//		mv.addObject("content_import", "edicao-list");
//		return mv;
//	}
//	
	
	/*
	 * Pages
	 */
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String pageForm() {
		return "campeonato/form";
	}
	
	@RequestMapping(value="/lista", method=RequestMethod.GET)
	public String pageList() {
		return "campeonato/list";
	}
	
	
	/*
	 * Rest Full
	 */
	
	/**
	 * pega o campeonato pelo id
	 * @param id
	 * @return campeonato
	 */
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	public ResponseEntity<String> get(@PathVariable("id") long id) {
		try {
			Campeonato campeonato = this.campeonatoService.get(Campeonato.class, id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(campeonato ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Salvar Campeonato
	 * @param campeonato
	 * @return JSON
	 */
	@RequestMapping(value="/save/usuario/{idUsuario}", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Campeonato campeonato, @PathVariable("idUsuario") long idUsuario) {
		try {
			// grava campeonato
			this.campeonatoService.save(campeonato, idUsuario);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(campeonato), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value="/get/list/por/usuario/{idUsuario}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListPorUsuario(@PathVariable("idUsuario") long idUsuario) {
		try {
			List<Campeonato> campeonatos = this.campeonatoService.getListPorUsuario(new Usuario(idUsuario));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(campeonatos ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * pega lista de campeonatos por usuario onde o usuario contem perfil administrador
	 * @param usuarioId
	 * @return lista campeonato
	 */
	@RequestMapping(value="/get/list/by/usuario/adm/{usuarioId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListByUsuarioAdm(@PathVariable("usuarioId") long usuarioId) {
		try {
			List<Campeonato> campeonatos = this.campeonatoService.getListByUsuarioAdm(new Usuario(usuarioId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(campeonatos ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
