<%@ page contentType="text/html; charset=UTF-8"%>

<script src="controleDeServicoAngularJs/resources/js/lib/jquery.maskMoney.min.js" charset="utf-8"></script>
<script src="controleDeServicoAngularJs/resources/js/lib/jquery.mask.min.js" charset="utf-8"></script>

<link rel="stylesheet" href="controleDeServicoAngularJs/resources/css/bootstrap-3.3.4/datePicker/css/datepicker.css" type="text/css"></link>
<link rel="stylesheet" href="controleDeServicoAngularJs/resources/css/bootstrap-3.3.4/datePicker/css/datepicker3.css" type="text/css"></link>
<script src="controleDeServicoAngularJs/resources/css/bootstrap-3.3.4/datePicker/js/bootstrap-datepicker.js" charset="utf-8"></script>
<script src="controleDeServicoAngularJs/resources/css/bootstrap-3.3.4/datePicker/js/locales/bootstrap-datepicker.pt-BR.js" charset="utf-8"></script>

<link href="controleDeServicoAngularJs/resources/js/lib/bootstrapTable/bootstrap-table.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="controleDeServicoAngularJs/resources/js/lib/bootstrapTable/bootstrap-table.js" charset="utf-8"></script>
<script type="text/javascript" src="controleDeServicoAngularJs/resources/js/lib/bootstrapTable/locale/bootstrap-table-pt-BR.js" charset="utf-8"></script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Cadastro de Serviço</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<div class="row" ng-controller="CadastroDeServicoController">
	<div class="panel panel-primary" id="divCadastroServico">
		<div class="panel-heading">Novo Serviço</div>
		<form role="form" name="formulario">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12">
						<div class="row">
							<div class="form-group col-md-6">
								<label class="control-label" for="inputNomeServico">Nome:</label><span
									class="obrigatorio">*</span> <input class="form-control"
									name="nome" id="inputNomeServico" ng-model="servico.nome" />
							</div>
							<div class="form-group col-md-2">
								<label class="control-label" for="inputPreco">Preço:</label> <input
									class="form-control" id="inputPreco" ng-model="servico.preco"
									name="preco" />
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-3">
								<label class="control-label" for="inputDescricao">Descrição:</label>
								<textarea class="form-control" id="inputDescricao"
									ng-model="servico.descricao" name="descricao" rows="3"></textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-footer" style="text-align: right;">
				<button type="button" class="btn btn-success"
					ng-click="salvar(servico)" id="btnSalvarServico">salvar</button>
				<button type="button" class="btn btn-success" ng-click="editar()"
					id="btnAlterarServico">Editar</button>
				<button type="button" class="btn btn-primary" ng-click="cancelar()">Cancelar</button>
			</div>
		</form>
	</div>
	
	<div class="row" ng-controller="CadastroDeServicoController">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading" style="text-align: right;">
					<label style="float: left;margin-top: 7px;">
						Serviços
					</label>
					
					<button type="button" ng-click="novoServico()"
						class="btn btn-default" style="margin-left: 80%;">Novo
						Serviço</button>
				</div>
				<div class="panel-body">
					<table id="tableServico" data-sort-name="nome">
						<thead>
							<tr>
								<th data-field="nome">Nome</th>
								<th data-field="preco" data-formatter="moneyFormatter">Preço</th>
								<th data-field="descricao">Descrição</th>
								<th data-field="operate" data-formatter="operateFormatterPadrao"
									data-events="operateEventsCadastroDeServico">Ação</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
