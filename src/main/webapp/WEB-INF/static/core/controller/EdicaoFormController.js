/**
 * EdicaoFormController responsavel pela view edicao/form.jsp
 */
app.controller('EdicaoFormController', ['CampeonatoService', 'TipoEdicaoService', function(CampeonatoService, TipoEdicaoService) {
	
	var self = this;
	
	self.init = function() {
		var usuarioTODO = 1;
		CampeonatoService.getListCampeonatoPorUsuario(usuarioTODO).then(function(resp) {
			self.campeonatos = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});

		TipoEdicaoService.getListTipo().then(function(resp) {
			self.tipos = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});	
		
	}
	
	self.init();
	
}]);