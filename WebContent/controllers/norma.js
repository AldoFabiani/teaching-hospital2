angular.module('teaching').controller("NormaController",
		[ 'inserimentoService','$http', function($inserimentoService,$http) {
			//mi salvo il contesto della funzione
			var self = this;

			//per l'inserimento di una nuova norma di preparazione!
			self.nuovaNorma = {};

			// tutte le norme di preparazione presenti nel db
			self.norme = [];

			//per i filtri
			self.searchNorme;

			// GET per la lista di tutte le norme presenti nel sistema
			self.refresh = function(){
				$http({
					method : 'GET',
					url : 'norme',
				}).then(function successCallback(response) {
					self.norme = response.data;
				});
			}

			// aggiungi una norma nella base di dati
			this.inserisciNorma = function() {
				var params = {
						nome: self.nuovaNorma.nome,
						descrizione: self.nuovaNorma.descrizione
				}

				var toDo= function(){
					self.refresh();
					$('#inserimentoNorma').modal('hide');

				}
				$inserimentoService.inserisciOggetto('norma',params,toDo);
				
			};
			
			self.refresh();

		} ]);