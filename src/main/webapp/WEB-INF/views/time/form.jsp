
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

				<form action="${pageContext.request.contextPath}/time/post?page=N" method="post">
					<h1 class="text-info"> {{timeFormCtrl.time.nome}}</h1>
					<div class="form-group col-lg-4">
						<label>Nome do Time <small id="id_view" class="text-warning">?</small></label> <span id="id_message_nome"></span>
						<input class="form-control" type="text" ng-model="timeFormCtrl.time.nome">
					</div>						
				 
					<br/>

					<a href="${pageContext.request.contextPath}" class="btn btn-default">Cancelar</a>
					<button	type="submit">Salvar</button>
					
					<br/><br/>
					
				</form>
			
			    <div ng-show="timeFormCtrl.time != null" class="row" >
			        <div class="col-lg-12">
			            <div class="panel panel-success"> 
			                <div class="panel-heading">
			                    <h3 class="panel-title">
			                    	<i class="fa fa-fw fa-table"></i> Jogadores
			                    	<a class="pull-right" href="${pageContext.request.contextPath}/jogador/page/simple?page=popup"><span class="text-info">Novo Jogador</span></a>	
			                    </h3> 
			                </div>
			                <div class="panel-body">
				                                
				                <form >
					                <div class="row">
					                	<div class="col-lg-8">
					                		<select ng-model="timeFormCtrl.jogador.nome" ng-options="j.nome for j in timeFormCtrl.jogadores" class="form-control"></select>
										</div>
										<div class="col-lg-2">
											<button type="submit" class="btn btn-info">Adicionar Jogador</button>
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
										<tr ng-repeat="jogador in  timeFormCtrl.jogadores"> 
											<td title="{{jogador.posicao.descricao}}">
												<img src="${pageContext.request.contextPath}/static/quartashow/img/{{jogador.posicao.imgName }}"/></td> 
											<td>{{jogador.nome}}</td>
											<td><a href="${pageContext.request.contextPath}/time/system/{{timeFormCtrl.time.id}}/remove/jogador/{{jogador.id}}"><span class="text-danger">Retirar do Time</span></a></td>
										</tr>									
									</tbody>								
								</table>                                
				                               
				                               
			                </div>
			            </div>
			        </div>
			    </div>
		    
		     </section>
	
		</aside>