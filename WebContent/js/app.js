/**
 * 
 */

var app = angular.module('teaching', []);

app.controller('MediciController', function() {
	var self = this;
	var test;
	this.medici = (function() {
		return $.getJSON('inserisciNuovaPrenotazione').then(function(data) {
			test=data;
			return data;
		});
	})();
	
	console.log(test);
});
