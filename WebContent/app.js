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
		})
		.factory(
				'inserimentoService',[ '$http', function($http) {
					var methods = {};
					
					// Inserisce un oggetto nel db
					methods.inserisciOggetto = function(url, params, toDo) {
						$http({
							method : 'POST',
							url : url,
							headers : {
								'Content-Type' : 'application/json'
							},
							params : params
						}).success(function(data) {
							console.log(data);
							toDo();
							$('input').val('');
							$('textarea').val('');

						});
					};
					return methods;
					
				}]
		);

