/**
 * AngularJS modulo de configuracao e rotas
 */

var app = angular.module('app', ['ngRoute']);

var SERVER_APP = '/jcampeonato';

app.config(['$routeProvider', function($routeProvider) {
	
	$routeProvider
		.when('/', { templateUrl: SERVER_APP + '/home'})
		// Campeonato
		.when('/campeonato/novo', { templateUrl: SERVER_APP + '/campeonato/novo'})	 
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
		.when('/jogadorinfo/artilharia/edicao/:edicaoId', { templateUrl: SERVER_APP + '/jogadorinfo/artilharia' })
		;
	
	
		//.when('/login_post', { templateUrl: SERVER_APP + '/usuario/login?u=jsantos' } )		
		//.when('/show', { templateUrl: SERVER_APP + '/home'});	 
}]);  