modulo.controller('IndexController', function($scope, $http) {
	
	$scope.logout = function(){
		 
		 call('http://localhost:8080/gspm/rest/autenticacao/logout', {})
			.success(function(retorno){
				window.location = "http://localhost:8080/gspm/views/login.jsp";
			})
			.error(function(msg){
				if(msg.responseText != undefined){
					alert(JSON.parse(msg.responseText).mensagemDeErro);
			}
		});
		 
	 }
});
