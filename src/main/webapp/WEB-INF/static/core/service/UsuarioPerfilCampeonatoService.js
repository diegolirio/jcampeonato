/**
 * UsuarioPerfilCampeonatoService
 */
app.factory('UsuarioPerfilCampeonatoService', ['$http', function($http) {
	
	var _serverURL = function(url) {
		return SERVER_APP + '/usuarioPerfilCampeonato' + url;
	};
	
	/**
	 * pega UsuarioPerfilCampeonato por usuario e campeonato
	 */
	var _getByUsuarioAndCampeonato = function(usuario, campeonato) {
		return $http.get(_serverURL('/get/by/usuario/'+usuario.id+'/and/campeonato/'+campeonato.id));
	};
	
	/**
	 * pega lista por usuario
	 */
	var _getListByUsuario = function(usuario) {
		return $http.get(_serverURL('/get/list/by/usuario/'+usuario.id));
	};
	
	return {
		getByUsuarioAndCampeonato : _getByUsuarioAndCampeonato,
		
		getListByUsuario : _getListByUsuario
	};
	
}]);