
         <aside class="right-side" ng-controller="EdicaoFormController as edicaoFormCtrl">
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Edição
                     <small>{{edicaoFormCtrl.edicao.campeonato.descricao}} {{edicaoFormCtrl.edicao.descricao}}</small>
                 </h1>
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">Edição</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Edição</h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" ng-submit="edicaoFormCtrl.save(edicaoFormCtrl.edicao)">
                        
                        	<input type="hidden" class="form-control" ng-model="edicaoFormCtrl.edicao.id">
                        
                            <div class="box-body">
                                <div class="form-group">
                                    <label>Campeonato </label>
                        			<select ng-model="edicaoFormCtrl.edicao.campeonato" ng-options="c.descricao for c in edicaoFormCtrl.campeonatos" class="form-control"></select>
                        		</div>
                        	</div>
                        
                            <div class="box-body">
                                <div class="form-group">
                                    <label>Descrição <span class="text-muted">(Exemplo: Digite por exemplo o ano: 2015)</span> </label>
                                    <input type="text" class="form-control" ng-model="edicaoFormCtrl.edicao.descricao" required="required">
                                </div>
                            </div><!-- /.box-body -->
                            
                            <div class="box-body">
                                <div class="form-group">
                                    <label>Tipo </label>
                        			<select ng-model="edicaoFormCtrl.edicao.tipo" ng-options="t.descricao for t in edicaoFormCtrl.tipos" class="form-control"></select>
                        		</div>
                        	</div>                            
 
                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Salvar</button>
                                <div class="pull-right">
                                	<a ng-show="edicaoFormCtrl.next" href="#/grupos/novo" class="btn btn-success btn-sm">Anterior</a>
                                	<a ng-show="edicaoFormCtrl.next" href="#/grupos/novo" class="btn btn-success btn-sm">Proximo >>></a>
                                </div>
                            </div>
                        </form>
                    </div><!-- /.box -->					
					
	
		     </section>
	
		</aside>