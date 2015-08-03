/**
 * 
 */
app.controller('ClassificacaoFormController', ['$routeParams', '$route', 'EdicaoService', 'TimeService', 'GrupoService', 'ClassificacaoService', 
                                              function($routeParams, $route, EdicaoService, TimeService, GrupoService, ClassificacaoService) {
	
	var self = this;
	
	var init = function() {
		
		// busca edicao por id
		EdicaoService.getPorId($routeParams.edicaoId).then(function(resp) {
			self.edicao = resp.data;
			return self.edicao;
		}).then(function(edicaoResp) {
			
			// Busca os grupos com as classificacoes para popular os ja vinculados
			
			//GrupoService.getGruposClassificacoesPorEdicao(edicaoResp).then(function(resp) {
			GrupoService.getListaPorEdicao(edicaoResp).then(function(resp) {
				self.grupos = resp.data;
				//alert(JSON.stringify(self.grupos));
				return self.grupos; 
			}).then(function(gruposResp) {
				
				for(var i = 0; i <= self.grupos.length-1; i++) {
				//var i = 0;
				//var ok = true;
				//while(i <= self.grupos.length-1) {
					console.log('Init = '+ i); 
					//if(ok == true) {
						//ok = false;
						//self.grupos[i].classificacoes = [{"id": i, "time": {"nome": "Alemanha"}}, {"id": i+1, "time": {"nome": "Brasil"}}];
						self.grupos[i].classificacoes = [];
						ClassificacaoService.getClassificacoesByGrupoSync(self.grupos[i]).then(function(resp) { 
							//alert(JSON.stringify(resp)); 
							//self.grupos[i].classificacoes = resp.data;  
							//alert(JSON.stringify(self.grupos[i]));
							return resp.data;
						}).then(function(classificacoesResp) { 
							console.log('Popula = '+ i); 
							self.grupos[i].classificacoes = classificacoesResp;
							//ok = true;
							//i++; 
						}, function(error) {
							alert(error.data);
						});
					}
				}
				
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
	
	self.save = function(classificacao) {
		ClassificacaoService.save(classificacao).then(function(resp) {
			$route.reload();
		}, function(error) {
			alert(error.data);
		});
	};
	
	init();
	
}]);