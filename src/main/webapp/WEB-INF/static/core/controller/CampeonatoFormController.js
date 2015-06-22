/**
 * CampeonatoFormController responsavel pela view campeonato/form.jsp
 */
app.controller('CampeonatoFormController', ['CampeonatoService', function(CampeonatoService) {
	
	var self = this;
	
	/**
	 * Salvar Campeonato
	 */
	self.save = function(campeonato) {
		var idUsuario = 1;
		CampeonatoService.save(campeonato, idUsuario).then(function(resp) {
			self.campeonato = resp.data;
			alert('Campeonato gravado com sucesso!');
			self.next = true;
		}, function(error) {
			alert(JSON.stringify(error));
		});
	};
	
	
}]);