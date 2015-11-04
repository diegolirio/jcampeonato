/**
 * JogadorInfoArtilhariaController
 */
app.controller('JogadorInfoArtilhariaController', ['$rootScope', '$routeParams', 'EdicaoService', 'JogadorInfoEdicaoService',
                                                   function($rootScope, $routeParams, EdicaoService, JogadorInfoEdicaoService) {
	
	var self = this;
	
	var init = function() {
		EdicaoService.get($routeParams.edicaoId).then(function(resp) {
			self.edicao = resp.data;
			$rootScope.edicao = self.edicao;
			return resp;
		}).then(function(edicaoResp) {
			JogadorInfoEdicaoService.getByEdicaoArtilharia(edicaoResp.data).then(function(resp) {
				self.jogadoresInfoEdicao = resp.data;
			}, function(error) {
				alert(error.data);
			});
		}, function(error) {
			alert(error.data);
		});
		
	};
	
	init();
	
}]);