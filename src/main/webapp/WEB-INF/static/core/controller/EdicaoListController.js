/**
 * EdicaoListController responsavel por manipular a view edicao/list.jsp
 */
app.controller('EdicaoListController', ['$scope', 'EdicaoService', function($scope, EdicaoService) {
	
	var self = this;
	
	self.init = function() {
		var statusPendete = 1;
		
		/*
		 * Busca edicoes pendentes(1), em que o usuario esteje vinculado como ADM(1)
		 */
		EdicaoService.getListByStatusAndUsuarioAdm(statusPendete, $scope.usuarioLogado).then(function(resp) {
			self.edicoes = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	self.init();
	
}]);