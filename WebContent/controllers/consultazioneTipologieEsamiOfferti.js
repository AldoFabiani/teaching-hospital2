angular.module('teaching').controller("ConsultazioneTipologieEsamiOfferti",
['$http','$filter',function($http,$filter){
	var self = this;
	self.tipologie=[];
	self.searchTipologie;
	self.tipologia={};
	self.previewPronto=true;
	
	$http({
		method: 'GET',
		url:'inserisciNuovaPrenotazione',
	}).then(function successCallback(response){
		self.tipologie=response.data.tipologie;
	});
	
	// al click selezioni la tipologia
	this.addTipologia = function(tipologia) {
		self.tipologia = tipologia;
		self.presente=true;
		console.log(tipologia);
		delete self.tipologia["id"];
		self.tipologia.costo= $filter('currency')(self.tipologia.costo,"€");
		$('#sceltaEffettuata').modal('show');
	};



} ]);
	
