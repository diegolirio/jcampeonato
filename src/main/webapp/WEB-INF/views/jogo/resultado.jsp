
         <aside class="right-side" ng-controller="JogoResultadoController as jgResultCtrl">
            
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 
				    <h1 class="page-header text-success visible-lg visible-md visible-sm">		
						{{ jgResultCtrl.jogo.grupo.edicao.campeonato.descricao }} {{ jgResultCtrl.jogo.grupo.edicao.descricao }}
					</h1>
					
					<h3 class="page-header text-success visible-xs">		
						{{ jgResultCtrl.jogo.grupo.edicao.campeonato.descricao }} {{ jgResultCtrl.jogo.grupo.edicao.descricao }}		     	
					</h3>	
                 
             </section>

             <!-- Main content -->
             <section class="content">
			             
					<!-- Placar Responsive -->
					<h1 class="page-header col-lg-12 col-md-12 col-sm-12 visible-lg visible-md visible-sm">
						<a href ng-click="jgResultCtrl.previousJogo(jgResultCtrl.jogo)" title="Anterior">
							<span class="glyphicon glyphicon-arrow-left col-md-1"></span>
						</a>
						<span class="text-center col-md-3">
							<a href="#/time/{{ jgResultCtrl.jogo.timeA.id }}/edicao/{{ jgResultCtrl.jogo.grupo.edicao.id }}">{{ jgResultCtrl.jogo.timeA.nome }}</a>
						</span>
						<span class="text-center text-danger col-md-1" id="id_rA" >{{ jgResultCtrl.jogo.resultadoA }}</span>
						<span class="text-center text-muted col-md-2">X</span>
						<span class="text-center text-danger col-md-1" id="id_rB">{{ jgResultCtrl.jogo.resultadoB }}</span>
						<span class="text-center col-md-3">
							<a href="#/time/{{ jgResultCtrl.jogo.timeB.id }}/edicao/{{ jgResultCtrl.jogo.grupo.edicao.id }}">{{ jgResultCtrl.jogo.timeB.nome }}</a>
						</span>
						<a href ng-click="jgResultCtrl.nextJogo(jgResultCtrl.jogo)" title="Pr�ximo">
							<span class="glyphicon glyphicon-arrow-right col-md-1"></span>
						</a>
					</h1>		
					
					<div class="page-header col-xs-12 visible-xs ">
						<table class="table">
							<tr>
								<td>
									<a href ng-click="jgResultCtrl.previousJogo(jgResultCtrl.jogo)" title="Anterior">
										<span class="glyphicon glyphicon-arrow-left col-md-1"></span>
									</a>
								</td>
								<td>
									<a href ng-click="jgResultCtrl.nextJogo(jgResultCtrl.jogo)" title="Pr�ximo">
										<span class="glyphicon glyphicon-arrow-right col-md-1"></span>
									</a>
								</td>								
							</tr>
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
						<span ng-show="jgResultCtrl.jogo.status.id != 1 && usuarioLoginCtrl.isLoggedIn && (jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1 || jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 2)">
							<a href ng-click="jgResultCtrl.returnStatus(jgResultCtrl.jogo)" class="btn btn-default btn-danger btn-outline">
								<span class="glyphicon glyphicon-arrow-left"> Voltar p/ {{jgResultCtrl.jogo.status.id == 2 ? 'Pendente' : 'Em andamento'}}</span>
							</a>
						</span> 
						<img ng-src="${pageContext.request.contextPath}/static/core/img/{{jgResultCtrl.jogo.status.imgName}}" /> {{jgResultCtrl.jogo.status.descricao}}
						| Rodada: {{jgResultCtrl.jogo.rodada}} | Local: {{jgResultCtrl.jogo.local.descricao}} | Harbito: {{jgResultCtrl.jogo.harbito.nome}}  
						| Data: {{jgResultCtrl.jogo.dataHora}}
					</div>

					<div ng-show="jgResultCtrl.jogo.status.id == 2 && usuarioLoginCtrl.isLoggedIn && (jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1 || jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 2)">
						<a href ng-click="jgResultCtrl.showWindowAddEvento(jgResultCtrl.escalacao, jgResultCtrl.GOL)" class="btn btn-outline btn-info">Adicionar Gol</a>
						<a href ng-click="jgResultCtrl.showWindowAddEvento(jgResultCtrl.escalacao, jgResultCtrl.CARTAO_AMARELO)" class="btn btn-outline btn-warning">Cart�o Amarelo</a>
						<a href ng-click="jgResultCtrl.showWindowAddEvento(jgResultCtrl.escalacao, jgResultCtrl.CARTAO_VERMELHO)" class="btn btn-outline btn-danger" onclick="showWindowPopup(this.href, 600, 800); return false;">Cart�o Vermelho</a>
						<a href class="btn btn-outline btn-primary" onclick="showWindowPopup(this.href, 600, 800); return false;">Falta</a>
						<a href class="btn btn-outline btn-info" onclick="showWindowPopup(this.href, 600, 800); return false;"><b class="text-danger">Gol Contra</b></a>
					</div>
			
			    	<div ng-show="jgResultCtrl.jogo.status.id == 1 && usuarioLoginCtrl.isLoggedIn && (jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1 || jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 2)" class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"> 
							<a  href ng-click="jgResultCtrl.createEscalacaoByJogo(jgResultCtrl.jogo)" class="btn btn-outline btn-success btn-lg btn-block">
								Adicionar informa��es da Partida
							</a>
						</div>
					</div>
					<br/><br/>
					<div ng-show="jgResultCtrl.jogo.status.id != 1" class="row">						
			            <div class="panel panel-primary">
							<div class="panel-heading">
		                    	<h3 class="panel-title"><i class="fa fa-fw fa-table"></i> Escala��o </h3>
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
											<tr ng-repeat="je in jgResultCtrl.escalacao.jogadoresEscalados" ng-show="jgResultCtrl.jogo.timeA.id == je.time.id" class="{{jgResultCtrl.jogo.vencedor == 'A' ? 'success' : 'danger'}}" >
												<td>
													<a href ng-show="jgResultCtrl.jogo.status.id == 2 && usuarioLoginCtrl.isLoggedIn && (jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1 || jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 2)" 
													   ng-click="jgResultCtrl.excluirJogadorEscalcao(je)" > 
														<span class="text-danger" title="excluir jogador da escala��o">excluir</span>
													</a>
												</td>
												<td><img alt="foto" ng-src="{{je.jogador.uriFoto}}" title="{{je.jogador.nome}}" class="img-responsive img-circle" height="30" width="30"/></td>
												<td class="jogador{{je.id}}"> 
													 <img ng-src="${pageContext.request.contextPath}/static/core/img/{{je.posicao.imgName}}" alt="{{je.jogador.posicao.descricao}}"/>
													 <a href="#/jogadorinfo/jogador/{{je.jogador.id}}/edicao/{{jgResultCtrl.jogo.grupo.edicao.id}}">{{je.jogador.nome}}</a>
												</td>
												<td> 
													<img ng-repeat="e in je.eventos" ng-src="${pageContext.request.contextPath}/static/core/img/{{e.imgName}}" alt="{{e.descricao}}" />
													<a ng-show="je.eventos.length > 0 && jgResultCtrl.jogo.status.id == 2 && usuarioLoginCtrl.isLoggedIn && (jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1 || jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 2)" 
													   href ng-click="jgResultCtrl.showWindowRemoveEvento(je)"> 
														<img src="${pageContext.request.contextPath}/static/core/img/lixeira.png" alt="Excluir" title="Excluir Gol, Cart�o amarelo ou Cart�o vermelho" class="pull-right" />
													</a>
												</td>
											</tr>
										</tbody>								
									</table>	        
									<a ng-show="jgResultCtrl.jogo.status.id == 2 && usuarioLoginCtrl.isLoggedIn && (jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1 || jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 2)" 
										href ng-click="jgResultCtrl.showWindowAddJogadorEscalacao(jgResultCtrl.escalacao, jgResultCtrl.jogo.timeA)" class="btn btn-outline btn-warning btn-xs btn-block">
											adicionar jogador para {{ jgResultCtrl.jogo.timeA.nome }}
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
										<tbody >     
											<tr ng-repeat="je in jgResultCtrl.escalacao.jogadoresEscalados" ng-show="jgResultCtrl.jogo.timeB.id == je.time.id" class="{{jgResultCtrl.jogo.vencedor == 'B' ? 'success' : 'danger'}}" >
											    <td><a ng-show="jgResultCtrl.jogo.status.id == 2 && usuarioLoginCtrl.isLoggedIn && (jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1 || jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 2)" href ng-click="jgResultCtrl.excluirJogadorEscalcao(je)"> <span class="text-danger" title="excluir jogador da escala��o">excluir</span></a></td>
											    <td><img alt="foto" ng-src="{{je.jogador.uriFoto}}" title="{{je.jogador.nome}}" class="img-responsive img-circle" height="30" width="30"/></td>
												<td class="jogador{{je.id}}"> 
													 <img ng-src="${pageContext.request.contextPath}/static/core/img/{{je.posicao.imgName}}" alt="{{je.jogador.posicao.descricao}}"/>
													 <a href="#/jogadorinfo/jogador/{{je.jogador.id}}/edicao/{{jgResultCtrl.jogo.grupo.edicao.id}}">{{je.jogador.nome}}</a>
												</td>
												<td> 
													<img ng-repeat="e in je.eventos" ng-src="${pageContext.request.contextPath}/static/core/img/{{e.imgName}}" alt="{{e.descricao}}" />
													<div ng-show="usuarioLoginCtrl.isLoggedIn && (jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1 || jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 2) && je.eventos.length > 0 && jgResultCtrl.jogo.status.id == 2">
														<a ng-click="jgResultCtrl.showWindowRemoveEvento(je)" > 
															<img src="${pageContext.request.contextPath}/static/core/img/lixeira.png" alt="Excluir" title="Excluir Gol, Cart�o amarelo ou Cart�o vermelho" class="pull-right" />
														</a>
													</idv>															
												</td>													
											</tr>
										</tbody>								
									</table>
									<a ng-show="jgResultCtrl.jogo.status.id == 2 && usuarioLoginCtrl.isLoggedIn && (jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1 || jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 2)" href 
									   class="btn btn-outline btn-warning btn-xs btn-block" ng-click="jgResultCtrl.showWindowAddJogadorEscalacao(jgResultCtrl.escalacao, jgResultCtrl.jogo.timeB)">
										adicionar jogador para {{ jgResultCtrl.jogo.timeB.nome }}
									</a>
		                    	</div>


							</div>
					
					</div>
		    	</div>
		    	
		
				<div ng-show="jgResultCtrl.jogo.status.id == 2 && usuarioLoginCtrl.isLoggedIn && (jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 1 || jgResultCtrl.usuarioPerfilCampeonato.perfil.id == 2)"> 
					<a href ng-click="jgResultCtrl.finalizar(jgResultCtrl.jogo)" class="btn btn-outline btn-success btn-lg btn-block">Finalizar Jogo</a>
				</div>					    	
			    	
             </section>
	
		</aside>