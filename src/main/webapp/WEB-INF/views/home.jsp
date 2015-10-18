
            <aside ng-controller="HomeController as homeCtrl" class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Quarta<span class="text-warning">Show</span>
                        <small>.com</small>
                        &nbsp; <a ng-show="usuarioLoginCtrl.isLoggedIn" href="#/edicao/pendentes" class="btn btn-success btn-sm">Criar Novo Campeonato</a>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
		                <div ng-repeat="e in homeCtrl.edicoes" class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
		                    <div class="panel panel-success">
		                        <div class="panel-heading">
		                            <div class="row">
		                                <div class="col-xs-3">
											<!-- <i class="fa fa-comments fa-5x"></i> -->
											<img alt="{{ e.id }}" src="${pageContext.request.contextPath}">
		                                </div>
		                                <div class="col-xs-9 text-right">
		                                    <div class="huge"><a href="${pageContext.request.contextPath}/edicao/{{ e.id }}">{{ e.campeonato.descricao }} <br/><span class="text-info">{{ e.descricao }}</span></a></div>
		                                    <div>{{ e.status.descricao }}</div>
		                                </div>
		                            </div>
		                        </div>
		                        <a href="${pageContext.request.contextPath}/edicao/{{ e.id }}">
		                            <div class="panel-footer">
		                                <span class="pull-left">Entrar</span>
		                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
		                                <div class="clearfix"></div>
		                            </div>
		                        </a>
		                    </div>
		                </div>
				</section>
				
			</aside>