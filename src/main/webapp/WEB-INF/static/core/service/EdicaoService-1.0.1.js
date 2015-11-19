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
	
	/**
	 * pega edicao por id
	 */
	var _getPorId = function(id) {
		return $http.get(serverURL('/get/por/id/'+id));
	};
	
	/**
	 * pega lista de edicoes por campeonato
	 */
	var _getListByCampeonato = function(campeonato) {
		return $http.get(serverURL('/get/list/by/campeonato/'+campeonato.id));
	};
	
	var _save = function(edicao) {
		return $http.post(serverURL('/save'), edicao);
	};

	var _confirmaConclusao = function(edicao) {
		return $http.post(serverURL('/confirma/conclusao'), edicao);
	};
	
	/**
	 * Finaliza Primeira fase
	 */
	var _finalizarPrimeiraFase = function(edicao) {
		return $http.post(serverURL('/' + edicao.id+'/finalizarPrimeiraFase'));
	};
	
	return {
		
		getEdicoesPorStatus : _getEdicoesPorStatus,
		
		getListByStatusAndUsuarioAdm : _getListByStatusAndUsuarioAdm,
		
		get : _getPorId,
		
		getListByCampeonato : _getListByCampeonato,
		
		save : _save,
		
		finalizarPrimeiraFase : _finalizarPrimeiraFase
		
	};
	
}]);
