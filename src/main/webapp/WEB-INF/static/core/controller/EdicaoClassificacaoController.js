/**
 * 
 */
app.controller('EdicaoClassificacaoController',['$routeParams', 'EdicaoService', 'GrupoService', 'ClassificacaoService',
                                                function($routeParams, EdicaoService, GrupoService, ClassificacaoService) {

	var self = this;
	
	var init = function() {
		// busca edicao
		EdicaoService.getPorId($routeParams.id).then(function(resp) {
			self.edicao = resp.data;
			return resp;
		}).then(function(edicaoResp) {
			// busca grupos encadeado com edicao
			GrupoService.getListaPorEdicao(edicaoResp.data).then(function(resp) {
				self.grupos = resp.data;
			}, function(error) {
				alert(error.data);
			});
			return edicaoResp;
		}).then(function(edicaoResp) {
			// busca classificacoes encadeado com edicao
			ClassificacaoService.getClassificacoesByEdicao(edicaoResp.data).then(function(resp) {
				self.classificacoes = resp.data;
			}, function(error) {
				alert(error.data);
			});
		}).then(function(edicaoResp) {
			// busca jogos encadeado com edicao
			JogoService.getListaPorEdicao(edicaoResp.data).then(function(resp) {
				self.jogos = resp.data;
			}, function(error) {
				alert(error.data);
			});
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);
