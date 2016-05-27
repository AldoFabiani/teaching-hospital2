angular
		.module('teaching', [ 'ngRoute'])
		.config(
				function($routeProvider) {
					$routeProvider
							.when(
									'/inserimentoPrenotazione',
									{
										controller : 'InserimentoController as inserimentoCtrl',
										templateUrl : 'templates/inserisciPrenotazione.html',
									})
							.when(
									'/inserimentoPrenotazione/:pazienteCodiceFiscale',
									{
										controller : 'InserimentoController as inserimentoCtrl',
										templateUrl : 'templates/inserisciPrenotazione.html',
									})
									.otherwise({
								redirectTo : '/'
							});
				});


// })();
