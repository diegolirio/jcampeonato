/**
 * EdicaoListController responsavel por manipular a view edicao/list.jsp
 */
app.controller('EdicaoListController', ['EdicaoService', function(EdicaoService) {
	
	var self = this;
	
	self.init = function() {
		var statusPendete = 1;
		EdicaoService.getEdicoesPorStatus(statusPendete).then(function(resp) {
			self.edicoes = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	self.init();
	
}]);