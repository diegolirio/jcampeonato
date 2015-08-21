
         <aside class="right-side" ng-controller="JogoFormController as jgFormCtrl">
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
                     <li class="active">Grupos</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Jogo</h3>
                        </div><!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" ng-submit="jgFormCtrl.save(jgFormCtrl.grupo)">
                        
                        	<input type="hidden" class="form-control" ng-model="jgFormCtrl.grupo.id">
                        
                            <div class="box-footer"> 
                                <button type="submit" class="btn btn-primary">Salvar</button>
                                <div class="pull-right">
                                	<a ng-show="jgFormCtrl.next" href="#/classificacao/novo/edicao/{{jgFormCtrl.edicao.id}}" class="btn btn-success btn-sm">Proximo</a>
                                </div>
                            </div>
                        </form>
                        
                    </div><!-- /.box -->		
                  
		     </section>
	
		</aside>