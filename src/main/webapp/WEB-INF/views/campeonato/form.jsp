
         <aside class="right-side" ng-controller="CampeonatoFormController as campFormCtrl">
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Campeonato
                     <small>Formulário</small>
                 </h1>
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">Campeonato</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Campeonato</h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" ng-submit="campFormCtrl.save(campFormCtrl.campeonato)">
                        
                        	<input type="hidden" class="form-control" ng-model="campFormCtrl.campeonato.id">
                        
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Descrição <span class="text-muted">(Atenção: Digite um nome simples ex: Campeonato Brasileiro)</span> </label>
                                    <input type="text" class="form-control" ng-model="campFormCtrl.campeonato.descricao" required="required">
                                </div>
                            </div><!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">Salvar</button>
                                <div class="pull-right">
                                	<a ng-show="campFormCtrl.next" href="#/edicao/novo" class="btn btn-success btn-sm">Proximo</a>
                                </div>
                            </div>
                        </form>
                    </div><!-- /.box -->					
					
	
		     </section>
	
		</aside>