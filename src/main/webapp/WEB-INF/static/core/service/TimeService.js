/**
 * 
 */
app.factory('TimeService', ['$http', function($http) {
	
	var serverURL = function(url) {
		return SERVER_APP + '/time' + url;
	};	
	
	var _getTimes = function() {
		return $http.get(serverURL('/get/list'));
	};
	
	return {
		
		getTimes : _getTimes
		
	};
	
}]);