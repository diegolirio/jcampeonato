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
		
		// ***************************************
		// Carregamento para edicao
		if( $routeParams.id != null) {
		
			self.modoEdicao = true;
			// busca jogo por id
			JogoService.get($routeParams.id).then(function(resp) {
				self.jogo = resp.data;
				self.edicao = self.jogo.grupo.edicao; 
				var dataArray = self.jogo.dataHora.split('-');
				self.jogo.dataHora = dataArray[2]+"/"+dataArray[1]+"/"+dataArray[0];
				
				return self.edicao;
			}).then(function(edicao) {
				// Pega lista de grupos por edicao (encadeado)
				GrupoService.getListaPorEdicao(edicao).then(function(resp) {
					self.grupos = resp.data; 
					for(var i = 0; i <= self.grupos.length-1; i++) { 
						if(self.grupos[i].id == self.jogo.grupo.id) {
							self.jogo.grupo = self.grupos[i];
							break;
						}
					}					
				}, function(error) {
					alert(error.data);
				});	
				
				return edicao;
			}).then(function(edicao) {
				HarbitoService.getListaPorEdicao(edicao).then(function(resp) {
					self.harbitos = resp.data;
					for(var i = 0; i <= self.harbitos.length-1; i++) { 
						if(self.harbitos[i].id == self.jogo.harbito.id) {
							self.jogo.harbito = self.harbitos[i];
							break;
						}
					}						
				}, function(error) {
					alert(error.data);
				});
				return edicao;
			}).then(function(edicao) {
				LocalService.getListaPorEdicao(edicao).then(function(resp) {
					self.locais = resp.data;
					for(var i = 0; i <= self.locais.length-1; i++) { 
						if(self.locais[i].id == self.jogo.local.id) {
							self.jogo.local = self.locais[i];
							break;
						}
					}						
				}, function(error) {
					alert(error.data);
				});
				return edicao;
			}).then(function(edicao) {
				TimeService.getListaPorEdicao(edicao).then(function(resp) {
					self.times = resp.data;
					for(var i = 0; i <= self.times.length-1; i++) { 
						if(self.times[i].id == self.jogo.timeA.id) 
							self.jogo.timeA = self.times[i];
						if(self.times[i].id == self.jogo.timeB.id) 
							self.jogo.timeB = self.times[i];
					}						
				}, function(error) {
					alert(error.data);
				});			
				return edicao;
			}).then(function(edicao) {
				JogoService.getListaPorEdicao(edicao).then(function(resp) {
					self.jogos = resp.data;
				}, function(error) {
					alert(error.data);
				});
			}, function(error) {
				alert(error.data);
			});
		}
		else {
			
			self.modoEdicao = $routeParams.modoEdicao == "true";
			// para cadastro Novo
			
			// Pega a edicao por id (pathParams)
			EdicaoService.get($routeParams.edicaoId).then(function(resp) {
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
		}
		
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
			if(self.modoEdicao == true)
				$location.path( '/edicao/'+self.edicao.id+'/classificacao' );
			self.jogos.push(resp.data);
			self.jogo = {};
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
	
	/**
	 * exclui jogo pendente
	 */
	self.deleteJogo = function(jogo) {
		if(jogo.status.id != 1) {
			alert('Jogo não encontra-se pendente');
			return;
		} 
		
		JogoService.deleteJogo(jogo).then(function(resp) {
			var index = self.jogos.indexOf(jogo);
			self.jogos.splice(index,1);
		}, function(error) {
			alert(error.data);
		});
		
			
	};
	
	self.init();
	
}]);