/**
 * EscalacaoService
 */
app.factory('EscalacaoService',['$http', function($http) {
	
	
	var _serverURL = function(url) {
		return SERVER_APP + "/escalacao" + url;
 	};
	
	/**
	 * Cria escalacao por Jogo
	 */
	var _createByJogo = function(jogo) {
		return $http.post(_serverURL('/create/by/jogo/'+jogo.id));
	};
	
	/**
	 * pega escalacao por jogo
	 */
	var _getByJogo = function(jogo) {
		return $http.get(_serverURL('/get/by/jogo/'+jogo.id));
	};
	
	return {
	
		createByJogo : _createByJogo,
		
		getByJogo : _getByJogo
		
	};
	
}]);