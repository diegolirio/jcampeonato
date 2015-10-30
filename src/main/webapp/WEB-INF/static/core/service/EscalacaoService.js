/**
 * EscalacaoService
 */
app.factory('EscalacaoService',['$http', function($http) {
	
	
	var _serverURL = function(url) {
		return SERVER_APP + "/escalacao" + url;
 	};
	
	/**
	 * Cria escalacao por Jogo
	 */
	var _createByJogo = function(jogo) {
		return $http.post(_serverURL('/create/by/jogo/'+jogo.id));
	};
	
	/**
	 * pega escalacao por jogo
	 */
	var _getByJogo = function(jogo) {
		return $http.get(_serverURL('/get/by/jogo/'+jogo.id));
	};
	
	/**
	 * Pega escalacao por id
	 */
	var _get = function(id) {
		return $http.get(_serverURL('/get/'+id));
	};
	
	/**
	 * TODO: analisar se move para JogadorEscaladoService
	 * Add evento para jogador escalado
	 */
	var _addEventoToJogadorEscalado = function(evento, jogadorEscalado) {
		return $http.post(_serverURL('/add/evento/'+evento.id+'/to/jogadorescalado/'+jogadorEscalado.id));
	}

	/**
	 * TODO: analisar se move para JogadorEscaladoService
	 * Remove evento do jogador escalado
	 */
	var _removeEventoFromJogadorEscalado = function(evento, jogadorEscalado) {
		return $http.post(_serverURL('/remove/evento/'+evento.id+'/from/jogadorescalado/'+jogadorEscalado.id));
	}
	
	return {
	
		createByJogo : _createByJogo,
		
		getByJogo : _getByJogo,
		
		get : _get,
		
		addEventoToJogadorEscalado : _addEventoToJogadorEscalado,
		
		removeEventoFromJogadorEscalado : _removeEventoFromJogadorEscalado
		
	};
	
}]);