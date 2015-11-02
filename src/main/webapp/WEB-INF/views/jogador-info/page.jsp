
         <aside class="right-side" ng-controller="JogadorInfoPageController as jogadorInfoPgCtrl">
              
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h2>
                     {{ jogadorInfoPgCtrl.jogador.nome }}
   		    		 <a ng-show="usuarioLoginCtrl.isLoggedIn && (jogadorInfoPgCtrl.usuarioPerfilCampeonato.perfil.id == 1 || jogadorInfoPgCtrl.usuarioPerfilCampeonato.perfil.id == 2)" href="#/jogador/{{ jogadorInfoPgCtrl.jogador.id }}">
		   				<span class="glyphicon glyphicon-pencil text-muted"></span>
		   			 </a>
                     <small>
                     	{{ jogadorInfoPgCtrl.edicao.campeonato.descricao }}
                     	{{ jogadorInfoPgCtrl.edicao.descricao }}
                     </small>
                 </h2>
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">{{ jogadorInfoPgCtrl.edicao.campeonato.descricao }} {{ jogadorInfoPgCtrl.edicao.descricao }}</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">
								  
					<div class="table-responsive visible-lg visible-md visible-sm">
						<table class="table">
							<tbody>
								<tr>
									<td><img src="{{ jogadorInfoPgCtrl.jogador.uriFoto }}" class="img-circle" height="100"></td>
									<td><h1 class="page-header text-primary">{{ jogadorInfoPgCtrl.jogador.nome }} <small>...</small></h1></td>
									<td><h1><small class="text-success">R$ 0,00</small></h1></td>
									<td></td>
								</tr> 
							</tbody>
						</table>
					</div>
					
					<div class="visible-xs text-center">
						<p><img src="{{ jogadorInfoPgCtrl.jogador.uriFoto }}" class="img-circle" height="100"></p>
						<h2 class="page-header text-primary">{{ jogadorInfoPgCtrl.jogador.nome }} </h2>
						<p><small>...</small></p>
						<h3><small class="text-success">R$ 0,00</small></h3>
						<br/><br/><br/>  
					</div>
				
					    <div class="row" ng-show="jogadorInfoPgCtrl.jogadorInfoEdicao != null">
					    	<table class="table text-center">
					    		<thead class="text-success">
					    			<tr>
					    				<td colspan="4">
					    					<b>{{jogadorInfoPgCtrl.jogadorInfoEdicao.edicao.campeonato.descricao }} 
					    					{{jogadorInfoPgCtrl.jogadorInfoEdicao.edicao.descricao}}</b>
					    				</td>
					    			</tr>
					    		</thead>	    	
					    		<thead class="text-danger">
					    			<tr>
					    				<td>jogos</td>
					    				<td>C. Amarelo</td>
					    				<td>C. Vermelho</td>
					    				<td>Gols</td>
					    			</tr>
					    		</thead>	    	
					    		<tbody>
					    			<tr>
					    				<td>{{jogadorInfoPgCtrl.jogadorInfoEdicao.jogos}}</td>
					    				<td>{{jogadorInfoPgCtrl.jogadorInfoEdicao.cartaoAmarelo}}</td>
					    				<td>{{jogadorInfoPgCtrl.jogadorInfoEdicao.cartaoVermelho}}</td>
					    				<td>{{jogadorInfoPgCtrl.jogadorInfoEdicao.gols}}</td>
					    			</tr>
					    		</tbody>
					    	</table>
					    	
					    	<!-- jogos -->
					    	<div ng-show="jogadorInfoPgCtrl.jogadorInfoEdicao.gols > 0">
					    		<div class="row">
					    			<center>Jogos em que marcou gols</center> 
					    		</div>
					    		<div class="row">
								    <div class="col-lg-4 col-md-6 col-sm-12 col-xs-12" ng-repeat="jogo in jogadorInfoPgCtrl.jogosComGols">   
								      	
								      		<div class="table-responsive">
								      			<a href="#/jogo/{{jogo.id}}/resultado">
									        		<table class="table well text-center">
									        			<tbody >
									        				<tr>
									        					<td><h4 class="text-info">{{ jogo.timeA.nome }}</h4></td>
									        					<td><h4 class="text-danger" ng-show="jogo.status.id != 1">{{ jogo.resultadoA }}</h4></td>	
																<td><h4 class="text-muted">X</h4></td>
																<td><h4 class="text-danger" ng-show="jogo.status.id != 1">{{ jogo.resultadoB }}</h4></td>
												        		<td><h4 class="text-info">{{ jogo.timeB.nome }}</h4></td>											        					
									        				</tr>
									        			</tbody>
									        		</table>
								        	    </a>
								            </div>   
								      </div>
								 </div>        
					    	</div>
					    	<!-- fim jogos -->
					    	
					    </div>
					 
             </section>
	
		</aside>