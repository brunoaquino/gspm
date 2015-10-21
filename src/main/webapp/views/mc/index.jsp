<!DOCTYPE html>
<html lang="pt-br" ng-app="csAdmin">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>Controle de Serviço</title>

		<!-- Bootstrap Core CSS -->
		<link href="../resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

		<!-- MetisMenu CSS -->
		<link href="../resources/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

		<!-- Timeline CSS -->
		<link href="../resources/dist/css/timeline.css" rel="stylesheet">

		<!-- Custom CSS -->
		<link href="../resources/dist/css/sb-admin-2.css" rel="stylesheet">

		<!-- Morris Charts CSS -->
		<link href="../resources/bower_components/morrisjs/morris.css" rel="stylesheet">

		<!-- Custom Fonts -->
		<link href="../resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
		
		<script src="../resources/js/lib/jquery-1.10.2.js" charset="utf-8"></script>
		<script src="../resources/js/calendar/calendar.js" charset="utf-8"></script>
		
		<script src="../resources/js/lib/angular.min.js"></script>
		<script src="../resources/js/lib/angular-animate.min.js"></script>
        <script src="../resources/js/lib/angular-route.min.js"></script>
		<script src="../resources/js/main.js"></script>
		<script src="../resources/js/controllers/index-controller.js"></script>
		
		<script src="../resources/js/minhasLibs/request.js"></script>
		<script src="../resources/js/minhasLibs/enums.js" charset="utf-8"></script>
		<script src="../resources/js/minhasLibs/tableFormatters.js" charset="utf-8"></script>
		
		
		<script src="../resources/js/controllers/login-controller.js" charset="utf-8"></script>
		<script src="../resources/js/controllers/index-controller.js" charset="utf-8"></script>
		<script src="../resources/js/controllers/cadastroDeUsuario-controller.js" charset="utf-8"></script>
		<script src="../resources/js/controllers/cadastroDeServico-controller.js" charset="utf-8"></script>
		<script src="../resources/js/controllers/cadastroDeFuncionario-controller.js" charset="utf-8"></script>
		<script src="../resources/js/controllers/cadastroDeCliente-controller.js" charset="utf-8"></script>
		<script src="../resources/js/controllers/gerenciadorDeServicos-controller.js" charset="utf-8"></script>
	</head>

	<body>

		<div id="wrapper" ng-controller=IndexController>
			<!-- Navigation -->
			<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">Cs Admin</a>
				</div>
				<!-- /.navbar-header -->

				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
							<i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
						</a>
						<ul class="dropdown-menu dropdown-user">
							<li>
								<a href="#">
									<i class="fa fa-user fa-fw"></i> Perfil de Usuário
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-gear fa-fw"></i>Configurações
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a ng-click="logout()">
									<i class="fa fa-sign-out fa-fw" ></i> Sair
								</a>
							</li>
						</ul>
						<!-- /.dropdown-user -->
					</li>
					<!-- /.dropdown -->
				</ul>
				<!-- /.navbar-top-links -->

				<div class="navbar-default sidebar" role="navigation">
					<div class="sidebar-nav navbar-collapse">
						<ul class="nav" id="side-menu">
							<li class="sidebar-search">
								<div class="input-group custom-search-form">
									<input type="text" class="form-control" placeholder="Procurar...">
									<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
								</div>
								<!-- /input-group -->
							</li>
							<li>
								<a href="/home"><i class="fa fa-dashboard fa-fw"></i> Home</a>
							</li>
							<li>
								<a href="#">
									<i class="fa fa-paste fa-fw"></i> Cadastros
									<span class="fa arrow"></span>
								</a>
								<ul class="nav nav-second-level">
									<li>
										<a href="/cadastroDeCliente">Cliente</a>
									</li>
									<li>
										<a href="/cadastroDeFuncionario">Funcionário</a>
									</li>
									<li>
										<a href="/cadastroDeServico">Serviço</a>
									</li>
								</ul>
								<!-- /.nav-second-level -->
							</li>
							<li>
								<a href="index.html">
									<i class="fa fa-folder-open fa-fw"></i>Adminstração
									<span class="fa arrow"></span>
								</a>
								<ul class="nav nav-second-level">
									<li>
										<a href="/cadastroDeUsuario">Usuário</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
					<!-- /.sidebar-collapse -->
				</div>
				<!-- /.navbar-static-side -->
			</nav>

			<div id="page-wrapper">
				<ng-view></ng-view>
			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->

		 <script src="../resources/bower_components/jquery/dist/jquery.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="../resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

		<!-- Metis Menu Plugin JavaScript -->
		<script src="../resources/bower_components/metisMenu/dist/metisMenu.min.js"></script>

		<!-- Morris Charts JavaScript -->
		<!--<script src="../resources/bower_components/raphael/raphael-min.js"></script>-->
		<!--<script src="../resources/bower_components/morrisjs/morris.min.js"></script>-->
		<!--<script src="../resources/js/morris-data.js"></script>-->

		<!-- Custom Theme JavaScript -->
		<script src="../resources/dist/js/sb-admin-2.js"></script>

	</body>
</html>
