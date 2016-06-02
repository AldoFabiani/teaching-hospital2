angular
		.module('teaching')
		.controller(
				"InserimentoPrenotazioneController",
				[
						'entityManagerService',
						'$filter',
						function($entityManagerService, $filter) {
							// mi salvo il contesto della funzione
							var self = this;

							// liste bindate e caricate dal GET
							self.tipologie = [];
							self.medici = [];

							// medico, tipologia, paziente e data esame
							// selezionati
							self.medico = {};
							self.tipologia = {};
							self.dataEsame;
							self.paziente = {};
							self.codiceFiscalePaziente;
							self.prenotazione = {};
							// booleano per ng-show e hide
							self.hoCercatoPaziente = false;
							self.previewPronto = true;
							// per i filtri
							self.searchMedici;
							self.searchTipologie;

							// GET per la lista delle tipologie e la lista dei
							// medici
							self.getTipologie = function(){
								doTask = function(response){
									self.tipologie = response.data;
								};
								$entityManagerService.getOggetto('inserisciNuovaPrenotazione', doTask);	
							};
							self.getTipologie();
							// se è presente carica il paziente per mostrarlo
							// all'amministratore
							// durante la conferma
							this.trovaPaziente = function() {
								$("#myButton").button('loading');
								$http(
										{
											method : 'GET',
											url : 'findPaziente',
											headers : {
												'Content-Type' : 'application/json'
											},
											params : {
												codiceFiscale : self.codiceFiscalePaziente
											}
										}).then(function(response) {
									self.paziente = response.data;
									self.hoCercatoPaziente = true;
									$("#myButton").button('reset');

								}, function(response) {
									self.paziente = {};
									self.hoCercatoPaziente = true;
									$("#myButton").button('reset');
								});
							};

							// al click selezioni il medico
							this.selectMedico = function(medico) {
								$(event.target).siblings()
										.removeClass("active");
								$(event.target).addClass("active");
								if (self.medico === medico) {
									self.medico = null
								} else
									self.medico = medico;

							};

							// aggiungi una prenotazione nella base di dati
							this.aggiungiPrenotazione = function() {
								params = {
									medico : self.medico.codice,
									tipologia : self.tipologia.nome,
									codiceFiscale : self.paziente.codiceFiscale,
									dataEsame : self.dataEsame
								}
								doTask = function(response){
									self.paziente = {};
									self.hoCercatoPaziente = false;
									$('li').removeClass('active');
									$('#prenotazioneAggiunta').modal('hide');
								}
								$entityManagerService.inserisciOggetto('inserisciPrenotazione', params, doTask); 
							};
			// al click selezioni la tipologia
			this.addTipologia = function(tipologia) {
				self.tipologia = tipologia;
				$(event.target).siblings().removeClass("active");
				$(event.target).toggleClass("active");
			};

<<<<<<< HEAD
							this.makeNewPrenotazione = function() {
								self.prenotazione.paziente = self.paziente.codiceFiscale;
								self.prenotazione.medico = self.medico.nome
										+ self.medico.cognome;
								self.prenotazione.esame = self.tipologia.nome;
								self.prenotazione.data = self.dataEsame;
								self.prenotazione.prezzo = $filter('currency')(
										self.tipologia.costo, "€");
							}
=======
			// al click selezioni la tipologia
			this.addTipologia = function(tipologia) {
				self.tipologia = tipologia;
				$(event.target).siblings().removeClass("active");
				$(event.target).toggleClass("active");
			};
>>>>>>> refs/remotes/origin/master

						} ]);