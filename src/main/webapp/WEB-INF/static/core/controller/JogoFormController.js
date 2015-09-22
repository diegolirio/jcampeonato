/**
 * 
 */
app.controller('JogoFormController', ['$routeParams', '$route', '$location', 'EdicaoService', 'GrupoService',
                                      function($routeParams, $route, $location, EdicaoService, GrupoService) {
	
	var self = this;
	
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
		}, function(error) {
			alert(error.data);
		});
		
		/*
		 * Pega todos os Harbitos. TODO mudar para pegar todos os harbitos do campeonato
		 */
//		HarbitoService.getList().then(function(resp) {
//			self.harbitos = resp.data;
//		});
		
	};
	
	/**
	 * Salva Grupo
	 */
	self.save = function(jogo) {
		//grupo.edicao = self.edicao;
		alert(JSON.stringify(jogo));
	};	
	
	self.init();
	
}]);