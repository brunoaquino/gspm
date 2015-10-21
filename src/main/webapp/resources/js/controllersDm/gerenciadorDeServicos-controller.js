var listaDeOS = [];
var tableOrdemDeServico;
var osSendoEditada;

function atualizaTableGerenciamentoDeServico(){
	buscaOrdensDeServico();
	tableOrdemDeServico.bootstrapTable('load', listaDeOS);
}

function carregaOrdemDeServico(os){
	$("#btnSalvarOrdemDeServico").hide();
	$("#btnAlterarOrdemDeServico").show();
}

window.operateEventsGerenciadorDeServicos = {
	'click .edit' : function(e, value, row, index) {
		$('#osModal').modal();
		osSendoEditada = row;
		carregaOrdemDeServico(row);
	},
	'click .remove' : function(e, value, row, index) {
		if(confirm("Excluir Registro?")){
			
			call('http://localhost:8080/controleDeServico/rest/ordemDeServico/delete',row).success(function(retorno) {
				alert("Resgistro excluído com sucesso");
				
				atualizaTableGerenciamentoDeServico();
				
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
		}
	}
};

function buscaOrdensDeServico() {
	call('http://localhost:8080/controleDeServico/rest/ordemDeServico/getOrdensDeServicoPorFiltro', {})
			.success(function(retorno) {
				listaDeOS = retorno;
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
}

modulo.controller('GerenciadorDeServicosController', function($scope, $http) {
	$("#divOrdemDeServico").hide();
	
	buscaOrdensDeServico();

	ativaMascaras();
	
	ativaTable();
	
	
	$('#osModal').on('hidden.bs.modal', function (e) {
		limpaFormulario();
	});
	
	$scope.salvar = function() {
	}
	$scope.editar = function() {
	}

	$scope.filtrarOrdensDeServicoPorFiltro = function() {
		
		var filtroOrdemDeServico = {};
			
		if($('#inputDataInicioAgendamentoValue').val() != ""){
			dataInicio = $("#inputDataInicioAgendamentoValue").val().split("/");
			filtroOrdemDeServico.dataDeAgendamentoInicial = new Date(dataInicio[2], dataInicio[1] - 1, dataInicio[0]);
		}	
		if($('#inputDataFimAgendamentoValue').val() != ""){
			dataFim = $("#inputDataFimAgendamentoValue").val().split("/");
			filtroOrdemDeServico.dataDeAgendamentoFim = new Date(dataFim[2], dataFim[1] - 1, dataFim[0]);
		}	
			
		call('http://localhost:8080/controleDeServico/rest/ordemDeServico/getOrdensDeServicoPorFiltro', filtroOrdemDeServico)
		.success(function(retorno) {
			listaDeOS = retorno;
		}).error(function(msg) {
			trataMensagemDeErro(msg);
		});
	}
	
	$scope.novaOrdemDeServico = function() {
		limpaFormulario();
		$("#btnSalvarOrdemDeServico").show();
		$("#btnAlterarOrdemDeServico").hide();
		$("#divOrdemDeServico").show("slow","swing");
	}
	
	function ativaMascaras(){
		$('#inputDataInicioAgendamento').datepicker({
			autoclose : true,
			format:'dd/mm/yyyy',
			todayHighlight : true,
			language : 'pt-BR'
		});
		
		$('#inputDataFimAgendamento').datepicker({
			autoclose : true,
			format:'dd/mm/yyyy',
			todayHighlight : true,
			language : 'pt-BR'
		});
	};


	function isDadosValidos(OS) {
		var dadosValidos = true;

		return dadosValidos;
	}
	
	function limpaFormulario(){
	};

	function ativaTable() {
		tableOrdemDeServico = $('#tableOrdemDeServico');
		tableOrdemDeServico.bootstrapTable({
				data : listaDeOS,
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
