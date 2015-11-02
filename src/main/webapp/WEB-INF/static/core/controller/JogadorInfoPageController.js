/**
 * JogadorInfoPageController
 */
app.controller('JogadorInfoPageController', ['$rootScope', '$scope', '$routeParams', 'EdicaoService', 'JogadorInfoEdicaoService', 'JogadorService', 'JogoService', 'UsuarioPerfilCampeonatoService',
                                           function($rootScope, $scope, $routeParams, EdicaoService, JogadorInfoEdicaoService, JogadorService, JogoService, UsuarioPerfilCampeonatoService) {
	
	var self = this;
	
	var init = function() {
		EdicaoService.get($routeParams.edicaoId).then(function(resp) {
			self.edicao = resp.data;
			$rootScope.edicao = self.edicao;
			return resp;
		}).then(function(edicaoResp) {
			
			JogadorService.get($routeParams.jogadorId).then(function(resp) {
				self.jogador = resp.data;
				var jogadorInfoEdicaoClone = {};
				jogadorInfoEdicaoClone.edicao = edicaoResp.data;
				jogadorInfoEdicaoClone.jogador = resp.data;
				return jogadorInfoEdicaoClone;
			}).then(function(jogadorInfoEdicaoClone) {
				JogadorInfoEdicaoService.getByEdicaoAndJogador(jogadorInfoEdicaoClone.edicao, jogadorInfoEdicaoClone.jogador).then(function(resp) {
					self.jogadorInfoEdicao = resp.data;
				}, function(error) {
					alert(error.data);
				});
				return jogadorInfoEdicaoClone.jogador;
			}).then(function(jogador) {
				JogoService.getListJogadorWithGols(jogador).then(function(resp) {
					self.jogosComGols = resp.data;
				}, function(error) {
					alert(error.data);
				});
				// TODO: pega qtde eventos gols por jogo e jogador (analisar)
			}, function(error) {
				alert(error.data);
			});			
			return edicaoResp;
		}).then(function(edicaoResp) {
			// busca usuarioPerfilCampeonato encadeado com edicao
			if($scope.usuarioLogado != null) {
				var campeonato = edicaoResp.data.campeonato;
				UsuarioPerfilCampeonatoService.getByUsuarioAndCampeonato($scope.usuarioLogado, campeonato).then(function(resp) {
					self.usuarioPerfilCampeonato = resp.data;
				}, function(error) {
					alert('Erro ao busca perfil: ' + error.data);
				});
			}
		}, function(error) {
			alert(error.data);
		});
		
	}; 
	
	init();
	
}]);