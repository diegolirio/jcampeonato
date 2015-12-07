/**
 * 
 */
app.factory('PodiumService', ['$http', function($http) {
	
	var _serverURL = function(url) {
		return SERVER_APP + '/podium' + url;
	};
	
	/**
	 * pega podium por edicao
	 */
	var _getByEdicao = function(edicao) {
		return $http.get(_serverURL('/get/by/edicao/'+edicao.id));
	};
	
	return {
		
		getByEdicao : _getByEdicao
		
	};
	
}]);