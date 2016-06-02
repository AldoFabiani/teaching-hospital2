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

					// GET per la lista delle tipologie
					self.getTipologie = function() {
						setTipologie = function(response) {
							self.tipologie = response.data;
						};
						$entityManagerService.getOggetti('tipologieController',
								setTipologie);
					};

					self.getTipologie();
				} ]);
