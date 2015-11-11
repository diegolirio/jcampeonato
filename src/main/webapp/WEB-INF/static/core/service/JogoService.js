/**
 * JogoService
 */
app.factory('JogoService', ['$http', function($http) {

	var serverURL = function(url) {
		return SERVER_APP + '/jogo' + url;
	};
	
	/**
	 * pega lista de jogos por Edicao
	 */
	var _getListaPorEdicao = function(edicao) {
		return $http.get(serverURL('/get/lista/por/edicao/'+edicao.id));
	};
	
	/**
	 * busca jogo por id
	 */
	var _get = function(id) {
		return $http.get(serverURL('/get/'+id)); 
	};

	/**
	 * busca lista de jogos por time
	 */
	var _getListByTime = function(time) {
		return $http.get(serverURL('/get/list/by/time/'+time.id));
	};
	
	/**
	 * pega lista de jogos em que jogador marcou gols
	 */
	var _getListJogadorWithGols = function(jogador) {
		return $http.get(serverURL('/get/list/jogador/'+jogador.id+'/with/gols'));
	};
	
	/**
	 * pega ultima rodada dos jogos por edicao (return response int)
	 */
	var _getLastRodadaByEdicao = function(edicao) {
		return $http.get(serverURL('/get/last/rodada/by/edicao/'+edicao.id));
	};
	
	/**
	 * Salvar Jogo
	 */
	var _save = function(jogo) {
		console.log(jogo);
		return $http.post(serverURL('/save'), jogo);
	};
	
	/**
	 * Delete Jogo 
	 */
	var _deleteJogo = function(jogo) {
		return $http.post(serverURL('/'+jogo.id+'/delete'));
	};
	
	/**
	 * finalizar Jogo
	 */
	var _finalizar = function(jogo) {
		return $http.post(serverURL('/'+jogo.id+'/finalizar/'));
	};
	
	/**
	 * return status
	 */
	var _returnStatus = function(jogo) {
		return $http.post(serverURL('/'+jogo.id+'/return/status'));
	}
	
	/**
	 * pega proximo jogo
	 */
	var _nextJogo = function(jogo) {
		return $http.get(serverURL('/get/'+jogo.id+'/next')); 
	};

	/**
	 * pega jogo anterior
	 */
	var _previousJogo = function(jogo) {
		return $http.get(serverURL('/get/'+jogo.id+'/previous')); 
	};	
	
	return {
		
		getListaPorEdicao : _getListaPorEdicao,
		
		get : _get,
		
		getListByTime : _getListByTime,

		getListJogadorWithGols : _getListJogadorWithGols,

		getLastRodadaByEdicao : _getLastRodadaByEdicao,
		
		save : _save,
		
		deleteJogo : _deleteJogo,
		
		finalizar : _finalizar,
		
		returnStatus : _returnStatus,
		
		previousJogo : _previousJogo,
		
		nextJogo : _nextJogo
 		
	};
	
}]);
