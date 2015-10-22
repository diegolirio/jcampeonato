/**
 * JogadorService
 */
app.factory('JogadorService', ['$http', function($http) {

	/**
	 * URL app + url controller + url method
	 */
	var _serverURL = function(url) {
		return SERVER_APP + '/jogador' + url;
	};
	
	/**
	 * busca lista de jogadores por time
	 */
	var _getListByTime = function(time) {
		return $http.get(_serverURL('/get/list/by/time/'+time.id));
	}
	
	return {
		
		getListByTime : _getListByTime
		
	};
	
}]);
