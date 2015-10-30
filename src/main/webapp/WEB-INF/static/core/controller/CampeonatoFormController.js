/**
 * CampeonatoFormController responsavel pela view campeonato/form.jsp
 */
app.controller('CampeonatoFormController', ['CampeonatoService', '$window', '$scope', 
                                            function(CampeonatoService, $window, $scope) {
	
	var self = this;
	
	/**
	 * Salvar Campeonato
	 */
	self.save = function(campeonato) {
		var idUsuario = $scope.usuarioLogado.id;
		CampeonatoService.save(campeonato, idUsuario).then(function(resp) {
			self.campeonato = resp.data.campeonato;
			alert('Campeonato gravado com sucesso!');
			self.next = true;
			$window.location.href = '#/edicao/novo'; 
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	
}]);