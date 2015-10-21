/**
 *  JogoResultadoController controller view/jogo/resultado
 */
app.controller('JogoResultadoController', ['$routeParams', 'JogoService',
                                           function($routeParams, JogoService) {
                                           
	var self = this;
	
	var init = function() {
		// busca jogo por id
		JogoService.get($routeParams.id).then(function(resp) {
			self.jogo = resp.data;
		});
		
	};
	
	init();
	
}]);