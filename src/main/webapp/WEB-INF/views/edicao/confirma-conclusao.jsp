
         <aside class="right-side" ng-controller="EdicaoConfirmaConclusaoController as edConfConclusaoCtrl">
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Edição
                     <small>{{edConfConclusaoCtrl.edicao.campeonato.descricao}} {{edConfConclusaoCtrl.edicao.descricao}}</small>
                 </h1>
                 
				<div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb">
							<li><i class="glyphicon glyphicon-ok text-success"></i> <a href="/jchampionship">Campeonato</a></li>
							<li><i class="glyphicon glyphicon-ok text-success"></i> Campeonato/Edicao</li>
							<li><i class="glyphicon glyphicon-ok text-success"></i> Grupos/Chaves</li>	
							<li><i class="glyphicon glyphicon-ok text-success"></i> Times/nos Grupos</li>	
							<li><i class="glyphicon glyphicon-ok text-success"></i> Jogos X Jogos</li>	
							<li class="text-warning" style="font-size:30px;"><i class="glyphicon glyphicon-star"></i> Confirmação</li>	
						</ol>
					</div>
				</div>                 
				                 
                 
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">Edição - Confirmação</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

				<div class="col-md-6">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Confirma Edição</h3>
                        </div><!-- /.box-header -->
    
						    <div class="row" ng-repeat="grupo in edConfConclusaoCtrl.grupos">
						        <div class="col-lg-12">
						            <div class="panel panel-info">
						                <div class="panel-heading">
						                    <h3 class="panel-title"><i class="fa fa-fw fa-table"></i> Grupo {{ g.descricao }} </h3>
						                </div>
						                <div class="panel-body">
						                    
						                    <!--  Table -->
											<table class="table table-striped table-hover well">
												<thead>
													<tr class="text-danger">
														<td >Col</td>
														<td >Time</td>
														<td >J</td>
														<td >V</td>
														<td >E</td>
														<td >D</td>
														<td >Pontos</td>
													</tr>
												<tbody id="id_tbody">
														<tr class="" ng-repeat="class in edConfConclusaoCtrl.classificacoes | filter: grupo.id">
															<td title="Colocacao" class="text-info">{{ class.colocacao }}º</td>
															<td >{{ class.time.nome }}</td>
															<td >{{ class.jogos }}</td>
															<td >{{ class.vitorias }}</td>
															<td >{{ class.empates }}</td>
															<td >{{ class.derrotas }}</td>
															<td >{{ class.pontos }}</td>
														</tr>									
												</tbody>								
											</table>    
											
											<div class="row">
											        <div class="col-lg-6" ng-repeat="jogo in edConfConclusaoCtrl.jogos | filter: grupo.id">   
											        	<h3 class="text-info">
											        		{{ jogo.timeA.nome }} <small>X</small> {{ jogo.timeB.nome }} 
											        		<small> {{ j.local.descricao }} - {{ jogo.dataHora }} </small> 
											        	</h3>
											        </div>
										    </div>
						                    
						                </div>
						            </div>
						        </div>
						    </div>
						    <!-- /.row -->
					    
					
						<a href  class="btn btn-info pull-right" ng-click="edConfConclusaoCtrl.confirmarInicioEdicao()">
							Concluir Cadastro <i class="glyphicon glyphicon-share-alt"></i>
						</a>
    
                    </div><!-- /.box -->					
				</div>	
	
		     </section>
	
		</aside>