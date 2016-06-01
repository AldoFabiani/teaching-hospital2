angular.module('teaching').controller("InserimentoTipologiaEsameController",
		[ '$http', function($http) {
			//mi salvo il contesto della funzione
			var self = this;
			
			//liste bindate e caricate dal GET
			self.indicatoriDiRisultato = [];
			self.normeDiPreparazione = [];
			
			//nome, descrizione e costo della nuova tipologia di esame 
			// e tutte le sue norme di preparazione e i suoi indicatori di risultato
			self.nuovaTipologiaEsame = {
					normeTipologiaEsame: [],
					indicatoriTipologiaEsame: []
			};
		
			//per i filtri
			self.searchNormeDiPreparazione;
			self.searchIndicatoriDiRisultato;
			
			//per l'inserimento di una nuova norma di preparazione!
			self.nuovaNormaDiPreparazione = {};
		
			//per l'inserimento di un nuovo indicatore di risultato!
			self.nuovoIndicatoreRisultato = {};

			// GET per la lista di tutte le norme di preparazione e di tutti gli indicatori di risultato
			// presenti nel sistema
			$http({
				method : 'GET',
				url : 'inserisciNuovaTipologiaEsame',
			}).then(function successCallback(response) {
				self.indicatoriDiRisultato = response.data.indicatoriDiRisultato;
				self.normeDiPreparazione = response.data.normeDiPreparazione;
			});

			this.changedStatusNormeDiPreparazione = function($event,norma){
				  var checkbox = $event.target;
				  if(checkbox.checked==true){
					  self.addNormaDiPreparazione(norma.id);
				  }
				  else{
					  self.removeNormaDiPreparazione(norma.id);
				  }
			}
			
			this.changedStatusIndicatoriDiRisultato = function($event,indicatore){
				  var checkbox = $event.target;
				  if(checkbox.checked==true){
					  self.addIndicatoreDiRisultato(indicatore.id);
				  }
				  else{
					  self.removeIndicatoreDiRisultato(indicatore.id);
				  }
			}
			
			// seleziono una norma di preparazione
			this.addNormaDiPreparazione = function(idNormaDiPreparazione) {
				self.nuovaTipologiaEsame.normeTipologiaEsame.push(idNormaDiPreparazione);
			};
			
			// deseleziono una norma di preparazione
			this.removeNormaDiPreparazione = function(idNormaDiPreparazione) {
				var index = self.nuovaTipologiaEsame.normeTipologiaEsame.indexOf(idNormaDiPreparazione);
				if(index>-1) self.nuovaTipologiaEsame.normeTipologiaEsame.splice(index, 1);
			};

			// seleziono un indicatore di risultato
			this.addIndicatoreDiRisultato = function(idIndicatoreDiRisultato) {
				self.nuovaTipologiaEsame.indicatoriTipologiaEsame.push(idIndicatoreDiRisultato);
			};
			
			// deseleziono un indicatore di risultato
			this.removeIndicatoreDiRisultato = function(idIndicatoreDiRisultato) {
				var index = self.nuovaTipologiaEsame.indicatoriTipologiaEsame.indexOf(idIndicatoreDiRisultato);
				if(index>-1) self.nuovaTipologiaEsame.indicatoriTipologiaEsame.splice(index, 1);
			};
			
			// aggiungi una norma nella base di dati
			this.inserisciNormaDiPreparazione = function() {
				$http({
					method : 'POST',
					url : 'inserisciNormaDiPreparazione',
					headers : {
						'Content-Type' : 'application/json'
					},
					params : {
						nome: self.nuovaNormaDiPreparazione.nomeNuovaNormaDiPreparazione,
						descrizione: self.nuovaNormaDiPreparazione.descrizioneNuovaNormaDiPreparazione
					}
				}).success(function(data) {
					console.log(data);
					self.normeDiPreparazione.push(
							{ 	id: parseFloat(data), 
								nome: self.nuovaNormaDiPreparazione.nomeNuovaNormaDiPreparazione,
								descrizione: self.nuovaNormaDiPreparazione.descrizioneNuovaNormaDiPreparazione
								}
							);
					$('input').val('');
					$('textarea').val('');
					$('#inserimentoNormaDiPreparazione').modal('hide');
				});
			};
			
			// aggiungi un nuovo indicatore nella base di dati
			this.inserisciIndicatoreDiRisultato = function() {
				$http({
					method : 'POST',
					url : 'inserisciIndicatoreDiRisultato',
					headers : {
						'Content-Type' : 'application/json'
					},
					params : {
						nome: self.nuovoIndicatoreRisultato.nomeNuovoIndicatoreDiRisultato
					}
				}).success(function(data) {
					console.log(data);
					self.indicatoriDiRisultato.push(
							{ 	id: parseFloat(data), 
								nome: self.nuovoIndicatoreRisultato.nomeNuovoIndicatoreDiRisultato
								}
							);
					$('input').val('');
					$('textarea').val('');
					$('#inserimentoIndicatoreDiRisultato').modal('hide');
				});
			};

			// aggiungi una tipologia di esame nella base di dati
			// caso per il momento semplificato:
			// - no controllo sul nome
			this.aggiungiTipologiaEsame = function() {
				$http({
					method : 'POST',
					url : 'inserisciTipologiaEsame',
					headers : {
						'Content-Type' : 'application/json'
					},
					params : {
						nomeTipologiaEsame : self.nuovaTipologiaEsame.nomeTipologiaEsame,
						descrizioneTipologiaEsame: self.nuovaTipologiaEsame.descrizioneTipologiaEsame,
						costoTipologiaEsame: self.nuovaTipologiaEsame.costoTipologiaEsame,
						normeTipologiaEsame: self.nuovaTipologiaEsame.normeTipologiaEsame,
						indicatoriTipologiaEsame: self.nuovaTipologiaEsame.indicatoriTipologiaEsame
						
					}
				}).success(function(data) {
					console.log(data);
				});
			};

		} ]);