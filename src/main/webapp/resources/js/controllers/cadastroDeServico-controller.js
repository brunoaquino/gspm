var selecionaItemMenu;
var listaDeServicos = [];
var tableServico;
var servicoSendoEditado;

function atualizaTableServico(){
	buscaServicos();
	tableServico.bootstrapTable('load', listaDeServicos);
}

function carregaServico(servico){
	if(servico!=undefined){
		$("#inputNomeServico").val(servico.nome);
		if(!(servico.preco.toString().indexOf(".") > -1)){
			$("#inputPreco").val(servico.preco + ".00");
		}else{
			$("#inputPreco").maskMoney('mask', servico.preco);
		}
		$("#inputPreco").maskMoney('mask');
		$("#inputDescricao").val(servico.descricao);
	}
	$("#btnSalvarServico").hide();
	$("#btnAlterarServico").show();
}

window.operateEventsCadastroDeServico = {
	'click .edit' : function(e, value, row, index) {
		servicoSendoEditado = row;
		$("#divCadastroServico").show("slow","swing");
		carregaServico(row);
	},
	'click .remove' : function(e, value, row, index) {
		if(confirm("Excluir Registro?")){
			call('http://localhost:8080/controleDeServicoAngularJs/rest/servico/delete',row).success(function(retorno) {
				alert("Resgistro excluído com sucesso");
				
				atualizaTableServico();
				
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
		}
	}
};

function buscaServicos() {
	call('http://localhost:8080/controleDeServicoAngularJs/rest/servico/getServicos', {})
			.success(function(retorno) {
				listaDeServicos = retorno;
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
}

modulo.controller('CadastroDeServicoController', function($scope, $http) {
	$("#divCadastroServico").hide();
	
	$("#btnSalvarServico").show();
	$("#btnAlterarServico").hide();
	
	$("#inputPreco").maskMoney({
		showSymbol:true,
		prefix:'R$ ',
		symbol : 'R$ ',
		thousands : '.',
		decimal : ','
	});

	buscaServicos();

	ativaTable();
	
	$scope.salvar = function(servico) {
		servico.preco = $('#inputPreco').maskMoney('unmasked')[0]; 
		
		if (isDadosValidos(servico)) {
			call('http://localhost:8080/controleDeServicoAngularJs/rest/servico/salva',servico).success(function(retorno) {
				limpaFormulario();
				alert("Serviço criado com sucesso");
				atualizaTableServico();
				$("#divCadastroServico").hide("slow","swing");
				
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
		}
	}
	$scope.editar = function() {
			servicoSendoEditado.nome = $('#inputNomeServico').val();
			servicoSendoEditado.preco = $('#inputPreco').maskMoney('unmasked')[0];
			servicoSendoEditado.descricao = $('#inputDescricao').val();
		
		if (isDadosValidos(servicoSendoEditado)) {
			call('http://localhost:8080/controleDeServicoAngularJs/rest/servico/atualiza',servicoSendoEditado).success(function(retorno) {
				limpaFormulario();
				alert("Serviço editado com sucesso");
				atualizaTableServico();
				$("#divCadastroServico").hide("slow","swing");
				
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
		}
	}

	$scope.cancelar = function() {
		limpaFormulario();
		$("#divCadastroServico").hide("slow","swing");
	}
	
	$scope.novoServico = function() {
		limpaFormulario();
		$("#btnSalvarServico").show();
		$("#btnAlterarServico").hide();
		$("#divCadastroServico").show("slow","swing");
	}


	function isDadosValidos(servico) {
		var dadosValidos = true;
		if (servico != undefined) {
			if (servico.nome == '') {
				alert("Campo nome é obrigatório");
				dadosValidos = false;
			}
		} else {
			alert("Preencha os dados obrigatórios (*) do serviço");
			dadosValidos = false;
		}

		return dadosValidos;
	}
	
	function limpaFormulario(){
		$("#inputNomeServico").val("");
		$("#inputPreco").val("");
		$("#inputDescricao").val("");
	};

	function ativaTable() {
		tableServico = $('#tableServico');
		tableServico.bootstrapTable({
				data : listaDeServicos,
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
