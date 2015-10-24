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
	 * Salvar Jogo
	 */
	var _save = function(jogo) {
		console.log(jogo);
		return $http.post(serverURL('/save'), jogo);
	};
	
	/**
	 * finalizar Jogo
	 */
	var _finalizar = function(jogo) {
		$http.post(serverURL('/'+jogo.id+'/finalizar/'));
	};
	
	return {
		
		getListaPorEdicao : _getListaPorEdicao,
		
		get : _get,
		
		save : _save
		
	};
	
}]);
