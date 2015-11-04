/**
 * CampeonatoListController manipula -> view/campeonato/list.jsp
 */
app.controller('CampeonatoListController', ['$scope', '$routeParams', 'UsuarioPerfilCampeonatoService',
                                            function($scope, $routeParams, UsuarioPerfilCampeonatoService) {
	
	var self = this;
	 
	var init = function() {
		UsuarioPerfilCampeonatoService.getListByUsuario($scope.usuarioLogado).then(function(resp) {
			self.usuarioPerfisCampeonatos = resp.data;
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
	
}]);