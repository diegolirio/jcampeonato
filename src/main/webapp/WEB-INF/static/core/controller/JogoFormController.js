/**
 * 
 */
app.controller('JogoFormController', ['$routeParams', '$route', '$location', 'EdicaoService', 'GrupoService', 'HarbitoService', 'LocalService', 'TimeService', 'JogoService',
                                      function($routeParams, $route, $location, EdicaoService, GrupoService, HarbitoService, LocalService, TimeService, JogoService) {
	
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
			return respEdicao;
		}).then(function(respEdicao) {
			JogoService.getListaPorEdicao(respEdicao.data).then(function(resp) {
				self.jogos = resp.data;
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
		if(jogo.id == undefined) {
			jogo.id = 0;
			jogo.status = {};
			jogo.status.id = 1; // pendente
			jogo.sequencia = -1;
			jogo.resultadoA = 0;
			jogo.resultadoB = 0;
		} 
		
		var dataArray = jogo.dataHora.split('/');
		jogo.dataHora = dataArray[2]+"-"+dataArray[1]+"-"+dataArray[0];
		
		JogoService.save(jogo).then(function(resp) {
			self.jogos.push(resp.data);
		}, function(error) {
			alert(error.data);
		});
	};	

	/**
	 * Salvar Harbito
	 */
	self.saveHarbito = function(harbito, campeonato) {
		harbito.campeonato = campeonato;
		HarbitoService.save(harbito).then(function(resp) {
			self.harbitos.push(resp.data);
			$('#id-harbito-modal-form').modal('hide');
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * Salvar Local
	 */
	self.saveLocal = function(local, campeonato) {
		local.campeonato = campeonato;
		LocalService.save(local).then(function(resp) {
			self.locais.push(resp.data);
			$('#id-local-modal-form').modal('hide');
		}, function(error) {
			alert(error.data);
		});
	};	
	
	
	self.init();
	
}]);