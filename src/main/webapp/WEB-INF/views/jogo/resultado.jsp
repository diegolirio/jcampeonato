
         <aside class="right-side" ng-controller="JogoResultadoController as jgResultCtrl">
            
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Edições 
                     <small>Pendentes</small>
                 </h1>
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">{{ jgResultCtrl.edicao.campeonato.descricao }} {{ jgResultCtrl.edicao.descricao }}</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">
			             
					<!-- Placar Responsive -->
					<h1 class="page-header col-lg-12 col-md-12 col-sm-12 visible-lg visible-md visible-sm"> 
						<span class="text-center col-md-4"><a href="#/time/{{ jgResultCtrl.jogo.timeA.id }}/edicao/{{ jgResultCtrl.jogo.grupo.edicao.id }}">{{ jgResultCtrl.jogo.timeA.nome }}</a></span>
						<span class="text-center text-danger col-md-1" id="id_rA" >{{ jgResultCtrl.jogo.resultadoA }}</span>
						<span class="text-center text-muted col-md-1">X</span>
						<span class="text-center text-danger col-md-1" id="id_rB">{{ jgResultCtrl.jogo.resultadoB }}</span>
						<span class="text-center col-md-4"><a href="#/time/{{ jgResultCtrl.jogo.timeB.id }}/edicao/{{ jgResultCtrl.jogo.grupo.edicao.id }}">{{ jgResultCtrl.jogo.timeB.nome }}</a></span>
					</h1>		
					<div class="page-header col-xs-12 visible-xs text-center">
						<table class="table">
							<tr>
								<td><h3 class="text-center col-md-4"><a href="#/time/{{ jgResultCtrl.jogo.timeA.id }}/edicao/{{ jgResultCtrl.jogo.grupo.edicao.id }}">{{ jgResultCtrl.jogo.timeA.nome }}</a></h3></td>
								<td><h3 class="text-center text-danger col-md-1" >{{ jgResultCtrl.jogo.resultadoA }}</h3></td>
							</tr>
							<tr>
								<td><h3 class="text-center col-md-4"><a href="#/time/{{ jgResultCtrl.jogo.timeB.id }}/edicao/{{ jgResultCtrl.jogo.grupo.edicao.id }}">{{ jgResultCtrl.jogo.timeB.nome }}</a></h3></td>
								<td><h3 class="text-center text-danger col-md-1" id="id_rB">{{ jgResultCtrl.jogo.resultadoB }}</h3></td>
							</tr>
						</table>		
					</div>
					<!-- Fim Placar Responsive -->
					 
					<div class="text-muted pull-right">
						<p class="text-primary"> 
							<img src="${pageContext.request.contextPath}/static/quartashow/img/{{ jgResultCtrl.jogo.status.imgName }}" /> {{ jgResultCtrl.jogo.status.descricao }}
						</p>
						<p>Rodada: {{ jgResultCtrl.jogo.rodada }}</p>		
						<p>Local: {{ jgResultCtrl.jogo.local.descricao }} / Harbito: {{ jgResultCtrl.jogo.harbito.nome }}</p>  
						<p>Data: <fmt:formatDate value="{{ jgResultCtrl.jogo.dataHora }} </p>
					</div>

			    
             </section>
	
		</aside>