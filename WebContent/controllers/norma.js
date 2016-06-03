angular.module('teaching').controller(
		"NormaController",
		[
				'entityManagerService',
				function($entityManagerService) {
					// mi salvo il contesto della funzione
					var self = this;

					// per l'inserimento di una nuova norma di preparazione!
					self.nuovaNorma = {};

					// tutte le norme di preparazione presenti nel db
					self.norme = [];

					// per i filtri
					self.searchNorme;

					// GET per la lista di tutte le norme presenti nel sistema
					self.refresh = function() {
						
						doTask = function(response){
							self.norme = response.data;
						}
						$entityManagerService.getOggetti('norme', doTask);
					}

					// aggiungi una norma nella base di dati
					this.inserisciNorma = function() {
						params = {
							nome : self.nuovaNorma.nome,
							descrizione : self.nuovaNorma.descrizione
						}

						doTask = function() {
							self.refresh();
							$(':input','#inserimentoNorma').val('');
							$('#inserimentoNorma').modal('hide');
						};
						$entityManagerService.inserisciOggetto('norma', params,
								doTask);

					}
					
					self.refresh();
				} ]);