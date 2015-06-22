package com.diegolirio.jcampeonato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diegolirio.jcampeonato.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Qualifier("usuarioService")
	@Autowired
	private UsuarioService usuarioService; 
	
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public ModelAndView pageLogin() {
//		ModelAndView mv = new ModelAndView("_login");
//		return mv;
//	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView pageRegister() {
		ModelAndView mv = new ModelAndView("_register");
		return mv;
	}	
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public ModelAndView pageEfetuarLogin(Usuario usuario, BindingResult result, HttpSession session) {
//		ModelAndView mv = new ModelAndView("_login");
//		return mv;
//	}	
	
}
