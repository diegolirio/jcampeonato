/**
 * 
 */
app.factory('TimeService', ['$http', function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/time' + url;
	};	
	
	/**
	 * Pega time por id
	 */
	var _get = function(id) {
		return $http.get(serverURL('/get/'+id));
	};
	
	var _getTimes = function() {
		return $http.get(serverURL('/get/list'));
	};
	
	var _getListaPorEdicao = function(edicao) {
		return _getTimes();
	};
	
	/**
	 * Grava Time
	 */
	var _save = function(time) {
		return $http.post(serverURL('/save'), time);
	};
	
	/**
	 * Add jogador ao time
	 */
	var _addJogador = function(time, jogador) {
		return $http.post(serverURL("/"+time.id+'/add/jogador/'+jogador.id));
	};
	
	/**
	 * Remove jogador do time
	 */
	var _removeJogador = function(time, jogador) {
		return $http.post(serverURL("/"+time.id+'/remove/jogador/'+jogador.id));
	};
	
	return {
		
		get : _get,
		
		getTimes : _getTimes,
		
		getListaPorEdicao : _getListaPorEdicao,
		
		save : _save,
		
		addJogador : _addJogador,
		
		removeJogador : _removeJogador
		
	};
	
}]);