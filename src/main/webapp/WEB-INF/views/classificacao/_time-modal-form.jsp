		
		<!-- ------------------------------------------------------ -->
		<!-- Não tem Controller é controlado pela pagina que inclui -->
		<!-- ------------------------------------------------------ -->
		
		<!-- Modal -->
		<div class="modal fade" id="id-time-modal-form" tabindex="-1" role="dialog" aria-labelledby="id-modal-form-label">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		    	
		    	<form ng-submit="classFormCtrl.saveTime(classFormCtrl.time, classFormCtrl.edicao.campeonato)">
			      
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="id-modal-form-label">Cadastro de Time</h4>
			      </div>
			      <div class="modal-body">
			        	
		                <div class="box-body">
		                    <div class="form-group">
		                        <label for="exampleInputEmail1">Time <span class="text-muted"> (Nome do time) </span> </label>
		                        <input type="text" class="form-control" ng-model="classFormCtrl.time.nome" required="required">
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