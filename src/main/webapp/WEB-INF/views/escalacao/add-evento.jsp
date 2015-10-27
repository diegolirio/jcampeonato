
<div ng-controller="EscalacaoAddEventoController as escalacaoAddEventoCtrl">


	<form ng-submit="escalacaoAddEventoCtrl.addEvento(escalacaoAddEventoCtrl.jogadorEscalado)">

		<h1>
			Adicionar {{ escalacaoAddEventoCtrl.evento.descricao }} para 
			<span class="text-success">{{ escalacaoAddEventoCtrl.jogadorEscalado.jogador.nome }}<small> {{ escalacaoAddEventoCtrl.jogadorEscalado.time.nome }}</small></span>
		</h1>
		
		<div class="form-group col-lg-4 col-md-6">
			<label>Jogadores {{ escalacaoAddEventoCtrl.escalacao.jogo.timeA.nome }}</label>
			<select class="form-control" ng-model="escalacaoAddEventoCtrl.jogadorEscalado" ng-options="(j.jogador.nome + ' - ' + j.time.nome) for j in escalacaoAddEventoCtrl.escalacao.jogadoresEscalados"></select>
		</div>						
	 
<!-- 		<div class="form-group col-lg-4 col-md-6"> -->
<!-- 			<label>Jogadores {{ escalacaoAddEventoCtrl.jogo.timeB.nome }}</label> -->
<!-- 			<select class="form-control" ng-model="escalacaoAddEventoCtrl.jogador" ng-options="j.nome for j in escalacaoAddEventoCtrl.jogadoresB"></select>   -->
<!-- 		</div>						 -->
	 
		<br/>
			
		<a href class="btn btn-default" onclick="window.close();">Cancelar</a>
		
		<input class="btn btn-success saveEventoJogadorEscalado" type="submit" value="Salvar">
			
		<br/><br/>
		
	</form>
</div>