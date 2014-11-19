<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="bg-black">

        <meta charset="UTF-8">
        <title>Registrar Nova Conta</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/static/adminlte-master/css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="bg-black">

        <div class="form-box" id="login-box">
            <div class="header">Criar Nova Conta</div>
            <form action="" method="post">
                <div class="body bg-gray">
                	<c:if test="${not empty usuario}">
	                    <div class="form-group">
	                        <input type="text" name="name" class="form-control" placeholder="Full name"/>
	                    </div>
					</c:if>
                    <div class="form-group">
                        <input type="email" name="email" class="form-control" placeholder="Email"/>
                    </div>					
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Senha"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password2" class="form-control" placeholder="Confirmar Senha"/>
                    </div>
                </div>
                <div class="footer">                    

                    <button type="submit" class="btn bg-olive btn-block">Confirmar</button>

                    <a href="${pageContext.request.contextPath}/usuario/login" class="text-center">Eu já tenho uma conta</a>
                </div>
            </form>

            <div class="margin text-center">
                <span>Entrar com o Facebook</span>
                <br/>
                <button class="btn bg-light-blue btn-circle"><i class="fa fa-facebook"></i></button>
                <!-- <button class="btn bg-aqua btn-circle"><i class="fa fa-twitter"></i></button> -->
                <!-- <button class="btn bg-red btn-circle"><i class="fa fa-google-plus"></i></button> -->

            </div>
        </div>

        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/static/adminlte-master/js/bootstrap.min.js" type="text/javascript"></script>

    </body>
</html>