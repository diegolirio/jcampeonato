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
		.when('/jogo/novo/edicao/:edicaoId',  { templateUrl: SERVER_APP + '/jogo/novo'});
	
	
		//.when('/login_post', { templateUrl: SERVER_APP + '/usuario/login?u=jsantos' } )		
		//.when('/show', { templateUrl: SERVER_APP + '/home'});	 
}]);  