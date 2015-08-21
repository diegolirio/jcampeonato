package com.diegolirio.jcampeonato.controller;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Usuario;

@Controller
@RequestMapping("/usuario/login")
public class UsuarioLoginController {

	/**
	 * Efetuar Login
	 * @param usuario
	 * @param session
	 * @return Response (JSON)
	 */
	@RequestMapping(value="/efetuar", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> efetuarLogin(@RequestBody Usuario usuario, HttpSession session) {
		try {
			if(usuario== null) {
				usuario = new Usuario();
				usuario.setId(1);
				usuario.setEmail("diegolirio.dl@gmail.com");
				usuario.setNome("Diego Lirio");
			}
			session.setAttribute("usuarioLogado", usuario);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(usuario), HttpStatus.OK);
		} catch(Exception e ) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Verifica se h� sess�o(logado) do usuario
	 * @param session
	 * @return restFull JSON usuario
	 */
	@RequestMapping(value="/session", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getSessionLogged(HttpSession session) {
		try {
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			if(usuario == null) 
				throw new RuntimeException("Usuario desconectado");
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(usuario), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}	
	
	/*
	 * Sair da sessao
	 */
	@RequestMapping(value="/logout", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> logout(HttpSession session) {
		try {
			session.invalidate();
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
}
