/**
 *  JogoResultadoController controller view/jogo/resultado
 */
app.controller('JogoResultadoController', ['$routeParams', '$window', 'JogoService', 'EscalacaoService',
                                           function($routeParams, $window, JogoService, EscalacaoService) {
                                           
	var self = this;
	
	var init = function() {
		// busca jogo por id
		JogoService.get($routeParams.id).then(function(resp) {
			self.jogo = resp.data;
			return resp;
		}).then(function(jogoResp) {
			EscalacaoService.getByJogo(jogoResp.data).then(function(resp) {
				self.escalacao = resp.data;
				console.log(self.escalacao); 
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
	
	init();
	
}]);