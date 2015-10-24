/**
 * 
 */

app.controller('UsuarioLoginController', ['$scope', '$window', 'UsuarioService', 
                                          function($scope, $window, UsuarioService) {

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
	
	self.login = function() {
		var usuario = {"id":1, "nome": "Diego Lirio", "email": "diegolirio.dl@gmail.com"};
		UsuarioService.login(usuario).then(function(resp) {
			self.isLoggedIn = true;
			self.usuarioLogado = resp.data;
			$window.location.reload();
		}, function(error) {
			alert(JSON.stringify(error));
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
