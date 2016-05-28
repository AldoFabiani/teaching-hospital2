angular.module('teaching').controller("InserimentoTipologiaEsameController",
		[ '$http', function($http) {
			//mi salvo il contesto della funzione
			var self = this;
			
			//liste bindate e caricate dal GET
			self.indicatoriDiRisultato = [];
			self.normeDiPreparazione = [];
			
			//nome, descrizione e costo della nuova tipologia di esame 
			// e tutte le sue norme di preparazione e i suoi indicatori di risultato
			self.nomeTipologiaEsame;
			self.descrizioneTipologiaEsame;
			self.costoTipologiaEsame;
			self.normeTipologiaEsame = [];
			self.indicatoriTipologiaEsame = [];
			
			//per i filtri
			self.searchNormeDiPreparazione;
			self.searchIndicatoriDiRisultato;
			
			//per l'inserimento di una nuova tipologia!
			self.nomeNuovaTipologia;
			self.descrizioneNuovaTipologia;

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
					  self.addNormaDiPreparazione(norma);
				  }
				  else{
					  self.removeNormaDiPreparazione(norma);
				  }
			}
			
			// seleziono una norma di preparazione
			this.addNormaDiPreparazione = function(normaDiPreparazione) {
				self.normeTipologiaEsame.push(normaDiPreparazione);
			};
			
			// deseleziono una norma di preparazione
			this.removeNormaDiPreparazione = function(normaDiPreparazione) {
				var index = self.normeTipologiaEsame.indexOf(normaDiPreparazione);
				if(index>-1) self.normeTipologiaEsame.splice(index, 1);
			};

			// seleziono un indicatore di risultato
			this.addIndicatoreDiRisultato = function(indicatoreDiRisultato) {
				self.indicatoriTipologiaEsame.push(indicatoreDiRisultato);
			};
			
			// deseleziono un indicatore di risultato
			this.addIndicatoreDiRisultato = function(indicatoreDiRisultato) {
				var index = self.indicatoriTipologiaEsame.indexOf(indicatoreDiRisultato);
				if(index>-1) self.indicatoriTipologiaEsame.splice(index, 1);
			};
			
			this.nuovaNormaDiPreparazione = function(){
				self.normeDiPreparazione.push(
						{ 	id: -1, 
							nome: self.nomeNuovaTipologia,
							descrizione: self.descrizioneNuovaTipologia
							}
						);
				self.nomeNuovaTipologia="";
				self.descrizioneNuovaTipologia="";
			}

			// aggiungi una tipologia di esame nella base di dati
			// caso per il momento semplificato:
			// - no controllo sul nome
			this.aggiungiPrenotazione = function() {
				$http({
					method : 'POST',
					url : 'inserisciTipologiaEsame',
					headers : {
						'Content-Type' : 'application/json'
					},
					params : {
						nomeTipologiaEsame : self.nomeTipologiaEsame,
						descrizioneTipologiaEsame: self.descrizioneTipologiaEsame,
						costoTipologiaEsame: self.costoTipologiaEsame,
						normeTipologiaEsame: self.normeTipologiaEsame,
						indicatoriTipologiaEsame: self.indicatoriTipologiaEsame
						
					}
				}).success(function(data) {
					console.log(data);
				});
			};

		} ]);