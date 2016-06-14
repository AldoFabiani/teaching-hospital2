package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.Medico;
import it.uniroma3.model.Prenotazione;


public interface MedicoService {

	public List<Medico> listMedici();
	public Medico findByCodice(String codice);
	public List<Prenotazione> listPrenotazioniMedico(String codiceMedico);
	
}
