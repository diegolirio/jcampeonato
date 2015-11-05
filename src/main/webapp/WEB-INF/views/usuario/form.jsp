
         <aside class="right-side" ng-controller="UsuarioFormController as usuFormCtrl">
              
             <!-- Content Header (Page header) -->
             <section class="content-header">
                 <h2>
                     {{ usuFormCtrl.usuario.nome }}
                 </h2>
             </section>

             <!-- Main content -->
             <section class="content">
								  
					<form ng-submit="usuFormCtrl.save(usuFormCtrl.usuario)">
					
<!-- 						<div class="row"> -->
<!-- 							<div class="form-group"> -->
<!-- 								<img ng-src="{{ usuFormCtrl.jogador.uriFoto }}" class="img-circle" height="100"> -->
<!-- 							    <input type="file" ng-model="jogadorFormCtrl.jogador.uriFoto"> -->
<!-- 							</div>							 -->
<!-- 						</div> -->
						<br/>
						<div class="row">	
						    <div class="box-body">
                                <div class="form-group col-md-4">
                                    <label>Nome </label>
                                    <input type="text" class="form-control" ng-model="usuFormCtrl.usuario.nome" required="required">
                                </div>
                            </div><!-- /.box-body -->
                        </div>
                        <div class="row">
						    <div class="box-body">
                                <div class="form-group col-md-4">
                                    <label>Email </label>
                                    <input type="email" class="form-control" ng-model="usuFormCtrl.usuario.email" required="required">
                                </div>
                            </div><!-- /.box-body -->                            
                        </div>
                        <div class="row">
						    <div class="box-body">
                                <div class="form-group col-md-4">
                                    <label>Membro desde </label>
                                    <input type="text" class="form-control" ng-model="usuFormCtrl.usuario.dataCadastro" disabled="disabled">
                                </div>
                            </div><!-- /.box-body -->                            
                        </div>
                        
                        <div class="box-footer">
                        	<a href ng-click="" class="btn btn-default">Alterar senha</a>
                            <button type="submit" class="btn btn-primary">Salvar</button>
                        </div>                            
						
					</form>		
			
					 
             </section>
	
		</aside>