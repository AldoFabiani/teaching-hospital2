<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="prenotazione" ng-controller="myCtrl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<scrpit src="css/bootstrap.js">
<script src="js/prenotazione/inserisciPrenotazione.js"></script>
<title>Prenotazione</title>
</head>
<body>
	<h2>Nuova prenotazione</h2>
	<div id="tipologie" class="container-fluid">
		<h6>Scegli una tipologia</h6>
		<ul>
		</ul>
	</div>
	<div id="medici" class="container-fluid">
		<h6>Scegli un medico</h6>
		<ul>
		</ul>
	</div>
	<div class="row">
		<div id="codiceFiscale" class="col-md-4">
			Codice Fiscale del paziente <input type="text"
				class="form-control" placeholder="Inserisci il codice fiscale...">
			<button ng-click="inserisciPrenotazione()" type="submit" class="btn btn-default">Invia</button>
		</div>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
	
<script>
var app = angular.module('prenotazione', []);
app.controller('myCtrl', function($scope, $http) {
	inserisciNuovaPrenotazione($http);
});
</script>
</html>