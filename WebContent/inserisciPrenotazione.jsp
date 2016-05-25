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
	<div ng-controller="InserimentoController as inserimentoCtrl">
		<form name="inserimentoPrenotazione" ng-submit="inserimentoCtrl.aggiungiPrenotazione()">
			<h2>Inserisci una prenotazione</h2>
			<div id="container">
				<!-- Inserimento-->
				<lista-medici></lista-medici>
				<lista-tipologie></lista-tipologie>
			</div>

			<!-- Live preview -->
			<div id="prenotazioneInserita">
				<strong>Il medico è: {{inserimentoCtrl.medico.nome}}</strong>
			</div>

			<button type="submit" class="btn btn-primary btn-lg btn-block">Inserisci
				prenotazione</button>
		</form>
	</div>
</body>
</html>