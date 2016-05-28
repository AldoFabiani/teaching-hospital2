angular.module('teaching').controller("ConsultazioneTipologieEsamiOfferti",
['$http',function($http){
	var self = this;
	self.tipologie=[];
	self.searchTipologie;
	self.tipologia={};
	
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
	};



} ]);
	










