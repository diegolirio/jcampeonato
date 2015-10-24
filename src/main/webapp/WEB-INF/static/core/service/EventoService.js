/**
 * EventoService
 */
app.factory('EventoService',['$http', function($http) {
	
	var _serverURL = function(url) {
		return SERVER_APP + "/escalacao" + url;
	};
	
	/**
	 * pega lista de eventos por escalacao
	 */
	var _getListByEscalacao = function(escalacao) {
		return $http.get(_serverURL('/get/by/escalacao/'+escalacao.id));
	};
	
	return {
		
		getListByEscalacao : _getListByEscalacao
		
	};
	
}]);