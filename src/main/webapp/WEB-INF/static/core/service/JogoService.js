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
	
	return {
		
		getListaPorEdicao : _getListaPorEdicao,
		
		get : _get,
		
		getListByTime : _getListByTime,
		
		save : _save,
		
		deleteJogo : _deleteJogo,
		
		finalizar : _finalizar,
		
		returnStatus : _returnStatus
 		
	};
	
}]);
