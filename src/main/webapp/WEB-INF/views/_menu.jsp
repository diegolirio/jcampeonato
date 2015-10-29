<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="${pageContext.request.contextPath}" class="logo">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
                QuartaShow
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
						
<%-- 						<li><a href="${pageContext.request.contextPath}/usuario/login?next=${requestScope['javax.servlet.forward.request_uri']}"><i class="fa fa-sign-in"></i> Login</a></li>						 --%>
						<li ng-hide="usuarioLoginCtrl.isLoggedIn"><a href="#/login" ><i class="fa fa-sign-in"></i> Login</a></li>						 
						
                        <!-- User Account: style can be found in dropdown.less -->
                        <li ng-show="usuarioLoginCtrl.isLoggedIn" class="dropdown user user-menu">
                            <a href="?#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <span>{{usuarioLoginCtrl.usuarioLogado.nome}} <i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- User image -->
                                <li class="user-header bg-light-blue">
                                    <img src="${pageContext.request.contextPath}/static/adminlte-master/img/avatar-215x215.png" class="img-circle" alt="User Image" />
                                    <p>
                                        {{usuarioLoginCtrl.usuarioLogado.nome}} - Web Developer
                                        <small>Member since Nov. 2012</small>
                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <li class="user-body">
                                    <div class="col-xs-4 text-center">
<!--                                         <a href="#">Followers</a> -->
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Meus campeonatos</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
<!--                                         <a href="#">Friends</a> -->
                                    </div>
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a href="#" class="btn btn-default btn-flat">Perfil</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href ng-click="usuarioLoginCtrl.logout()" class="btn btn-default btn-flat">Sair</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>

