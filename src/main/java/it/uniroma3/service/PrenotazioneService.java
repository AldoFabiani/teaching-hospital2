package it.uniroma3.service;

import it.uniroma3.model.Prenotazione;

public interface PrenotazioneService {
	public void insertPrenotazione(Prenotazione prenotazione);
	public Prenotazione findPrenotazioneByCodiceConRisultati(String codice);
	public Prenotazione findPrenotazioneByCodice(String codice);
	public void updatePrenotazione(Prenotazione prenotazione);
}
