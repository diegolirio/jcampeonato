/**
 * 
 */
app.factory('CampeonatoService', ['$http', function($http) {
	
	var _save = function(campeonato, isUsuario) {
		return $http.post(SERVER_APP + '/campeonato/save/usuario/'+isUsuario, campeonato);
	};
	
	return {
		
		save : _save
		
	};
	
}]);