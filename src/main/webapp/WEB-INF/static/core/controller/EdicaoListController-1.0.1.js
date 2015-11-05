/**
 * EdicaoListController responsavel por manipular a view edicao/list.jsp
 */
app.controller('EdicaoListController', ['$routeParams', '$scope', 'EdicaoService', 'CampeonatoService', 
                                        function($routeParams, $scope, EdicaoService, CampeonatoService) {
	
	var self = this;
	
	self.init = function() {
		
		var statusPendete = 1;		
		
		/*
		 * 2 senarios
		 * 
		 * 1. Quando passado o campeonato na url pode editar o nome do campeonato...
		 * 2. Quando não vier esta Cadastrando um novo por form wizard
		 */
		
		if($routeParams.campeonatoId != null) {
			// lista por campeonato
			CampeonatoService.get($routeParams.campeonatoId).then(function(resp) {
				self.campeonato = resp.data;
				return resp;
			}).then(function(campeonatoResp) {
				EdicaoService.getListByCampeonato(campeonatoResp.data).then(function(resp) {
					self.edicoes = resp.data;
				}, function(error) {
					alert(error.data);
				});
			}, function(error) {
				alert(error.data);
			});
		} else {
			// Executada ao cadastrar uma nova Edicao (form wizard)
			/*
			 * Busca edicoes pendentes(1), em que o usuario esteje vinculado como ADM(1)
			 */
			EdicaoService.getListByStatusAndUsuarioAdm(statusPendete, $scope.usuarioLogado).then(function(resp) {
				self.edicoes = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});			
		}
	};
	
	self.init();
	
}]);