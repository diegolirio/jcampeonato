package com.diegolirio.jcampeonato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.JogadorEscalado;
import com.diegolirio.jcampeonato.service.JogadorEscaladoService;

@Controller
@RequestMapping("jogadorescalado")
public class JogadorEscaladoController {

	@Autowired
	private JogadorEscaladoService jogadorEscaladoService;

	/**
	 * Exclui Jogador Escalado
	 * @param id
	 * @return HttpStatus
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ResponseEntity<String> deleteJogadorEscalado(@PathVariable("id") long id) {
		try {
			JogadorEscalado jogadorEscalado = this.jogadorEscaladoService.get(JogadorEscalado.class, id);
			if(jogadorEscalado.getEventos().size() == 0) {
				this.jogadorEscaladoService.delete(JogadorEscalado.class, id);
				return new ResponseEntity<String>(HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Existem Gols ou Cart�es adicionados a este Jogador, para retira-lo da escala��o, retire primeiramente esses eventos!", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	
}
