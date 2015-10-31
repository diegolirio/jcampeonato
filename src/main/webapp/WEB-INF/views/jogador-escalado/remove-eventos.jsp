
<div ng-controller="JogadorEscaladoRemoveEventoController as jogadorEscRmvEvController">


		<h3 class="text-center">
			Remover evento <span class="text-danger">
			<br/>
			{{ jogadorEscRmvEvController.jogadorEscalado.jogador.nome }}</span>
			<small> {{ jogadorEscRmvEvController.jogadorEscalado.time.nome }}</small>
		</h3>
		
		<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<td class="text-info">Evento</td>
					<td></td>
				</tr>					
			</thead>
			<tbody>
				<tr ng-repeat="evento in jogadorEscRmvEvController.jogadorEscalado.eventos">
					<td>
						<h5>
							<img src="${pageContext.request.contextPath}/static/core/img/{{evento.imgName}}" alt="{{evento.descricao}}" />
							{{evento.descricao}}
						</h5>
					</td>
					<td>
						<a href ng-click="jogadorEscRmvEvController.removeEvento(evento)">
							<img src="${pageContext.request.contextPath}/static/core/img/lixeira.png" alt="Excluir" title="Excluir {{evento.descricao}}" />
						</a>
					</td>
				</tr>
			</tbody>
		</table>
		</div>

</div>