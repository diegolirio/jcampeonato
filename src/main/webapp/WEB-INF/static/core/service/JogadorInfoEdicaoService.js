/**
 * JogadorInfoEdicaoService
 */
app.factory('JogadorInfoEdicaoService', ['$http', function($http) {

	var _serverURL = function(url) {
		return SERVER_APP + '/jogadorinfoedicao' + url;
	};
	
	var _getByEdicao = function(edicao) {
		return $http.get(_serverURL('/get/by/edicao/'+edicao.id));
	};
	
	return {
		
		getByEdicao : _getByEdicao
		
	};
	
}]);
