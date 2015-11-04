
         <aside class="right-side" ng-controller="JogadorFormController as jogadorFormCtrl">
              
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h2>
                     {{ jogadorFormCtrl.jogador.nome }}
                 </h2>
             </section>

             <!-- Main content -->
             <section class="content">
								  
					<form ng-submit="jogadorFormCtrl.save(jogadorFormCtrl.jogador)">
					
						<div class="row">
							<div class="form-group">
								<img ng-src="{{ jogadorFormCtrl.jogador.uriFoto }}" class="img-circle" height="100">
							    <input type="file" ng-model="jogadorFormCtrl.jogador.uriFoto">
							</div>							
						</div>
						<br/>
						<div class="row">	
						    <div class="box-body">
                                <div class="form-group col-md-4">
                                    <label>Nome </label>
                                    <input type="text" class="form-control" ng-model="jogadorFormCtrl.jogador.nome" required="required">
                                </div>
                            </div><!-- /.box-body -->
                        </div>
                        <div class="row">
						    <div class="box-body">
                                <div class="form-group col-md-4">
                                    <label>Apelido </label>
                                    <input type="text" class="form-control" ng-model="jogadorFormCtrl.jogador.apelido" >
                                </div>
                            </div><!-- /.box-body -->                            
                        </div>
                        
                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                        </div>                            
						
					</form>		
			
					 
             </section>
	
		</aside>