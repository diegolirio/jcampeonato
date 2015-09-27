/**
 * HarbitoService
 */
app.factory('HarbitoService', ['$http', function($http) {

	var serverURL = function(url) {
		return SERVER_APP + '/harbito' + url;
	};
	
	var _getPorId = function(id) {
		return $http.get(serverURL('/get/por/id/'+id));
	};
	
	var _save = function(harbito) {
		return $http.post(serverURL('/save'), harbito);
	};
	
	var _getListaPorEdicao = function(edicao) {
		return $http.get(serverURL('/get/lista/por/edicao/'+edicao.id));
	};
	
	var _excluir = function(harbito) {
		return $http.post(serverURL('/delete/'+harbito.id));
	};
	
	return {
		
		getPorId : _getPorId,
		
		save : _save,
		
		getListaPorEdicao : _getListaPorEdicao,
		
		excluir : _excluir
		
	};
	
}]);
