angular.module('teaching').controller("IndicatoreDiRisultatoController",
		[ '$http', function($http) {
			//mi salvo il contesto della funzione
			var self = this;
			
			//per l'inserimento di un nuovo indicatore di risultato!
			self.nuovoIndicatoreRisultato = {};
			
			// aggiungi un nuovo indicatore nella base di dati
			this.inserisciIndicatoreDiRisultato = function() {
				$http({
					method : 'POST',
					url : 'inserisciIndicatoreDiRisultato',
					headers : {
						'Content-Type' : 'application/json'
					},
					params : {
						nome: self.nuovoIndicatoreRisultato.nomeNuovoIndicatoreDiRisultato
					}
				}).success(function(data) {
					console.log(data);
					self.indicatoriDiRisultato.push(
							{ 	id: parseFloat(data), 
								nome: self.nuovoIndicatoreRisultato.nomeNuovoIndicatoreDiRisultato
								}
							);
					$('input').val('');
					$('textarea').val('');
					$('#inserimentoIndicatoreDiRisultato').modal('hide');
				});
			};
		} ]);