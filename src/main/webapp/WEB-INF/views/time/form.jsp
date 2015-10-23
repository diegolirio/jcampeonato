
         <aside class="right-side" ng-controller="TimeFormController as timeFormCtrl">
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Edição
                     <small>{{timeFormCtrl.edicao.campeonato.descricao}} {{timeFormCtrl.edicao.descricao}}</small>
                 </h1>
                 
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">Edição</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

				
		
					<form ng-submit="timeFormCtrl.save(timeFormCtrl.time)">
						<h1 class="text-info"> {{timeFormCtrl.time.nome}}</h1>
						<div class="form-group col-lg-6 col-md-6">
							<label>Nome do Time <small id="id_view" class="text-warning">?</small></label> 
							<input class="form-control" type="text" ng-model="timeFormCtrl.time.nome">
						</div>						
					 
						<br/>
	
						<a href="${pageContext.request.contextPath}" class="btn btn-default">Cancelar</a>
						<button	type="submit" class="btn btn-success">Salvar</button>
						
						<br/><br/>
						
					</form>

					<div class="col-lg-9 col-md-9">			
				    
				    		<div ng-show="timeFormCtrl.time != null" class="row" >
						            <div class="panel panel-success"> 
						                <div class="panel-heading">
						                    <h3 class="panel-title"><i class="fa fa-fw fa-table"></i> Jogadores</h3> 
						                </div>
						                <div class="panel-body">
							                                
							                <form ng-submit="timeFormCtrl.addJogadorTime(timeFormCtrl.time, timeFormCtrl.jogadorAddTime)">
								                <div class="row">
								                	<div class="col-lg-8">
								                		<select ng-model="timeFormCtrl.jogadorAddTime" ng-options="j.nome for j in timeFormCtrl.jogadores" class="form-control"></select>
													</div>
													<div class="col-lg-2">
														<button type="submit" class="btn btn-primary">Adicionar Jogador</button>
													</div>
													<div class="col-lg-2">
													</div>							
												</div>	
											</form>	
											<br/><br/>  
							                               
						                    <!--  Table -->                                
											<table class="table table-striped table-hover well">
												<thead>
													<tr class="text-success">
														<th></th>
														<th >Nome</th>
														<th ></th>
													</tr>
												<tbody id="id_tbody">
													<tr ng-repeat="jogador in  timeFormCtrl.time.jogadores"> 
														<td title="{{jogador.posicao.descricao}}">
															<img src="${pageContext.request.contextPath}/static/quartashow/img/{{jogador.posicao.imgName }}"/></td> 
														<td>{{jogador.nome}}</td>
														<td>
															<a href ng-click="timeFormCtrl.removeJogadorTime(timeFormCtrl.time, jogador)" class="btn btn-default">
																<span class="glyphicon glyphicon-trash text-danger"></span>
															</a>
														</td>
													</tr>									
												</tbody>								
											</table>                                
							                               
							                               
							                </div>
							            </div>
							            
							 </div>
		    		</div>
		    		<div class="col-lg-3 col-md-3">
	            			<div class="panel panel-success"> 
				                <div class="panel-heading">
				                    <h3 class="panel-title"><i class="fa fa-fw fa-table"></i> Jogadores</h3> 
				                </div>
				                <div class="panel-body">		    		
									<form ng-submit="timeFormCtrl.saveJogador(timeFormCtrl.jogadorNovo)">
										<h1 class="text-info"> Jogador</h1>
										
										<div class="form-group col-lg-12">
											<label>Nome </label>
											<input class="form-control" type="text" ng-model="timeFormCtrl.jogadorNovo.nome">
										</div>			
										
										<div class="form-group col-lg-12">
											<label>Posição </label>
											<select ng-model="timeFormCtrl.jogadorNovo.posicao" ng-options="p.descricao for p in timeFormCtrl.posicoes" class="form-control"></select>
										</div>
											
										<a href class="btn btn-default">Cancelar</a>
										<input type="submit" class="btn btn-success" name="btnSave" value="Salvar">
									</form>
								</div>
							</div>		    					
		    		</div>
		     </section>
	
		</aside>