angular
		.module('teaching', [ 'ngRoute'])
		.config(
				function($routeProvider) {
					$routeProvider
							.when(
									'/inserimentoPrenotazione',
									{
										controller : 'InserimentoPrenotazioneController as inserimentoPrenotazioneCtrl',
										templateUrl : 'templates/inserisciPrenotazione.html',
									})
							.when(
									'/inserimentoPrenotazione/:pazienteCodiceFiscale',
									{
										controller : 'InserimentoPrenotazioneController as inserimentoPrenotazioneCtrl',
										templateUrl : 'templates/inserisciPrenotazione.html',
									})
							.when(
									'/consultazioneTipologieEsamiOfferti',
									{
										controller:'ConsultazioneTipologieEsamiOfferti as consultazioneTipologieEsamiOffertiCtrl',
										templateUrl:'templates/consultazioneTipologieEsamiOfferti.html',
									})		
									.otherwise({
								redirectTo : '/'
							});
				});


// })();
