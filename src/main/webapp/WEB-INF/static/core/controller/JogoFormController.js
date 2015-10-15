/**
 * 
 */
app.controller('JogoFormController', ['$routeParams', '$route', '$location', 'EdicaoService', 'GrupoService', 'HarbitoService', 'LocalService', 'TimeService',
                                      function($routeParams, $route, $location, EdicaoService, GrupoService, HarbitoService, LocalService, TimeService) {
	
	var self = this;
	
	/*
	 * Pega todos os Harbitos. TODO mudar para pegar todos os harbitos do campeonato
	 */
	
	self.init = function() {
		/*
		 * Pega a edicao por id (pathParams)
		 */
		EdicaoService.getPorId($routeParams.edicaoId).then(function(resp) {
			self.edicao = resp.data;
			return resp;
		}).then(function(respEdicao) {
			// Pega lista de grupos por edicao (encadeado)
			GrupoService.getListaPorEdicao(respEdicao.data).then(function(resp) {
				self.grupos = resp.data;
			}, function(error) {
				alert(error.data);
			});	
			return respEdicao;
		}).then(function(respEdicao) {
			HarbitoService.getListaPorEdicao(respEdicao.data).then(function(resp) {
				self.harbitos = resp.data;
			}, function(error) {
				alert(error.data);
			});
			return respEdicao;
		}).then(function(respEdicao) {
			LocalService.getListaPorEdicao(respEdicao.data).then(function(resp) {
				self.locais = resp.data;
			}, function(error) {
				alert(error.data);
			});
			return respEdicao;
		}).then(function(respEdicao) {
			TimeService.getListaPorEdicao(respEdicao.data).then(function(resp) {
				self.times = resp.data;
			}, function(error) {
				alert(error.data);
			});			
		}, function(error) {
			alert(error.data);
		});
		
	};
	
	/**
	 * Salva Grupo
	 */
	self.save = function(jogo) {
		//grupo.edicao = self.edicao;
		//alert(JSON.stringify(jogo));
		jogoService.save(jogo).then(function(resp) {
			
		}, function(error) {
			alert(error.data);
		});
	};	
	
	self.init();
	
}]);