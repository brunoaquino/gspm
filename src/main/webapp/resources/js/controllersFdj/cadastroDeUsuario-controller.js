var selecionaItemMenu;
var listaDeUsuarios = [];
var tableUsuario;
var usuarioSendoEditado;

function atualizaTableUsuario(){
	buscaUsuarios();
	tableUsuario.bootstrapTable('load', listaDeUsuarios);
}

function ativaMascarasUsuario(){
	$('#inputCepUsuario').mask('00000-000');
	$('#inputTelefoneUsuario').mask('(00)0000-0000');
	$('#inputCelularUsuario').mask('(00)0000-0000');
	$('#inputCpfUsuario').mask('999.999.999-99');
	$('#inputRgUsuario').mask('99999999999');
	
	 $('#inputDataNascimento').datepicker({
			autoclose : true,
			format:'dd/mm/yyyy',
			todayHighlight : true,
			language : 'pt-BR'
		});
}

function carregaUsuario(usuario){
	if(usuario!=undefined){
		$("#inputNomeUsuario").val(usuario.nome);
		$("#inputEmailUsuario").val(usuario.email);
		$("#inputCpfUsuario").val(formataCPFOuCNPJ(usuario.cpf));
		$("#inputRgUsuario").val(usuario.rg);
		
		if(usuario.dataDeNascimento != undefined && usuario.dataDeNascimento != ""){
			$("#inputDataNascimentoValue").val(formataData(usuario.dataDeNascimento));
		}
		
		$("#inputTelefoneUsuario").val(usuario.telefone);
		$("#inputCelularUsuario").val(usuario.celular);
		$("#inputEnderecoUsuario").val(usuario.endereco);
		$("#inputCepUsuario").val(usuario.cep);
		$("#SelectEstado").val(usuario.estado);
		$("#inputBairroUsuario").val(usuario.bairro);
		$("#inputObservacoesUsuario").val(usuario.observacoes);
	}
	$("#btnSalvarUsuario").hide();
	$("#btnAlterarUsuario").show();
}

window.operateEventsCadastroDeUsuario = {
	'click .edit' : function(e, value, row, index) {
		usuarioSendoEditado = row;
		$("#divCadastroUsuario").show("slow","swing");
		carregaUsuario(row);
	},
	'click .remove' : function(e, value, row, index) {
		if(confirm("Excluir Registro?")){
			
			row.dataDeAlteracao = new Date(row.dataDeAlteracao);
			row.dataDeCadastro = new Date(row.dataDeCadastro);
			
			if(row.dataDeNascimento != undefined && row.dataDeNascimento != ""){
				row.dataDeNascimento = new Date(row.dataDeNascimento);
			}
			
			call('http://localhost:8080/controleDeServicoAngularJs/rest/usuario/delete',row).success(function(retorno) {
				alert("Resgistro excluído com sucesso");
				
				atualizaTableUsuario();
				
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
		}
	}
};

function buscaUsuarios() {
	call('http://localhost:8080/controleDeServicoAngularJs/rest/usuario/getUsuarios', {})
			.success(function(retorno) {
				listaDeUsuarios = retorno;
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
}

modulo.controller('CadastroDeUsuarioController', function($scope, $http) {
	$("#divCadastroUsuario").hide();
	
	buscaUsuarios();

	ativaTable();
	
	$scope.salvar = function() {
			var usuario = {};
			usuario.email = $("#inputEmailUsuario").val();
			usuario.senha = $("#inputSenhaUsuario").val();
			usuario.login = $("#inputLoginUsuario");
			empresa = {
				id:$("#SelectEmpresaDoUsuario").val()
			}
			usuario.empresa = empresa;
			
			isDadosValidos(usuario);
			
//			call('http://localhost:8080/controleDeServicoAngularJs/rest/usuario/salva',usuario).success(function(retorno) {
//				limpaFormulario();
//				alert("Usuáio criado com sucesso");
//				atualizaTableUsuario();
//				$("#divCadastroUsuario").hide("slow","swing");
//				
//			}).error(function(msg) {
//				trataMensagemDeErro(msg);
//			});
		}
	$scope.editar = function() {
			usuarioSendoEditado.nome = $("#inputNomeUsuario").val();
			usuarioSendoEditado.email = $("#inputEmailUsuario").val();
			usuarioSendoEditado.cpf = $("#inputCpfUsuario").val().replace("-","").replace(".","").replace(".","");
			if($('#inputDataNascimentoValue').val() != ""){
				dataNascimento = $("#inputDataNascimentoValue").val().split("/");
				usuarioSendoEditado.dataDeNascimento = new Date(dataNascimento[2], dataNascimento[1] - 1, dataNascimento[0]);
			}else{
				usuarioSendoEditado.dataDeNascimento = undefined;
			}			
			usuarioSendoEditado.rg = $("#inputRgUsuario").val();
			usuarioSendoEditado.telefone = $("#inputTelefoneUsuario").val().replace("-","").replace(" ","").replace("(","").replace(")","");
			usuarioSendoEditado.celular = $("#inputCelularUsuario").val().replace("-","").replace(" ","").replace("(","").replace(")","");
			usuarioSendoEditado.endereco = $("#inputEnderecoUsuario").val();
			usuarioSendoEditado.cep = $("#inputCepUsuario").val().replace("-","").replace(".","").replace(".","");
			usuarioSendoEditado.estado = $("#SelectEstado").val();
			usuarioSendoEditado.bairro = $("#inputBairroUsuario").val();
			usuarioSendoEditado.observacoes = $("#inputObservacoesUsuario").val();
			
			
			usuarioSendoEditado.dataDeAlteracao = new Date(usuarioSendoEditado.dataDeAlteracao);
			usuarioSendoEditado.dataDeCadastro = new Date(usuarioSendoEditado.dataDeCadastro);
			
			isDadosValidos(usuarioSendoEditado);
		
		if (isDadosValidos(usuarioSendoEditado)) {
			call('http://localhost:8080/controleDeServicoAngularJs/rest/usuario/atualiza',usuarioSendoEditado).success(function(retorno) {
				limpaFormulario();
				alert("Usuáio editado com sucesso");
				atualizaTableUsuario();
				$("#divCadastroUsuario").hide("slow","swing");
				
			}).error(function(msg) {
				trataMensagemDeErro(msg);
			});
		}
	}

	$scope.cancelar = function() {
		limpaFormulario();
		$("#divCadastroUsuario").hide("slow","swing");
	}
	
	$scope.novoUsuario = function() {
		limpaFormulario();
		$("#btnSalvarUsuario").show();
		$("#btnAlterarUsuario").hide();
		$("#divCadastroUsuario").show("slow","swing");
	}


	function isDadosValidos(usuario) {
		var dadosValidos = true;
		if (usuario != undefined) {
			if (usuario.email == '') {
				alert("Campo e-mail é obrigatório");
				dadosValidos = false;
			}
			if (usuario.login == '') {
				alert("Campo login é obrigatório");
				dadosValidos = false;
			}
			if (usuario.senha == '') {
				alert("Campo senha é obrigatório");
				dadosValidos = false;
			}
			if(usuario.empresa.id==''){
				alert("Campo empresa é obrigatório");
				dadosValidos = false;
			}
		} else {
			alert("Preencha os dados do usuário");
			dadosValidos = false;
		}

		return dadosValidos;
	}
	
	function limpaFormulario(){
		$("#inputEmailUsuario").val("");
		$("#inputLoginUsuario").val("");
		$("#inputSenhaUsuario").val("");
		$("#SelectEmpresaDoUsuario").val("");
	};

	function ativaTable() {
		tableUsuario = $('#tableUsuario');
		tableUsuario.bootstrapTable({
				data : listaDeUsuarios,
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
