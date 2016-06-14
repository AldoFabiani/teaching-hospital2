<html ng-app="teaching">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teaching-Hospital-Web</title>
<!--CSS FILE  -->
<link rel="stylesheet" href="Assets/css/th_nav.css">
<link rel="stylesheet" href="Assets/css/main.css">
<link rel="stylesheet"
	href="Assets/vendor/css/loading-bar.css">
<!--JS FILE  -->
<script type="text/javascript"
	src="Assets/vendor/js/jquery-1.12.4.min.js"></script>
<link href="Assets/vendor/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="Assets/vendor/js/angular.min.js"></script>
<script type="text/javascript" src="Assets/vendor/js/loading-bar.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-route.min.js"></script>
<script type="text/javascript" src="Assets/app/app.js"></script>
<script type="text/javascript"
	src="Assets/app/controllers/prenotazione.js"></script>
<script type="text/javascript"
	src="Assets/app/controllers/inserimentoTipologiaEsame.js"></script>
<script type="text/javascript"
	src="Assets/app/controllers/consultazioneTipologieEsamiOfferti.js"></script>
<script type="text/javascript" src="Assets/app/controllers/norma.js"></script>
<script type="text/javascript" src="Assets/app/controllers/medici.js"></script>
<script type="text/javascript"
	src="Assets/app/controllers/indicatore.js"></script>
<script type="text/javascript" src="Assets/app/controllers/tipologie.js"></script>
</head>
<body>
	<header ng-include="'HTML/element/navbar.html'"></header>
	<div id="container" class="container-fluid">
		<div ng-view></div>
	</div>
</body>
<script type="text/javascript" src="Assets/vendor/js/bootstrap.min.js"></script>

</html>

