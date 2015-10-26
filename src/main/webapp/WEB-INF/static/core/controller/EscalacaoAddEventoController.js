/**
 * 
 */
app.controller('EscalacaoAddEventoController', ['$routeParams', 'EventoService', 'JogoService',
                                                function($routeParams, EventoService, JogoService) {
	
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
		}).then(function(jogoResp) {
//			JogadorService.getListByTime(jogoResp.data.timeA).then(function(resp) {
//				self.jogadores.push()
//			});
		}, function(error) {
			alert(error.data);
		});
	};
	
	init(); 
	
}]);