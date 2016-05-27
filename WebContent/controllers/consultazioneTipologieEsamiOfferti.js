/**
 * 
 */

angular.module('teaching').controller("ConsultazioneEsamiOffertiController",
['http',function($http){
	var self = this;
	self.tipologie=[];
	
	$http({
		method: 'GET',
	url:consultazioneTipologieEsamiOfferti,
	}).then(function successCallback(response){
		self.tipologie=responde.data.tipologie;
	})
} ]);
	
// al click selezioni la tipologia
this.addTipologia = function(tipologia) {
	self.tipologia = tipologia;
};












