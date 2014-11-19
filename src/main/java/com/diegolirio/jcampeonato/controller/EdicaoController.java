package com.diegolirio.jcampeonato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("edicao")
public class EdicaoController {

	@RequestMapping(value = "/system/{id}", method = RequestMethod.GET)
	public ModelAndView pageForm(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("_base");
		mv.addObject("content_import", "edicao-form"); 
		return mv;
	}
}
