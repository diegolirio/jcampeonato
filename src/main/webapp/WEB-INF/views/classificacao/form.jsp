
         <aside class="right-side" ng-controller="ClassificacaoFormController as classFormCtrl">
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Times ...
                     <small>Edição {{classFormCtrl.edicao.campeonato.descricao}} {{classFormCtrl.edicao.descricao}} - classificacao</small>
                 </h1>
                 
				<div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb">
							<li><i class="glyphicon glyphicon-ok text-success"></i> <a href="/jchampionship">Campeonato</a></li>
							<li><i class="glyphicon glyphicon-ok text-success"></i> <a href="/jchampionship">Campeonato/Edicao</a></li>
							<li><i class="glyphicon glyphicon-ok text-success"></i> <a href="/jchampionship">Grupos/Chaves</a></li>	
							<li class="text-warning" style="font-size:30px;"><i class="glyphicon glyphicon-star"></i> Times/nos Grupos</li>	
							<li><i class="fa fa-edit"></i> Jogos X Jogos</li>	
							<li><i class="fa fa-edit"></i> Confirmação</li>	
						</ol>
					</div>
				</div>                     
                 
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">Classificacao</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Adicionar Times nos Grupos</h3>
                        </div><!-- /.box-header -->
                        
                        <!-- form start -->
						<div class="col-lg-12">
				
									<form ng-submit="classFormCtrl.save(classFormCtrl.classificacao)" name="formClass">
				
										<input type="hidden" class="form-control" ng-model="classFormCtrl.classificacao.id">
				
										<div class="form-group col-lg-4" >
											<label>Time </label>
											<a href="/jchampionship/time/page/simple?idSelected=id_times" onclick="showWindowPopup(this.href, 750, 900); return false;"><i class="glyphicon glyphicon-plus"></i></a>
											<select ng-model="classFormCtrl.classificacao.time" ng-options="t.nome for t in classFormCtrl.times" class="form-control" required="required"></select> 
										</div>
										
										<div class="form-group col-lg-4">
											<label>Grupo </label> <span id="id_message_grupo"></span>
											<select ng-model="classFormCtrl.classificacao.grupo" ng-options="g.descricao for g in classFormCtrl.grupos" class="form-control" required="required"></select>
										</div>
										
										<br/>
										
										<button class="btn btn-success" ng-disabled="formClass.$invalid">
											Adicionar Time ao Grupo
										</button>
													
						                 <div class="pull-right">
						                 	<a href="#/jogo/novo/edicao/{{classFormCtrl.edicao.id}}" class="btn btn-primary btn-sm">Proximo</a>
						                 </div>					
										
				
									</form>
														
						</div>
                    </div><!-- /.box -->		
                    
                    <div class="col-md-7" ng-repeat="g in classFormCtrl.grupos">
                            <div class="box">
                                <h2>Grupo {{g.descricao}}</h2>
                                <div class="box-body">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th style="width: 10px">#</th>
                                            <th>Descrição</th>
                                            <th style="width: 10px"></th>
                                        </tr>
                                        <tr ng-repeat="c in classFormCtrl.classificacoes | filter: g.id"> 
                                            <td>{{c.id}}</td>
                                            <td>{{c.time.nome}} - {{ c.grupo.descricao }}</td>
                                            <td><a href ng-click="classFormCtrl.excluir(c)">Excluir</a></td>
                                        </tr>
                                    </table>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                    </div>

		     </section>
	
		</aside>