angular.module('teaching').controller("InserimentoController",
		[ '$http', function($http) {
			var self = this;
			self.tipologie = [];
			self.medici = [];
			self.medico = {};
			self.tipologia = {};
			self.paziente = {};
			self.dataEsame;
			self.codiceFiscalePaziente;
			self.hoProvato = false;
			self.searchMedici;
			self.searchTipologie;

			$http({
				method : 'GET',
				url : 'inserisciNuovaPrenotazione',
			}).then(function successCallback(response) {
				console.log(response);
				self.medici = response.data.medici;
				self.tipologie = response.data.tipologie;
			});

			this.trovaPaziente = function() {
				$http({
					method : 'GET',
					url : 'findPaziente',
					headers : {
						'Content-Type' : 'application/json'
					},
					params : {
						codiceFiscale : self.codiceFiscalePaziente
					}
				}).then(function successCallback(response) {
					console.log(response);
					self.paziente = response.data;
					self.hoProvato = true;
				}, function errorCallback(response) {
					self.paziente = {};
					self.hoProvato = true;
				});
			};

			this.addMedico = function(medico) {
				self.medico = medico;
			};

			this.addTipologia = function(tipologia) {
				self.tipologia = tipologia;
			};

			this.aggiungiPrenotazione = function() {

				$http({
					method : 'POST',
					url : 'inserisciPrenotazione',
					headers : {
						'Content-Type' : 'application/json'
					},
					params : {
						medico : self.medico.codice,
						tipologia : self.tipologia.nome,
						codiceFiscale : self.paziente.codiceFiscale,
						dataEsame : self.dataEsame
					}
				}).success(function(data) {
					console.log(self.medico.codice);
					console.log(data);
				});
			};

		} ]);