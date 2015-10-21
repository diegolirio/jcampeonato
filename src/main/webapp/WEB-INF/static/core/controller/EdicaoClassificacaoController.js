/**
 * 
 */
app.controller('EdicaoClassificacaoController',['$routeParams', 'EdicaoService', 'GrupoService', 'ClassificacaoService',
                                                function($routeParams, EdicaoService, GrupoService, ClassificacaoService) {

	var self = this;
	
	var init = function() {
		EdicaoService.getPorId($routeParams.id).then(function(resp) {
			self.edicao = resp.data;
			return resp;
		}).then(function(edicaoResp) {
			GrupoService.getListaPorEdicao(edicaoResp.data).then(function(resp) {
				self.grupos = resp.data;
			}, function(error) {
				alert(error.data);
			});
			return edicaoResp;
		}).then(function(edicaoResp) {
			ClassificacaoService.getClassificacoesByEdicao(edicaoResp.data).then(function(resp) {
				self.classificacoes = resp.data;
			}, function(error) {
				alert(error.data);
			});
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);
