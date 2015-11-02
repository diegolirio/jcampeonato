/**
 * JogadorService
 */
app.factory('JogadorService', ['$http', function($http) {

	/**
	 * URL app + url controller + url method
	 */
	var _serverURL = function(url) {
		return SERVER_APP + '/jogador' + url;
	};
	
	/**
	 * busca lista de jogadores por time
	 */
	var _getListByTime = function(time) {
		return $http.get(_serverURL('/get/list/by/time/'+time.id));
	};
	
	/**
	 * pega lista de jogadores que nao estao escalados
	 */
	var _getListNotEscalacao = function(escalacao) {
		return $http.get(_serverURL('/get/list/not/escalacao/'+escalacao.id));
	};
	
	/**
	 * busca lista de jogadores por campeonato
	 * passando o campeonato no corpo da requisicao
	 */
	var _getListByCampeonato = function(campeonato) {
		return $http.get(_serverURL('/get/list/by/campeonato/'+campeonato.id));
	};
	
	/**
	 * salvar jogador
	 */
	var _save = function(jogador) {
		return $http.post(_serverURL('/save'), jogador);
	};
	
	return {
		
		getListByTime : _getListByTime,

		getListNotEscalacao : _getListNotEscalacao,
		
		getListByCampeonato : _getListByCampeonato, 
		
		save : _save
		
	};
	
}]);
