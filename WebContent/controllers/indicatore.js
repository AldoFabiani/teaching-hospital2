angular.module('teaching').controller("IndicatoreController",
		[ 'entityManagerService', function($entityManagerService) {
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
				
				var doTask= function(response){
					self.indicatori = response.data;
				}
				$entityManagerService.getOggetto('indicatori',doTask);
			}

			// aggiungi un indicatore nella base di dati
			this.inserisciIndicatore = function() {
				var params = {
						nome: self.nuovoIndicatore.nome
				}

				var toDo= function(){
					self.refresh();
				}
				$entityManagerService.inserisciOggetto('indicatore',params,toDo);
				
			};
			
			self.refresh();

		} ]);