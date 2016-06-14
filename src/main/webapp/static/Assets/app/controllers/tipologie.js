angular.module('teaching').controller(
		"TipologieController",
		[
				'entityManagerService',
				'$filter',
				function($entityManagerService, $filter) {
					// mi salvo il contesto della funzione
					var self = this;

					self.tipologie = [];
					self.searchTipologie;
					self.tipologia = {};
					
					
					// al click selezioni la tipologia
					this.addTipologia = function(tipologia) {
						self.tipologia = tipologia;
						$('#sceltaEffettuata').modal('hide');
						self.tipologia.costo = self.tipologia.costo
					};
					
					
					// GET per la lista delle tipologie
					self.getTipologie = function() {
						setTipologie = function(response) {
							self.tipologie = response.data;
						};
						$entityManagerService.getOggetti(
								'tipologia/listTipologie', setTipologie);
					}();
					
				} ]);
