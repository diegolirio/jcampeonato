/**
 * 
 */
app.controller('GrupoFormController', ['$routeParams', '$route', '$location', 'EdicaoService', 'GrupoService', 
                                      function($routeParams, $route, $location, EdicaoService, GrupoService) {
	
	var self = this;
	
	self.init = function() {
		
		EdicaoService.get($routeParams.edicaoId).then(function(resp) {
			self.edicao = resp.data;
			return resp;
		}).then(function(edicaoResponse) {
			GrupoService.getListaPorEdicao(edicaoResponse.data).then(function(resp) {
				self.grupos = resp.data;
				if(self.grupos.length > 0)
					self.next = true;
			}, function(error) {
				alert('Erro ao busca lista de Grupos:\n\n'+error.data);
			}); 
		  }, function(error) {
			alert(error.data);
		});
				
	};
	
	/**
	 * Salva Grupo
	 */
	self.save = function(grupo) {
		grupo.edicao = self.edicao;
		GrupoService.save(grupo).then(function(resp) {
			self.grupo = resp.data;	
			alert("Grupo: " + grupo.descricao + " gravado com sucesso"); 
			//$location.path($location.path()); //path('/jogo/novo/edicao/'+ self.edicao.id);
			$route.reload();
		}, function(error) { 
			alert(error.data);
		});
	};	
	
	/**
	 * Exclui Grupo
	 */
	self.excluir = function(grupo) {
		GrupoService.excluir(grupo).then(function(resp) {
			$route.reload();
		}, function(error) {
			alert('Erro ao Excluir Grupo: ' + error.data);
		});
	};
	
	self.init();
	
}]);