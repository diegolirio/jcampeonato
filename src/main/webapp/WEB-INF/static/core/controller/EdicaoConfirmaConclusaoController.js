/**
 * 
 */
app.controller('EdicaoConfirmaConclusaoController', 
		       ['$routeParams', '$window', 'EdicaoService', 'GrupoService', 'ClassificacaoService', 'JogoService',
		        function($routeParams, $window, EdicaoService, GrupoService, ClassificacaoService, JogoService) {
	
     var self = this;
     
     var init = function() { 
    	 
 		EdicaoService.getPorId($routeParams.id).then(function(resp) {
			self.edicao = resp.data;
			return resp;
 		}).then(function(edicaoResp) {
 			// busca grupos
 			GrupoService.getListaPorEdicao(edicaoResp.data).then(function(resp) {
 				self.grupos = resp.data;
 			});
 			return edicaoResp;
 		}).then(function(edicaoResp) {
 			ClassificacaoService.getClassificacoesByEdicao(edicaoResp.data).then(function(resp) {
 				self.classificacoes = resp.data;
 			});
 			return edicaoResp;
 		}).then(function(edicaoResp) {
 			JogoService.getListaPorEdicao(edicaoResp.data).then(function(resp) {
 				self.jogos = resp.data;
 			}); 
 		});
     };
    
     /**
      * Confirma Inicio da edicao setando o status para em andamento
      */
     self.confirmarInicioEdicao = function() {
    	self.edicao.status.id = 2;
    	EdicaoService.save(self.edicao).then(function() {
    		$window.location.href = SERVER_APP;
    	});
     };
     
     init();
		    	   
}]);