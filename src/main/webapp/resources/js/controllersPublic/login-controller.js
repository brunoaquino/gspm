var usuarioAutenticado;

modulo.controller( 'LoginController', function($scope, $http) {
	
	$("#login").focus()
	
	$scope.logar = function(keyEvent,usuario) {
		  if (keyEvent.which === 13)
			  autentica(usuario);
		}

	
    $scope.autenticar = function(usuario) { 
    	autentica(usuario);
    }
    
    function autentica(usuario){
    	call('http://localhost:8080/gspm/rest/autenticacao/autentica', usuario)
		.success(function(retorno){
			usuarioAutenticado = retorno;
			window.location = "http://localhost:8080/gspm/views/dm/index.jsp";
		})
		.error(function(msg){
			trataMensagemDeErro(msg);
		});
    }
	
});
