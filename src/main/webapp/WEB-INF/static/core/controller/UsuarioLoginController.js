/**
 * 
 */

app.controller('UsuarioLoginController', ['$scope', '$window', '$routeParams', '$location', 'UsuarioService', 
                                          function($scope, $window, $routeParams, $location, UsuarioService) {

	var self = this;
	
	/*
	 * isLoggedIn verifica no html se usuario esta logado
	 */
	self.isLoggedIn = false; 
	
	/*
	 * rotina UsuarioService.getSession executada ao estanciar UsuarioController, verifica se existe sessao(esta logado).
	 */
	UsuarioService.getSession().then(function(resp) {
		self.isLoggedIn = true;
		self.usuarioLogado = resp.data;
		$scope.usuarioLogado = self.usuarioLogado;
	}, function(error) {
		console.log(error.data); 
	});
	
	/**
	 * efetua login
	 */
	self.login = function(usuario) {
		UsuarioService.login(usuario).then(function(resp) {
			self.isLoggedIn = true;
			self.usuarioLogado = resp.data;
			if($routeParams.nextPage != null && $routeParams.nextPage != undefined && $routeParams.nextPage != '')
				$location.path($routeParams.nextPage);
			else
				$location.path('/');
		}, function(error) {
			alert(error.data);
		}); 
			
	};
	
	self.logout = function() {
		UsuarioService.logout().then(function() {
			$window.location.reload();
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	
}]);
