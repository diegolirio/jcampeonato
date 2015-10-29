
         <aside class="right-side" ng-controller="JogadorInfoArtilhariaController as jogadorInfoArtilhariaCtrl">
            
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h1>
                     Artilharia 
                 </h1>
                 <ol class="breadcrumb">
                     <li><a href="${pageContext.request.contextPath}"><i class="fa fa-dashboard"></i> Home</a></li>
                     <li class="active">{{ jogadorInfoArtilhariaCtrl.edicao.campeonato.descricao }} {{ jogadorInfoArtilhariaCtrl.edicao.descricao }}</li>
                 </ol>
             </section>

             <!-- Main content -->
             <section class="content">

				    <h1 class="page-header text-success visible-lg visible-md visible-sm">		
						{{ jogadorInfoArtilhariaCtrl.edicao.campeonato.descricao }} {{ jogadorInfoArtilhariaCtrl.edicao.descricao }}
					</h1>
					
					<h3 class="page-header text-success visible-xs">		
						{{ jogadorInfoArtilhariaCtrl.edicao.campeonato.descricao }} {{ jogadorInfoArtilhariaCtrl.edicao.descricao }}		     	
					</h3>	
				
					 
					 
					 
             </section>
	
		</aside>