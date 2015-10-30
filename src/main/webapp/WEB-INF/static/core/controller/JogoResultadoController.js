/**
 *  JogoResultadoController controller view/jogo/resultado
 */
app.controller('JogoResultadoController', ['$scope', '$routeParams', '$window', 'JogoService', 'EscalacaoService', 'EventoService',
                                           'UsuarioPerfilCampeonatoService', 'JogadorEscaladoService',
                                          function($scope, $routeParams, $window, JogoService, EscalacaoService, EventoService,
                                        	UsuarioPerfilCampeonatoService, JogadorEscaladoService) {
                                           
	var self = this;

	self.GOL = 1;
	self.CARTAO_AMARELO = 2;
	self.CARTAO_VERMELHO = 3;
	
	var init = function() {
		// busca jogo por id
		JogoService.get($routeParams.id).then(function(resp) {
			self.jogo = resp.data;
			return resp;
		}).then(function(jogoResp) {
			EscalacaoService.getByJogo(jogoResp.data).then(function(resp) {
				self.escalacao = resp.data;
			});
			return jogoResp;
		}).then(function(jogoResp) {
			// busca usuarioPerfilCampeonato encadeado com edicao
 			if($scope.usuarioLogado != null) {
 				var campeonato = jogoResp.data.grupo.edicao.campeonato;
				UsuarioPerfilCampeonatoService.getByUsuarioAndCampeonato($scope.usuarioLogado, campeonato).then(function(resp) {
					self.usuarioPerfilCampeonato = resp.data;
				}, function(error) {
					alert('Erro ao busca perfil: ' + error.data);
				});
 			}
		});
		
	};
	
	/**
	 * Cria escalacao por jogo
	 */
	self.createEscalacaoByJogo = function(jogo) {
		EscalacaoService.createByJogo(jogo).then(function(resp) {
			$window.location.reload();
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * finalizar Jogo
	 */
	self.finalizar = function(jogo) {
		JogoService.finalizar(jogo).then(function(resp) {
			$window.location.reload();
		}, function(error) {
			alert(error.data);
		});
	};
	
	self.showWindowAddEvento = function(escalacao, eventoId) {
		var url = SERVER_APP + "/simple/#/escalacao/"+escalacao.id+"/add/evento/"+eventoId;
		window.open(url,'','height=550, width=750, top=150, left=250, scrollbars=no, resizable=no');		
	};
	
	/**
	 * Retorna o Status do jogo, se estiver 3->2, 2->1 e 1 bloqueia
	 */
	self.returnStatus = function(jogo) {
		JogoService.returnStatus(jogo).then(function(resp) {
			$window.location.reload();
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * Exclui jogador da escalação, somente da escalação
	 */
	self.excluirJogadorEscalcao = function(jogadorEscalado) {
		JogadorEscaladoService.deleteJogadorEscalado(jogadorEscalado.id).then(function(resp) {
			$window.location.reload();
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);