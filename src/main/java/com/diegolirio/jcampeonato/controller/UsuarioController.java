package com.diegolirio.jcampeonato.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diegolirio.jcampeonato.model.Usuario;
import com.diegolirio.jcampeonato.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Qualifier("usuarioService")
	@Autowired
	private UsuarioService usuarioService; 
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView pageRegister() {
		ModelAndView mv = new ModelAndView("_register");
		return mv;
	}	
	
	@RequestMapping(value="/form")
	public String form() {
		return "usuario/form";
	}
	
	/*
	 * RestFull
	 */
	
	/**
	 * Grava usuario
	 * @param usuario
	 * @return usuario JSON
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json;charset=UTF-8", produces="application/json;charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Usuario usuario) {
		try {
			this.usuarioService.save(usuario);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(usuario), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
