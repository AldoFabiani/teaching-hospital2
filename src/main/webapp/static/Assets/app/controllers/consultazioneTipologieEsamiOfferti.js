angular.module('teaching').controller("ConsultazioneTipologieEsamiOfferti",
['$http','$filter',function($http,$filter){
	var self = this;
	self.tipologie=[];
	self.searchTipologie;
	self.tipologia={};
	self.previewPronto=true;
	
	$http({
		method: 'GET',
		url:'tipologia/listTipologie',
	}).then(function successCallback(response){
		self.tipologie=response.data.tipologie;
	});
	
	// al click selezioni la tipologia
	this.addTipologia = function(tipologia) {
		self.tipologia = tipologia;
		self.presente=true;
		$('#sceltaEffettuata').modal('hide');
		delete self.tipologia["id"];
		self.tipologia.costo= $filter('currency')(self.tipologia.costo,"€");
	};



} ]);
	
