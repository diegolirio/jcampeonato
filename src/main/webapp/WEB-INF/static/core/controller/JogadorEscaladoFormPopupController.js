/**
 * JogadorEscaladoFormPopupController
 */
app.controller('JogadorEscaladoFormPopupController', ['$routeParams', 'TimeService', 'EscalacaoService', 'JogadorService', 'JogadorEscaladoService',
                                                      function($routeParams, TimeService, EscalacaoService, JogadorService, JogadorEscaladoService) {
	
	var self = this;
	self.jogadorEscalado = {};
	
	var init = function() {
		TimeService.get($routeParams.timeId).then(function(resp) {
			self.time = resp.data;
			self.jogadorEscalado.time = self.time;
		}, function(error) {
			alert(error.data);
		});
		
		EscalacaoService.get($routeParams.escalacaoId).then(function(resp) {
			self.escalacao = resp.data;
			self.jogadorEscalado.escalacao = self.escalacao;
			return resp; 
		}).then(function(escalacaoResp) {
			JogadorService.getListNotEscalacao(escalacaoResp.data).then(function(resp) {
				self.jogadoresNaoEscalados = resp.data;
			}, function(error) {
				alert(error.data);
			});
		}, function(error) {
			alert(error.data);
		});
	}; 
	
	self.save = function(jogadorEscalado) {
		JogadorEscaladoService.save(jogadorEscalado).then(function(resp) {
			window.opener.location.reload();
			window.close();
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);