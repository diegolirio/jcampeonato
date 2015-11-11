package com.diegolirio.jcampeonato.controller;

import java.util.Calendar;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Classificacao;
import com.diegolirio.jcampeonato.model.ClassificacaoHist;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Escalacao;
import com.diegolirio.jcampeonato.model.Evento;
import com.diegolirio.jcampeonato.model.Jogador;
import com.diegolirio.jcampeonato.model.JogadorEscalado;
import com.diegolirio.jcampeonato.model.JogadorInfoEdicao;
import com.diegolirio.jcampeonato.model.Jogo;
import com.diegolirio.jcampeonato.model.Status;
import com.diegolirio.jcampeonato.model.Time;
import com.diegolirio.jcampeonato.service.ClassificacaoHistService;
import com.diegolirio.jcampeonato.service.ClassificacaoService;
import com.diegolirio.jcampeonato.service.EscalacaoService;
import com.diegolirio.jcampeonato.service.JogadorEscaladoService;
import com.diegolirio.jcampeonato.service.JogadorInfoEdicaoService;
import com.diegolirio.jcampeonato.service.JogoService;

@Controller
@RequestMapping("jogo")
public class JogoController {

	@Autowired @Qualifier("jogoService")
	private JogoService jogoService;
	
	@Autowired
	private EscalacaoService escalacaoService;

	@Autowired
	private JogadorInfoEdicaoService jogadorInfoEdicaoService;

	@Autowired
	private ClassificacaoHistService classificacaoHistService;

	@Autowired
	private ClassificacaoService classificacaoService;

	@Autowired
	private JogadorEscaladoService jogadorEscaladoService;

	/*
	 * Pages
	 */
	
	/**
	 * Retorna Form Jogo
	 * @return String
	 */
	@RequestMapping(value="/novo")
	public String novo() {
		return "jogo/form";
	}

	/**
	 * pagina resulta/placar do jogo e escalacao
	 * @return
	 */
	@RequestMapping(value="/resultado")
	public String pageResultado() {
		return "jogo/resultado";
	}
	
	
	/*
	 * RestFull
	 */
	
	/**
	 * Busca lista de locais por Edicao
	 * @param edicaoId
	 * @return lista de jogos JSON
	 */
	@RequestMapping(value="/get/lista/por/edicao/{edicaoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListaPorEdicao(@PathVariable("edicaoId") long edicaoId) {
		try {
			List<Jogo> jogos = this.jogoService.getListByEdicao(new Edicao(edicaoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogos), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	};	
	
	/**
	 * pega o jogo por id
	 * @param id
	 * @return jogo JSON
	 */
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> get(@PathVariable("id") long id) {
		try {
			Jogo jogo = this.jogoService.get(Jogo.class, id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogo), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * pega lista de jogos por time
	 * @param time
	 * @return jogos JSON
	 */
	@RequestMapping(value="/get/list/by/time/{timeId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListByTime(@PathVariable("timeId") long timeId) {
		try {
			List<Jogo> jogos = this.jogoService.getListByTime(new Time(timeId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogos), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	/**
	 * pega o jogo por id
	 * @param id
	 * @return jogo JSON
	 */
	@RequestMapping(value="/get/{id}/next", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getNext(@PathVariable("id") long id) {
		try {
			Jogo jogo = this.jogoService.get(Jogo.class, id);
			Jogo nextJogo = this.jogoService.getNextJogo(jogo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(nextJogo), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * pega o jogo por id
	 * @param id
	 * @return jogo JSON
	 */
	@RequestMapping(value="/get/{id}/previous", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getPrevious(@PathVariable("id") long id) {
		try {
			Jogo jogo = this.jogoService.get(Jogo.class, id);
			Jogo previousJogo = this.jogoService.getPreviousJogo(jogo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(previousJogo), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * pega lista de jogos em que jogador marcou gols
	 * @param jogadorId
	 * @return jogos JSON
	 */
	@RequestMapping(value="/get/list/jogador/{jogadorId}/with/gols", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListJogadorWithGols(@PathVariable("jogadorId") long jogadorId) {
		try {
			List<Jogo> jogos = this.jogoService.getListJogadorWithGols(new Jogador(jogadorId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogos), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	/**
	 * pega ultima rodada de jogos por edicao
	 * @param edicaoId
	 * @return rodada (int) JSON
	 */
	@RequestMapping(value="/get/last/rodada/by/edicao/{edicaoId}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> getLastRodadaByEdicao(@PathVariable("edicaoId") long edicaoId) {
		try {
			int ultimaRodada = this.jogoService.getLastRodadaByEdicao(new Edicao(edicaoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(ultimaRodada ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Salva Jogo
	 * @param jogo
	 * @return
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Jogo jogo) {
		try {
			// *************** BUG ******************
			Calendar data = Calendar.getInstance();
			data.setTime(jogo.getDataHora());
			data.add(Calendar.DATE, 1);
			jogo.setDataHora(data.getTime()); 
			// **************************************
			if(jogo.getSequencia() == -1)
				jogo.setSequencia((int)(this.jogoService.getLastSequenciaByRodada(jogo.getRodada())+1));
			this.jogoService.save(jogo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogo), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * delete jogo
	 * @param id
	 * @return HttpStatus
	 */
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		this.jogoService.delete(Jogo.class, id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	/**
	 * finaliza o Jogo e calcula classificacao e artilharia
	 * @param id
	 * @return jogo JSON
	 */
	@RequestMapping(value="/{id}/finalizar", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> finalizar(@PathVariable("id") long id) {
		try {
			Jogo jogo = this.jogoService.get(Jogo.class, id);
			this.jogoService.finalizar(jogo);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(jogo ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Retorna Jogo de Finalizado para em andamento e retorna os calculos (classificacao, 
	 *   jogadorInfoEdicao) e delete o historico da rodada caso o ultimo historico seje o mesmo
	 *   sendo calculado
	 * @param id
	 * @return JSON
	 */
	@RequestMapping(value="/{id}/return/status", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> returnStatusJogo(@PathVariable("id") long id) {
		try {
			Jogo jogo = this.jogoService.get(Jogo.class, id);
			if(jogo.getStatus().getId() == 1)  // finalizado
				throw new RuntimeException("Jogo encontra-se com Status " + jogo.getStatus().getDescricao());
			
			if (jogo.getStatus().getId() == 3) {
				this.retornaCalculoJogadorInfoEdicao(jogo);
				this.retornaCalculaClassificacao(jogo);
				this.jogoService.ordenaClassificacao(jogo); 
				jogo.setStatus(new Status(2)); // seta jogo p/ status em andamento...
				this.jogoService.save(jogo);
			}
			else if(jogo.getStatus().getId() == 2) {
				Escalacao escalacao = this.escalacaoService.getByJogo(jogo);
				List<JogadorEscalado> jogadoresEscalados = escalacao.getJogadoresEscalados();
				// verifica se tem evento cadastrado
				for (JogadorEscalado jogadorEscalado : jogadoresEscalados) {
					if(jogadorEscalado.getEventos().size() > 0) {
						throw new RuntimeException("Para voltar jogo para Status Pendente, deve excluir todos os eventos(gols, cartoes) do jogo.");
					}
				}
				// exclui jogador escalado
				for (JogadorEscalado jogadorEscalado : jogadoresEscalados) {
					this.jogadorEscaladoService.delete(JogadorEscalado.class, jogadorEscalado.getId());
				}
				// exclui escalacao
				this.escalacaoService.delete(Escalacao.class, escalacao.getId());
				// set jogo status pendente
				jogo.setStatus(new Status(1l)); 
				jogo.setResultadoA(0);
				jogo.setResultadoB(0); 
				this.jogoService.save(jogo);
			}
			return new ResponseEntity<String>(HttpStatus.OK);
				
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private void retornaCalculoJogadorInfoEdicao(Jogo jogo) {
		Escalacao escalacao = this.escalacaoService.getByJogo(jogo);
		List<JogadorInfoEdicao> jogadoresInfoEdicao = this.jogadorInfoEdicaoService.getByEdicao(jogo.getGrupo().getEdicao());
		for (JogadorEscalado je : escalacao.getJogadoresEscalados()) {
			for(JogadorInfoEdicao jie : jogadoresInfoEdicao) {
				if(je.getJogador().getId() == jie.getJogador().getId()) {
					jie.setJogos(jie.getJogos()-1);
					for (Evento evento : je.getEventos()) {

						if(evento.getId() == 1) // 1 = Gol
							jie.setGols(jie.getGols()-1);
						else
						if(evento.getId() == 2) // 2 = Cartao Amarelo
							jie.setCartaoAmarelo(jie.getCartaoAmarelo()-1);
						else 
						if (evento.getId() == 3) // 3 = Cartao Vermelho
							jie.setCartaoVermelho(jie.getCartaoVermelho()-1);
					}
					this.jogadorInfoEdicaoService.save(jie);
				}
			}
		}
	}

	private List<Classificacao> retornaCalculaClassificacao(Jogo jogo) {
		// pega a ultima rodada guardada no historico da classificacao
		int rodadaLastHist = this.classificacaoHistService.getNumberHistLastRodada(jogo.getGrupo());
		// se o ultimo hist da clasificacao for a mesma rodada do jogo cancelado, delete o historico... 
		if(rodadaLastHist == jogo.getRodada()) {
			List<ClassificacaoHist> histLastRodada = classificacaoHistService.getHistListByRodada(jogo.getRodada(), jogo.getGrupo());
			for (ClassificacaoHist hist : histLastRodada) {
				this.classificacaoHistService.delete(ClassificacaoHist.class, hist.getId());
			}			
		}
		
		char vencedor = 'E';
		if(jogo.getResultadoA() > jogo.getResultadoB()) 
			vencedor = 'A';
		else if (jogo.getResultadoA() < jogo.getResultadoB())
			vencedor = 'B';
		
		List<Classificacao> classificacoes = this.classificacaoService.getClassificacoesByGrupo(jogo.getGrupo());
		
		// Retorna o calculo gerado da clasificacao
		for (Classificacao classTime : classificacoes) {
			// calcula classificacao time A
			if(classTime.getTime().getId() == jogo.getTimeA().getId()) {
				classTime.setJogos(classTime.getJogos()-1);
				classTime.setGolsPro(classTime.getGolsPro()-jogo.getResultadoA());
				classTime.setGolsContra(classTime.getGolsContra()-jogo.getResultadoB());
				if(vencedor == 'A') {
					classTime.setVitorias(classTime.getVitorias()-1);
					classTime.setPontos(classTime.getPontos()-3);
				} 
				else if (vencedor == 'E') {
					classTime.setEmpates(classTime.getEmpates()-1);
					classTime.setPontos(classTime.getPontos()-1);
				} else if(vencedor == 'B') {
					classTime.setDerrotas(classTime.getDerrotas()-1);
				}
				this.classificacaoService.save(classTime);
			} // Calcula classificacao Time B 
			else if(classTime.getTime().getId() == jogo.getTimeB().getId()) {
				classTime.setJogos(classTime.getJogos()-1);
				classTime.setGolsPro(classTime.getGolsPro()-jogo.getResultadoB());
				classTime.setGolsContra(classTime.getGolsContra()-jogo.getResultadoA()); 
				if(vencedor == 'A') {
					classTime.setDerrotas(classTime.getDerrotas()-1);
				} else if(vencedor == 'E') {
					classTime.setEmpates(classTime.getEmpates()-1);
					classTime.setPontos(classTime.getPontos()-1);					
				} else if(vencedor == 'B') {
					classTime.setVitorias(classTime.getVitorias()-1);
					classTime.setPontos(classTime.getPontos()-3);
				}
				this.classificacaoService.save(classTime);
			}
		}
		return classificacoes;
	}

	
	
}
