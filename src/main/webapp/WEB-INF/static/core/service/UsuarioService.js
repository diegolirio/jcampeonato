/**
 * UsuarioService, camada que acessa o back-end
 */
app.factory('UsuarioService', ['$http', function($http) {
	
	var _getSession = function() {
		return $http.get(SERVER_APP+'/usuario/login/session');
	};
	
	var _login = function(usuario) {
		return $http.post(SERVER_APP+'/usuario/login/efetuar', usuario);
	};
	
	/*
	 * Invalida session no back-end
	 */
	var _logout = function() {
		return $http.get(SERVER_APP+'/usuario/login/logout');
	};
	
	/*
	 * Acesso publico
	 */
	return {
		
		getSession : _getSession,
		
		login : _login,
		
		logout : _logout
		
	};
	
}]);