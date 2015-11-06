/**
 * JogadorFormController
 */
app.controller('JogadorFormController', ['$routeParams', '$location', '$rootScope', 'JogadorService', 'PosicaoService',
                                         function($routeParams, $location, $rootScope, JogadorService, PosicaoService) {

	var self = this;
	
	var init = function() {
		JogadorService.get($routeParams.id).then(function(resp) {
			self.jogador = resp.data;
		}).then(function(jogadorResp) {
			PosicaoService.getList().then(function(resp) {
				self.posicoes = resp.data;
				for(var i = 0; i <= self.posicoes.length-1; i++) {
					if(self.posicoes[i].id == self.jogador.posicao.id) { 
						self.jogador.posicao = self.posicoes[i];
						break;
					}
				}				
			}, function(error) {
				alert(error.data);
			});
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * Salva jogador
	 */
	self.save = function(jogador) {
		JogadorService.save(jogador).then(function(resp) {
			$location.path('/jogadorinfo/jogador/'+jogador.id+'/edicao/'+$rootScope.edicao.id);
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);
