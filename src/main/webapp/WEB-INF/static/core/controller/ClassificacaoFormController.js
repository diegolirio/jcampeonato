/**
 * 
 */
app.controller('ClassificacaoFormController', ['$routeParams', '$route', 'EdicaoService', 'TimeService', 'GrupoService', 'ClassificacaoService', 
                                              function($routeParams, $route, EdicaoService, TimeService, GrupoService, ClassificacaoService) {
	
	var self = this;
	
	var init = function() {
		
		// busca edicao por id
		EdicaoService.getPorId($routeParams.edicaoId).then(function(resp) {
			self.edicao = resp.data;
			return self.edicao;
		}).then(function(edicao) {
			// busca grupos 
			GrupoService.getListaPorEdicao(edicao).then(function(resp) {
				self.grupos = resp.data;
			}, function(error) {
				alert(error.data);
			});			
		}, function(error) {
			alert(error.data);
		});
		
		// TODO: Analisar busca de times por campeonato...
		TimeService.getTimes().then(function(resp) {
			self.times = resp.data;
		}, function(error) {
			alert(error);
		});
		
		//ClassificacaoService.getListaPorEdicao
		alert('Popular Cadastrados...'); 
		
	};
	
	self.save = function(classificacao) {
		ClassificacaoService.save(classificacao).then(function(resp) {
			$route.reload();
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);