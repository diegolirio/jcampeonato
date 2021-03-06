
         <aside class="right-side" ng-controller="EdicaoFormController as edicaoFormCtrl">
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Edi��o
                     <small>{{edicaoFormCtrl.edicao.campeonato.descricao}} {{edicaoFormCtrl.edicao.descricao}}</small>
                 </h1>
                 
				<div class="row">
					<div class="col-lg-12">
						<ol class="breadcrumb">
							<li><i class="glyphicon glyphicon-ok text-success"></i> <a href="/jchampionship">Campeonato</a></li>
							<li class="text-warning" style="font-size:30px;"><i class="glyphicon glyphicon-star"></i> Campeonato/Edicao</li>
							<li><i class="fa fa-edit"></i> Grupos/Chaves</li>	
							<li><i class="fa fa-edit"></i> Times/nos Grupos</li>	
							<li><i class="fa fa-edit"></i> Jogos X Jogos</li>	
							<li><i class="fa fa-edit"></i> Confirma��o</li>	
						</ol>
					</div>
				</div>                 
				                 
                 
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">Edi��o</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

				<div class="col-md-6">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Edi��o</h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" ng-submit="edicaoFormCtrl.save(edicaoFormCtrl.edicao)">
                        
                            <div class="box-body">
                                <div class="form-group">
                                    <label>Campeonato <a href="#/campeonato/novo"><span class="glyphicon glyphicon-plus"></span></a> </label>
                        			<select ng-model="edicaoFormCtrl.edicao.campeonato" ng-options="c.descricao for c in edicaoFormCtrl.campeonatos" class="form-control"></select>
                        		</div>
                        	</div>
                        
                            <div class="box-body">
                                <div class="form-group">
                                    <label>Descri��o <span class="text-muted">(Exemplo: Digite por exemplo o ano: 2015)</span> </label>
                                    <input type="text" class="form-control" ng-model="edicaoFormCtrl.edicao.descricao" required="required">
                                </div>
                            </div><!-- /.box-body -->
                            
                            <div class="box-body">
                                <div class="form-group">
                                    <label>Tipo </label>
                        			<select ng-model="edicaoFormCtrl.edicao.tipoEdicao" ng-options="t.descricao for t in edicaoFormCtrl.tipos" class="form-control"></select>
                        		</div>
                        	</div>                            
 
                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Salvar</button>
                                <a href="#/edicao/pendentes" class="btn btn-default">Pendentes</a>
                                <div class="pull-right">
                                	<a ng-show="edicaoFormCtrl.next" href="#/grupos/novo" class="btn btn-success btn-sm">Anterior</a>
                                	<a ng-show="edicaoFormCtrl.next" href="#/grupos/novo" class="btn btn-success btn-sm">Proximo >>></a>
                                </div>
                            </div>
                        </form>
                    </div><!-- /.box -->					
				</div>	
	
		     </section>
	
		</aside>