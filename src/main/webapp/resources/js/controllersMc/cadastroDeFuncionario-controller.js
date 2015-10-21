var selecionaItemMenu;
var listaDeFuncionarios = [];
var tableFuncionario;
var funcionarioSendoEditado;

function atualizaTableFuncionario(){
	buscaFuncionarios();
	tableFuncionario.bootstrapTable('load', listaDeFuncionarios);
}

function ativaMascarasFuncionario(){
	$('#inputCepFuncionario').mask('00000-000');
	$('#inputTelefoneFuncionario').mask('(00)0000-0000');
	$('#inputCelularFuncionario').mask('(00)0000-0000');
	$('#inputCpfFuncionario').mask('999.999.999-99');
	$('#inputRgFuncionario').mask('99999999999');
	
	 $('#inputDataNascimento').datepicker({
			autoclose : true,
			format:'dd/mm/yyyy',
			todayHighlight : true,
			language : 'pt-BR'
		});
}

function carregaFuncionario(funcionario){
	if(funcionario!=undefined){
		$("#inputNomeFuncionario").val(funcionario.nome);
		$("#inputEmailFuncionario").val(funcionario.email);
		$("#inputCpfFuncionario").val(formataCPFOuCNPJ(funcionario.cpf));
		$("#inputRgFuncionario").val(funcionario.rg);
		
		if(funcionario.dataDeNascimento != undefined && funcionario.dataDeNascimento != ""){
			$("#inputDataNascimentoValue").val(formataData(funcionario.dataDeNascimento));
		}
		
		$("#inputTelefoneFuncionario").val(funcionario.telefone);
		$("#inputCelularFuncionario").val(funcionario.celular);
		$("#inputEnderecoFuncionario").val(funcionario.endereco);
		$("#inputCepFuncionario").val(funcionario.cep);
		$("#SelectEstado").val(funcionario.estado);
		$("#inputBairroFuncionario").val(funcionario.bairro);
		$("#inputObservacoesFuncionario").val(funcionario.observacoes);
		ativaMascarasFuncionario();
	}
	$("#btnSalvarFuncionario").hide();
	$("#btnAlterarFuncionario").show();
}

window.operateEventsCadastroDeFuncionario = {
	'click .edit' : function(e, value, row, index) {
		funcionarioSendoEditado = row;
		$("#divCadastroFuncionario").show("slow","swing");
		carregaFuncionario(row);
	},
	'click .remove' : function(e, value, row, index) {
		if(confirm("Excluir Registro?")){
			
			row.dataDeAlteracao = new Date(row.dataDeAlteracao);
			row.dataDeCadastro = new Date(row.dataDeCadastro);
			
			if(row.dataDeNascimento != undefined && row.dataDeNascimento != ""){
				row.dataDeNascimento = new Date(row.dataDeNascimento);
			}
			
			call('http://localhost:8080/controleDeServicoAngularJs/rest/funcionario/delete',row).success(function(retorno) {
				alert("Resgistro excluído com sucesso");
				
				atualizaTableFuncionario();
				
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
		}
	}
};

function buscaFuncionarios() {
	call('http://localhost:8080/controleDeServicoAngularJs/rest/funcionario/getFuncionarios', {})
			.success(function(retorno) {
				listaDeFuncionarios = retorno;
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
}

modulo.controller('CadastroDeFuncionarioController', function($scope, $http) {
	$("#divCadastroFuncionario").hide();
	
	$scope.estados = estados;
	
	ativaMascarasFuncionario();
	
	buscaFuncionarios();

	ativaTable();
	
	$scope.salvar = function() {
			var funcionario = {};
			funcionario.nome = $("#inputNomeFuncionario").val();
			funcionario.email = $("#inputEmailFuncionario").val();
			funcionario.cpf = $("#inputCpfFuncionario").val().replace("-","").replace(".","").replace(".","");
			if($('#inputDataNascimentoValue').val() != ""){
				dataNascimento = $("#inputDataNascimentoValue").val().split("/");
				funcionario.dataDeNascimento = new Date(dataNascimento[2], dataNascimento[1] - 1, dataNascimento[0]);
			}			
			funcionario.rg = $("#inputRgFuncionario").val();
			funcionario.telefone = $("#inputTelefoneFuncionario").val().replace("-","").replace(" ","").replace("(","").replace(")","");
			funcionario.celular = $("#inputCelularFuncionario").val().replace("-","").replace("(","").replace(" ","").replace(")","");
			funcionario.endereco = $("#inputEnderecoFuncionario").val();
			funcionario.cep = $("#inputCepFuncionario").val().replace("-","").replace(".","").replace(".","");
			funcionario.estado = $("#SelectEstado").val();
			funcionario.bairro = $("#inputBairroFuncionario").val();
			funcionario.observacoes = $("#inputObservacoesFuncionario").val();
			
			isDadosValidos(funcionario);
			
			call('http://localhost:8080/controleDeServicoAngularJs/rest/funcionario/salva',funcionario).success(function(retorno) {
				limpaFormulario();
				alert("Funcionário criado com sucesso");
				atualizaTableFuncionario();
				$("#divCadastroFuncionario").hide("slow","swing");
				
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
		}
	$scope.editar = function() {
			funcionarioSendoEditado.nome = $("#inputNomeFuncionario").val();
			funcionarioSendoEditado.email = $("#inputEmailFuncionario").val();
			funcionarioSendoEditado.cpf = $("#inputCpfFuncionario").val().replace("-","").replace(".","").replace(".","");
			if($('#inputDataNascimentoValue').val() != ""){
				dataNascimento = $("#inputDataNascimentoValue").val().split("/");
				funcionarioSendoEditado.dataDeNascimento = new Date(dataNascimento[2], dataNascimento[1] - 1, dataNascimento[0]);
			}else{
				funcionarioSendoEditado.dataDeNascimento = undefined;
			}			
			funcionarioSendoEditado.rg = $("#inputRgFuncionario").val();
			funcionarioSendoEditado.telefone = $("#inputTelefoneFuncionario").val().replace("-","").replace(" ","").replace("(","").replace(")","");
			funcionarioSendoEditado.celular = $("#inputCelularFuncionario").val().replace("-","").replace(" ","").replace("(","").replace(")","");
			funcionarioSendoEditado.endereco = $("#inputEnderecoFuncionario").val();
			funcionarioSendoEditado.cep = $("#inputCepFuncionario").val().replace("-","").replace(".","").replace(".","");
			funcionarioSendoEditado.estado = $("#SelectEstado").val();
			funcionarioSendoEditado.bairro = $("#inputBairroFuncionario").val();
			funcionarioSendoEditado.observacoes = $("#inputObservacoesFuncionario").val();
			
			
			funcionarioSendoEditado.dataDeAlteracao = new Date(funcionarioSendoEditado.dataDeAlteracao);
			funcionarioSendoEditado.dataDeCadastro = new Date(funcionarioSendoEditado.dataDeCadastro);
			
			isDadosValidos(funcionarioSendoEditado);
		
		if (isDadosValidos(funcionarioSendoEditado)) {
			call('http://localhost:8080/controleDeServicoAngularJs/rest/funcionario/atualiza',funcionarioSendoEditado).success(function(retorno) {
				limpaFormulario();
				alert("Funcionário editado com sucesso");
				atualizaTableFuncionario();
				$("#divCadastroFuncionario").hide("slow","swing");
				
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
		}
	}

	$scope.cancelar = function() {
		limpaFormulario();
		$("#divCadastroFuncionario").hide("slow","swing");
	}
	
	$scope.novoFuncionario = function() {
		limpaFormulario();
		$("#btnSalvarFuncionario").show();
		$("#btnAlterarFuncionario").hide();
		$("#divCadastroFuncionario").show("slow","swing");
	}


	function isDadosValidos(funcionario) {
		var dadosValidos = true;
		if (funcionario != undefined) {
			if (funcionario.nome == undefined || funcionario.nome == '') {
				alert("Campo nome é obrigatório");
				dadosValidos = false;
			}
			if (funcionario.cpf == undefined || funcionario.cpf == '') {
				alert("Campo CPF é obrigatório");
				dadosValidos = false;
			}
		} else {
			alert("Preencha os dados obrigatórios (*) do funcionário");
			dadosValidos = false;
		}

		return dadosValidos;
	}
	
	function limpaFormulario(){
		$("#inputNomeFuncionario").val("");
		$("#inputEmailFuncionario").val("");
		$("#inputCpfFuncionario").val("");
		$("#inputRgFuncionario").val("");
		$("#inputDataNascimentoValue").val("");
		$("#inputTelefoneFuncionario").val("");
		$("#inputCelularFuncionario").val("");
		$("#inputEnderecoFuncionario").val("");
		$("#inputCepFuncionario").val("");
		$("#SelectEstado").val("");
		$("#inputBairroFuncionario").val("");
		$("#inputObservacoesFuncionario").val("");
	};

	function ativaTable() {
		tableFuncionario = $('#tableFuncionario');
		tableFuncionario.bootstrapTable({
				data : listaDeFuncionarios,
				classes : "table table-hover table-condensed table-hover",
				cache : false,
				height : 400,
				pagination : true,
				pageSize : 10,
				pageList : [ 10, 25, 50, 100, 200 ],
				search : true,
				showColumns : true,
				showRefresh : true,
				minimumCountColumns : 2,
				sortOrder : "asc",
			});
	}
});
