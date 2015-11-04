/**
 * CampeonatoFormController responsavel pela view campeonato/form.jsp
 */
app.controller('CampeonatoFormController', ['CampeonatoService', '$location', '$routeParams', '$window', '$scope', 
                                            function(CampeonatoService, $location, $routeParams, $window, $scope) {
	
	var self = this;
	
	var init = function() {
		CampeonatoService.get($routeParams.id).then(function(resp) {
			self.campeonato = resp.data;
			self.modoEdicao = true;
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * Salvar Campeonato
	 */
	self.save = function(campeonato) {
		var idUsuario = $scope.usuarioLogado.id;
		CampeonatoService.save(campeonato, idUsuario).then(function(resp) {
			if(self.modoEdicao == true) {
				$location.path('/campeonato/p/usuario/'+idUsuario);
			} else {
				self.campeonato = resp.data.campeonato;
				alert('Campeonato gravado com sucesso!');
				self.next = true;
				$window.location.href = '#/edicao/novo';
			}
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	init();
	
	
}]);