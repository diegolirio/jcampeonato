/**
 * 
 */
app.factory('CampeonatoService', ['$http', function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/campeonato' + url;
	};
	
	var _save = function(campeonato, isUsuario) {
		return $http.post(SERVER_APP + '/campeonato/save/usuario/'+isUsuario, campeonato);
	};
	
	/**
	 * Busca campeonatos para o perfil desse usuario
	 */
	var _getListByUsuario = function(usuario) {
		return $http.get(serverURL('/get/list/por/usuario/'+usuario.id));
	};
	
	/**
	 * Busca campeonatos para o perfil desse usuario
	 */
	var _getListByUsuarioAdm = function(usuario) {
		return $http.get(serverURL('/get/list/by/usuario/adm/'+usuario.id));
	};
	
	return {
		
		save : _save,
		
		getListByUsuario : _getListByUsuario,
		
		getListByUsuarioAdm : _getListByUsuarioAdm
		
	};
	
}]);