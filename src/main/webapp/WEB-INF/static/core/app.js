/**
 * AngularJS modulo de configuracao e rotas
 */

var app = angular.module('app', ['ngRoute']);

var SERVER_APP = '/jcampeonato';

app.config(['$routeProvider', '$httpProvider', function($routeProvider, $httpProvider) {
	
	$routeProvider
		.when('/',      { templateUrl: SERVER_APP + '/home'})
		.when('/login', { templateUrl: SERVER_APP + '/usuario/login/'})
		// Campeonato
		.when('/campeonato/novo',                 { templateUrl: SERVER_APP + '/campeonato/form'})	 
		.when('/campeonato/p/usuario/:usuarioId', { templateUrl: SERVER_APP + '/campeonato/lista'})
		.when('/campeonato/:id/editar', 		  { templateUrl: SERVER_APP + '/campeonato/form'})
		// Edicao
		.when('/edicao/pendentes', { templateUrl: SERVER_APP + '/edicao/list'})		 
		.when('/edicao/novo',      { templateUrl: SERVER_APP + '/edicao/novo'}) 
		.when('/edicao/novo/:id',  { templateUrl: SERVER_APP + '/edicao/novo'})
		.when('/edicao/:id/confirma/conclusao',  { templateUrl: SERVER_APP + '/edicao/confirma/conclusao'})
		.when('/edicao/:id/classificacao',       { templateUrl: SERVER_APP + '/edicao/classificacao'})
		// Grupo
		.when('/grupo/novo/edicao/:edicaoId',  { templateUrl: SERVER_APP + '/grupo/novo'})
		// Classificacao
		.when('/classificacao/novo/edicao/:edicaoId',  { templateUrl: SERVER_APP + '/classificacao/novo'})
		// Jogo
		.when('/jogo/novo/edicao/:edicaoId',         { templateUrl: SERVER_APP + '/jogo/novo'})
		.when('/jogo/novo/edicao/:edicaoId/:modoEdicao',         { templateUrl: SERVER_APP + '/jogo/novo'})
		.when('/jogo/:id/novo/edicao/:edicaoId', { templateUrl: SERVER_APP + '/jogo/novo' })
		.when('/jogo/:id/resultado',  		 		 { templateUrl: SERVER_APP + '/jogo/resultado'})
		// time
		.when('/time/:timeId/edicao/:edicaoId', { templateUrl: SERVER_APP + '/time/page'})
		.when('/time/:id', 						{ templateUrl: SERVER_APP + '/time/form'})
		// Escalacao
		.when('/escalacao/:escalacaoId/add/evento/:eventoId', { templateUrl: SERVER_APP + '/escalacao/add/evento'})
		// JogadorInfo
		.when('/jogadorinfo/artilharia/edicao/:edicaoId', { templateUrl: SERVER_APP + '/jogadorinfoedicao/artilharia' })
		.when('/jogadorinfo/jogador/:jogadorId/edicao/:edicaoId', { templateUrl: SERVER_APP + '/jogadorinfoedicao/page' })
		.when('/jogadorinfo/jogadores/edicao/:edicaoId', { templateUrl: SERVER_APP + '/jogadorinfoedicao/jogadores' })
		// JogadorEscalado
		.when('/jogadorescalado/:jogadorEscaladoId/remove/eventos',           { templateUrl: SERVER_APP + '/jogadorescalado/remove/eventos' })
		.when('/jogadorescalado/save/by/escalacao/:escalacaoId/time/:timeId', { templateUrl: SERVER_APP + '/jogadorescalado/form/popup' })
		// Jogador
		.when('/jogador/:id', { templateUrl: SERVER_APP + '/jogador/form' })
		;
	
	
		//.when('/login_post', { templateUrl: SERVER_APP + '/usuario/login?u=jsantos' } )		
		//.when('/show', { templateUrl: SERVER_APP + '/home'});	 
	
	
	/* ******************** Interceptor ******************** */
	$httpProvider.responseInterceptors.push('HttpInterceptor');
    /* ******************** Loading Gif ******************** */ 
    var spinnerFunction = function (data) {
            $('#spinner').show();
            return data; 
    };      
    $httpProvider.defaults.transformRequest.push(spinnerFunction); 		
	

}]);  

 

app.factory('HttpInterceptor',['$q', function($q) { 
	/********************************************************************************************
     * Tratamento do retorno do response(ajax)...
	 ********************************************************************************************/	  	
	return function (promise) { 
		return promise.then(function (resp) {
			$('#spinner').hide();  
			return resp;
		}, function (errorResp) {
			$('#spinner').hide();
			return $q.reject(errorResp);
		});
	};

}]);
