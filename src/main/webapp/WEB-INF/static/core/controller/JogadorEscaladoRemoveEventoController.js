/**
 * 
 */
app.controller('JogadorEscaladoRemoveEventoController', ['$routeParams', 'JogadorEscaladoService', 'EscalacaoService',
                                                         function($routeParams, JogadorEscaladoService, EscalacaoService) {
	
	var self = this;
	
	var init = function() {
		JogadorEscaladoService.get($routeParams.jogadorEscaladoId).then(function(resp) {
			self.jogadorEscalado = resp.data;
		}, function(error) {
			alert(error.data);
		});
	};
	
	/**
	 * remove evento
	 */
	self.removeEvento = function(evento) {
		var _ok = confirm('Deseja excluir ' + evento.descricao);
		if(_ok == true) {
			EscalacaoService.removeEventoFromJogadorEscalado(evento, self.jogadorEscalado).then(function(resp) {
				window.opener.location.reload();
				window.close();
			}, function(error) {
				alert(error.data);
			});
		}
	};
	
	init();
	
}]);