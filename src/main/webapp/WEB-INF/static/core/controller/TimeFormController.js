/**
 * TimeFormController (view/time/form.jsp)
 */
app.controller('TimeFormController', ['$routeParams', 'TimeService', 'JogadorService', 'PosicaoService',
                                      function($routeParams, TimeService, JogadorService, PosicaoService) {
	
	var self = this;
	
	var init = function() {
		// busca time
		TimeService.get($routeParams.id).then(function(resp) {
			self.time = resp.data;
			return resp;
		}).then(function(timeResp) {
			// busca lista de jogadores por time, encadeado apos busca time
			JogadorService.getListByTime(timeResp.data).then(function(resp) {
				self.jogadores = resp.data;
			});
		});
		
		// busca posicoes
		PosicaoService.getList().then(function(resp) {
			self.posicoes = resp.data;
		});
		
	};
	
	/**
	 * salva jogador
	 */
	self.save = function(jogador) {
		alert(JSON.stringify(jogador));
		JogadorService.save(jogador).then(function(resp) {
			// add na lista
			self.jogadores.push(resp.data);
		});
	};
	
	init();
	
}]);