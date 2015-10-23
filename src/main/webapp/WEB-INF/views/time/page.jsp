
         <aside class="right-side" ng-controller="TimePageController as timePageCtrl">
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Edição
                     <small>{{timePageCtrl.edicao.campeonato.descricao}} {{timePageCtrl.edicao.descricao}}</small>
                 </h1>
                 
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">Edição</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">
			
				<h1 class="page-header">
					{{ timePageCtrl.time.nome }} 
		    		<a ng-show="true" href="#/time/{{ timePageCtrl.time.id }}">
		   				<span class="glyphicon glyphicon-pencil text-muted"></span>
		   			</a>
				</h1>			
				 
				<div ng-show="timePageCtrl.classificacao != null" class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            {{timePageCtrl.classificacao.grupo.edicao.campeonato.descricao}} {{timePageCtrl.classificacao.grupo.edicao.descricao }}
	                        </div>
	                        <!-- /.panel-heading --> 
	                        <div class="panel-body">
								<div class="col-lg-5">
									<div class="text-center">
										<ul class="text-muted">
											<li style="font-size: 20px;" class="text-primary">{{timePageCtrl.classificacao.colocacao}}º Colocado</li>
											<li style="font-size: 20px;" class="text-primary">{{timePageCtrl.classificacao.pontos}} pontos</li>
											<br/>
											<li>{{timePageCtrl.classificacao.golsPro}} Gols Pró</li>
											<li>{{timePageCtrl.classificacao.golsContra}} Gols Contra</li>
											<li>{{timePageCtrl.classificacao.golsPro - classificacao.golsContra}} Saldo de Gols</li>
											<li>{{timePageCtrl.classificacao.pontos * 100 / ((timePageCtrl.classificacao.jogos == 0 ? 1 : timePageCtrl.classificacao.jogos) * 3) }} % de aproveitamento</li>							
										</ul>
									</div>
								</div>                           
	                        	<div class="col-lg-7">
<%-- 											<jsp:include page="grafico_pizza_classificacao.jsp"></jsp:include> --%>
								</div>
	                        </div>
	                        <!-- /.panel-body -->
	                    </div>
	                    <!-- /.panel -->
	                </div>			
				</div>

				<div class="col-lg-10">
					<div class="panel panel-primary">
						<div class="panel-heading">
							Jogadores
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-hover">
									<thead class="text-danger">
										<tr>
											<th class="text-muted">#</th>
											<th></th>
											<th>Nome</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<tr ng-repeat="jogador in timePageCtrl.jogadores | filter: time.id">
											<td class="text-muted"><img alt="foto" src="{{jogador.uriFoto}}" class="img-responsive img-circle" height="30" width="30"/> </td>
											<td><img src="${pageContext.request.contextPath}/static/quartashow/img/{{jogador.posicao.imgName}}" alt="{{jogador.posicao.descricao}}"/></td>
											<td>
												<h5><a href="${pageContext.request.contextPath}/jogador/{{jogador.id}}/edicao/{{ timePageCtrl.edicao != null ? timePageCtrl.edicao.id : 0}"> {{ jogador.nome }} </a></h5>
											</td>
											<td></td> 
										</tr>
										<h3 ng-show="timePageCtrl.jogadores.length == 0 && true">
											Não há jogadores para este time <a href="#/time/{{timePageCtrl.time.id}}">Cadastre agora</a>
										</h3>
									</tbody>
								</table>
							</div>
						</div>
						<div class="panel-footer">
							Sujeito a Alterações...
						</div>
					</div>
				</div>
				
<!-- 				<div class="row"> -->
<%-- 					<c:if test="${not empty edicao}"> --%>
<%-- 						<jsp:include page="jogo-list.jsp"></jsp:include> --%>
<!-- 					</c:if>	 -->
<!-- 				</div>		 -->
					
	
		     </section>
	
		</aside>