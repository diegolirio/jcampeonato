/**
 * 
 */
app.controller('EscalacaoAddEventoController', ['$routeParams', 'EventoService', 'EscalacaoService', 'JogadorService',
                                                function($routeParams, EventoService, EscalacaoService, JogadorService) {
	
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
		EscalacaoService.get($routeParams.escalacaoId).then(function(resp) {
			self.escalacao = resp.data;
			return resp;
		});
//		.then(function(jogoResp) {
//			JogadorService.getListByTime(jogoResp.data.timeA).then(function(resp) {
//				self.jogadoresA = resp.data;
//			});
//			JogadorService.getListByTime(jogoResp.data.timeB).then(function(resp) {
//				self.jogadoresB = resp.data;
//			});			
//		}, function(error) {
//			alert(error.data);
//		});
	};
	
	/**
	 * addEvento
	 */
	self.addEvento = function(jogadorEscalado) {
		console.log(jogadorEscalado);
		console.log(self.evento);
		EscalacaoService.addEventoToJogadorEscalado(self.evento, jogadorEscalado).then(function(resp) {
			window.opener.location.reload();
			window.close();
		}, function(error) {
			alert(error.data);
		});
	};
	
	init(); 
	
}]);