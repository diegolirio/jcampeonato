
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
								<a href="${pageContext.request.contextPath}/harbito/page/simple" onclick="showWindowPopup(this.href, 400, 600); return false;"><i class="glyphicon glyphicon-plus"></i></a> 
								<select class="form-control" id="id_harbitos" name="harbito.id">
									<option value="" selected="selected">Selecione o Harbito...</option>
								</select>
							</div>						
			
							<div class="form-group col-lg-3">
								<label>Local </label> 
								<a href="${pageContext.request.contextPath}/local/page/simple" onclick="showWindowPopup(this.href, 400, 600); return false;"><i class="glyphicon glyphicon-plus"></i></a>
								<select class="form-control" id="id_locais" name="local.id">
									<option value="" selected="selected">Selecione o Local...</option>
								</select>
							</div>						

							<div class="form-group col-lg-2">
								<label>Data e Hora </label> <span id="id_message_datahora"></span>
								<input class="form-control datepicker" type="text" name="dataHora" value="${jogo.dataHoraStrEN}">
							</div>

							<div class="form-group col-lg-5">
								<label>Time A </label> <span id="id_message_timea"></span>
								<select class="form-control" id="id_timea" name="timeA.id" ${not empty jogo ? 'disabled="disabled"' : ''}>
									<option value="" selected="selected">Selecione o Time A...</option>
								</select>
							</div>						
							<div class="form-group col-lg-2 text-center text-muted"><h1>X</h1></div>
							<div class="form-group col-lg-5">
								<label>Time B </label> <span id="id_message_timeb"></span> 
								<select class="form-control" id="id_timeb" name="timeB.id" ${not empty jogo ? 'disabled="disabled"' : ''}>
									<option value="" selected="selected">Selecione o Time B...</option>
								</select>
							</div>																														
			
							<br/>
							
							<a href="${pageContext.request.contextPath}/jogo/delete_confirm/${jogo.id}" onclick="showWindowPopup(this.href); return false;" class="btn btn-danger pull-right">Excluir</a>			
							<input type="submit" class="btn btn-success pull-right" value="${not empty jogo ? 'Salvar' : 'Adicionar Jogo'}" >
			
                        </form>
                     </div>
                  </div><!-- /.box -->		
                  
		     </section>
	
		</aside>