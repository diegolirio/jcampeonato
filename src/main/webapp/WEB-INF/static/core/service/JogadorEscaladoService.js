/**
 * JogadorEscaladoService
 */
app.factory('JogadorEscaladoService', ['$http', function($http) {

	var _serverURL = function(url) {
		return SERVER_APP + '/jogadorescalado' + url;
	};
	
	/**
	 * Exclui Jogador escalado
	 */
	var _deleteJogadorEscalado = function(id) {
		return $http.post(_serverURL('/delete/'+id));
	};
	
	return {
		
		deleteJogadorEscalado : _deleteJogadorEscalado
		
	};
	
}]);
