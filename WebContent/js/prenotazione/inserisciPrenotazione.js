function inserisciPrenotazione() {
	$http.get('/inserisciPrenotazioneController', config).then(successCallback,
			errorCallback);
}
function inserisciNuovaPrenotazione(http) {
	
}