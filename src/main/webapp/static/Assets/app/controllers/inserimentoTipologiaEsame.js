angular.module('teaching').controller("InserimentoTipologiaEsameController",
		['entityManagerService','$filter', function($entityManagerService,$filter) {
			//mi salvo il contesto della funzione
			var self = this;
			
			//nome, descrizione e costo della nuova tipologia di esame 
			// e tutte le sue norme di preparazione e i suoi indicatori di risultato
			self.nuovaTipologiaEsame = {
					nome: '',
					descrizione: '',
					costo: '',
					norme: [],
					indicatori: []
			};
			
			this.changedStatusNorme = function($event,norma){
				var checkbox = $event.target;
				if(checkbox.checked==true){
					self.addNorma(norma.nome);
				}
				else{
					self.removeNorma(norma.nome);
				}
			}
			this.changedStatusIndicatori = function($event,indicatore){
				  var checkbox = $event.target;
				  if(checkbox.checked==true){
					  self.addIndicatore(indicatore.nome);
				  }
				  else{
					  self.removeIndicatore(indicatore.nome);
				  }
			}
			
			// seleziono una norma di preparazione
			this.addNorma = function(nomeNorma) {
				self.nuovaTipologiaEsame.norme.push(nomeNorma);
			};
			
			// deseleziono una norma di preparazione
			this.removeNorma = function(nomeNorma) {
				var index = self.nuovaTipologiaEsame.norme.indexOf(nomeNorma);
				if(index>-1) self.nuovaTipologiaEsame.norme.splice(index, 1);
			};

			// seleziono un indicatore di risultato
			this.addIndicatore = function(nomeIndicatore) {
				self.nuovaTipologiaEsame.indicatori.push(nomeIndicatore);
			};
			
			// deseleziono un indicatore di risultato
			this.removeIndicatore = function(nomeIndicatore) {
				var index = self.nuovaTipologiaEsame.indicatori.indexOf(nomeIndicatore);
				if(index>-1) self.nuovaTipologiaEsame.indicatori.splice(index, 1);
			};
			
			this.isNormaChecked = function(nomeNorma){
				return (self.nuovaTipologiaEsame.norme.indexOf(nomeNorma)>=0);
			}
			this.isIndicatoreChecked = function(nomeIndicatore){
				return (self.nuovaTipologiaEsame.indicatori.indexOf(nomeIndicatore)>=0);
			}
			
			// aggiungi una tipologia di esame nella base di dati
			// caso per il momento semplificato:
			// - no controllo sul nome
			this.aggiungiTipologiaEsame = function() {
				params = {
					nome : self.nuovaTipologiaEsame.nome,
					descrizione: self.nuovaTipologiaEsame.descrizione,
					costo: self.nuovaTipologiaEsame.costo,
					norme: self.nuovaTipologiaEsame.norme,
					indicatori: self.nuovaTipologiaEsame.indicatori
				};
				doTask = function() {
					$(':input').val('');
					$(':checkbox').val('');
					self.nuovaTipologiaEsame.nome='';
					self.nuovaTipologiaEsame.descrizione='';
					self.nuovaTipologiaEsame.costo='';
//					self.nuovaTipologiaEsame.norme=[];
//					self.nuovaTipologiaEsame.indicatori=[];
					$('#tipologiaAggiunta').modal('hide');
				};
				$entityManagerService.inserisciOggetto('tipologia/addTipologia', params,doTask,function(){});		
			};

		} ]);