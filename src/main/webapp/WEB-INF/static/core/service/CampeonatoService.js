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
	var _getListCampeonatoPorUsuario = function(idUsuario) {
		return $http.get(serverURL('/get/list/por/usuario/'+idUsuario));
	};
	
	return {
		
		save : _save,
		
		getListCampeonatoPorUsuario : _getListCampeonatoPorUsuario
		
	};
	
}]);