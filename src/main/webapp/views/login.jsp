<!DOCTYPE html>
<html lang="pt-br" ng-app="csAdmin">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Bruno">

    <title>Controle de Serviço</title>

    <!-- Bootstrap Core CSS -->
    <link href="../resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../resources/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <script src="../resources/js/lib/angular.min.js"></script>
<!-- 	<script src="../resources/js/lib/angular-animate.min.js"></script> -->
    <script src="../resources/js/lib/angular-route.min.js"></script>
    
	<script src="../resources/js/minhasLibs/request.js" charset="utf-8"></script>
	<script src="../resources/js/minhasLibs/enums.js" charset="utf-8"></script>
	
	<script src="../resources/js/main.js"></script>
	
	<script src="../resources/js/controllers/login-controller.js"></script>

</head>

<body bgproperties="fixed" style="background-image: url(../resources/img/planoDeFundoLogin.jpg);">

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Bem vindo</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" ng-controller="LoginController">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Login" name=login autofocus ng-model="usuario.login" id="login">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" ng-model="usuario.senha" ng-keypress="logar($event,usuario)">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Lembre-me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <a class="btn btn-lg btn-success btn-block" ng-click="autenticar(usuario)">Login</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="../resources/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../resources/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
