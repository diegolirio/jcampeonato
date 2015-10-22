/**
 * EdicaoService
 */
app.factory('EdicaoService', ['$http', function($http) {

	var serverURL = function(url) {
		return SERVER_APP + '/edicao' + url;
	};
	
	var _getEdicoesPorStatus = function(idStatus) {
		return $http.get(serverURL('/get/list/por/status/'+idStatus));
	};
	
	var _getPorId = function(id) {
		return $http.get(serverURL('/get/por/id/'+id));
	};
	
	var _save = function(edicao) {
		return $http.post(serverURL('/save'), edicao);
	};
	
	return {
		
		getEdicoesPorStatus : _getEdicoesPorStatus,
		
		get : _getPorId,
		
		save : _save
		
	};
	
}]);
