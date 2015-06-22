package com.diegolirio.jcampeonato.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Perfil;
import com.diegolirio.jcampeonato.model.Usuario;
import com.diegolirio.jcampeonato.service.PerfilService;
import com.diegolirio.jcampeonato.service.UsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UsuarioService usuarioService;

	private PerfilService perfilService;
	
	@RequestMapping(value="/criar_base")
	public String create() {
		
		// Usuario diegolirio
		Usuario usuario = new Usuario();
		usuario.setEmail("diegolirio.dl@gmail.com");
		usuario.setNome("Diego Lirio");
		if(usuarioService.existeUsuarioEmail(usuario.getEmail()) == false)
			usuarioService.save(usuario);
		
		
		// Perfil ADM
		Perfil perfil = this.perfilService.get(Perfil.class, 1l);
		if(perfil == null) {
			perfil = new Perfil(0, "Administrador");
			this.perfilService.save(perfil);
		}
		
		return "redirect:/";
	}
	
	/**
	 * Template
	 * @return
	 */
	@RequestMapping(value = "/template", method = RequestMethod.GET)
	public String template() {
		logger.info("Page Template....");
		return "template/index"; 
	}	
	
	/**
	 * Base ngview
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String base() {
		logger.info("Page Base....");
		return "_base2";
	}
	
	/**
	 * Pagina Home
	 * @return String
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		logger.info("Page Home....");
		return "home";
	}
	
		
	
}
