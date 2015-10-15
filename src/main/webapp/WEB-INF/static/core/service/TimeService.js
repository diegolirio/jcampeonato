/**
 * 
 */
app.factory('TimeService', ['$http', function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/time' + url;
	};	
	
	var _getTimes = function() {
		return $http.get(serverURL('/get/list'));
	};
	
	var _getListaPorEdicao = function(edicao) {
		return _getTimes();
	};
	
	/**
	 * Grava Jogo
	 */
	var save = function(jogo) {
		http.post(serverURL('/save'), jogo);
	};
	
	return {
		
		getTimes : _getTimes,
		
		getListaPorEdicao : _getListaPorEdicao
		
	};
	
}]);