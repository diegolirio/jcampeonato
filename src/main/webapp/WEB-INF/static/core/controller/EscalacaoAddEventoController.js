/**
 * 
 */
app.controller('EscalacaoAddEventoController', ['$routeParams', 'EventoService', 'JogoService', 'JogadorService',
                                                function($routeParams, EventoService, JogoService, JogadorService) {
	
	var self = this;
	
	self.jogadores = [];
	 
	var init = function() {
		// busca evento por id
		EventoService.get($routeParams.eventoId).then(function(resp) {
			self.evento = resp.data;
		}, function(error) {
			alert(error.data); 
		});
		// busca jogo por id
		JogoService.get($routeParams.jogoId).then(function(resp) {
			self.jogo = resp.data;
			return resp;
		}).then(function(jogoResp) {
			JogadorService.getListByTime(jogoResp.data.timeA).then(function(resp) {
				self.jogadoresA = resp.data;
			});
			JogadorService.getListByTime(jogoResp.data.timeB).then(function(resp) {
				self.jogadoresB = resp.data;
			});			
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * addEvento
	 */
	self.addEvento = function(jogador) {
		console.log(jogador);
		console.log(self.evento);
	};
	
	init(); 
	
}]);