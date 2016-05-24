<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="teaching">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserimento prenotazione</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/angular.min.js"></script>
<script src="js/app.js"></script>
<script src="js/jquery-1.12.4.min.js"></script>
</head>
<body>
	<h2>Inserisci una prenotazione</h2>
	<div id="container">
		<div id="mediciContainer"
			ng-controller="MediciController as mediciController">
			<h4>Seleziona un medico</h4>
			<div class="list-group">
				<ul>
					<li ng-repeat="medico in mediciController.medici">
						{{medico.nome}}</li>
				</ul>
			</div>
			<button type="button" class="btn btn-primary btn-lg btn-block">Inserisci
				prenotazione</button>
		</div>
</body>
</html>