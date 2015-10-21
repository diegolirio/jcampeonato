
         <aside class="right-side" ng-controller="EdicaoClassificacaoController as edicaoCLassCtrl">
            
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Edições 
                     <small>Pendentes</small>
                 </h1>
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">{{ edicaoCLassCtrl.edicao.campeonato.descricao }} {{ edicaoCLassCtrl.edicao.descricao }}</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

				    <h1 class="page-header text-success visible-lg visible-md visible-sm">		
						{{ edicaoCLassCtrl.edicao.campeonato.descricao }} {{ edicaoCLassCtrl.edicao.descricao }}
					</h1>
					
					<h3 class="page-header text-success visible-xs">		
						{{ edicaoCLassCtrl.edicao.campeonato.descricao }} {{ edicaoCLassCtrl.edicao.descricao }}		     	
					</h3>	
				
					 
					    <div class="row" ng-repeat="grupo in edicaoCLassCtrl.grupos">
					        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					            <div class="panel panel-primary">
					                <div class="panel-heading">
					                    <h3 class="panel-title"><i class="fa fa-fw fa-table"></i> Classificação {{ grupo.descricao }} </h3>
					                </div>
					                <div class="panel-body">
					                    
					                    <div class="table-responsive"> 
						                    <!--  Table -->
											<table class="table table-striped table-hover well">
												<thead>
													<tr class="text-danger">
														<th class="text-center">Col</th>
														<th >Time</th>
														<th class="text-center">Pontos</th>
														<th class="text-center">J</th>
														<th class="text-center">V</th>
														<th class="text-center">E</th>
														<th class="text-center">D</th>
														<th class="text-center">GP</th>
														<th class="text-center">GC</th>
														<th class="text-center">SG</th>
														<th class="text-center" title="percentual de aproveitamento">%</th>
													</tr>
												</thead>
												<tbody id="id_tbody">
														<tr class="" ng-controller="class in edicaoCLassCtrl.classificacoes | filter: grupo.id">
															<td title="Colocacao" class="text-info text-center"><b>{{class.colocacao}}º</b></td>
															<td ><a href="${pageContext.request.contextPath}/time/${c.time.id}/edicao/${edicao.id}">${c.time.nome}</a></td>
															<td class="text-center"><b>{{class.pontos}}</b></td>
															<td class="text-center">{{class.jogos}}</td>
															<td class="text-center">{{class.vitorias}}</td>
															<td class="text-center">{{class.empates}}</td>
															<td class="text-center">{{class.derrotas}}</td>
															<td class="text-center">{{c.golsPro}}</td>
															<td class="text-center">{{c.golsContra}}</td>
															<td class="text-center">{{c.golsPro - c.golsContra}}</td>										
															<td class="text-center"><small>{{class.pontos * 100 / ((class.jogos == 0 ? 1 : class.jogos) * 3)}}</small></td>
														</tr>									
												</tbody>								
											</table>    
										</div>						
					                </div>
					            </div>
					        </div>
					    </div>
					    <!-- /.row -->	    
					     <br/>						    
					
					<br/><br/> 
					
<%-- 					<jsp:include page="jogo-list.jsp"></jsp:include> --%>
<%-- 				    <c:if test="${not empty usuario && not empty admin && admin}"> --%>
						 <div class="row">
							<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
								<br/>
								<a href="${pageContext.request.contextPath}/edicao/system/${edicao.id}/jogos" class="btn btn-block btn-outline btn-success" >
									Cadastrar Novo jogo
								</a>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
								<br/>
								<a href="${pageContext.request.contextPath}/edicao/system/${edicao.id}/finalizarPrimeiraFase" class="btn btn-block btn-outline btn-danger" id="idFinalizarFase">
									Finalizar
								</a>
							</div>
							<br/><br/>
						</div>
<!-- 				    </c:if>  	 -->
            
             </section>
	
		</aside>