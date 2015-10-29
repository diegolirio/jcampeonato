
         <aside class="right-side" ng-controller="JogoFormController as jgFormCtrl">
             
             <jsp:include page="_harbito-modal-form.jsp"></jsp:include>
             <jsp:include page="_local-modal-form.jsp"></jsp:include>
             
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Jogos
                     <small>Edição {{jgFormCtrl.edicao.campeonato.descricao}} {{jgFormCtrl.edicao.descricao}}</small>
                 </h1>
                 
				<div class="row"> 
					<div class="col-lg-12">
						<ol class="breadcrumb">
							<li><i class="glyphicon glyphicon-ok text-success"></i> <a href="/jchampionship">Campeonato</a></li>
							<li><i class="glyphicon glyphicon-ok text-success"></i> <a href="/jchampionship">Campeonato/Edicao</a></li>
							<li><i class="glyphicon glyphicon-ok text-success"></i> <a href="/jchampionship">Grupos/Chaves</a></li>	
							<li><i class="glyphicon glyphicon-ok text-success"></i> <a href="/jchampionship">Times/nos Grupos</a></li>	
							<li class="text-warning" style="font-size:30px;"><i class="glyphicon glyphicon-star"></i>Jogos X Jogos</li>	
							<li><i class="fa fa-edit"></i> Confirmação</li>	
						</ol>
					</div>
				</div>                     
                 
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">Jogos</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">
				<div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Jogo</h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" ng-submit="jgFormCtrl.save(jgFormCtrl.jogo)">
                        
                        	<input type="hidden" ng-model="jgFormCtrl.jogo.id">
							<input type="hidden" ng-model="jgFormCtrl.jogo.status.id" >
							<input type="hidden" ng-model="jgFormCtrl.jogo.sequencia" >

							<div class="form-group col-lg-1">
								<label><small>Rodada</small> </label> 
								<input class="form-control" type="text" ng-model="jgFormCtrl.jogo.rodada">
							</div>

							<div class="form-group col-lg-3">
								<label>Grupo </label> 
								<select class="form-control" ng-model="jgFormCtrl.jogo.grupo" ng-options="g.descricao for g in jgFormCtrl.grupos"></select> 
							</div>

							<div class="form-group col-lg-3">
								<label>Harbito </label> 
								<a href  data-toggle="modal" data-target="#id-harbito-modal-form"><i class="glyphicon glyphicon-plus"></i></a> 
								<select class="form-control" ng-model="jgFormCtrl.jogo.harbito" ng-options="h.nome for h in jgFormCtrl.harbitos"></select>
							</div>						
			
							<div class="form-group col-lg-3">
								<label>Local </label> 
								<a href  data-toggle="modal" data-target="#id-local-modal-form"><i class="glyphicon glyphicon-plus"></i></a>
								<select class="form-control" ng-model="jgFormCtrl.jogo.local" ng-options="l.descricao for l in jgFormCtrl.locais"></select>
							</div>						

							<div class="form-group col-lg-2">
								<label>Data e Hora </label>
								<input class="form-control datepicker" type="text" ng-model="jgFormCtrl.jogo.dataHora">
							</div>

							<div class="form-group col-lg-5">
								<label>Time A </label> <span id="id_message_timea"></span>
								<select class="form-control" ng-model="jgFormCtrl.jogo.timeA" ng-options="t.nome for t in jgFormCtrl.times"></select>
							</div>						
							<div class="form-group col-lg-2 text-center text-muted"><h1>X</h1></div>
							<div class="form-group col-lg-5">
								<label>Time B </label> <span id="id_message_timeb"></span> 
								<select class="form-control" ng-model="jgFormCtrl.jogo.timeB" ng-options="t.nome for t in jgFormCtrl.times"></select>
							</div>																														
			
							<br/>

							<div class="pull-right">
            	                <input type="submit" class="btn btn-success btn-sm" value="Salvar" >
                               	<a ng-show="jgFormCtrl.modoEdicao != true && jgFormCtrl.jogos.length > 0 && jgFormCtrl.edicao.id == 1" href="#/edicao/{{jgFormCtrl.edicao.id}}/confirma/conclusao" class="btn btn-info btn-sm">Proximo</a>
                            </div>							
							
							
                        </form>
                     </div>
                  </div><!-- /.box -->		
				                  
				  <div ng-hide="jgFormCtrl.modoEdicao == true" class="col-lg-12">
						<table class="table table-striped table-hover well">
							<thead class="text-center">
								<tr class="text-danger">
									<!-- <td>ID</td> -->
									<td >Sequencia</td>
									<td >Rodada</td>
									<td >Grupo</td>
									<td >Time A</td>
									<td ></td>
									<td class="text-center text-muted"></td>
									<td ></td>
									<td >Time B</td>
									<td >Local</td>
									<td >Harbito</td>
									<td>Data</td>
									<td title="Excluir">Excluir</td>
								<tr>
							</thead>
							<tbody>
								<tr class="text-center" ng-repeat="j in jgFormCtrl.jogos">
									<td><small class="text-muted">{{ j.sequencia }}</small></td>
									<td >{{ j.rodada }}</td>
									<td >{{ j.grupo.descricao }}</td>
									<td >{{ j.timeA.nome }}</td>
									<td >{{j.resultadoA }}</td>
									<td class="text-muted">X</td>
									<td >{{ j.resultadoB }}</td>
									<td >{{ j.timeB.nome }}</td>
									<td >{{ j.local.descricao }}</td>    
									<td >{{ j.harbito.nome }}</td>
									<td >{{ j.dataHora }} </td>
									<td ng-show="j.status.id == 1"><a href ng-click="jgFormCtrl.deleteJogo(j)">excluir</a></td>
								</tr>
							</tbody>								
						</table>       				
				 </div>                  
                  
                  
		     </section>
	
		</aside>