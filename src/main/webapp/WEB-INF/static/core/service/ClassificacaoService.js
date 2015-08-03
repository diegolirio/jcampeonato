/**
 * 
 */
app.factory('ClassificacaoService', ['$http', '$q',
                                    function($http, $q) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/classificacao' + url;
	};
	
	var _save = function(classificacao) {
		return $http.post(serverURL('/save'), classificacao);
	};
	
	var _getClassificacoesByGrupo = function(grupo) {
		return $http.get(serverURL('/get/list/by/grupo/'+grupo.id));
	};
	
	var _getClassificacoesByGrupoSync = function(grupo) {
		var deferred = $q.defer();
		$http.get(serverURL('/get/list/by/grupo/'+grupo.id)).success(function(data,status,headers,config) {
	        deferred.resolve(data);
	    }).error(function(data,status,headers,config){
	        deferred.reject(status);
	    });
		return deferred.promise;
	};
	
	
	return {
		
		save : _save,
		
		getClassificacoesByGrupo : _getClassificacoesByGrupo,
		
		getClassificacoesByGrupoSync : _getClassificacoesByGrupoSync
		
	};
	
}]);