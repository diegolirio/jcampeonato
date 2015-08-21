/**
 * 
 */
app.factory('ClassificacaoService', ['$http', '$q',
                                    function($http, $q) {
	
	var _serverURL = function(url) {
		return SERVER_APP + '/classificacao' + url;
	};
	
	var _save = function(classificacao) {
		return $http.post(_serverURL('/save'), classificacao);
	};
	
	var _getClassificacoesByGrupo = function(grupo) {
		return $http.get(_serverURL('/get/list/by/grupo/'+grupo.id));
	};

	/**
	 * Busca classificacoes por edicao
	 */
	var _getClassificacoesByEdicao = function(edicao) {
		return $http.get(_serverURL('/get/list/by/edicao/'+edicao.id));
	};
	
	/**
	 * Excluir Classificacao
	 */
	var _deleteClassificacao = function(classificacao) {
		return $http.post(_serverURL('/delete/'+classificacao.id));
	}
	
	
	return {
		
		save : _save,
		
		deleteClassificacao : _deleteClassificacao,
		
		getClassificacoesByGrupo : _getClassificacoesByGrupo,
		
		getClassificacoesByEdicao : _getClassificacoesByEdicao
		
	};
	
}]);