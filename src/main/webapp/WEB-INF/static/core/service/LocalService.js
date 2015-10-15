/**
 * LocalService
 */
app.factory('LocalService', ['$http', function($http) {

	var serverURL = function(url) {
		return SERVER_APP + '/local' + url;
	};
	
	/**
	 * Busca por id
	 */
	var _getPorId = function(id) {
		return $http.get(serverURL('/get/por/id/'+id));
	};
	
	/**
	 * Salva Local
	 */
	var _save = function(local) {
		return $http.post(serverURL('/save'), local);
	};
	
	/**
	 * Busca locais por edicao
	 */
	var _getListaPorEdicao = function(edicao) {
		return $http.get(serverURL('/get/lista/por/edicao/'+edicao.id));
	};
	
	/**
	 * Exclui Local
	 */
	var _excluir = function(local) {
		return $http.post(serverURL('/delete/'+local.id));
	};
	
	return {
		
		getPorId : _getPorId,
		
		save : _save,
		
		getListaPorEdicao : _getListaPorEdicao,
		
		excluir : _excluir
		
	};
	
}]);
