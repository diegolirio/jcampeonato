/**
 * CampeonatoFormController responsavel pela view campeonato/form.jsp
 */
app.controller('CampeonatoFormController', ['CampeonatoService', '$window', function(CampeonatoService, $window) {
	
	var self = this;
	
	/**
	 * Salvar Campeonato
	 */
	self.save = function(campeonato) {
		var idUsuario = 1;
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