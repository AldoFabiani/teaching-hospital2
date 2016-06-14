angular
		.module('teaching')
		.controller(
				"PrenotazioniController",
				[
						'entityManagerService',
						'$filter',
						function($entityManagerService, $filter) {
							// mi salvo il contesto della funzione
							var self = this;

							// medico, tipologia, paziente e data esame
							// selezionati
							self.medico = {};
							self.tipologia = {};
							self.dataEsame;
							self.paziente = {};
							self.codiceFiscalePaziente;
							self.prenotazioni = [];
							self.prenotazione = {};
							// booleano per ng-show e hide
							self.hoCercatoPaziente = false;
							self.hoCercatoMedico = false;
							self.previewPronto = true;

							// se è presente carica il paziente per mostrarlo
							// all'amministratore
							// durante la conferma
							this.trovaPaziente = function() {
								$("#myButton").button('loading');
								setPaziente = function(response) {
									self.paziente.nome = response.data.nome;
									self.paziente.cognome = response.data.cognome;
									self.paziente.codiceFiscale = response.data.codiceFiscale;
									self.paziente.email = response.data.email;
									self.paziente.telefono = response.data.telefono;
									self.paziente.dataNascita = response.data.dataNascita;
									self.paziente.indirizzo = response.data.indirizzo;
									self.hoCercatoPaziente = true;
									$("#myButton").button('reset');
								};
								getFailed = function(response) {
									self.paziente = {};
									self.hoCercatoPaziente = true;
									$("#myButton").button('reset');
								};
								params = {
									codiceFiscale : self.codiceFiscalePaziente
								};
								$entityManagerService.getOggetto(
										'paziente/find/'
												+ self.codiceFiscalePaziente,
										params, setPaziente, getFailed);
							};

							// al click selezioni il medico
							this.selectMedico = function(medico) {
								$(event.target).siblings()
										.removeClass("active");
								$(event.target).addClass("active");
								self.hoCercatoMedico = false;
								if (self.medico === medico) {
									self.medico = null
								} else
									self.medico = medico;
							};

							// al click selezioni la tipologia
							this.addTipologia = function(tipologia) {
								self.tipologia = tipologia;
								$(event.target).siblings()
										.removeClass("active");
								$(event.target).toggleClass("active");
							};

							// fa la preview della prenotazione
							this.makeNewPrenotazione = function() {
								self.prenotazione.paziente = self.paziente.codiceFiscale;
								if (self.medico.nome)
									self.prenotazione.medico = self.medico.nome
											+ ' ' + self.medico.cognome;
								else
									self.prenotazione.medico = '';
								self.prenotazione.esame = self.tipologia.nome;
								self.prenotazione.data = self.dataEsame;
								self.prenotazione.prezzo = self.tipologia.costo
							};

							// aggiungi una prenotazione nella base di dati
							this.aggiungiPrenotazione = function() {
								params = {
									medico : self.medico.codice,
									tipologia : self.tipologia.nome,
									codiceFiscale : self.paziente.codiceFiscale,
									dataEsame : self.dataEsame
								}
								doTask = function(response) {
									self.paziente = {};
									self.codiceFiscalePaziente = '';
									self.prenotazione = {};
									self.tipologia = {};
									self.dataEsame = null;
									self.hoCercatoPaziente = false;
									$('button').removeClass('active');
									$('#prenotazioneAggiunta').modal('hide');
								}
								$entityManagerService.inserisciOggetto(
										'prenotazione/addPrenotazione', params,
										doTask);
							};

							// carica le prenotazioni dal database
							this.caricaPrenotazioni = function() {
								doTask = function(response) {
									self.prenotazioni = response.data
									self.hoCercatoMedico = true;
								};
								doFail = function(response) {
								}
								$entityManagerService.getOggetto(
										'medico/listPrenotazioni/'+self.medico.codice, {},
										doTask, doFail);
							};
						} ]);