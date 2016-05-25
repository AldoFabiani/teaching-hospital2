/**
 * 
 */

(function() {
	var app = angular.module('teaching', []);
	
	app.controller("InserimentoController",['$http', function($http){
		var self = this;
		self.medico={};
		
		var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }
		
		this.aggiungiPrenotazione= function(){
			
			$http({
			      method: 'POST',
			      url: 'inserisciPrenotazione',
			      headers: {'Content-Type': 'application/json'},
			      params:  {medico:self.medico.codice}
			    }).success(function (data) 
			      {
			    	console.log(self.medico.codice);
			    	console.log(data);
			      });
			  };
			
			
			
			
			
//			$http.post('inserisciPrenotazione',self.medico.codice,config).success(function(data){
//				console.log(self.medico.codice);
//				console.log(data);
//			});
//		}
	}]);

	app.directive('listaMedici', [ '$http', function($http) {
		return {
			restrict : 'E',
			templateUrl : 'lista-medici.html',
			controller : function() {
				var self = this;
				self.medici = [];
				$http.get('inserisciNuovaPrenotazione').success(function(data) {
					self.medici = data.medici;
				});
				
				this.addMedicoPrenotazione = function(codice){
					$('#codiceMedico').val(codice);
				};
			},
			controllerAs : 'medici'
		};
	} ]);

	app.directive('listaTipologie', [ '$http', function($http) {
		return {
			restrict : "E",
			templateUrl : "lista-tipologie.html",
			controller : function() {
				var self = this;
				self.tipologie = [];
				$http.get('inserisciNuovaPrenotazione').success(function(data) {
					self.tipologie = data.tipologie;

				});
			},
			controllerAs : "tipologie"
		};
	} ]);
	
	
	
	
	
	
})();
