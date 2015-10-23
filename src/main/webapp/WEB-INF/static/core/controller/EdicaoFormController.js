/**
 * EdicaoFormController responsavel pela view edicao/form.jsp
 */
app.controller('EdicaoFormController', ['CampeonatoService', 'TipoEdicaoService', 'EdicaoService', '$routeParams', '$location',
                                        function(CampeonatoService, TipoEdicaoService, EdicaoService, $routeParams, $location) {
	
	var self = this;
	
	var setEdicao = function(id) {
		EdicaoService.get(id).then(function(resp) {
			self.edicao = resp.data;
			// Seleciona o tipo
			for(var i = 0; i <= self.tipos.length-1; i++) {
				if(self.tipos[i].id == self.edicao.tipoEdicao.id) {
					self.edicao.tipoEdicao = self.tipos[i];
					break;
				}
			}
			// Seleciona o Campeonato...
			for(var i = 0; i <= self.campeonatos.length-1; i++) {
				if(self.campeonatos[i].id == self.edicao.campeonato.id) {
					self.edicao.campeonato = self.campeonatos[i];
					break;
				}
			}
		}, function(error) {
			alert(JSON.stringify(error));
		});		
	}
	
	/**
	 * Inicializacao da Classe
	 */
	self.init = function() {
		var usuarioTODO = 1;
		
		CampeonatoService.getListCampeonatoPorUsuario(usuarioTODO).then(function(resp) {
			self.campeonatos = resp.data;
		}).then(function() {
			TipoEdicaoService.getListTipo().then(function(resp) {
				self.tipos = resp.data;
			}, function(error) {
				alert(JSON.stringify(error));
			});			
		}).then(function() {
			if($routeParams.id > 0) {
				setEdicao($routeParams.id);
			}					
		}, function(error) {
			alert(JSON.stringify(error));
		});

	}
	
	/**
	 * Salvar Edicao... 
	 */
	self.save = function(edicao) {
		//edicao.id = 0;
		//edicao.status = {"id": 1};
		//edicao = {"id":1,"descricao":"2015","status":{"id":1,"descricao":"Pendente","imgName":null},"campeonato":{"id":1,"descricao":"Quarta Show"},"tipoEdicao":{"id":1,"descricao":"1a fase (fase de Grupo) e Mata-mata"}};
		EdicaoService.save(edicao).then(function(resp) {
			alert("Edicao: " + edicao.campeonato.descricao + " " + edicao.descricao + " gravado com sucesso"); 
			self.edicao = resp.data;	
			//setEdicao(self.edicao.id); 
			$location.path('/grupo/novo/edicao/'+ self.edicao.id); 
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	self.init();
	
}]);