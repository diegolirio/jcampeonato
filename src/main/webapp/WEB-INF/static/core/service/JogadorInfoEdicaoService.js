/**
 * JogadorInfoEdicaoService
 */
app.factory('JogadorInfoEdicaoService', ['$http', function($http) {

	var _serverURL = function(url) {
		return SERVER_APP + '/jogadorinfoedicao' + url;
	};
	
	var _getByEdicao = function(edicao) {
		return $http.get(_serverURL('/get/by/edicao/'+edicao.id));
	};
	
	var _getByEdicaoAndJogador = function(edicao, jogador) {
		return $http.get(_serverURL('/get/by/edicao/'+edicao.id+'/jogador/'+jogador.id));
	};
	
	return {
		
		getByEdicao : _getByEdicao,
		
		getByEdicaoAndJogador : _getByEdicaoAndJogador
		
	};
	
}]);
