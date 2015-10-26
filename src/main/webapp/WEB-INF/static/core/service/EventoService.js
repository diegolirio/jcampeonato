/**
 * EventoService
 */
app.factory('EventoService',['$http', function($http) {
	
	var _serverURL = function(url) {
		return SERVER_APP + "/evento" + url;
	};
	
	/**
	 * pega lista de eventos por escalacao
	 */
	var _getListByEscalacao = function(escalacao) {
		return $http.get(_serverURL('/get/by/escalacao/'+escalacao.id));
	};
	
	/**
	 * pega evento por id 
	 */
	var _get = function(id) {
		console.log(id); 
		return $http.get(_serverURL('/get/'+id));
	};
	
	return {
		
		getListByEscalacao : _getListByEscalacao,
		
		get : _get
		
	};
	
}]);