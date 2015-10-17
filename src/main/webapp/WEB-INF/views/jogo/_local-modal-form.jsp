		
		<!-- ------------------------------------------------------ -->
		<!-- Não tem Controller é controlado pela pagina que inclui -->
		<!-- ------------------------------------------------------ -->
		
		<!-- Modal -->
		<div class="modal fade" id="id-local-modal-form" tabindex="-1" role="dialog" aria-labelledby="id-local-modal-form-label">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		    	
		    	<form ng-submit="jgFormCtrl.saveLocal(jgFormCtrl.local, jgFormCtrl.edicao.campeonato)">
			      
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="id-local-modal-form-label">Cadastro de Local</h4>
			      </div>
			      <div class="modal-body">
			        	
		                <div class="box-body">
		                    <div class="form-group">
		                        <label>Local <span class="text-muted"> (Descrição do local) </span> </label>
		                        <input type="text" class="form-control" ng-model="jgFormCtrl.local.descricao" required="required">
		                    </div>
		                </div><!-- /.box-body -->	      		  	
			        	
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
			        <button type="submit" class="btn btn-primary">Salvar</button>
			      </div>
			      
			   </form>
			   
		    </div>
		  </div>
		</div>