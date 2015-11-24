package com.diegolirio.jcampeonato.controller;

import java.util.Calendar;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Campeonato;
import com.diegolirio.jcampeonato.model.Classificacao;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Fase;
import com.diegolirio.jcampeonato.model.Grupo;
import com.diegolirio.jcampeonato.model.Harbito;
import com.diegolirio.jcampeonato.model.Jogo;
import com.diegolirio.jcampeonato.model.Local;
import com.diegolirio.jcampeonato.model.Status;
import com.diegolirio.jcampeonato.model.Usuario;
import com.diegolirio.jcampeonato.service.ClassificacaoService;
import com.diegolirio.jcampeonato.service.EdicaoService;
import com.diegolirio.jcampeonato.service.FaseService;
import com.diegolirio.jcampeonato.service.GrupoService;
import com.diegolirio.jcampeonato.service.JogoService;
import com.diegolirio.jcampeonato.service.StatusService;

@Controller
@RequestMapping("edicao")
public class EdicaoController {
	
	@Autowired
	private EdicaoService edicaoService;
	@Autowired
	private GrupoService grupoService;
	@Autowired
	private ClassificacaoService classificacaoService;
	@Autowired
	private JogoService jogoService;
	@Autowired
	private FaseService faseService;
	@Autowired
	private StatusService statusService;

	/*
	 * Pages
	 */

	@RequestMapping(value="/novo", method=RequestMethod.GET)
	public String pageForm() {
		return "edicao/form";
	}	

	@RequestMapping(value="/confirma/conclusao", method=RequestMethod.GET)
	public String pageConfirmaConclusao() {
		return "edicao/confirma-conclusao";
	}	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String pageList() {
		return "edicao/list";
	}

	@RequestMapping(value="/classificacao", method=RequestMethod.GET)
	public String pageClassificacao() {
		return "edicao/classificacao";
	}
	
	
	/*
	 * Rest Full
	 */
	
	/**
	 * Pega as edicoes por Status
	 * @param idStatus
	 * @return
	 */
	@RequestMapping(value="/get/list/por/status/{idStatus}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListPorStatus(@PathVariable("idStatus") long idStatus) {
		try {
			List<Edicao> edicoes = this.edicaoService.getListPorStatus(new Status(idStatus));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(edicoes ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * pega lista de edicao por status e usuario administrador
	 * @param idStatus
	 * @return
	 */
	@RequestMapping(value="/get/list/by/status/{statusId}/and/usuario/adm/{usuarioAdmId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getListByStatusAndusuarioAdm(@PathVariable("statusId") long statusId, @PathVariable("usuarioAdmId") long usuarioAdmId) {
		try {
			List<Edicao> edicoes = this.edicaoService.getListByStatusAndUsuarioAdm(new Status(statusId), new Usuario(usuarioAdmId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(edicoes ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Pega a Edicao por ID
	 * @param id
	 * @return JSON
	 */
	@RequestMapping(value="/get/por/id/{id}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getPorId(@PathVariable("id") long id) {
		try {
			Edicao edicao = this.edicaoService.get(Edicao.class, id);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(edicao ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Pega lista de Edicao por Campeonato
	 * @param campeonatoId
	 * @return lista de edicao JSON
	 */
	@RequestMapping(value="/get/list/by/campeonato/{campeonatoId}", method=RequestMethod.GET, produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getByCampeonato(@PathVariable("campeonatoId") long campeonatoId) {
		try {
			List<Edicao> edicoes = this.edicaoService.getListByCampeonato(new Campeonato(campeonatoId));
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(edicoes ), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	/**
	 * Salvar Edicao
	 * @param edicao
	 * @return JSON
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> save(@RequestBody Edicao edicao) {
		try {
			this.edicaoService.save(edicao);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(edicao), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	/**
	 * Confirma conclusao setando edicao e grupos da edicao para em andamento
	 * @param edicao
	 * @return JSON
	 */
	@RequestMapping(value="/confirma/conclucao", method=RequestMethod.POST, consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> confirmaConclusao(@RequestBody Edicao edicao) {
		try {
			this.edicaoService.confirmaConclusao(edicao);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(edicao), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

	/**
	 * Finaliza 1a Fase
	 */
	 @RequestMapping(value="/{id}/finalizarPrimeiraFase", method=RequestMethod.POST, produces="application/json")
	 public ResponseEntity<String> finalizar1Fase(@PathVariable("id") long id) {
		 try {
			 Edicao edicao = this.edicaoService.get(Edicao.class, id);
			 List<Grupo> grupos = this.grupoService.getListaPorEdicao(edicao);
			 validaFinalizacaoFase(grupos);
			 if(grupos.size() == 1) {
				 List<Classificacao> classificacoes = this.classificacaoService.getClassificacoesByGrupo(grupos.get(0));
				 if(classificacoes.size() <= 3) {
					 // Cria somente a Final
					 criarFinal1Fase1GrupoMenosQ3Times(grupos.get(0));
				 } else if(classificacoes.size() > 3) {
					 // cria 3lugar e final
					 criar3LugarFinal1Fase1GrupoMenosQ3Times(grupos.get(0));
				 }
			 } else if (grupos.size() == 2) {
				 // cria semi
			 } else if (grupos.size() == 4) {
				 // cria quartas
			 } else if (grupos.size() == 8) {
				 // cria oitavas
			 }
			 this.grupoService.updateSetStatusFinalizado(grupos);
			 return new ResponseEntity<String>(HttpStatus.CREATED);
		 } catch(Exception e) {
			 e.printStackTrace();
			 return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }	
	
	 private boolean validaFinalizacaoFase(List<Grupo> grupos) {
			for (Grupo grupo : grupos) {
				// verifica se todos os grupos são da 1a fase.
				if(grupo.getFase().getSigla() != '1')
					throw new RuntimeException("Existem grupos que nao sao da Primeira fase(pode ja ter sido finalizados), nao ha possibilidades de finalizar.");
				List<Jogo> jogos = this.jogoService.getListByGrupo(grupo);
				// verifica se exite pelo menos 1 jogo por grupo.
				if(jogos.size() <= 0) 
					throw new RuntimeException("Grupo " + grupo.getDescricao() + " não contem jogos.");
				for (Jogo jogo : jogos) { 
					// verifica se todos os jogos estão finalizados.
					if(jogo.getStatus().getId() != 3)
						throw new RuntimeException("Existem jogos não encerrados, encerrem todos os jogos para finalizar a Fase!");
					// verifica se todos os times tem a mesma qtde de jogos.
				}
				List<Classificacao> classificacoes = this.classificacaoService.getClassificacoesByGrupo(grupo);
				int qtdeJ = classificacoes.get(0).getJogos();
				for (Classificacao classificacao : classificacoes) {
					 if(qtdeJ != classificacao.getJogos()) 
						 throw new RuntimeException("Todos os Times devem estar com a mesma quantidade de Jogos para finalizar a fase!");
				}
			}
			return true;
		}

		private boolean criarFinal1Fase1GrupoMenosQ3Times(Grupo grupoUnicoPrimeiraFase) {
			// TODO: refatorar criar final
			// cria 2 fase com final e 3 lugar
			Fase _2fase = this.faseService.getBySigla('2');
			Grupo grupo = new Grupo();
			grupo.setEdicao(grupoUnicoPrimeiraFase.getEdicao());
			grupo.setFase(_2fase);
			grupo.setDescricao("Segunda Fase (Mata-mata)");
			grupo.setStatus(this.statusService.get(Status.class, 2l));
			this.grupoService.save(grupo);
			List<Classificacao> classificacoes = this.classificacaoService.getClassificacoesByGrupo(grupoUnicoPrimeiraFase);
			List<Jogo> jogos = this.jogoService.getListByGrupo(grupoUnicoPrimeiraFase);
			// Cria a Final, rodada -1
			criaJogoMataMata(grupo, 
							 jogos.get(0).getHarbito(), 
							 jogos.get(0).getLocal(), 
							 classificacoes,
							 -1,
							 1,
							 2);
			return true;
		}
		
		/**
		 * Criar 3 lugar e final 
		 * @param grupoUnicoPrimeiraFase
		 * @return
		 */
		private boolean criar3LugarFinal1Fase1GrupoMenosQ3Times(Grupo grupoUnicoPrimeiraFase) {
			// cria 2 fase com final e 3 lugar
			Fase _3 = this.faseService.getBySigla('3');
			Grupo _3LugarGrupo = new Grupo();
			_3LugarGrupo.setEdicao(grupoUnicoPrimeiraFase.getEdicao());
			_3LugarGrupo.setFase(_3);
			_3LugarGrupo.setDescricao(_3.getDescricao());
			_3LugarGrupo.setStatus(this.statusService.get(Status.class, 2l));
			this.grupoService.save(_3LugarGrupo);

			List<Classificacao> classificacoes = this.classificacaoService.getClassificacoesByGrupo(grupoUnicoPrimeiraFase);
			List<Jogo> jogos = this.jogoService.getListByGrupo(grupoUnicoPrimeiraFase);
			// Cria a 3 Lugar, rodada -3
			criaJogoMataMata(_3LugarGrupo, 
						     jogos.get(0).getHarbito(), 
						     jogos.get(0).getLocal(), 
						     classificacoes,
						     1,
						     3,
						     4);		

			// Cria a Final, rodada -1
			Fase _final = this.faseService.getBySigla('F');
			Grupo finalGrupo = new Grupo();
			finalGrupo.setEdicao(grupoUnicoPrimeiraFase.getEdicao());
			finalGrupo.setFase(_final);
			finalGrupo.setDescricao(_final.getDescricao());
			finalGrupo.setStatus(this.statusService.get(Status.class, 2l));
			this.grupoService.save(finalGrupo);

			criaJogoMataMata(finalGrupo, 
							 jogos.get(0).getHarbito(), 
							 jogos.get(0).getLocal(), 
							 classificacoes,
							 2,
							 1,
							 2);
			grupoUnicoPrimeiraFase.setStatus(new Status(3l));
			this.grupoService.save(grupoUnicoPrimeiraFase);
			return true;
		}

		private void criaJogoMataMata(Grupo grupo, Harbito harbito, Local local, List<Classificacao> classificacoes, int rodada, int colocacaoTimeA, int colocacaoTimeB) {
			Jogo jogo = new Jogo();
			jogo.setDataHora(Calendar.getInstance().getTime());
			jogo.setGrupo(grupo);
			jogo.setHarbito(harbito);
			jogo.setLocal(local);
			jogo.setRodada(rodada);
			jogo.setSequencia((int)this.jogoService.getListByGrupo(grupo).size()+1); // TODO: refatorar
			jogo.setStatus(new Status(1l));
			boolean timeAOK = false;
			for (Classificacao classificacao : classificacoes) {
				if(classificacao.getColocacao() == colocacaoTimeA && timeAOK == false) {
					jogo.setTimeA(classificacao.getTime());
					timeAOK = true;
				} else if(classificacao.getColocacao() == colocacaoTimeB || classificacao.getColocacao() == colocacaoTimeA) {
					jogo.setTimeB(classificacao.getTime());
				}
			}
			this.jogoService.save(jogo);
		}
		
		@RequestMapping(value="/{id}/voltar/fase/{faseId}", method=RequestMethod.POST, produces="application/json")
		public ResponseEntity<String> voltarParaPrimeiraFase(@PathVariable("id") long id, @PathVariable("faseId") long faseId) {
			try {
				Edicao edicao = this.edicaoService.get(Edicao.class, id);
				Fase fase = this.faseService.get(Fase.class, faseId);
				
				List<Grupo> gruposFaseAtual = this.grupoService.getListByEdicaoAndFase(edicao, fase);
				if(fase.getSigla() == 'F') {
					gruposFaseAtual.addAll(this.grupoService.getListByEdicaoAndFase(edicao, this.faseService.getBySigla('3')));
				}
				
				for (Grupo grupo : gruposFaseAtual) {
					List<Jogo> jogos = this.jogoService.getListByGrupo(grupo);
					for (Jogo jogo : jogos) {
						if(jogo.getStatus().getId() > 1) { // > 1, em andamento ou finalizado
							throw new RuntimeException("2ª Fase em andamento impossivel voltar para 1ª Fase!");
						}
					}
				}

				// Exclui Jogos da 2ª Fase
				for (Grupo grupo : gruposFaseAtual) {
					List<Jogo> jogos = this.jogoService.getListByGrupo(grupo); 
					for (Jogo jogo : jogos) {
						if(jogo.getStatus().getId() == 1) { // > 1, em andamento ou finalizado
							this.jogoService.delete(Jogo.class, jogo.getId());
						}
					}
					this.grupoService.delete(Grupo.class, grupo.getId());
				}		
				
				List<Grupo> grupos = this.grupoService.getListaPorEdicao(edicao);
				for (Grupo grupo : grupos) {
					grupo.setStatus(new Status(2l));
					this.grupoService.save(grupo);
				}			
				//HttpHeaders headers = new HttpHeaders();
				//headers.setLocation(URI.create("/jchampionship/"));
				return new ResponseEntity<String>(HttpStatus.OK);
			} catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		
	 
}
