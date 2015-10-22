/**
 * PosicaoService
 */
app.factory('PosicaoService', ['$http', 
                               function($http) {
	
	var _serverURL = function(url) {
		return SERVER_APP + "/posicao" + url;
	};
	
	/**
	 * pega lista de posicoes
	 */
	var _getList = function() {
		return $http.get(_serverURL('/get/list'));
	};
	
	return {
		
		getList : _getList
		
	};
	
}]);