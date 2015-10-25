/**
 * 
 */
app.controller('EscalacaoAddEventoController', ['$routeParams', 'EventoService',
                                                function($routeParams, EventoService) {
	
	var self = this;
	
	var init = function() {
		EventoService.get($routeParams.eventoId).then(function(resp) {
			self.evento = respa.data;
		}, function(error) {
			alert(error.data);
		});
	};
	
}]);