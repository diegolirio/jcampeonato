package com.diegolirio.jcampeonato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CampeonatoController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView pageHome() {
		ModelAndView mv = new ModelAndView("_base");
		mv.addObject("content_import", "edicao-list");
		return mv;
	}
}
