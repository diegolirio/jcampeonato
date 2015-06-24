/**
 * EdicaoFormController responsavel pela view edicao/form.jsp
 */
app.controller('EdicaoFormController', ['CampeonatoService', 'TipoEdicaoService', 'EdicaoService', '$routeParams',
                                        function(CampeonatoService, TipoEdicaoService, EdicaoService, $routeParams) {
	
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
		
		if($routeParams.id > 0) {
			EdicaoService.getPorId($routeParams.id).then(function(resp) {
				self.edicao = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});
		}
		
	}
	
	/**
	 * Salvar Edicao... 
	 */
	self.save = function(edicao) {
		EdicaoService.save(edicao).then(function(resp) {
			alert("Edicao: " + edicao.campeonato.descricao + " " + edicao.descricao + " gravado com sucesso");
			self.edicao = resp.data;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	self.init();
	
}]);