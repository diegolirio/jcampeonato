package com.diegolirio.jcampeonato.controller;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Usuario;
import com.diegolirio.jcampeonato.model.UsuarioPerfilCampeonato;
import com.diegolirio.jcampeonato.service.UsuarioPerfilCampeonatoService;

@Controller
@RequestMapping("usuarioperfilcampeonato")
public class UsuarioPerfilCampeonatoController {

	@Autowired
	private UsuarioPerfilCampeonatoService usuarioPerfilCampeonatoService;

	/*
	 * RestFull
	 */
	
	/**
	 * pega UsuarioPerfilCampeonato por usuario e campeonato
	 * @param usuarioId
	 * @param campeonatoId
	 * @return UsuarioPerfilCampeonato JSON
	 */
	@RequestMapping(value="/get/by/usuario/{usuarioId}/and/campeonato/{campeonatoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getByUsuarioAndCampeonato(@PathVariable("usuarioId") long usuarioId, @PathVariable("campeonatoId") long campeonatoId) {
		try {
			UsuarioPerfilCampeonato usuarioPerfilCampeonato = 
					this.usuarioPerfilCampeonatoService.getByUsuarioAndCampeonato(new Usuario(usuarioId), new Campeonato(campeonatoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(usuarioPerfilCampeonato), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * pega lista de campeonatos por usuario
	 * @param usuarioId
	 * @return lista campeonato
	 */
	@RequestMapping(value="/get/list/by/usuario/{usuarioId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListByUsuarioA(@PathVariable("usuarioId") long usuarioId) {
		try {
			List<UsuarioPerfilCampeonato> usuariosPerfisCampeonatos = this.usuarioPerfilCampeonatoService.getListByUsuario(new Usuario(usuarioId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(usuariosPerfisCampeonatos ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}		
	
}
