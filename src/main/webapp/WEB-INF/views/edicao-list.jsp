<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Campeonatos
                        <small>Edições</small>
                        &nbsp; <a href="${pageContext.request.contextPath}/edicao/system/0" class="btn btn-success btn-sm">Criar Campeonato</a>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Edições</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">

					<c:forEach var="e" items="${edicoes}">
	                    <!-- Small boxes (Stat box) -->
	                    <div class="row">
	                        <div class="col-lg-6 col-xs-12">
	                            <!-- small box -->
	                            <div class="small-box bg-aqua">
	                                <div class="inner">
	                                    <h3>
	                                        <a href="#"><span style="color:white;"> Quarta Show</span></a>
	                                    </h3>
	                                    <p> 
	                                        <a href="#"><span style="color:white;"> 2014</span></a>
	                                    </p>
	                                </div>
	                                <div class="icon">
	                                    <a href="#"><i style="color:white;" class="ion ion-bag"></i></a>
	                                </div>
	                                <a href="#" class="small-box-footer">
	                                    mais informações <i class="fa fa-arrow-circle-right"></i>
	                                </a>
	                            </div>
	                        </div><!-- ./col -->
	                   </c:forEach>
					</div>
				</section>
				
			</aside>