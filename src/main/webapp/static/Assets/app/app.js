angular
.module('teaching', [ 'ngRoute','angular-loading-bar'])
.config(
		function($routeProvider) {
			$routeProvider
			.when(
					'/inserimentoPrenotazione',
					{
						controller : 'InserimentoPrenotazioneController as inserimentoPrenotazioneCtrl',
						templateUrl : 'HTML/templates/inserisciPrenotazione.html',
					})
			.when(
					'/inserimentoPrenotazione/:pazienteCodiceFiscale',
					{
						controller : 'InserimentoPrenotazioneController as inserimentoPrenotazioneCtrl',
						templateUrl : 'HTML/templates/inserisciPrenotazione.html',
					})
			.when(
					'/inserimentoTipologiaEsame',
					{	
						controller : 'InserimentoTipologiaEsameController as inserimentoTipologiaEsameCtrl',
						templateUrl : 'HTML/templates/inserisciTipologiaEsame.html',
					})		

			.when(
					'/consultazioneTipologieEsamiOfferti',
					{
						controller:'ConsultazioneTipologieEsamiOfferti as consultazioneTipologieEsamiOffertiCtrl',
						templateUrl:'HTML/templates/consultazioneTipologieEsamiOfferti.html',
					})				
			.otherwise({
						redirectTo : '/'
											});
		})
		.factory(
				'entityManagerService',[ '$http', function($http) {
					var methods = {};
					
					// Inserisce un oggetto nel db
					methods.inserisciOggetto = function(url, params, toDo,getFailed) {
						$http({
							method : 'POST',
							url : url,
							headers : {
								'Content-Type' : 'application/json'
							},
							params : params
						}).then(function(data) {
							toDo();
						}, function(data){
							getFailed();
						});
					};
					
					methods.getOggetti = function(url,toDo,getFailed){
						$http({
							method : 'GET',
							url : url,
						}).then(function successCallback(response) {
							toDo(response);
						}, function(response){
							getFailed(response);
						});
					};
					
					methods.getOggetto = function(url,params,toDo,getFailed){
						$http({
							method : 'GET',
							url : url,
							params: params
						}).then(function successCallback(response) {
							toDo(response);
						}, function(response){
							getFailed(response);
						});
					};
					return methods;
					
				}]
		);

