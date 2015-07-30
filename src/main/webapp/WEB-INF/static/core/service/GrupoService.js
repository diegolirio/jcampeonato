/**
 * EdicaoService
 */
app.factory('GrupoService', ['$http', function($http) {

	var serverURL = function(url) {
		return SERVER_APP + '/grupo' + url;
	};
	
	var _getPorId = function(id) {
		return $http.get(serverURL('/get/por/id/'+id));
	};
	
	var _save = function(grupo) {
		return $http.post(serverURL('/save'), grupo);
	};
	
	var _getListaPorEdicao = function(edicao) {
		//return $http.get(serverURL('/get/lista/por/edicao'), edicao); 
		return $http.get(serverURL('/get/lista/por/edicao/'+edicao.id));
	};
	
	var _getGruposClassificacoesPorEdicao = function(edicao) {
		return $http.get(serverURL('/get/lista/com/classificacao/por/edicao/'+edicao.id));
	};
	
	var _excluir = function(grupo) {
		return $http.post(serverURL('/delete/'+grupo.id));
	};
	
	return {
		
		getPorId : _getPorId,
		
		save : _save,
		
		getListaPorEdicao : _getListaPorEdicao,
		
		getGruposClassificacoesPorEdicao : _getGruposClassificacoesPorEdicao,
		
		excluir : _excluir
		
	};
	
}]);
