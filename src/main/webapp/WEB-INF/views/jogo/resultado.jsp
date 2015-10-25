
         <aside class="right-side" ng-controller="JogoResultadoController as jgResultCtrl">
            
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Edições 
                     <small>Pendentes</small>
                 </h1>
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">{{ jgResultCtrl.edicao.campeonato.descricao }} {{ jgResultCtrl.edicao.descricao }}</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">
			             
					<!-- Placar Responsive -->
					<h1 class="page-header col-lg-12 col-md-12 col-sm-12 visible-lg visible-md visible-sm"> 
						<span class="text-center col-md-4">
							<a href="#/time/{{ jgResultCtrl.jogo.timeA.id }}/edicao/{{ jgResultCtrl.jogo.grupo.edicao.id }}">{{ jgResultCtrl.jogo.timeA.nome }}</a>
						</span>
						<span class="text-center text-danger col-md-1" id="id_rA" >{{ jgResultCtrl.jogo.resultadoA }}</span>
						<span class="text-center text-muted col-md-1">X</span>
						<span class="text-center text-danger col-md-1" id="id_rB">{{ jgResultCtrl.jogo.resultadoB }}</span>
						<span class="text-center col-md-4">
							<a href="#/time/{{ jgResultCtrl.jogo.timeB.id }}/edicao/{{ jgResultCtrl.jogo.grupo.edicao.id }}">{{ jgResultCtrl.jogo.timeB.nome }}</a>
						</span>
					</h1>		
					<div class="page-header col-xs-12 visible-xs text-center">
						<table class="table">
							<tr>
								<td>
									<h3 class="text-center col-md-4">
										<a href="#/time/{{ jgResultCtrl.jogo.timeA.id }}/edicao/{{ jgResultCtrl.jogo.grupo.edicao.id }}">{{ jgResultCtrl.jogo.timeA.nome }}</a>
									</h3>
								</td>
								<td>
									<h3 class="text-center text-danger col-md-1" >{{ jgResultCtrl.jogo.resultadoA }}</h3>
								</td>
							</tr>
							<tr>
								<td>
									<h3 class="text-center col-md-4">
										<a href="#/time/{{ jgResultCtrl.jogo.timeB.id }}/edicao/{{ jgResultCtrl.jogo.grupo.edicao.id }}">{{ jgResultCtrl.jogo.timeB.nome }}</a>
									</h3>
								</td>
								<td><h3 class="text-center text-danger col-md-1" id="id_rB">{{ jgResultCtrl.jogo.resultadoB }}</h3></td>
							</tr>
						</table>		
					</div>
					<!-- Fim Placar Responsive -->

					<div class="text-muted">
						<span ng-show="jgResultCtrl.jogo.status.id != 1 && usuarioLoginCtrl.isLoggedIn && jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1">
							<a href="#/jogo/{{jgResultCtrl.jogo.id}}/retornStatus" class="btn btn-default btn-danger btn-outline">
								<span class="glyphicon glyphicon-arrow-left"> Voltar p/ {{jgResultCtrl.jogo.status.id == 2 ? 'Pendente' : 'Em andamento'}}</span>
							</a>
						</span> 
						<img src="${pageContext.request.contextPath}/static/core/img/{{jgResultCtrl.jogo.status.imgName}}" /> {{jgResultCtrl.jogo.status.descricao}}
						| Rodada: {{jgResultCtrl.jogo.rodada}} | Local: {{jgResultCtrl.jogo.local.descricao}} | Harbito: {{jgResultCtrl.jogo.harbito.nome}}  
						| Data: {{jgResultCtrl.jogo.dataHora}}
					</div>

					<div ng-show="jgResultCtrl.jogo.status.id == 2 && usuarioLoginCtrl.isLoggedIn && jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1">
						<a href="#/escalacao/system/{{jgResultCtrl.jogo.id}}/add/evento/1" class="btn btn-outline btn-info">Adicionar Gol</a>
						<a href="#/escalacao/system/{{jgResultCtrl.jogo.id}}/add/evento/2" class="btn btn-outline btn-warning" onclick="showWindowPopup(this.href, 600, 800); return false;">Cartão Amarelo</a>
						<a href="#/escalacao/system/{{jgResultCtrl.jogo.id}}/add/evento/3" class="btn btn-outline btn-danger" onclick="showWindowPopup(this.href, 600, 800); return false;">Cartão Vermelho</a>
						<a href="#/escalacao/system/{{jgResultCtrl.jogo.id}}/add/evento/3" class="btn btn-outline btn-primary" onclick="showWindowPopup(this.href, 600, 800); return false;">Falta</a>
						<a href="#/escalacao/system/{{jgResultCtrl.jogo.id}}/add/evento/3" class="btn btn-outline btn-info" onclick="showWindowPopup(this.href, 600, 800); return false;"><b class="text-danger">Gol Contra</b></a>
					</div>
			
			    	<div ng-show="jgResultCtrl.jogo.status.id == 1 && usuarioLoginCtrl.isLoggedIn && jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1" class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"> 
							<a  href ng-click="jgResultCtrl.createEscalacaoByJogo(jgResultCtrl.jogo)" class="btn btn-outline btn-default btn-lg btn-block">
								Adicionar informações da Partida
							</a>
						</div>
					</div>
					<br/><br/>
					<div ng-show="jgResultCtrl.jogo.status.id != 1" class="row">						
			            <div class="panel panel-primary">
							<div class="panel-heading">
		                    	<h3 class="panel-title"><i class="fa fa-fw fa-table"></i> Escalação </h3>
		                	</div>
		                	
		                	<div class="panel-body">
								<p>
									<img src="${pageContext.request.contextPath}/static/core/img/gol.png" height="12"/> <small class="text-muted">Gol</small> &bull;
									<img src="${pageContext.request.contextPath}/static/core/img/cartao-amarelo.png" height="12"/> <small class="text-muted">C. Amarelo</small> &bull;
									<img src="${pageContext.request.contextPath}/static/core/img/cartao-vermelho.png" height="12"/> <small class="text-muted">C. Vermelho</small>
								</p>		                	
	                	
	                	
			                	<div class="table-responsive col-lg-6 col-md-6 ">
									<!--  Table -->
									<table class="table">
										<thead class="text-warning">
											<tr >
												<th class="text-center" colspan="3">{{jgResultCtrl.escalacao.jogo.timeA.nome}}</th>
												<th></th>
											</tr> 
										</thead>								
										<tbody id="id_tbody">
											<tr ng-repeat="je in jgResultCtrl.escalacao.jogadoresEscalados" ng-show="jgResultCtrl.jogo.timeA.id == je.time.id" class="{{jgResultCtrl.jogo.resultadoA > jgResultCtrl.jogo.resultadoB ? 'success' : 'danger'}}" >
												<td>
													<a ng-show="jgResultCtrl.jogo.status.id == 2 && true" href="#/escalacao/jogadorEscalado/delete/{{je.id}}" > 
														<span class="text-danger">excluir</span>
													</a>
												</td>
												<td><img alt="foto" src="{{je.jogador.uriFoto}}" title="{{je.jogador.nome}}" class="img-responsive img-circle" height="30" width="30"/></td>
												<td class="jogador{{je.id}}"> 
													 <img src="${pageContext.request.contextPath}/static/core/img/{{je.jogador.posicao.imgName}}" alt="{{je.jogador.posicao.descricao}}"/>
													 <a href="${pageContext.request.contextPath}/jogador/{{je.jogador.id}}/edicao/{{jogo.grupo.edicao.id}}">{{je.jogador.nome}}</a>
												</td>
												<td> 
													<img ng-repeat="e in je.eventos" src="${pageContext.request.contextPath}/static/core/img/{{e.imgName}}" alt="{{e.descricao}}" />
													<a ng-show="je.eventos.length > 0 && jgResultCtrl.jogo.status.id == 2 && true" href="#/escalacao/jogadorEscalado/{{je.id}}/eventos/delete" > 
														<img src="${pageContext.request.contextPath}/static/core/img/lixeira.png" alt="Excluir" title="Excluir Gol, Cartão amarelo ou Cartão vermelho" class="pull-right" />
													</a>
												</td>
											</tr>
										</tbody>								
									</table>	        
									<a ng-show="jgResultCtrl.jogo.status.id == 2 && usuarioLoginCtrl.isLoggedIn && jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1" href="#/escalacao/{{jgResultCtrl.escalacao.id}}/add/jogador/time/{{jgResultCtrl.jogo.timeA.id}}" class="btn btn-outline btn-warning btn-xs btn-block">
										adicionar jogador para {{jgResult.jogo.timeA.nome}}
									</a>
		                    	</div>

								<div class="table-responsive col-lg-6 col-md-6">
									<!--  Table -->
									<table class="table">
										<thead class="text-warning">
											<tr>
												<th class="text-center" colspan="3">{{jgResultCtrl.escalacao.jogo.timeB.nome}}</th>
												<th></th>
											</tr> 
										</thead>								
										<tbody id="id_tbody">     
											<tr ng-repeat="je in jgResultCtrl.escalacao.jogadoresEscalados" ng-show="jgResultCtrl.jogo.timeB.id == je.time.id" class="{{jgResult.jogo.resultadoA < jogo.resultadoB ? 'success' : 'danger'}}" >
											    <td><a ng-show="jgResultCtrl.jogo.status.id == 2 && true" href="#/escalacao/jogadorEscalado/delete/{{je.id}}"> <span class="text-danger">excluir</span></a></td>
											    <td><img alt="foto" src="{{je.jogador.uriFoto}}" title="{{je.jogador.nome}}" class="img-responsive img-circle" height="30" width="30"/></td>
												<td class="jogador{{je.id}}"> 
													 <img src="${pageContext.request.contextPath}/static/core/img/{{je.jogador.posicao.imgName}}" alt="{{je.jogador.posicao.descricao}}"/>
													 <a href="#/jogador/{{je.jogador.id}}/edicao/{{jgResultCtrl.jogo.grupo.edicao.id}}">{{je.jogador.nome}}</a>
												</td>
												<td> 
													<img ng-repeat="e in je.eventos" src="${pageContext.request.contextPath}/static/core/img/{{e.imgName}}" alt="{{e.descricao}}" />
													<div ng-show="je.eventos > 0 && jgResultCtrl.jogo.status.id == 2 && true">
														<a href="#/escalacao/jogadorEscalado/{{je.id}}/eventos/delete" > 
															<img src="${pageContext.request.contextPath}/static/core/img/lixeira.png" alt="Excluir" title="Excluir Gol, Cartão amarelo ou Cartão vermelho" class="pull-right" />
														</a>
													</idv>															
												</td>													
											</tr>
										</tbody>								
									</table>
									<a ng-show="jgResultCtrl.jogo.status.id == 2 && usuarioLoginCtrl.isLoggedIn && jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1" href="#/escalacao/{{jgResultCtrl.escalacao.id}}/add/jogador/time/{{jgResultCtrl.jogo.timeB.id}}" class="btn btn-outline btn-warning btn-xs btn-block" id="id_add_jogador_escalado_timeB" onclick="showWindowPopup(this.href, 400, 600); return false;">
										adicionar jogador para {{jgResultCtrl.jogo.timeB.nome}}
									</a>
		                    	</div>


							</div>
					
					</div>
		    	</div>
		    	
		
				<div ng-show="jgResultCtrl.jogo.status.id == 2 && usuarioLoginCtrl.isLoggedIn && jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1"> 
					<a href ng-click="jgResultCtrl.finalizar(jgResultCtrl.jogo)" class="btn btn-outline btn-success btn-lg btn-block">Finalizar Jogo</a>
				</div>					    	
			    	
             </section>
	
		</aside>