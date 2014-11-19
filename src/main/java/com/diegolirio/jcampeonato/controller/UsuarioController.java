package com.diegolirio.jcampeonato.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diegolirio.jcampeonato.model.Usuario;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView pageLogin() {
		ModelAndView mv = new ModelAndView("_login");
		return mv;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView pageEfetuarLogin(Usuario usuario, BindingResult result, HttpSession session) {
		ModelAndView mv = new ModelAndView("_login");
		return mv;
	}	
	
}
