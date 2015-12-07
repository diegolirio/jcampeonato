/**
 * 
 */
app.controller('HomeController', function(EdicaoService) {
	
	var self = this;
	
	var init = function() {

		//EdicaoService.getEdicoesPorStatus(2).then(function(resp) {
		//	self.edicoes = resp.data;
		//});
		EdicaoService.getListStatusEmAndamentoAndFinalizado().then(function(resp) {
			self.edicoes = resp.data;
		}, function(error) {
			alert(error.data);
		});
		
	};
	
	init();
	
});