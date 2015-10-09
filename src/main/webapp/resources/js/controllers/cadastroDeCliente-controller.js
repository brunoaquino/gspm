var selecionaItemMenu;
var listaDeClientes = [];
var tableCliente;
var clienteSendoEditado;

function atualizaTable(){
	buscaClientes();
	tableCliente.bootstrapTable('load', listaDeClientes);
}

function ativaMascarasCliente(){
	$('#inputCepCliente').mask('00000-000');
	$('#inputTelefoneCliente').mask('(00)0000-0000');
	$('#inputCelularCliente').mask('(00)0000-0000');
	$('#inputCpfCliente').mask('999.999.999-99');
	$('#inputRgCliente').mask('99999999999');
	
	 $('#inputDataNascimento').datepicker({
			autoclose : true,
			format:'dd/mm/yyyy',
			todayHighlight : true,
			language : 'pt-BR'
		});
}

function carregaCliente(cliente){
	if(cliente!=undefined){
		$("#inputNomeCliente").val(cliente.nome);
		$("#inputEmailCliente").val(cliente.email);
//		$("#inputCpfCliente").val(formataCPFOuCNPJ(cliente.cpf));
		$("#inputRgCliente").val(cliente.rg);
		
		if(cliente.dataDeNascimento != undefined && cliente.dataDeNascimento != ""){
			$("#inputDataNascimentoValue").val(formataData(cliente.dataDeNascimento));
		}
		
		$("#inputTelefoneCliente").val(cliente.telefone);
		$("#inputCelularCliente").val(cliente.celular);
		$("#inputEnderecoCliente").val(cliente.endereco);
		$("#inputCepCliente").val(cliente.cep);
		$("#SelectEstado").val(cliente.estado);
		$("#inputBairroCliente").val(cliente.bairro);
		$("#inputObservacoesCliente").val(cliente.observacoes);
		ativaMascarasCliente();
	}
	$("#btnSalvarCliente").hide();
	$("#btnAlterarCliente").show();
}

window.operateEventsCadastroDeCliente = {
	'click .edit' : function(e, value, row, index) {
		clienteSendoEditado = row;
		$("#divCadastroCliente").show("slow","swing");
		carregaCliente(row);
	},
	'click .remove' : function(e, value, row, index) {
		if(confirm("Excluir Registro?")){
			
			row.dataDeAlteracao = new Date(row.dataDeAlteracao);
			row.dataDeCadastro = new Date(row.dataDeCadastro);
			
			if(row.dataDeNascimento != undefined && row.dataDeNascimento != ""){
				row.dataDeNascimento = new Date(row.dataDeNascimento);
			}
			call('http://localhost:8080/controleDeServicoAngularJs/rest/cliente/delete',row).success(function(retorno) {
				alert("Resgistro excluído com sucesso");
				
				atualizaTable();
				
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
		}
	}
};

function buscaClientes() {
	call('http://localhost:8080/controleDeServicoAngularJs/rest/cliente/getClientes', {})
			.success(function(retorno) {
				listaDeClientes = retorno;
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
}

modulo.controller('CadastroDeClienteController', function($scope, $http) {
	$("#divCadastroCliente").hide();
	
	$scope.estados = estados;
	
	ativaMascarasCliente();
	
	buscaClientes();

	ativaTable();
	
	$scope.salvar = function() {
			var cliente = {};
			cliente.nome = $("#inputNomeCliente").val();
			cliente.email = $("#inputEmailCliente").val();
//			cliente.cpf = $("#inputCpfCliente").val().replace("-","").replace(".","").replace(".","");
			if($('#inputDataNascimentoValue').val() != ""){
				dataNascimento = $("#inputDataNascimentoValue").val().split("/");
				cliente.dataDeNascimento = new Date(dataNascimento[2], dataNascimento[1] - 1, dataNascimento[0]);
			}			
			cliente.rg = $("#inputRgCliente").val();
			cliente.telefone = $("#inputTelefoneCliente").val().replace("-","").replace(" ","").replace("(","").replace(")","");
			cliente.celular = $("#inputCelularCliente").val().replace("-","").replace("(","").replace(" ","").replace(")","");
			cliente.endereco = $("#inputEnderecoCliente").val();
			cliente.cep = $("#inputCepCliente").val().replace("-","").replace(".","").replace(".","");
			cliente.estado = $("#SelectEstado").val();
			cliente.bairro = $("#inputBairroCliente").val();
			cliente.observacoes = $("#inputObservacoesCliente").val();
			
			isDadosValidos(cliente);
			
			call('http://localhost:8080/controleDeServicoAngularJs/rest/cliente/salva',cliente).success(function(retorno) {
				limpaFormulario();
				alert("Cliente criado com sucesso");
				atualizaTable();
				$("#divCadastroCliente").hide("slow","swing");
				
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
		}
	$scope.editar = function() {
			clienteSendoEditado.nome = $("#inputNomeCliente").val();
			clienteSendoEditado.email = $("#inputEmailCliente").val();
//			clienteSendoEditado.cpf = $("#inputCpfCliente").val().replace("-","").replace(".","").replace(".","");
			if($('#inputDataNascimentoValue').val() != ""){
				dataNascimento = $("#inputDataNascimentoValue").val().split("/");
				clienteSendoEditado.dataDeNascimento = new Date(dataNascimento[2], dataNascimento[1] - 1, dataNascimento[0]);
			}else{
				clienteSendoEditado.dataDeNascimento = undefined;
			}			
			clienteSendoEditado.rg = $("#inputRgCliente").val();
			clienteSendoEditado.telefone = $("#inputTelefoneCliente").val().replace("-","").replace(" ","").replace("(","").replace(")","");
			clienteSendoEditado.celular = $("#inputCelularCliente").val().replace("-","").replace(" ","").replace("(","").replace(")","");
			clienteSendoEditado.endereco = $("#inputEnderecoCliente").val();
			clienteSendoEditado.cep = $("#inputCepCliente").val().replace("-","").replace(".","").replace(".","");
			clienteSendoEditado.estado = $("#SelectEstado").val();
			clienteSendoEditado.bairro = $("#inputBairroCliente").val();
			clienteSendoEditado.observacoes = $("#inputObservacoesCliente").val();
			
			
			clienteSendoEditado.dataDeAlteracao = new Date(clienteSendoEditado.dataDeAlteracao);
			clienteSendoEditado.dataDeCadastro = new Date(clienteSendoEditado.dataDeCadastro);
			
			isDadosValidos(clienteSendoEditado);
		
		if (isDadosValidos(clienteSendoEditado)) {
			call('http://localhost:8080/controleDeServicoAngularJs/rest/cliente/atualiza',clienteSendoEditado).success(function(retorno) {
				limpaFormulario();
				alert("Cliente editado com sucesso");
				atualizaTable();
				$("#divCadastroCliente").hide("slow","swing");
				
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
		}
	}

	$scope.cancelar = function() {
		limpaFormulario();
		$("#divCadastroCliente").hide("slow","swing");
	}
	
	$scope.novoCliente = function() {
		limpaFormulario();
		$("#btnSalvarCliente").show();
		$("#btnAlterarCliente").hide();
		$("#divCadastroCliente").show("slow","swing");
	}


	function isDadosValidos(cliente) {
		var dadosValidos = true;
		if (cliente != undefined) {
			if (cliente.nome == undefined || cliente.nome == '') {
				alert("Campo nome é obrigatório");
				dadosValidos = false;
			}
//			if (cliente.cpf == undefined || cliente.cpf == '') {
//				alert("Campo CPF é obrigatório");
//				dadosValidos = false;
//			}
		} else {
			alert("Preencha os dados obrigatórios (*) do Cliente");
			dadosValidos = false;
		}

		return dadosValidos;
	}
	
	function limpaFormulario(){
		$("#inputNomeCliente").val("");
		$("#inputEmailCliente").val("");
		$("#inputCpfCliente").val("");
		$("#inputRgCliente").val("");
		$("#inputDataNascimentoValue").val("");
		$("#inputTelefoneCliente").val("");
		$("#inputCelularCliente").val("");
		$("#inputEnderecoCliente").val("");
		$("#inputCepCliente").val("");
		$("#SelectEstado").val("");
		$("#inputBairroCliente").val("");
		$("#inputObservacoesCliente").val("");
	};

	function ativaTable() {
		tableCliente = $('#tableCliente');
		tableCliente.bootstrapTable({
				data : listaDeClientes,
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
