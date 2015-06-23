/**
 * TipoEdicaoService
 */
app.factory('TipoEdicaoService', ['$http', function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/tipo_edicao' + url;
	};
	
	/**
	 * Busca tipos da edicao 
	 */
	var _getListTipo = function(idUsuario) {
		return $http.get(serverURL('/get/list'));
	};
	
	return {
		
		getListTipo : _getListTipo
		
	};
	
}]);