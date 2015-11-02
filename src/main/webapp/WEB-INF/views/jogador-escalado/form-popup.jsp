
<div ng-controller="JogadorEscaladoFormPopupController as jogadorEscFormPopupCtrl">

		<h3 class="text-center">
			Adicionar Jogador na Escalação
			<br/>
			Para <span class="text-danger">{{ jogadorEscFormPopupCtrl.time.nome }}</span>
		</h3>
			
		<form ng-submit="jogadorEscFormPopupCtrl.save(jogadorEscFormPopupCtrl.jogadorEscalado)">
	
			<div class="form-group col-lg-4 col-md-6">
				<label>Jogadores</label>
				<select class="form-control" ng-model="jogadorEscFormPopupCtrl.jogadorEscalado.jogador" 
						ng-options="(j.nome) for j in jogadorEscFormPopupCtrl.jogadoresNaoEscalados"></select>
			</div>						
			<br/>
			<input class="btn btn-success" type="submit" value="Salvar">
			<a href class="btn btn-default" onclick="window.close();">Cancelar</a>
			

		</form>
	
</div>