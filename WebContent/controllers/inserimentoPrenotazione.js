angular.module('teaching').controller("InserimentoPrenotazioneController",
		[ '$http', function($http) {
			//mi salvo il contesto della funzione
			var self = this;
			
			//liste bindate e caricate dal GET
			self.tipologie = [];
			self.medici = [];
			
			//medico, tipologia, paziente e data esame selezionati
			self.medico = {};
			self.tipologia = {};
			self.dataEsame;
			self.paziente = {};
			self.codiceFiscalePaziente;
			//booleano per ng-show e hide
			self.hoCercatoPaziente = false;
			
			//per i filtri
			self.searchMedici;
			self.searchTipologie;

			// GET per la lista delle tipologie e la lista dei medici
			$http({
				method : 'GET',
				url : 'inserisciNuovaPrenotazione',
			}).then(function successCallback(response) {
				self.medici = response.data.medici;
				self.tipologie = response.data.tipologie;
			});

			// se è presente carica il paziente per mostrarlo all'amministratore
			// durante la conferma
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
					self.paziente = response.data;
					self.hoCercatoPaziente = true;
				}, function errorCallback(response) {
					self.paziente = {};
					self.hoCercatoPaziente = true;
				});
			};

			// al click selezioni il medico
			this.addMedico = function(medico) {
				self.medico = medico;
			};

			// al click selezioni la tipologia
			this.addTipologia = function(tipologia) {
				self.tipologia = tipologia;
			};

			// aggiungi una prenotazione nella base di dati
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
					console.log(data);
				});
			};

		} ]);