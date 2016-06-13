angular.module('teaching').controller(
		"IndicatoreController",
		[
				'entityManagerService',
				function($entityManagerService) {
					// mi salvo il contesto della funzione
					var self = this;

					// per l'inserimento di un nuovo indicatore di risultato!
					self.nuovoIndicatore = {};

					// tutte gli indicatori di risultato presenti nel db
					self.indicatori = [];

					// per i filtri
					self.searchIndicatori;

					// GET per la lista di tutti gli indicatori presenti nel
					// sistema
					self.refresh = function() {

						var doTask = function(response) {
							self.indicatori = response.data;
						}
						$entityManagerService.getOggetti(
								'indicatore/listIndicatori', doTask);
					}

					// aggiungi un indicatore nella base di dati
					this.inserisciIndicatore = function() {
						params = {
							nome : self.nuovoIndicatore.nome
						}

						doTask = function() {
							self.refresh();
							alert("Inserimento riuscito con successo");
							$(':input', '#inserimentoIndicatore').val('');
							$('#inserimentoIndicatore').modal('hide');
						}
						getFailed = function() {
							alert("Qualcosa non è andato a buon fine.");
							$(':input', '#inserimentoIndicatore').val('');
							$('#inserimentoIndicatore').modal('hide');
						}
						$entityManagerService.inserisciOggetto(
								'indicatore/addIndicatore', params, doTask,
								getFailed);

					};

					self.refresh();

				} ]);