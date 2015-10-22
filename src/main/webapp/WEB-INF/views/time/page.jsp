
         <aside class="right-side" ng-controller="TimePageController as timePageCtrl">
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Edição
                     <small>{{timePageCtrl.edicao.campeonato.descricao}} {{timePageCtrl.edicao.descricao}}</small>
                 </h1>
                 
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">Edição</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">
			
				<h1 class="page-header">
					{{ timePageCtrl.time.nome }} 
		    		<a ng-show="true" href="#/time/{{ timePageCtrl.time.id }}">
		   				<span class="glyphicon glyphicon-pencil text-muted"></span>
		   			</a>
			   		</c:if>
				</h1>				
	
		     </section>
	
		</aside>