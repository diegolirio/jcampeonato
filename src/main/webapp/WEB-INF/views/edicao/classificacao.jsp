
         <aside class="right-side" ng-controller="EdicaoClassificacaoController as edicaoCLassCtrl">
            
             <!-- Main content -->
             <section class="content">

				    <h1 class="page-header text-success visible-lg visible-md visible-sm">		
						{{ edicaoCLassCtrl.edicao.campeonato.descricao }} {{ edicaoCLassCtrl.edicao.descricao }}
					</h1>
					
					<h3 class="page-header text-success visible-xs">		
						{{ edicaoCLassCtrl.edicao.campeonato.descricao }} {{ edicaoCLassCtrl.edicao.descricao }}		     	
					</h3>	
				

					
					<div class="row col-md-12">
					 
							<div class="nav-tabs-custom">
							
								<ul class="nav nav-tabs">
									<li ng-repeat="g in edicaoCLassCtrl.grupos" ng-class="{ active:edicaoCLassCtrl.isSet($index) }" ng-hide="g.fase.sigla == '3'">
										<a href ng-click="edicaoCLassCtrl.setTab($index)" data-toggle="tab"> {{ g.descricao }} </a>
									</li>
								</ul>
  
								<div class="tab-content">
									<div ng-repeat="grupo in edicaoCLassCtrl.grupos" ng-show="edicaoCLassCtrl.isSet($index)">

										<!-- 1 fase -->
										<div ng-show="grupo.fase.sigla == '1'">
									            
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
																		<tr class="" ng-repeat="class in edicaoCLassCtrl.classificacoes | filter: grupo.id">
																			<td title="Colocacao" class="text-info text-center"><b>{{class.colocacao}}º</b></td>
																			<td ><a href="#/time/{{class.time.id}}/edicao/{{edicao.id}}">{{class.time.nome}}</a></td>
																			<td class="text-center"><b>{{class.pontos}}</b></td>
																			<td class="text-center">{{class.jogos}}</td>
																			<td class="text-center">{{class.vitorias}}</td>
																			<td class="text-center">{{class.empates}}</td>
																			<td class="text-center">{{class.derrotas}}</td>
																			<td class="text-center">{{class.golsPro}}</td>
																			<td class="text-center">{{class.golsContra}}</td>
																			<td class="text-center">{{class.golsPro - class.golsContra}}</td>										
																			<td class="text-center"><small>{{ (class.pontos * 100 / ((class.jogos == 0 ? 1 : class.jogos) * 3) | number:2) }}</small></td>
																		</tr>									
																</tbody>								
															</table>    
														</div>						
									                </div>
									          </div>      
	
											  <div class="row">
													
													<!-- JOGOS -->
												    <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12" ng-repeat="jogo in edicaoCLassCtrl.jogos | filter: grupo.id" ng-show="jogo.grupo.fase.sigla == grupo.fase.sigla">   
							
												      		<div class="table-responsive">
												      			<a href="#/jogo/{{jogo.id}}/resultado">
												        		<table class="table well text-center">
												        			<thead>
												        				<tr>
												        					<td colspan="5" class="text-muted"> 
												        						<small> 
												        							Rodada: {{jogo.rodada}} - {{ jogo.dataHora }}
												        						</small>
																	    		<a href="#/jogo/{{jogo.id}}/novo/edicao/{{edicaoCLassCtrl.edicao.id}}" 
																	    		   ng-show="jogo.status.id == 1 && usuarioLoginCtrl.isLoggedIn && (edicaoCLassCtrl.usuarioPerfilCampeonato.perfil.id == 1 || edicaoCLassCtrl.usuarioPerfilCampeonato.perfil.id == 2)">
																	   				<span class="glyphicon glyphicon-pencil text-muted pull-right pencil-edit"></span>
																	   			</a>    
												        					</td>
												        				</tr>
												        			</thead>
												        			<tbody >
												        				<tr>
												        					<td><h4 class="text-info">{{ jogo.timeA.nome }}</h4></td>
												        					<td><h4 class="text-danger" ng-show="jogo.status.id != 1">{{ jogo.resultadoA }}</h4></td>	
																			<td><h4 class="text-muted">X</h4></td>
																			<td><h4 class="text-danger" ng-show="jogo.status.id != 1">{{ jogo.resultadoB }}</h4></td>
															        		<td><h4 class="text-info">{{ jogo.timeB.nome }}</h4></td>											        					
												        				</tr>
												        			</tbody>
												        			<tfoot>
												        				<tr>
												        					<td colspan="3">
												        						<small><span class=""><img ng-src="${pageContext.request.contextPath}/static/core/img/{{jogo.status.imgName}}"/> ( {{ jogo.status.descricao }} )</span></small>
																			</td>
																			<td colspan="2">
																				<small>{{ jogo.local.descricao }}</small>
																			</td>
												        				</tr>
												        		</table>
												        	    </a>
												            </div>   
												      		
												      		<br/>
												    </div>        
													<!-- Fim JOGOS -->
											  </div>
											    
												<br/><br/> 
												
													 <div class="row" ng-show="usuarioLoginCtrl.isLoggedIn && (edicaoCLassCtrl.usuarioPerfilCampeonato.perfil.id == 1 || edicaoCLassCtrl.usuarioPerfilCampeonato.perfil.id == 2)">
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<br/>
															<a href="#/jogo/novo/edicao/{{ edicaoCLassCtrl.edicao.id }}/true" class="btn btn-block btn-outline btn-success" ng-disabled="grupo.status.id != 1">
																Cadastrar Novo jogo
															</a> 
														</div>
														<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
															<br/>
															<a href ng-click="edicaoCLassCtrl.finalizarPrimeiraFase(edicaoCLassCtrl.edicao)" class="btn btn-block btn-outline btn-danger" ng-disabled="grupo.status.id != 1">
																Finalizar
															</a>
														</div>
														<br/><br/>
													</div>								                
								                
								        </div> 
								        <!-- fim fase 1 -->
								            
								       
								       <!-- final | 3lugar -->     
								       <div ng-show="grupo.fase.sigla == 'F' || grupo.fase.sigla == '3'">
								            <div ng-show="(jogo.grupo.fase.sigla == '3' || jogo.grupo.fase.sigla == 'F')" ng-repeat="jogo in edicaoCLassCtrl.jogos | filter: grupo.id">
												
													<!-- 3lugar -->
										      		<div class="table-responsive col-lg-4 col-md-6 col-sm-12 col-xs-12" ng-show="jogo.grupo.fase.sigla == '3'" >
										      			<a href="#/jogo/{{jogo.id}}/resultado">
										        		<table class="table well text-center">
										        			<thead>
										        				<tr>
										        					<td colspan="5" class="text-muted"> 
										        						<small> 
										        							3º Lugar - {{ jogo.dataHora }}
										        						</small>
															    		<a href="#/jogo/{{jogo.id}}/novo/edicao/{{edicaoCLassCtrl.edicao.id}}" 
															    		   ng-show="jogo.status.id == 1 && usuarioLoginCtrl.isLoggedIn && (edicaoCLassCtrl.usuarioPerfilCampeonato.perfil.id == 1 || edicaoCLassCtrl.usuarioPerfilCampeonato.perfil.id == 2)">
															   				<span class="glyphicon glyphicon-pencil text-muted pull-right pencil-edit"></span>
															   			</a>    
										        					</td>
										        				</tr>
										        			</thead>
										        			<tbody >
										        				<tr>
										        					<td><h4 class="text-info">{{ jogo.timeA.nome }}</h4></td>
										        					<td><h4 class="text-danger" ng-show="jogo.status.id != 1">{{ jogo.resultadoA }}</h4></td>	
																	<td><h4 class="text-muted">X</h4></td>
																	<td><h4 class="text-danger" ng-show="jogo.status.id != 1">{{ jogo.resultadoB }}</h4></td>
													        		<td><h4 class="text-info">{{ jogo.timeB.nome }}</h4></td>											        					
										        				</tr>
										        			</tbody>
										        			<tfoot>
										        				<tr>
										        					<td colspan="3">
										        						<small><span class=""><img ng-src="${pageContext.request.contextPath}/static/core/img/{{jogo.status.imgName}}"/> ( {{ jogo.status.descricao }} )</span></small>
																	</td>
																	<td colspan="2">
																		<small>{{ jogo.local.descricao }}</small>
																	</td>
										        				</tr>
										        		</table>
										        	    </a>
										            </div>  												
													<!-- fim 3lugar -->
													<!-- Final -->
										      		<div class="table-responsive col-lg-4 col-md-6 col-sm-12 col-xs-12" ng-show="jogo.grupo.fase.sigla == 'F'" >
										      			<a href="#/jogo/{{jogo.id}}/resultado">
										        		<table class="table well text-center">
										        			<thead>
										        				<tr>
										        					<td colspan="5" class="text-muted">
										        						<b class="text-success">Final</b> 
										        						<small>   
										        							 - {{ jogo.dataHora }}
										        						</small>
															    		<a href="#/jogo/{{jogo.id}}/novo/edicao/{{edicaoCLassCtrl.edicao.id}}" 
															    		   ng-show="jogo.status.id == 1 && usuarioLoginCtrl.isLoggedIn && (edicaoCLassCtrl.usuarioPerfilCampeonato.perfil.id == 1 || edicaoCLassCtrl.usuarioPerfilCampeonato.perfil.id == 2)">
															   				<span class="glyphicon glyphicon-pencil text-muted pull-right pencil-edit"></span>
															   			</a>    
										        					</td>
										        				</tr>
										        			</thead>
										        			<tbody >
										        				<tr>
										        					<td><h4 class="text-info">{{ jogo.timeA.nome }}</h4></td>
										        					<td><h4 class="text-danger" ng-show="jogo.status.id != 1">{{ jogo.resultadoA }}</h4></td>	
																	<td><h4 class="text-muted">X</h4></td>
																	<td><h4 class="text-danger" ng-show="jogo.status.id != 1">{{ jogo.resultadoB }}</h4></td>
													        		<td><h4 class="text-info">{{ jogo.timeB.nome }}</h4></td>											        					
										        				</tr>
										        			</tbody>
										        			<tfoot>
										        				<tr>
										        					<td colspan="3">
										        						<small><span class=""><img ng-src="${pageContext.request.contextPath}/static/core/img/{{jogo.status.imgName}}"/> ( {{ jogo.status.descricao }} )</span></small>
																	</td>
																	<td colspan="2">
																		<small>{{ jogo.local.descricao }}</small>
																	</td>
										        				</tr>
										        		</table>
										        	    </a>
										            </div>  												
													<!-- fim Final -->
												
								            </div>

									   </div> 
										
										
										
									 </div>								
								</div> 
								
							</div> 
					</div>
            
            	  </div>
            	  
             </section>
	
		</aside>