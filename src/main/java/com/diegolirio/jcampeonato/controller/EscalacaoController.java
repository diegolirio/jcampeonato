package com.diegolirio.jcampeonato.controller;

import java.net.URI;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Escalacao;
import com.diegolirio.jcampeonato.model.Evento;
import com.diegolirio.jcampeonato.model.Jogador;
import com.diegolirio.jcampeonato.model.JogadorEscalado;
import com.diegolirio.jcampeonato.model.Jogo;
import com.diegolirio.jcampeonato.model.Status;
import com.diegolirio.jcampeonato.service.EscalacaoService;
import com.diegolirio.jcampeonato.service.EventoService;
import com.diegolirio.jcampeonato.service.JogadorEscaladoService;
import com.diegolirio.jcampeonato.service.JogadorService;
import com.diegolirio.jcampeonato.service.JogoService;

@Controller
@RequestMapping(value="escalacao")
public class EscalacaoController {

	@Autowired @Qualifier("jogoService")
	private JogoService jogoService;
	
	@Autowired @Qualifier("jogadorService")
	private JogadorService jogadorService;

	@Autowired @Qualifier("escalacaoService")
	private EscalacaoService escalacaoService;

	@Autowired @Qualifier("jogadorEscaladoService")
	private JogadorEscaladoService jogadorEscaladoService;

	@Autowired @Qualifier("eventoService")
	private EventoService eventoService;

	/*
	 * Pages
	 */
	
	
	@RequestMapping(value="/add/evento")
	public String eventoAddJogo() {
		return "escalacao/add-evento";
	}
	
	/*
	 * RestFull
	 */
	
	/**
	 * pega escalacao por id
	 * @param id
	 * @return escalacao JSON
	 */
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> get(@PathVariable("id") long id) {
		try {
			Escalacao escalacao = this.escalacaoService.get(Escalacao.class, id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(escalacao), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Cria escalacao por jogo
	 * @param jogoId
	 * @return
	 */
	@RequestMapping(value="/create/by/jogo/{jogoId}", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> addEscalacao(@PathVariable("jogoId") long jogoId) {
		try {
			// TODO: refatorar
			Jogo jogo = this.jogoService.get(Jogo.class, jogoId);
			jogo.getTimeA().setJogadores(this.jogadorService.getListByTime(jogo.getTimeA()));
			jogo.getTimeB().setJogadores(this.jogadorService.getListByTime(jogo.getTimeB()));
			
			if(jogo.getTimeA().getJogadores().size() < 1) {
				throw new RuntimeException(jogo.getTimeA().getNome() + " nao ha jogadores cadastrados, por favor cadastre ao menos Um.");
			}
			if(jogo.getTimeB().getJogadores().size() < 1) {
				throw new RuntimeException(jogo.getTimeB().getNome() + " nao ha jogadores cadastrados, por favor cadastre ao menos Um.");
			}

			// se jogo contem escalacao exclui o mesmo
			Escalacao escalacaoExclui = this.escalacaoService.getByJogo(jogo);
			if(escalacaoExclui != null) {
				for (JogadorEscalado je : escalacaoExclui.getJogadoresEscalados()) {
					this.jogadorEscaladoService.delete(JogadorEscalado.class, je.getId());
				}
				this.escalacaoService.delete(Escalacao.class, escalacaoExclui.getId());
			}
			
			// cria nova escalacao
			Escalacao escalacao = new Escalacao();
			escalacao.setJogo(jogo);
			this.escalacaoService.save(escalacao);
			
			// cria escalacao dos jogadores do time A
			for (Jogador j : jogo.getTimeA().getJogadores()) {
				JogadorEscalado jeA = new JogadorEscalado();
				jeA.setEscalacao(escalacao);			
				jeA.setTime(jogo.getTimeA());
				jeA.setJogador(j);
				this.jogadorEscaladoService.save(jeA); 
			}
	
			// cria escalacao dos jogadores do time B
			for (Jogador j : jogo.getTimeB().getJogadores()) {
				JogadorEscalado jeB = new JogadorEscalado();
				jeB.setEscalacao(escalacao);			
				jeB.setTime(jogo.getTimeB());
				jeB.setJogador(j);
				this.jogadorEscaladoService.save(jeB);
			}		
			
			// seta jogo para em andamento
			jogo.setStatus(new Status(2));
			this.jogoService.save(jogo);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/jogo/"+jogo .getId()));
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
			
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	/**
	 * pega escalacao por jogo
	 * @param jogoId
	 * @return escalacao JSON
	 */
	@RequestMapping(value="/get/by/jogo/{jogoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getByJogo(@PathVariable("jogoId") long jogoId) {
		try {
			Escalacao escalacao = this.escalacaoService.getByJogo(new Jogo(jogoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(escalacao ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Add evento para jogadorEscalado
	 * @param eventoId
	 * @param jogadorEscaladoId
	 * @return
	 */
	@RequestMapping(value="/add/evento/{eventoId}/to/jogadorescalado/{jogadorEscaladoId}", method=RequestMethod.POST)
	public ResponseEntity<String> addEventoJogadorEscalado(@PathVariable("eventoId") long eventoId, @PathVariable("jogadorEscaladoId") long jogadorEscaladoId) {
		JogadorEscalado jogadorEscalado = this.jogadorEscaladoService.get(JogadorEscalado.class, jogadorEscaladoId);
		Evento evento = this.eventoService.get(Evento.class, eventoId);
		
		jogadorEscalado.getEventos().add(evento);
		this.jogadorEscaladoService.save(jogadorEscalado);
		
		Jogo jogo = this.jogoService.get(Jogo.class, jogadorEscalado.getEscalacao().getJogo().getId());
		if(evento.getId() == 1) { // GOL
			if(jogadorEscalado.getTime().getId() == jogo.getTimeA().getId()) {
				jogo.setResultadoA(jogo.getResultadoA()+1);
			} else if(jogadorEscalado.getTime().getId() == jogo.getTimeB().getId()) {
				jogo.setResultadoB(jogo.getResultadoB()+1);
			}
		}
		this.jogoService.save(jogo);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/jogo/system/"+jogadorEscalado.getEscalacao().getJogo().getId()));
		return new ResponseEntity<String>(headers , HttpStatus.CREATED);
	}	
	
	/**
	 * Remove evento do jogador escalado
	 * @param jogadorEscaladoId
	 * @param eventoId
	 * @return HttpStatus
	 */
	@RequestMapping(value="/remove/evento{eventoId}/from/jogadorescalado/{jogadorEscaladoId}", method=RequestMethod.POST, produces="application/json")
	public ResponseEntity<String> deleteEventosJogadorEscalado(@PathVariable("jogadorEscaladoId") long jogadorEscaladoId, @PathVariable("eventoId") long eventoId) {
		Evento evento = this.eventoService.get(Evento.class, eventoId);
		JogadorEscalado jogadorEscalado = this.jogadorEscaladoService.get(JogadorEscalado.class, jogadorEscaladoId);
		if(evento.getId() == 1) { // GOL
			Jogo jogo = jogadorEscalado.getEscalacao().getJogo();
			if(jogadorEscalado.getTime().getId() == jogadorEscalado.getEscalacao().getJogo().getTimeA().getId()) 
				jogo.setResultadoA(jogo.getResultadoA()-1);
			else 
				jogo.setResultadoB(jogo.getResultadoB()-1);
			this.jogoService.save(jogo);
		}
		jogadorEscalado.getEventos().remove(evento);
		this.jogadorEscaladoService.save(jogadorEscalado);
		return new ResponseEntity<String>(HttpStatus.OK);
	}		
	
	
}
