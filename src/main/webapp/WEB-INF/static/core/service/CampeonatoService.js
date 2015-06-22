/**
 * 
 */
app.factory('CampeonatoService', ['$http', function($http) {
	
	var _save = function(campeonato) {
		return $http.post(SERVER_APP + '/campeonato/save', campeonato);
	};
	
	return {
		
		save : _save
		
	};
	
}]);