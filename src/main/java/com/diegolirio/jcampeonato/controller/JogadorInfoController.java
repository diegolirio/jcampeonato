package com.diegolirio.jcampeonato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jogadorinfo")
public class JogadorInfoController {

	/*
	 * pages
	 */
	
	@RequestMapping(value="/artilharia")
	public String pageArtilharia() {
		return "jogador-info/artilharia";
	}
	
//	@RequestMapping(value="/artilharia/by/edicao/{edicaoId}", method=RequestMethod.GET)
//	public ModelAndView pageArtilharia(@PathVariable("edicaoId") long id) {
//		ModelAndView mv = new ModelAndView("_base2");
//		mv.addObject("content_import", "jogadorInfoEdicao-page");
//		Edicao edicao = this.edicaoDao.get(Edicao.class, id);
//		edicao.setJogadoresInfoEdicao(this.jogadorInfoEdicaoDao.getJogadoresInfoEdicaoByEdicao(edicao));
//		mv.addObject("edicao", edicao);
//		return mv;
//	}

	
}
