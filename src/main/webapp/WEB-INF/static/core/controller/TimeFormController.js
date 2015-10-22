/**
 * TimeFormController (view/time/form.jsp)
 */
app.controller('TimeFormController', ['$routeParams', 'TimeService', 'JogadorService',
                                      function($routeParams, TimeService, JogadorService) {
	
	var self = this;
	
	var init = function() {
		// busca time
		TimeService.get($routeParams.id).then(function(resp) {
			self.time = resp.data;
			return resp;
		}).then(function(timeResp) {
			// busca lista de jogadores por time, encadeado apos busca time
			JogadorService.getListByTime(timeResp.data).then(function(resp) {
				self.jogadores = resp.data;
			});
		});
	};
	
	init();
	
}]);