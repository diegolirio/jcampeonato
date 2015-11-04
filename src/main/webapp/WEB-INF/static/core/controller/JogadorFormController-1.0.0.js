/**
 * JogadorFormController
 */
app.controller('JogadorFormController', ['$routeParams', '$location', '$rootScope', 'JogadorService', 
                                         function($routeParams, $location, $rootScope, JogadorService) {

	var self = this;
	
	var init = function() {
		JogadorService.get($routeParams.id).then(function(resp) {
			self.jogador = resp.data;
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
