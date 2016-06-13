package it.uniroma3.service;

import it.uniroma3.model.Paziente;

public interface PazienteService {

	public void insertPaziente(Paziente paziente);

	Paziente findPaziente(String codiceFiscale);
	
}
