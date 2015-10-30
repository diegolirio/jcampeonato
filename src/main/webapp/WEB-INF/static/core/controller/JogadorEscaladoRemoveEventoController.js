/**
 * 
 */
app.controller('JogadorEscaladoRemoveEventoController', ['$routeParams', 'JogadorEscaladoService',
                                                         function($routeParams, JogadorEscaladoService) {
	
	var self = this;
	
	var init = function() {
		JogadorEscaladoService.get($routeParams.jogadorEscaladoId).then(function(resp) {
			self.jogadorEscalado = resp.data;
		}, function(error) {
			alert(error.data);
		});
	};
	
	
	init();
	
}]);