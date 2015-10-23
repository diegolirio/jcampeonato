/**
 * TimeFormController (view/time/form.jsp)
 */
app.controller('TimeFormController', ['$routeParams', 'TimeService', 'JogadorService', 'PosicaoService',
                                      function($routeParams, TimeService, JogadorService, PosicaoService) {
	
	var self = this;
	
	/**
	 * Construtor 
	 */
	var init = function() {
		// busca time
		TimeService.get($routeParams.id).then(function(resp) {
			self.time = resp.data;
			return resp;
		}).then(function(timeResp) {
			// busca lista de jogadores por time, encadeado apos busca time
			JogadorService.getListByTime(timeResp.data).then(function(resp) {
				self.time.jogadores = resp.data;
				console.log(resp.data);
			});
			// busca jogadores do campeonato...encadeado apos buscar time
			JogadorService.getListByCampeonato(timeResp.data.campeonato).then(function(resp) {
				self.jogadores = resp.data;
			});
			
		});
		
		// busca posicoes
		PosicaoService.getList().then(function(resp) {
			self.posicoes = resp.data;
		});
		
	};
	
	/**
	 * Salva time editado
	 */
	self.save = function(time) {
		TimeService.save(time).then(function(resp) {
			console.log('OK');
		}, function(error) {
			alert(error.data);
		})
	};
	
	/**
	 * Add jogador ao time
	 */
	self.addJogadorTime = function(time, jogadorAddTime) {
		TimeService.addJogador(time, jogadorAddTime).then(function(resp) {
			self.time.jogadores.push(resp.data);
		});
	};
	
	/**
	 * remove jogador do time
	 */
	self.removeJogadorTime = function(time, jogador) {
		TimeService.removeJogador(time, jogador).then(function(resp) {
			var index = self.time.jogadores.indexOf(jogador); 
			self.time.jogadores.splice(index, 1);			
		}, function(error) {
			alert(error.data); 
		});
	};
	
	/**
	 * salva novo jogador
	 */
	self.saveJogador = function(jogador) {
		jogador.campeonato = self.time.campeonato;
		console.log(jogador); 
		JogadorService.save(jogador).then(function(resp) {
			// add na lista
			jogador = resp.data;
			self.jogadores.push(jogador);
			var _ok = confirm("Deseja adiciona-lo ao time do " + self.time.nome + " ? ");
			if(_ok) 
				self.addJogadorTime(self.time, jogador);
		}, function(error) {
			console.error(error);
			alert(error.data);
		});
	};
	
	init();
	
}]);