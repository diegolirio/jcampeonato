package com.diegolirio.jcampeonato.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegolirio.jcampeonato.model.Evento;
import com.diegolirio.jcampeonato.model.Fase;
import com.diegolirio.jcampeonato.model.Perfil;
import com.diegolirio.jcampeonato.model.Posicao;
import com.diegolirio.jcampeonato.model.Status;
import com.diegolirio.jcampeonato.model.TipoEdicao;
import com.diegolirio.jcampeonato.model.Usuario;
import com.diegolirio.jcampeonato.service.EventoService;
import com.diegolirio.jcampeonato.service.FaseService;
import com.diegolirio.jcampeonato.service.PerfilService;
import com.diegolirio.jcampeonato.service.PosicaoService;
import com.diegolirio.jcampeonato.service.StatusService;
import com.diegolirio.jcampeonato.service.TipoEdicaoService;
import com.diegolirio.jcampeonato.service.UsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private TipoEdicaoService tipoEdicaoService;

	@Autowired
	private StatusService statusService;

	@Autowired
	private PosicaoService posicaoService;

	@Autowired @Qualifier("eventoService")
	private EventoService eventoService;

	@Autowired
	private FaseService faseService;

	
	@RequestMapping(value="/criar_base")
	public String create() {
		
		// Usuario diegolirio
		Usuario usuario = new Usuario();
		usuario.setEmail("diegolirio.dl@gmail.com");
		usuario.setNome("Diego Lirio");
		usuario.setSenha("198586");
		if(usuarioService.existeUsuarioEmail(usuario.getEmail()) == false)
			usuarioService.save(usuario);
		
		
		// Perfil ADM
		Perfil perfil = this.perfilService.get(Perfil.class, 1l);
		if(perfil == null) {
			perfil = new Perfil(0, "Administrador");
			this.perfilService.save(perfil);
		}
		// Perfil CRUD Jogo e Resultado dos Jogos
		Perfil perfil2 = this.perfilService.get(Perfil.class, 2l);
		if(perfil2 == null) {
			perfil2 = new Perfil(0, "Cadastrar/Editar Partidas e alterar resultado dos Jogos.");
			this.perfilService.save(perfil2);
		}
		// Perfil Altera somente resultado dos jogos.
		Perfil perfil3 = this.perfilService.get(Perfil.class, 3l);
		if(perfil3 == null) {
			perfil3 = new Perfil(0, "Altera somente resultado dos jogos.");
			this.perfilService.save(perfil3);
		}
		
		// Tipo da Edicao...
		TipoEdicao _grupoMataMata = this.tipoEdicaoService.get(TipoEdicao.class, 1l); //id=1
		if(_grupoMataMata == null) {
			_grupoMataMata = new TipoEdicao();
			_grupoMataMata.setDescricao("1a fase (fase de Grupo) e Mata-mata");
			this.tipoEdicaoService.save(_grupoMataMata);
		}
		
		TipoEdicao pontosCorridos = this.tipoEdicaoService.get(TipoEdicao.class, 2l); // id=2
		if(pontosCorridos == null) {
			pontosCorridos = new TipoEdicao();
			pontosCorridos.setDescricao("Pontos Corridos");
			this.tipoEdicaoService.save(pontosCorridos);
		}

		TipoEdicao mataMata = this.tipoEdicaoService.get(TipoEdicao.class, 3l); // id=3
		if(mataMata == null) {
			mataMata = new TipoEdicao();
			mataMata.setDescricao("Mata-Mata");
			this.tipoEdicaoService.save(mataMata);
		}
		
		Status pendente = this.statusService.get(Status.class, 1l);
		if(pendente == null) {
			pendente = new Status("Pendente", "interrogacao.png");
			this.statusService.save(pendente);
		}
		Status andamento = this.statusService.get(Status.class, 2l);
		if(andamento == null) {
			andamento = new Status("Andamento", "bola_32.png");
			this.statusService.save(andamento);
		}
		Status finalizado = this.statusService.get(Status.class, 3l);
		if(finalizado == null) {
			finalizado = new Status("Finalizado", "apito_24.png");
			this.statusService.save(finalizado);
		}		
		// posicao
		Posicao gk = this.posicaoService.getBySigla("GK"); 
		if(gk == null) {
			gk = new Posicao();
			gk.setDescricao("Goleiro");
			gk.setSigla("GK");
			gk.setImgName("golerio_24x24.png");
			this.posicaoService.save(gk);
		}
		Posicao at = this.posicaoService.getBySigla("AT");
		if(at == null) {
			at = new Posicao();
			at.setDescricao("Linha");
			at.setSigla("AT");
			at.setImgName("chuteira_32.png");
			this.posicaoService.save(at);	
		}
		// eventos do jogo
		Evento gol = this.eventoService.getByDescricao("Gol");
		if(gol == null) {
			gol = new Evento();
			gol.setDescricao("Gol");
			gol.setImgName("gol.png");
			this.eventoService.save(gol);
		}
		Evento ca = this.eventoService.getByDescricao("Cart�o Amarelo");
		if(ca == null) {
			ca = new Evento();
			ca.setDescricao("Cartao Amarelo");
			ca.setImgName("cartao-amarelo.png");
			this.eventoService.save(ca);
		}
		Evento cv = this.eventoService.getByDescricao("Cart�o Vermelho");
		if(cv == null) {
			cv = new Evento();
			cv.setDescricao("Cartao Vermelho");
			cv.setImgName("cartao-vermelho.png");
			this.eventoService.save(cv);
		}
		
		// Fases
		Fase _1fase = this.faseService.getBySigla('1');
		if(_1fase == null) {
			_1fase = new Fase();
			_1fase.setDescricao("1ª fase (fase de grupos)");
			_1fase.setSigla('1');
			this.faseService.save(_1fase);
		}
		Fase pontosCorridosFase = this.faseService.getBySigla('P');
		if(pontosCorridosFase == null) {
			pontosCorridosFase = new Fase();
			pontosCorridosFase.setDescricao("Pontos Corridos");
			pontosCorridosFase.setSigla('P');
			this.faseService.save(pontosCorridosFase);
		}
//				Fase _final = new Fase(); // id = 3
//				_final.setDescricao("Final");
//				_final.setSigla('F');
//				this.faseDao.save(_final);
//				
//				Fase _3Lugar = new Fase(); // id = 4
//				_3Lugar.setDescricao("3º Lugar");
//				_3Lugar.setSigla('3');
//				this.faseDao.save(_3Lugar);
//				
//				Fase semiFinal = new Fase(); // id = 5
//				semiFinal.setDescricao("Semi-Final");
//				semiFinal.setSigla('S');
//				this.faseDao.save(semiFinal);
//				
//				Fase quartas = new Fase(); // id = 6
//				quartas.setDescricao("Quarta-de-Final");
//				quartas.setSigla('Q');		
//				this.faseDao.save(quartas);
		//
//				Fase oitavas = new Fase(); // id = 7
//				oitavas.setDescricao("Oitavas-de-Final");
//				oitavas.setSigla('O');
//				this.faseDao.save(oitavas);
				
				// Fases
		Fase _2fase = this.faseService.getBySigla('2');
		if(_2fase == null) {
			_2fase = new Fase();
			_2fase.setDescricao("2ª fase (Mata-Mata)");
			_2fase.setSigla('2');
			this.faseService.save(_2fase);		
		}
		Fase _8final = this.faseService.getBySigla('8');
		if(_8final == null) {
			_8final = new Fase();
			_8final.setDescricao("Oitavas-de-Final (Mata-Mata)");
			_8final.setSigla('8');
			this.faseService.save(_8final);		
		}
		Fase _4final = this.faseService.getBySigla('4');
		if(_4final == null) {
			_4final = new Fase();
			_4final.setDescricao("Quartas-de-Final (Mata-Mata)");
			_4final.setSigla('4');
			this.faseService.save(_4final);		
		}
		Fase _sFinal = this.faseService.getBySigla('S');
		if(_sFinal == null) {
			_sFinal = new Fase();
			_sFinal.setDescricao("Semi-Final (Mata-Mata)");
			_sFinal.setSigla('S');
			this.faseService.save(_sFinal);		
		}
		Fase _3 = this.faseService.getBySigla('3');
		if(_3 == null) {
			_3 = new Fase();
			_3.setDescricao("Terceiro-Lugar");
			_3.setSigla('3');
			this.faseService.save(_3);		
		}
		Fase _final = this.faseService.getBySigla('F');
		if(_final == null) {
			_final = new Fase();
			_final.setDescricao("Final");
			_final.setSigla('F');
			this.faseService.save(_final);		
		}
		return "redirect:/";
	}
	
	/**
	 * Template
	 * @return
	 */
	@RequestMapping(value = "/template", method = RequestMethod.GET)
	public String template() {
		logger.info("Page Template....");
		return "template/index"; 
	}	
	
	/**
	 * Base ngview
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	/**
	 * Base simple ngview
	 */
	@RequestMapping(value = "/simple", method = RequestMethod.GET)
	public String indexSimple() {
		logger.info("Page index....");
		return "index_simple";
	}
	
	
	/**
	 * Pagina Home
	 * @return String
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		logger.info("Page Home....");
		return "home";
	}
	
		
	
}
