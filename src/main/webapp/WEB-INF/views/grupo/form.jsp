
         <aside class="right-side" ng-controller="GrupoFormController as grpFormCtrl">
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Grupos
                     <small>Edição {{grpFormCtrl.edicao.campeonato.descricao}} {{grpFormCtrl.edicao.descricao}}</small>
                 </h1>
                 
				<div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb">
							<li><i class="glyphicon glyphicon-ok text-success"></i> <a href="/jchampionship">Campeonato</a></li>
							<li><i class="glyphicon glyphicon-ok text-success"></i> <a href="/jchampionship">Campeonato/Edicao</a></li>
							<li class="text-warning" style="font-size:30px;"><i class="glyphicon glyphicon-star"></i> Grupos/Chaves</li>	
							<li><i class="fa fa-edit"></i> Times/nos Grupos</li>	
							<li><i class="fa fa-edit"></i> Jogos X Jogos</li>	
							<li><i class="fa fa-edit"></i> Confirmação</li>	
						</ol>
					</div>
				</div>                     
                 
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">Grupos</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Grupo</h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" ng-submit="grpFormCtrl.save(grpFormCtrl.grupo)">
                        
                        	<input type="hidden" class="form-control" ng-model="grpFormCtrl.grupo.id">
                        
                            <div class="box-body">
                                <div class="form-group">
                                    <label>Descrição <span class="text-muted">(Ex: A, B ou Serie A para grupo unico)</span> </label>
                                    <input type="text" class="form-control" ng-model="grpFormCtrl.grupo.descricao" required="required">
                                </div>
                            </div><!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Salvar</button>
                                <div class="pull-right">
                                	<a ng-show="grpFormCtrl.next" href="#/edicao/novo" class="btn btn-success btn-sm">Proximo</a>
                                </div>
                            </div>
                        </form>
                    </div><!-- /.box -->		
                    
                    <div class="col-md-7">
                            <div class="box">
                               
                                <div class="box-body">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th style="width: 10px">#</th>
                                            <th>Descrição</th>
                                            <th style="width: 10px"></th>
                                        </tr>
                                        <tr ng-repeat="g in grpFormCtrl.grupos">
                                            <td>{{g.id}}</td>
                                            <td>{{g.descricao}}</td>
                                            <td><a href ng-click="grpFormCtrl.excluir(g)">Excluir</a></td>
                                        </tr>
                                    </table>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                    </div>	                    			
					
	
		     </section>
	
		</aside>