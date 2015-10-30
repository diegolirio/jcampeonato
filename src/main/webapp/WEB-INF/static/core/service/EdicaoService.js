/**
 * EdicaoService
 */
app.factory('EdicaoService', ['$http', function($http) {

	var serverURL = function(url) {
		return SERVER_APP + '/edicao' + url;
	};
	
	var _getEdicoesPorStatus = function(idStatus) {
		return $http.get(serverURL('/get/list/por/status/'+idStatus));
	};
	
	/**
	 * pega lista de edicoes por status e usuarioAdministrador
	 */
	var _getListByStatusAndUsuarioAdm = function(statusId, usuarioAdm) {
		return $http.get(serverURL('/get/list/by/status/'+statusId+'/and/usuario/adm/'+usuarioAdm.id));
	};
	
	var _getPorId = function(id) {
		return $http.get(serverURL('/get/por/id/'+id));
	};
	
	var _save = function(edicao) {
		return $http.post(serverURL('/save'), edicao);
	};
	
	return {
		
		getEdicoesPorStatus : _getEdicoesPorStatus,
		
		getListByStatusAndUsuarioAdm : _getListByStatusAndUsuarioAdm,
		
		get : _getPorId,
		
		save : _save
		
	};
	
}]);
