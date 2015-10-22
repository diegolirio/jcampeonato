/**
 * 
 */
app.controller('ClassificacaoFormController', ['$routeParams', '$route', 'EdicaoService', 'TimeService', 'GrupoService', 'ClassificacaoService', 
                                              function($routeParams, $route, EdicaoService, TimeService, GrupoService, ClassificacaoService) {
	
	var self = this;
	
	var init = function() {
		
		// busca edicao por id
		EdicaoService.get($routeParams.edicaoId).then(function(resp) {
			self.edicao = resp.data;
			return self.edicao;
		}).then(function(edicaoResp) {
			// Busca os grupos com as classificacoes para popular os ja vinculados
			GrupoService.getListaPorEdicao(edicaoResp).then(function(resp) {
				self.grupos = resp.data;
				return edicaoResp; 
			}).then(function(edicaoResp_c) {
				ClassificacaoService.getClassificacoesByEdicao(edicaoResp_c).then(function(resp) {
					self.classificacoes = resp.data;
				}, function(error) {
					alert(error.data);
				});
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
		
	};
	
	/**
	 * Salva classificacao
	 */
	self.save = function(classificacao) {
		ClassificacaoService.save(classificacao).then(function(resp) {
			$route.reload();
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * Excluir Classificacao
	 */
	self.excluir = function(classificacao) {
		ClassificacaoService.deleteClassificacao(classificacao).then(function(resp) {
			$route.reload();
		}, function(error) {
			alert(error.data);
		});
	}

	/**
	 * Salva o time
	 */
	self.saveTime = function(time, campeonato) {
		time.campeonato = campeonato;
		TimeService.save(time).then(function(resp) {
			self.times.push(resp.data);
			$('#id-time-modal-form').modal('hide'); 
			//self.classificacao.time = resp.data;
		}, function(error) {
			alert(error.data);
		}); 
	};
	
	init();
	
}]);