
         <aside class="right-side" ng-controller="JogadorInfoArtilhariaController as jogadorInfoArtilhariaCtrl">
            
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Artilharia 
                 </h1>
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">{{ jogadorInfoArtilhariaCtrl.edicao.campeonato.descricao }} {{ jogadorInfoArtilhariaCtrl.edicao.descricao }}</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

				    <h1 class="page-header text-success visible-lg visible-md visible-sm">		
						{{ jogadorInfoArtilhariaCtrl.edicao.campeonato.descricao }} {{ jogadorInfoArtilhariaCtrl.edicao.descricao }}
					</h1>
					
					<h3 class="page-header text-success visible-xs">		
						{{ jogadorInfoArtilhariaCtrl.edicao.campeonato.descricao }} {{ jogadorInfoArtilhariaCtrl.edicao.descricao }}		     	
					</h3>	
				
				            <div class="panel panel-primary">
				                <div class="panel-heading">
				                    <h3 class="panel-title"><i class="fa fa-fw fa-table"></i> Artilharia </h3>
				                </div>
				                <div class="panel-body">
				                    
				                    <!--  Table -->
				                    <div class="table-responsive">
										<table class="table table-striped table-hover well">
											<thead>
												<tr class="text-danger">
													<td >Jogador</td>
													<td>J</td>
													<td><img src="${pageContext.request.contextPath}/static/core/img/cartao-amarelo.png"/> </td>
													<td><img src="${pageContext.request.contextPath}/static/core/img/cartao-vermelho.png"/> </td>
													<td>Gols</td>
												</tr>
											</thead>
											<tbody>
												<tr ng-repeat="jie in jogadorInfoArtilhariaCtrl.jogadoresInfoEdicao | filter: edicao.id" {{ $index == 0 ? "style='font-size:25px;'" : '' }} >  
													<td>
														<a href="#/jogadorinfo/jogador/{{ jie.jogador.id }}/edicao/{{ jie.edicao.id }}" title="{{jie.jogador.nome}}">
															<img src="{{jie.jogador.uriFoto}}" class="img-circle" height="{{ $index == 0 ? 50 : 30 }}" width="{{ $index == 0 ? 50 : 30 }}"/> 
															{{ jie.jogador.nome }}
														</a>
													</td>
													<td><small>{{ jie.jogos }}</small></td>
													<td><small class="text-warning">{{ jie.cartaoAmarelo }}</small></td>
													<td><small class="text-danger">{{ jie.cartaoVermelho }}</small></td>
													<td class="text-info">{{ jie.gols }}</td> 
												</tr>
											</tbody>								
										</table>    
									</div>					
				                </div>
				            </div>
				 
					 
             </section>
	
		</aside>