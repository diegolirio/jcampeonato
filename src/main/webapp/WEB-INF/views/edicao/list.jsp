
         <aside class="right-side" ng-controller="EdicaoListController as edicaoListCtrl">
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Edições 
                     <small>Pendentes</small>
                 </h1>
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">Edições Pendentes</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

                        <div class="col-md-7">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">Edições <small><a href="#/edicao/novo" class="btn btn-default">Cadastrar Nova Edição</a></small></h3>
                                </div><!-- /.box-header -->
                                <div class="box-body">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th style="width: 10px">#</th>
                                            <th>Campeonato</th>
                                            <th>Descrição</th>
                                            <th>Tipo</th>
                                            <th style="width: 10px"></th>
                                        </tr>
                                        <tr ng-repeat="e in edicaoListCtrl.edicoes">
                                            <td>{{e.id}}</td>
                                            <td>{{e.campeonato.descricao}}</td>
                                            <td>{{e.descricao}}</td>
                                            <td>{{e.tipoEdicao.descricao}}</td>
                                            <td>
                                            	<a ng-show="edicaoListCtrl.campeonato == null" href="#/edicao/novo/{{e.id}}">Concluir</a>
                                            	<a ng-show="edicaoListCtrl.campeonato != null && false" href="#/edicao/editar/{{e.id}}/true">Editar</a>
                                            </td>
                                        </tr>
                                    </table>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                       </div>	
		     </section>
	
		</aside>