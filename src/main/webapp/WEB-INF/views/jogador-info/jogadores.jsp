
         <aside class="right-side" ng-controller="JogadorInfoJogadoresController as jogadorInfoJogadoresCtrl">
            
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Jogadores 
                 </h1>
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">{{ jogadorInfoJogadoresCtrl.edicao.campeonato.descricao }} {{ jogadorInfoJogadoresCtrl.edicao.descricao }}</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

				    <h1 class="page-header text-success visible-lg visible-md visible-sm">		
						{{ jogadorInfoJogadoresCtrl.edicao.campeonato.descricao }} {{ jogadorInfoJogadoresCtrl.edicao.descricao }}
					</h1>
					
					<h3 class="page-header text-success visible-xs">		
						{{ jogadorInfoJogadoresCtrl.edicao.campeonato.descricao }} {{ jogadorInfoJogadoresCtrl.edicao.descricao }}		     	
					</h3>	
				
				            <div class="panel panel-primary">
				                <div class="panel-heading">
				                    <h3 class="panel-title"><i class="fa fa-fw fa-table"></i> Jogadores </h3>
				                </div>
				                <div class="panel-body">
				                    
				                    <!--  Table -->
				                    <div class="table-responsive">
										<table class="table table-striped table-hover well">
											<thead>
												<tr class="text-danger">
													<td >#</td>
													<td >Jogador</td>
												</tr>
											</thead>
											<tbody>
												<tr ng-repeat="jie in jogadorInfoJogadoresCtrl.jogadoresInfoEdicao | filter: edicao.id" >  
													<td><small>{{ jie.jogador.id }}</small></td>
													<td>
														<a href="#/jogadorinfo/jogador/{{ jie.jogador.id }}/edicao/{{ jie.edicao.id }}" title="{{jie.jogador.nome}}">
															<img ng-src="{{jie.jogador.uriFoto}}" class="img-circle" height="30" width="30"/> 
															{{ jie.jogador.nome }}
														</a>
													</td>
												</tr>
											</tbody>								
										</table>    
									</div>					
				                </div>
				            </div>
				 
					 
             </section>
	
		</aside>