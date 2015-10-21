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
		<h1 class="page-header">Cadastro de Funcionário</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<div class="row" ng-controller="CadastroDeFuncionarioController">
	<div class="panel panel-primary" id="divCadastroFuncionario">
		<div class="panel-heading">Novo Funcionário</div>
		<form role="form" name="formulario">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12">
						<div class="row">
							<div class="form-group col-md-5">
								<label class="control-label" for="inputNomeFuncionario">Nome:</label> <span class="obrigatorio">*</span> 
								<input class="form-control" id="inputNomeFuncionario" />
							</div>
							<div class="form-group col-md-5">
								<label class="control-label" for="inputEmailFuncionario">E-mail:</label> 
								<input class="form-control" id="inputEmailFuncionario" />
							</div>
						</div>
						<div class="row">
	                        <div class="form-group col-md-2">
								<label class="control-label" for="inputCpfFuncionario">CPF:</label> <span class="obrigatorio">*</span> 
								<input class="form-control" id="inputCpfFuncionario" />
							</div>
	                        <div class="form-group col-md-2">
								<label class="control-label" for="inputRgFuncionario">RG:</label> 
								<input class="form-control" id="inputRgFuncionario" />
							</div>
							<div class="form-group col-md-2 col-md-offset-1">
								<label class="control-label" for="inputDataNascimento">Data de Nascimento:</label>
				                <div class='input-group date' id='inputDataNascimento'>
				                    <input type='text' class="form-control" id='inputDataNascimentoValue'/>
				                    <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-calendar"></span>
				                    </span>
				                </div>
	           				</div>
	                        <div class="form-group col-md-2">
								<label class="control-label" for="inputTelefoneFuncionario">Telefone:</label>
								<input class="form-control" id="inputTelefoneFuncionario" />
							</div>
	                        <div class="form-group col-md-2">
								<label class="control-label" for="inputCelularFuncionario">Celular:</label>
								<input class="form-control" id="inputCelularFuncionario" />
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-3">
								<label class="control-label" for="inputEnderecoFuncionario">Endereço:</label>
								<input class="form-control" id="inputEnderecoFuncionario" />
							</div>
							<div class="form-group col-md-2">
								<label class="control-label" for="inputCepFuncionario">CEP:</label>
								<input class="form-control" id="inputCepFuncionario" />
							</div>
							<div class="form-group col-md-2">
								<label class="control-label" for="SelectEstado">Estado:</label>
								<select class="form-control" id="SelectEstado">
									 <option value="">Selecione</option>
	                                 <option ng-repeat="estado in estados" value="{{estado.value}}">{{estado.texto}}</option>
	                             </select>
							</div>
							<div class="form-group col-md-2">
								<label class="control-label" for="inputBairroFuncionario">Bairro:</label>
								<input class="form-control" id="inputBairroFuncionario"/>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-6">
								<label class="control-label" for="inputObservacoesFuncionario">Observações:</label>
								<textarea class="form-control" id="inputObservacoesFuncionario"rows="3"></textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-footer" style="text-align: right;">
				<button type="button" class="btn btn-success" ng-click="salvar()" id="btnSalvarFuncionario">Salvar</button>
				<button type="button" class="btn btn-success" ng-click="editar()" id="btnAlterarFuncionario">Editar</button>
				<button type="button" class="btn btn-primary" ng-click="cancelar()">Cancelar</button>
			</div>
		</form>
	</div>
	
	<div class="row" ng-controller="CadastroDeFuncionarioController">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading" style="text-align: right;">
					<label style="float: left;margin-top: 7px;">
						Funcionários
					</label>
					<button type="button" ng-click="novoFuncionario()" class="btn btn-default" style="margin-left: 80%;">Novo Funcionário</button>
				</div>
				<div class="panel-body">
					<table id="tableFuncionario" data-sort-name="nome">
						<thead>
							<tr>
								<th data-field="nome">Nome</th>
								<th data-field="dataDeCadastro" data-formatter="dataConverterFormatter">Data de Cadastro</th>
								<th data-field="operate" data-formatter="operateFormatterPadrao" data-events="operateEventsCadastroDeFuncionario">Ação</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
