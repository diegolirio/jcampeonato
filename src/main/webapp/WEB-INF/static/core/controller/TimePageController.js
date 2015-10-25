/**
 * TimePageController ( view/time/page.jsp )
 */
app.controller('TimePageController', ['$scope', '$routeParams', 'TimeService', 'EdicaoService', 'ClassificacaoService', 'JogadorService',
                                      'UsuarioPerfilCampeonatoService',
                                      function($scope, $routeParams, TimeService, EdicaoService, ClassificacaoService, JogadorService,
                                       UsuarioPerfilCampeonatoService) {
	
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
				return timeResp;
			}).then(function(timeResp) {
				// busca usuarioPerfilCampeonato encadeado com edicao
				if($scope.usuarioLogado != null) {
					var campeonato = timeResp.data.campeonato;
					UsuarioPerfilCampeonatoService.getByUsuarioAndCampeonato($scope.usuarioLogado, campeonato).then(function(resp) {
						self.usuarioPerfilCampeonato = resp.data;
					}, function(error) {
						alert('Erro ao busca perfil: ' + error.data);
					});
				}
			});
		});
	};
	
	init();
	
}]); 