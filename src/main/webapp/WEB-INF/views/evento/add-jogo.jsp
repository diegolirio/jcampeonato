
<div ng-controller="EscalacaoAddEventoController as escalacaoAddEventoCtrl">


	<form ng-submit="escalacaoAddEventoCtrl.addEvento(escalacaoAddEventoCtrl.jogador)">

		<h1>Adicionar {{ escalacaoAddEventoCtrl.evento.descricao }} para {{ escalacaoAddEventoCtrl.jogador.nome }}</h1>
		
		<div class="form-group col-lg-4 col-md-6">
			<label>Jogadores {{ escalacaoAddEventoCtrl.jogo.timeA.nome }}</label>
			<select class="form-control" ng-model="escalacaoAddEventoCtrl.jogador" ng-options="j.nome for j in escalacaoAddEventoCtrl.jogadoresA"></select>
		</div>						
	 
		<div class="form-group col-lg-4 col-md-6">
			<label>Jogadores {{ escalacaoAddEventoCtrl.jogo.timeB.nome }}</label>
			<select class="form-control" ng-model="escalacaoAddEventoCtrl.jogador" ng-options="j.nome for j in escalacaoAddEventoCtrl.jogadoresB"></select>
		</div>						
	 
		<br/>
			
		<a href class="btn btn-default" onclick="window.close();">Cancelar</a>
		
		<input class="btn btn-success saveEventoJogadorEscalado" type="submit" value="Salvar">
			
		<br/><br/>
		
	</form>
</div>