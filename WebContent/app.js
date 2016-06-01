angular
		.module('teaching', [ 'ngRoute','angular-loading-bar'])
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
									'/inserimentoTipologiaEsame',
									{
										controller : 'InserimentoTipologiaEsameController as inserimentoTipologiaEsameCtrl',
										templateUrl : 'templates/inserisciTipologiaEsame.html',
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

