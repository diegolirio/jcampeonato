/**
 * UsuarioService, camada que acessa o back-end
 */
app.factory('UsuarioService', ['$http', function($http) {
	
	/**
	 * Grava usuario
	 */
	var _save = function(usuario) {
		return $http.post(SERVER_APP+'/usuario/save', usuario);
	};

	/**
	 * pega usuario da sessao
	 */
	var _getSession = function() {
		return $http.get(SERVER_APP+'/usuario/login/session');
	};
	
	/**
	 * setar usuario na sessao
	 */
	var _setSession = function(usuario) {
		return $http.post(SERVER_APP+'/usuario/login/set/session', usuario);
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
		
		save : _save,
		
		getSession : _getSession,
		
		setSession : _setSession,
		
		login : _login,
		
		logout : _logout
		
	};
	
}]);