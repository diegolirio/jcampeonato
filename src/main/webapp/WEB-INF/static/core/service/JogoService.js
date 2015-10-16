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
	 * Salvar Jogo
	 */
	var _save = function(jogo) {
		console.log(jogo);
		return $http.post(serverURL('/save'), jogo);
	};
	
	return {
		
		getListaPorEdicao : _getListaPorEdicao,
		
		save : _save
		
	};
	
}]);
