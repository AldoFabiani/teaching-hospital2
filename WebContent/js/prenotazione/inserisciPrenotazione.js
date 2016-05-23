function inserisciPrenotazione() {
	$http.get('/inserisciPrenotazioneController', config).then(successCallback,
			errorCallback);
}
function inserisciNuovaPrenotazione(http) {
	http({
		method : 'GET',
		url : 'inserisciNuovaPrenotazione'
	}).then(function successCallback(response) {
		// this callback will be called asynchronously
		// when the response is available
		document.getElementById('medici').innerHTML = response.data;
	}, function errorCallback(response) {
		// called asynchronously if an error occurs
		// or server returns response with an error status.
		console.log(response);
	});
}