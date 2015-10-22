/**
 * TimePageController ( view/time/page.jsp )
 */
app.controller('TimePageController', ['$routeParams', 'TimeService', 'EdicaoService',
                                      function($routeParams, TimeService, EdicaoService) {
	
	var self = this;
	
	var init = function() {
		
		TimeService.get($routeParams.timeId).then(function(resp) {
			self.time = resp.data;
		});
		
		EdicaoService.get($routeParams.edicaoId).then(function(resp) {
			self.edicao = resp.data;
		});
	};
	
	init();
	
}]); 