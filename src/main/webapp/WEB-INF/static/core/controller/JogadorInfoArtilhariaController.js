/**
 * 
 */
app.controller('JogadorInfoArtilhariaController', ['$rootScope', '$routeParams', 'EdicaoService',
                                                   function($rootScope, $routeParams, EdicaoService) {
	
	var self = this;
	
	var init = function() {
		EdicaoService.get($routeParams.edicaoId).then(function(resp) {
			self.edicao = resp.data;
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);