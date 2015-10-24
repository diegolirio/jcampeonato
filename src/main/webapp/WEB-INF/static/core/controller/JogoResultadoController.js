/**
 *  JogoResultadoController controller view/jogo/resultado
 */
app.controller('JogoResultadoController', ['$routeParams', '$window', 'JogoService', 'EscalacaoService', 'EventoService',
                                           function($routeParams, $window, JogoService, EscalacaoService, EventoService) {
                                           
	var self = this;
	
	var init = function() {
		// busca jogo por id
		JogoService.get($routeParams.id).then(function(resp) {
			self.jogo = resp.data;
			return resp;
		}).then(function(jogoResp) {
			EscalacaoService.getByJogo(jogoResp.data).then(function(resp) {
				self.escalacao = resp.data;
			});
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
			
		});
	};
	
	init();
	
}]);