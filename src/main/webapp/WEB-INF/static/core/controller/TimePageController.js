/**
 * TimePageController ( view/time/page.jsp )
 */
app.controller('TimePageController', ['$routeParams', 'TimeService', 'EdicaoService', 'ClassificacaoService', 'JogadorService',
                                      function($routeParams, TimeService, EdicaoService, ClassificacaoService, JogadorService) {
	
	var self = this;
	
	var init = function() {
		
		// busca edicao
		EdicaoService.get($routeParams.edicaoId).then(function(resp) {
			self.edicao = resp.data;
		}).then(function(edicaoResp) {
			// busca time encadeado da edicao
			TimeService.get($routeParams.timeId).then(function(resp) {
				self.time = resp.data;
				return resp;
			}).then(function(timeResp) {
				// busca classificacao encadeado do time
				ClassificacaoService.getByEdicaoAndTime(self.edicao, timeResp.data).then(function(resp) {
					self.classificacao = resp.data;
				});
				return timeResp;
			}).then(function(timeResp) {
				// busca lista de jogadores por time
				JogadorService.getListByTime(timeResp.data).then(function(resp) {
					self.jogadores = resp.data;
				});
			});
		});
	};
	
	init();
	
}]); 