angular.module('teaching').controller("IndicatoreController",
		[ 'inserimentoService','$http', function($inserimentoService,$http) {
			//mi salvo il contesto della funzione
			var self = this;

			//per l'inserimento di un nuovo indicatore di risultato!
			self.nuovoIndicatore = {};

			// tutte gli indicatori di risultato presenti nel db
			self.indicatori = [];

			//per i filtri
			self.searchIndicatori;

			// GET per la lista di tutti gli indicatori presenti nel sistema
			self.refresh = function(){
				$http({
					method : 'GET',
					url : 'indicatori',
				}).then(function successCallback(response) {
					self.indicatori = response.data;
				});
			}

			// aggiungi un indicatore nella base di dati
			this.inserisciIndicatore = function() {
				var params = {
						nome: self.nuovoIndicatore.nome
				}

				var toDo= function(){
					self.refresh();
					$('#inserimentoIndicatore').modal('hide');

				}
				$inserimentoService.inserisciOggetto('indicatore',params,toDo);
				
			};
			
			self.refresh();

		} ]);