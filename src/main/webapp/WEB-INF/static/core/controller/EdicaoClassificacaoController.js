/**
 * 
 */
app.controller('EdicaoClassificacaoController',['$rootScope', '$scope','$routeParams', '$window', 'EdicaoService', 'GrupoService', 'ClassificacaoService', 'JogoService',
                                                'UsuarioPerfilCampeonatoService',
                                               function($rootScope, $scope, $routeParams, $window, EdicaoService, GrupoService, ClassificacaoService, JogoService,
                                                UsuarioPerfilCampeonatoService) {

	var self = this;

	
	self.setTab = function (tabId) {
        self.tab = tabId;
    };
    self.isSet = function (tabId) {
        return self.tab === tabId;
    };

    
	var init = function() {
		// busca edicao
		EdicaoService.get($routeParams.id).then(function(resp) {
			self.edicao = resp.data;
			$rootScope.edicao = self.edicao;
			return resp;
		}).then(function(edicaoResp) {
			// busca grupos encadeado com edicao
			GrupoService.getListaPorEdicao(edicaoResp.data).then(function(resp) {
				self.grupos = resp.data;
				self.tab = self.grupos.length-1;
			}, function(error) {
				alert(error.data);
			});
			return edicaoResp;
		}).then(function(edicaoResp) {
			// busca classificacoes encadeado com edicao
			ClassificacaoService.getClassificacoesByEdicao(edicaoResp.data).then(function(resp) {
				self.classificacoes = resp.data;
			}, function(error) {
				alert(error.data);
			});
			return edicaoResp;
		}).then(function(edicaoResp) { 
			// busca jogos encadeado com edicao
			JogoService.getListaPorEdicao(edicaoResp.data).then(function(resp) {
				self.jogos = resp.data;
			}, function(error) {
				alert(error.data);
			});
			return edicaoResp;
		}).then(function(edicaoResp) {
			// busca usuarioPerfilCampeonato encadeado com edicao
 			if($scope.usuarioLogado != null) {
				UsuarioPerfilCampeonatoService.getByUsuarioAndCampeonato($scope.usuarioLogado, edicaoResp.data.campeonato).then(function(resp) {
					self.usuarioPerfilCampeonato = resp.data;
				}, function(error) {
					alert('Erro ao busca perfil: ' + error.data);
				});
 			}
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * 
	 */
	self.finalizarPrimeiraFase = function(edicao) {
		EdicaoService.finalizarPrimeiraFase(edicao).then(function(resp) {
			$window.location.reload();
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);
