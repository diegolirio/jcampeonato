/**
 * 
 */
app.factory('ClassificacaoService', ['$http',
                                    function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/classificacao' + url;
	};
	
	var _save = function(classificacao) {
		return $http.post(serverURL('/save'), classificacao);
	};
	
	return {
		
		save : _save
		
	};
	
}]);