angular.module('teaching').controller("InserimentoTipologiaEsameController",
		[ '$http', function($http) {
			//mi salvo il contesto della funzione
			var self = this;
			
			//nome, descrizione e costo della nuova tipologia di esame 
			// e tutte le sue norme di preparazione e i suoi indicatori di risultato
			self.nuovaTipologiaEsame = {
					norme: [],
					indicatori: []
			};
			
			this.changedStatusNorme = function($event,norma){
				var checkbox = $event.target;
				if(checkbox.checked==true){
					self.addNorma(norma.id);
				}
				else{
					self.removeNorma(norma.id);
				}
			}
			this.changedStatusIndicatori = function($event,indicatore){
				  var checkbox = $event.target;
				  if(checkbox.checked==true){
					  self.addIndicatore(indicatore.id);
				  }
				  else{
					  self.removeIndicatore(indicatore.id);
				  }
			}
			
			// seleziono una norma di preparazione
			this.addNorma = function(idNorma) {
				self.nuovaTipologiaEsame.norme.push(idNorma);
			};
			
			// deseleziono una norma di preparazione
			this.removeNorma = function(idNorma) {
				var index = self.nuovaTipologiaEsame.norme.indexOf(idNorma);
				if(index>-1) self.nuovaTipologiaEsame.norme.splice(index, 1);
			};

			// seleziono un indicatore di risultato
			this.addIndicatore = function(idIndicatore) {
				self.nuovaTipologiaEsame.indicatori.push(idIndicatore);
			};
			
			// deseleziono un indicatore di risultato
			this.removeIndicatore = function(idIndicatore) {
				var index = self.nuovaTipologiaEsame.indicatori.indexOf(idIndicatore);
				if(index>-1) self.nuovaTipologiaEsame.indicatori.splice(index, 1);
			};
			
			this.isNormaChecked = function(idNorma){
				return (self.nuovaTipologiaEsame.norme.indexOf(idNorma)>=0);
			}
			this.isIndicatoreChecked = function(idIndicatore){
				return (self.nuovaTipologiaEsame.indicatori.indexOf(idIndicatore)>=0);
			}

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
						nomeTipologiaEsame : self.nuovaTipologiaEsame.nome,
						descrizioneTipologiaEsame: self.nuovaTipologiaEsame.descrizione,
						costoTipologiaEsame: self.nuovaTipologiaEsame.costo,
						norme: self.nuovaTipologiaEsame.norme,
						indicatori: self.nuovaTipologiaEsame.indicatori
						
					}
				}).success(function(data) {
					console.log(data);
				});
			};

		} ]);