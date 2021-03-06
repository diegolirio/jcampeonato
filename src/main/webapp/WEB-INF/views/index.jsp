<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html ng-app="app">
    <head>
        <meta charset="UTF-8">
        <title>Quarta Show 2015</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- Date Picker -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/datepicker/datepicker3.css" rel="stylesheet" type="text/css" />
        <!-- Daterange picker -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <link href="${pageContext.request.contextPath}/static/core/css/spinner.css" rel="stylesheet" type="text/css" />

 		<!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- jQuery UI 1.10.3 -->
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
       
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="skin-blue" ng-controller="UsuarioLoginController as usuarioLoginCtrl">
    
		<div id="spinner" class="spinner" style="display:none;"> 
		<%-- 	         <img id="img-spinner" src="${pageContext.request.contextPath}/static/core/img/bola_carregamento.gif" alt="Aguarde..."/> --%>
	         <img id="img-spinner"  src="http://diegolirio.com/quartashow/bola.gif" alt="Aguarde..."/> <br/>
	         <img id="img2-spinner" src="http://diegolirio.com/quartashow/QAURTASHOW.GIF" alt="QuartaShow..."/>
<!-- 	         <p>Aguarde...</p> -->
	    </div>  	
     
		<jsp:include page="_menu.jsp"></jsp:include>
		
        <div class="wrapper row-offcanvas row-offcanvas-left">
        
            <!-- Left side column. contains the logo and sidebar -->
			<jsp:include page="_menu_left.jsp"></jsp:include>
			 
			<!-- Right side column. Contains the navbar and content of the page -->
			<div ng-view></div>
			 
        </div><!-- ./wrapper -->

        <!-- add new calendar event modal -->

	
		<!-- ########################## AngularJS ########################################################################### -->
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28/angular.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28/angular-route.js"></script>
		<!--------- rotas e config da app angular ------------------->
		<script src="${pageContext.request.contextPath}/static/core/app-1.0.0.js"></script>  
		<!--------- Services ----------------> 
		<script src="${pageContext.request.contextPath}/static/core/service/UsuarioService-1.0.0.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/CampeonatoService.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/TipoEdicaoService.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/EdicaoService-1.0.2.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/GrupoService.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/TimeService.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/ClassificacaoService.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/service/HarbitoService.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/service/LocalService.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/service/JogoService.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/service/JogadorService.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/service/PosicaoService.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/service/EscalacaoService.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/service/EventoService.js" charset="UTF-8"></script>
		<script src="${pageContext.request.contextPath}/static/core/service/UsuarioPerfilCampeonatoService.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/service/JogadorInfoEdicaoService.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/service/JogadorEscaladoService.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/service/PodiumService-1.0.0.js"></script>
		<!--------- Controllers ------------->
		<script src="${pageContext.request.contextPath}/static/core/controller/UsuarioLoginController.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/controller/HomeController-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/controller/CampeonatoFormController.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/controller/EdicaoFormController.js" charset="UTF-8"></script>  
		<script src="${pageContext.request.contextPath}/static/core/controller/EdicaoListController-1.0.1.js" charset="UTF-8"></script>  
		<script src="${pageContext.request.contextPath}/static/core/controller/GrupoFormController-1.0.1.js" charset="UTF-8"></script>  
		<script src="${pageContext.request.contextPath}/static/core/controller/ClassificacaoFormController.js"></script>  
		<script src="${pageContext.request.contextPath}/static/core/controller/JogoFormController-1.0.2.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/controller/EdicaoConfirmaConclusaoController-1.0.0.js"></script>    
		<script src="${pageContext.request.contextPath}/static/core/controller/EdicaoClassificacaoController-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/controller/JogoResultadoController.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/controller/TimePageController.js"></script> 
		<script src="${pageContext.request.contextPath}/static/core/controller/TimeFormController.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/controller/EscalacaoAddEventoController.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/controller/JogadorInfoArtilhariaController-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/controller/JogadorInfoJogadoresController.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/controller/JogadorInfoPageController.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/controller/CampeonatoListController.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/controller/JogadorFormController-1.0.0.js"></script>
		<script src="${pageContext.request.contextPath}/static/core/controller/UsuarioFormController-1.0.0.js"></script>
		<!-- ########################## End AngularJS ####################################################################### -->

        <!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- Morris.js charts -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/plugins/morris/morris.min.js" type="text/javascript"></script>
        <!-- Sparkline -->
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
        <!-- jvectormap -->
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
        <!-- jQuery Knob Chart -->
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/plugins/jqueryKnob/jquery.knob.js" type="text/javascript"></script>
        <!-- daterangepicker -->
<%--         <script src="${pageContext.request.contextPath}/static/adminlte-master/js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script> --%>
        <!-- datepicker -->
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/plugins/datepicker/bootstrap-datepicker.js" type="text/javascript"></script>
        <!-- Bootstrap WYSIHTML5 -->
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
        <!-- iCheck -->
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>

        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/AdminLTE/app.js" type="text/javascript"></script>

        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/AdminLTE/dashboard.js" type="text/javascript"></script>

        <!-- AdminLTE for demo purposes -->
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/AdminLTE/demo.js" type="text/javascript"></script>


    </body>
</html>