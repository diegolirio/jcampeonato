
         <aside class="right-side" ng-controller="CampeonatoListController as campListCtrl">
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Campeonatos
                     <small>...</small>
                 </h1>
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">Campeonatos</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">Campeonatos</h3>
                        </div><!-- /.box-header -->
                        
						<table class="table">
							<thead>
								<td>#</td>
								<td>Descrição</td>
								<td></td>
								<td></td>
							</thead>
							<tbody>
								<tr ng-repeat="upc in campListCtrl.usuarioPerfisCampeonatos">
									<td>{{upc.campeonato.id}}</td>
									<td>{{upc.campeonato.descricao}}</td>
									<td><a href="#/edicaao/lista/por/campeonato/{{upc.campeonato.id}}">Ver edições</a></td>
									<td><a ng-show="upc.perfil.id == 1" href="#/campeonato/{{upc.campeonato.id}}/editar">Editar</a></td>
								</tr>
							</tbody>
						</table>
						
                    </div><!-- /.box -->					
					
	
		     </section>
	
		</aside>