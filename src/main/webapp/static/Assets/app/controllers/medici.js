angular.module('teaching').controller("MediciController",
		[ 'entityManagerService', '$filter', function($entityManagerService, $filter) {
			//mi salvo il contesto della funzione
			var self = this;
			
			self.medici = [];
			self.searchMedici;

			self.setMedici = function(response){
				self.medici = response.data;
			};
			
			self.getMedici = function(){
				$entityManagerService.getOggetti('medico/listMedici',self.setMedici);
			};
			
			self.getMedici();
		} ]);