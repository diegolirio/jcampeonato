/**
 * 
 */
app.controller('HomeController', function(EdicaoService) {
	
	var self = this;
	
	var init = function() {

		EdicaoService.getEdicoesPorStatus(2).then(function(resp) {
			self.edicoes = resp.data;
		});
		
	};
	
	init();
	
});