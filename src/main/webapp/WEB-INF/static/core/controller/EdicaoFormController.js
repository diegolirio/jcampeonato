/**
 * EdicaoFormController responsavel pela view edicao/form.jsp
 */
app.controller('EdicaoFormController', ['CampeonatoService', 'TipoEdicaoService', function(CampeonatoService, TipoEdicaoService) {
	
	var self = this;
	
	/**
	 * Inicializacao da Classe
	 */
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
	
	/**
	 * Salvar Edicao... 
	 */
	self.save = function(edicao) {
		alert(JSON.stringify(edicao));
	};
	
	self.init();
	
}]);