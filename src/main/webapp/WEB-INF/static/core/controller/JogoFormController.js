/**
 * 
 */
app.controller('JogoFormController', ['$routeParams', '$route', '$location', 'EdicaoService', 
                                      function($routeParams, $route, $location, EdicaoService) {
	
	var self = this;
	
	self.init = function() {
		
		EdicaoService.getPorId($routeParams.edicaoId).then(function(resp) {
			self.edicao = resp.data;
			return resp;
		}, function(error) {
			alert(error.data);
		});
				
	};
	
	/**
	 * Salva Grupo
	 */
	self.save = function(jogo) {
		//grupo.edicao = self.edicao;
		alert(JSON.stringify(jogo));
	};	
	
	self.init();
	
}]);