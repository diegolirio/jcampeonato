<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="app">
    <head>
        <meta charset="UTF-8">
        <title>Quarta Show</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// --> 
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="skin-blue" ng-controller="UsuarioLoginController as usuarioLoginCtrl">
    
		<div id="spinner" class="spinner" style="display:none;"> 
	         <img id="img-spinner" src="${pageContext.request.contextPath}/static/core/img/bola_carregamento.gif" alt="Aguarde..."/>
	         <p>Aguarde...</p>
	    </div>  	
    
    	
   		<div ng-view></div> 
		
	
		<!-- ########################## AngularJS ########################################################################### -->
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28/angular.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28/angular-route.js"></script>
		<!--------- rotas e config da app angular ------------------->
		<script src="${pageContext.request.contextPath}/static/core/app.js"></script>  
		<!--------- Services ----------------> 
		<script src="${pageContext.request.contextPath}/static/core/service/UsuarioService.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/CampeonatoService.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/TipoEdicaoService.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/EdicaoService.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/GrupoService.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/TimeService.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/ClassificacaoService.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/service/HarbitoService.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/service/LocalService.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/service/JogoService.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/service/JogadorService.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/service/PosicaoService.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/service/EscalacaoService.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/service/EventoService.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/service/UsuarioPerfilCampeonatoService.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/service/JogadorEscaladoService.js"></script>
		<!--------- Controllers -------------> 
		<script src="${pageContext.request.contextPath}/static/core/controller/UsuarioLoginController.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/controller/EscalacaoAddEventoController.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/controller/JogadorEscaladoRemoveEventoController.js"></script>
		<!-- ########################## End AngularJS ####################################################################### -->
		
        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>		

    </body>
</html>