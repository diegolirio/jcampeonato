/**
 * JogadorEscaladoService
 */
app.factory('JogadorEscaladoService', ['$http', function($http) {

	var _serverURL = function(url) {
		return SERVER_APP + '/jogadorescalado' + url;
	};
	
	/**
	 * pega por id
	 */
	var _get = function(id) {
		return $http.get(_serverURL('/get/'+id));
	};
	
	/**
	 * Exclui Jogador escalado
	 */
	var _deleteJogadorEscalado = function(id) {
		return $http.post(_serverURL('/delete/'+id));
	};
	
	/**
	 * salvar jogador escalado
	 */
	var _save = function(jogadorEscalado) {
		return $http.post(_serverURL('/save'), jogadorEscalado);
	};
	
	return {
		
		get : _get, 
		
		deleteJogadorEscalado : _deleteJogadorEscalado,
		
		save : _save
		
	};
	
}]);
