
<div ng-controller="EscalacaoAddEventoController as escalacaoAddEventoCtrl">


	{{ escalacaoAddEventoCtrl.titulo }}

	<form ng-submit="escalacaoAddEventoCtrl.addEvento(evento)">

		<h1>Adicionar {{ escalacaoAddEventoCtrl.evento.descricao }}</h1>
		
		<div class="form-group col-lg-4">
			<label>Jogador</label>
			<select class="form-control" ng-model="escalacaoAddEventoCtrl.jogadores" ng-options="j.nome for j in escalacaoAddEventoCtrl.jogadores"></select>
		</div>						
	 
		<br/>
			
		<a href class="btn btn-default" onclick="window.close();">Cancelar</a>
		
		<input class="btn btn-success saveEventoJogadorEscalado" type="submit" value="Salvar">
			
		<br/><br/>
		
	</form>
</div>