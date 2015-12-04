package com.diegolirio.jcampeonato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diegolirio.jcampeonato.dao.ClassificacaoDao;
import com.diegolirio.jcampeonato.dao.ClassificacaoHistDao;
import com.diegolirio.jcampeonato.dao.EdicaoDao;
import com.diegolirio.jcampeonato.dao.EscalacaoDao;
import com.diegolirio.jcampeonato.dao.GrupoDao;
import com.diegolirio.jcampeonato.dao.JogadorInfoEdicaoDao;
import com.diegolirio.jcampeonato.dao.JogoDao;
import com.diegolirio.jcampeonato.dao.PodiumDao;
import com.diegolirio.jcampeonato.model.Classificacao;
import com.diegolirio.jcampeonato.model.ClassificacaoHist;
import com.diegolirio.jcampeonato.model.Edicao;
import com.diegolirio.jcampeonato.model.Escalacao;
import com.diegolirio.jcampeonato.model.Evento;
import com.diegolirio.jcampeonato.model.Grupo;
import com.diegolirio.jcampeonato.model.Jogador;
import com.diegolirio.jcampeonato.model.JogadorEscalado;
import com.diegolirio.jcampeonato.model.JogadorInfoEdicao;
import com.diegolirio.jcampeonato.model.Jogo;
import com.diegolirio.jcampeonato.model.Podium;
import com.diegolirio.jcampeonato.model.Status;
import com.diegolirio.jcampeonato.model.Time;

@Service("jogoService")
public class JogoService extends AbstractGenericService<Jogo> {

	//@Autowired @Qualifier("finalizaJogoFaseGrupoMata")
	//private FinalizaJogo finalizaJogo;// = new FinalizaJogoFaseGrupoMata();
	
	@Autowired @Qualifier("classificacaoDao")
	private ClassificacaoDao classificacaoDao;
	
	@Autowired @Qualifier("escalacaoDao")
	private EscalacaoDao escalacaoDao;

	@Autowired @Qualifier("jogadorInfoEdicaoDao")
	private JogadorInfoEdicaoDao jogadorInfoEdicaoDao;

	@Autowired @Qualifier("jogoDao")
	private JogoDao jogoDao;

	@Autowired @Qualifier("classificacaoHistDao")
	private ClassificacaoHistDao classificacaoHistDao;

	@Autowired @Qualifier("grupoDao")
	private GrupoDao grupoDao;

	@Autowired
	private PodiumDao podiumDao;

	@Autowired
	private EdicaoDao edicaoDao;
	
	public List<Jogo> getListByEdicao(Edicao edicao) {
		return this.getList(Jogo.class);
	}

	/**
	 * finalizar jogo e calc
	 * @param jogo
	 */
	public void finalizar(Jogo jogo) {
		if(jogo.getStatus().getId() != 2)
			throw new RuntimeException("Jogo nao encontra-se em andamento.");
		
		
		// se tipo edicao for fase grupo mata-mata e se jogo for primeira fase
		if(jogo.getGrupo().getEdicao().getTipoEdicao().getId() == 1 && jogo.getGrupo().getFase().getSigla() == '1') {
			//FinalizaJogo finalizaJogo = new FinalizaJogoFaseGrupoMata();
			this.executeFinalizaFaseGrupoPrimeiraFase(jogo);
		} 
		
		// se tipo edicao for fase grupo mata-mata e se jogo for disputa terceiro lugar
		else if(jogo.getGrupo().getEdicao().getTipoEdicao().getId() == 1 && jogo.getGrupo().getFase().getSigla() == '3') {
			this.executeFinalizaFaseGrupo3Lugar(jogo);
		} 

		// se tipo edicao for fase grupo mata-mata e se jogo for FINAL
		else if(jogo.getGrupo().getEdicao().getTipoEdicao().getId() == 1 && jogo.getGrupo().getFase().getSigla() == 'F') {
			this.executeFinalizaFaseGrupoFinal(jogo);
		} 		
		
		else {
			throw new RuntimeException("Em desenvolvimento");
		}
		
		
	}
	
	/**
	 * Final Fase de Grupo Mata-Mata
	 * @param jogo
	 */
	private void executeFinalizaFaseGrupoFinal(Jogo jogo) {
		
		Edicao edicao = jogo.getGrupo().getEdicao();
		
		if(jogo.getResultadoA() == jogo.getResultadoB()) { // se empate 
			jogo.setStatus(new Status(4)); // disputa por penalti
		} else {
			
			//Atualiza JogodorInfo
			this.atualizaJogadorinfoEdicao(jogo);
			
			// verifica se todos os jogos estao finalizados
			List<Jogo> todosJogosEdicao = this.jogoDao.getListByEdicao(edicao);
			for (Jogo j : todosJogosEdicao) {
				if(j.getStatus().getId() != 3 && j.getId() != jogo.getId())
					throw new RuntimeException("Todos os jogos precisam estar Finalizados");
			}
			
			// Salva Jogo Finalizando o mesmo
			this.saveJogoFinalizado(jogo);
			System.out.println("===================================================================");
			System.out.println(jogo);
			System.out.println("===================================================================");
			
			// finaliza grupo final
			Grupo grupoFinal = jogo.getGrupo();
			grupoFinal.setStatus(new Status(3));
			this.grupoDao.save(grupoFinal);
			
			// cria podium
			Podium podium = this.podiumDao.getByEdicao(edicao);
			if(podium == null) {
				podium = new Podium();
			}
			podium.setEdicao(edicao);
			podium.setTimeCampeao(jogo.getVencedor() == 'A' ? jogo.getTimeA() : jogo.getTimeB());
			podium.setTimeViceCampeao(jogo.getVencedor() == 'A' ? jogo.getTimeB() : jogo.getTimeA());
			Jogo jogoTerceiroLugar = this.jogoDao.getTerceiroLugar(edicao);
			podium.setTimeTerceiroColocado(jogoTerceiroLugar.getVencedor() == 'A' ? jogoTerceiroLugar.getTimeA() : jogoTerceiroLugar.getTimeB());
			this.podiumDao.save(podium);

			// TODO: finaliza edicao
			edicao.setStatus(new Status(3));
			this.edicaoDao.save(edicao);
		}		
		
		//throw new RuntimeException("FInal Em desenvolvimento");
		
	}

	public void executeFinalizaFaseGrupoPrimeiraFase(Jogo jogo) {
		this.calculaClassificacao(jogo);
		this.ordenaClassificacao(jogo);
		this.atualizaJogadorinfoEdicao(jogo);
		this.saveJogoFinalizado(jogo);
		// guarda historico da classificacao se todos os jogos da rodada finalizado!
		this.saveClassificacaoHist(jogo.getGrupo(), jogo.getRodada());
	}
	
	public void executeFinalizaFaseGrupo3Lugar(Jogo jogo) {

		if(jogo.getResultadoA() == jogo.getResultadoB()) { // se empate 
			jogo.setStatus(new Status(4)); // disputa por penalti
		} else {
			this.atualizaJogadorinfoEdicao(jogo);
			this.saveJogoFinalizado(jogo);
			
			// finaliza grupo 3 Lugar
			Grupo grupo3Lugar = jogo.getGrupo();
			grupo3Lugar.setStatus(new Status(3));
			this.grupoDao.save(grupo3Lugar);
		}
	}
	
	public void saveJogoFinalizado(Jogo jogo) {
		jogo.setStatus(new Status(3));
		
		if(jogo.getResultadoA() > jogo.getResultadoB())			
			jogo.setVencedor('A');
		else if(jogo.getResultadoB() > jogo.getResultadoA())
			jogo.setVencedor('B');
		if(jogo.getResultadoA() == jogo.getResultadoB())
			// TODO: se nao contem penalti
			jogo.setVencedor('E');
		this.jogoDao.save(jogo);
	}
	
	private List<Classificacao> calculaClassificacao(Jogo jogo) {
		char vencedor = 'E';
		if(jogo.getResultadoA() > jogo.getResultadoB()) 
			vencedor = 'A';
		else if (jogo.getResultadoA() < jogo.getResultadoB())
			vencedor = 'B';
		System.out.println("JOGO=" + jogo);
		System.out.println("classificacaoDao="+this.classificacaoDao);
		List<Classificacao> classificacoes = this.classificacaoDao.getClassificacoesByGrupo(jogo.getGrupo());
		for (Classificacao classTime : classificacoes) {
			// calcula classificacao time A
			if(classTime.getTime().getId() == jogo.getTimeA().getId()) {
				classTime.setJogos(classTime.getJogos()+1);
				classTime.setGolsPro(classTime.getGolsPro()+jogo.getResultadoA());
				classTime.setGolsContra(classTime.getGolsContra()+jogo.getResultadoB());
				if(vencedor == 'A') {
					classTime.setVitorias(classTime.getVitorias()+1);
					classTime.setPontos(classTime.getPontos()+3);
				} 
				else if (vencedor == 'E') {
					classTime.setEmpates(classTime.getEmpates()+1);
					classTime.setPontos(classTime.getPontos()+1);
				} else if(vencedor == 'B') {
					classTime.setDerrotas(classTime.getDerrotas()+1);
				}
				this.classificacaoDao.save(classTime);
			} // Calcula classificacao Time B 
			else if(classTime.getTime().getId() == jogo.getTimeB().getId()) {
				classTime.setJogos(classTime.getJogos()+1);
				classTime.setGolsPro(classTime.getGolsPro()+jogo.getResultadoB());
				classTime.setGolsContra(classTime.getGolsContra()+jogo.getResultadoA()); 
				if(vencedor == 'A') {
					classTime.setDerrotas(classTime.getDerrotas()+1);
				} else if(vencedor == 'E') {
					classTime.setEmpates(classTime.getEmpates()+1);
					classTime.setPontos(classTime.getPontos()+1);					
				} else if(vencedor == 'B') {
					classTime.setVitorias(classTime.getVitorias()+1);
					classTime.setPontos(classTime.getPontos()+3);
				}
				this.classificacaoDao.save(classTime);
			}
		}
		return classificacoes;
	}	

	public List<Classificacao> ordenaClassificacao(Jogo jogo) {
		List<Classificacao> classificacoes = this.classificacaoDao.getClassificacoesByGrupo(jogo.getGrupo());
		int pontosAnt = -1;
		int sg = -1;
		int posReal = 0;
		for(int posicao = 0; posicao <= classificacoes.size()-1; posicao++) {
			Classificacao cS = null;
			// seleciona 1 ainda nao seleionado
			for (Classificacao classificacao : classificacoes) {
				if(!"S".equals(classificacao.getObservacao())) {
					cS = classificacao;
					break;
				}
			}
			// Pega o com maior pontos sg 
			for (Classificacao classificacao : classificacoes) {
				if(!"S".equals(classificacao.getObservacao())) {
					if(classificacao.getPontos() > cS.getPontos()) {
						cS = classificacao;
					} else if(classificacao.getPontos() == cS.getPontos() && 
							  classificacao.getGolsPro() - classificacao.getGolsContra() > cS.getGolsPro() - cS.getGolsContra()) {
						cS = classificacao;
					}
				}
			}
			
			// pontos anterior ou Saldo de Gols for maior que pontos do proximo aumenta 1 colocacao
			if(pontosAnt > cS.getPontos() ||
			   (pontosAnt == cS.getPontos() && sg > cS.getGolsPro() - cS.getGolsContra()) || 
			   posReal == 0) {
					posReal = posicao+1;
			}
			classificacoes.get(classificacoes.indexOf(cS)).setColocacao(posReal);
			classificacoes.get(classificacoes.indexOf(cS)).setObservacao("S");
			pontosAnt = cS.getPontos();
			sg = cS.getGolsPro() - cS.getGolsContra();
		}
		for (Classificacao classificacao : classificacoes) {
			classificacao.setObservacao("N");
			classificacao.setColocacao(classificacao.getColocacao());
			this.classificacaoDao.save(classificacao);
		}
		return classificacoes;
	}

	private void atualizaJogadorinfoEdicao(Jogo jogo) {
		Escalacao escalacao = this.escalacaoDao.getByJogo(jogo);
		
		// Salva os Jogadores escalados que nao existem na Info Edicao! 
		for (JogadorEscalado jogadorEscalado : escalacao.getJogadoresEscalados()) {
			JogadorInfoEdicao jogadorInfoEdicao = this.jogadorInfoEdicaoDao.getByJogadorAndEdicao(jogadorEscalado.getJogador(), jogo.getGrupo().getEdicao());
			if(jogadorInfoEdicao == null) 
				this.jogadorInfoEdicaoDao.save(new JogadorInfoEdicao(jogadorEscalado.getJogador(), jogo.getGrupo().getEdicao()));
		}
		
		// Pega os jogadores da Info Edicao e atualiza as informacoes...
		List<JogadorInfoEdicao> jogadoresInfoEdicao = this.jogadorInfoEdicaoDao.getByEdicao(jogo.getGrupo().getEdicao());
		// jogadores Info
		for (JogadorInfoEdicao jogadorInfoEdicao : jogadoresInfoEdicao) { 
		
			List<JogadorEscalado> jogadoresEscalados = escalacao.getJogadoresEscalados();
			// Jogadores Escalados
			for (JogadorEscalado jogadorEscalado : jogadoresEscalados) { 
				// se jogadorEscalado == jogadorInfoEdicao -> atualiza
				if(jogadorEscalado.getJogador().getId() == jogadorInfoEdicao.getJogador().getId()) { 
					
					jogadorInfoEdicao.setJogos(jogadorInfoEdicao.getJogos()+1);
					for (Evento evento : jogadorEscalado.getEventos()) {

						if(evento.getId() == 1) // 1 = Gol
							jogadorInfoEdicao.setGols(jogadorInfoEdicao.getGols()+1);
						else
						if(evento.getId() == 2) // 2 = Cartao Amarelo
							jogadorInfoEdicao.setCartaoAmarelo(jogadorInfoEdicao.getCartaoAmarelo()+1);
						else 
						if (evento.getId() == 3) // 3 = Cartao Vermelho
							jogadorInfoEdicao.setCartaoVermelho(jogadorInfoEdicao.getCartaoVermelho()+1);
					}
					this.jogadorInfoEdicaoDao.save(jogadorInfoEdicao);					
				}
			}
			
		}
		
	}

	private boolean saveClassificacaoHist(Grupo grupo, int rodada) {
		List<Jogo> jogosByGrupo = jogoDao.getListByGrupoAndRodada(grupo, rodada);
		// verifica se todos os jogos da rodada estado finalizados...
		for (Jogo jogo : jogosByGrupo) {
			if(jogo.getStatus().getId() != 3) 
				return false;
		}
		
		// verifica se tem no historico rodada maior ou igual a mesma, 
		//  sim -> nao guarda historico!
		int rodadaLastHist = this.classificacaoHistDao.getNumberHistLastRodada(grupo);
		if(rodadaLastHist >= rodada) {
			return false;
		}
		
		List<Classificacao> classificacoesByGrupo = classificacaoDao.getClassificacoesByGrupo(grupo);
		for (Classificacao classificacao : classificacoesByGrupo) {
			// se nao existe o historico guarda o mesmo!
			ClassificacaoHist classificacaoHist = this.classificacaoHistDao.getByTimeAndGrupoAndRodada(classificacao.getTime(), classificacao.getGrupo(), rodada);
			if(classificacaoHist == null) {
				ClassificacaoHist hist = new ClassificacaoHist();
				hist.setColocacao(classificacao.getColocacao());
				hist.setDerrotas(classificacao.getDerrotas()); 
				hist.setEmpates(classificacao.getEmpates());
				hist.setGolsContra(classificacao.getGolsContra());
				hist.setGolsPro(classificacao.getGolsPro());
				hist.setGrupo(grupo);
				hist.setJogos(classificacao.getJogos());
				hist.setObservacao(classificacao.getObservacao());
				hist.setPontos(classificacao.getPontos());
				hist.setRodada(rodada);
				hist.setTime(classificacao.getTime());
				hist.setVitorias(classificacao.getVitorias());
				this.classificacaoHistDao.save(hist);
			}
		}
		return true;
	}

	public List<Jogo> getListByTime(Time time) {
		return this.jogoDao.getListByTime(time);
	}

	public List<Jogo> getListJogadorWithGols(Jogador jogador) {
		return this.jogoDao.getListJogadorWithGols(jogador); 
	}

	public int getLastRodadaByEdicao(Edicao edicao) {
		return this.jogoDao.getLastRodadaByEdicao(edicao);
	}

	public int getLastSequenciaByRodada(int rodada) {
		return this.jogoDao.getLastSequenciaByRodada(rodada); 
	}	

	public Jogo getNextJogo(Jogo jogo) {
		return this.jogoDao.getNextJogo(jogo);
	}

	public Jogo getPreviousJogo(Jogo jogo) {
		return this.jogoDao.getPreviousJogo(jogo);
	}

	public List<Jogo> getListByGrupo(Grupo grupo) {
		return this.jogoDao.getListByGrupo(grupo);
	}
	
	
}
