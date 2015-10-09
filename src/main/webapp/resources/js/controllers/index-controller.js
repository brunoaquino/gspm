modulo.controller('IndexController', function($scope, $http) {
	
	$scope.logout = function(){
		 
		 call('http://localhost:8080/controleDeServicoAngularJs/rest/autenticacao/logout', {})
			.success(function(retorno){
				window.location = "http://localhost:8080/controleDeServicoAngularJs/views/login.jsp";
			})
			.error(function(msg){
				if(msg.responseText != undefined){
					alert(JSON.parse(msg.responseText).mensagemDeErro);
			}
		});
		 
	 }
});
