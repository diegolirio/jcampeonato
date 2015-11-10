/**
 * UsuarioFormController
 */
app.controller('UsuarioFormController', ['$routeParams', '$scope', '$window', 'UsuarioService',
                                         function($routeParams, $scope, $window, UsuarioService) {
	
	
	var self = this;
	
	
	var init = function() {
		self.usuario = $scope.usuarioLogado;
	};
	
	/**
	 * Grava usuario
	 */
	self.save = function(usuario) {
		UsuarioService.save(usuario).then(function(resp) {
			UsuarioService.setSession(usuario).then(function(resp) {
				$window.location.reload();
			}, function(error) {
				$window.location.reload();
			});
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);