
<div ng-controller="JogadorEscaladoRemoveEventoController as jogadorEscRmvEvController">


		<h1>
			Remover evento <span class="text-danger">{{ jogadorEscRmvEvController.jogadorEscalado.jogador.nome }}</span>  
			<small> {{ jogadorEscRmvEvController.jogadorEscalado.time.nome }}</small>
		</h1>
		
		<table class="table">
			<thead>
				<tr>
					<td>Evento</td>
					<td></td>
				</tr>					
			</thead>
			<tbody>
				<tr ng-repeat="evento in jogadorEscRmvEvController.jogadorEscalado.eventos">
					<td>{{evento.descricao}}</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		
	</form>
</div>