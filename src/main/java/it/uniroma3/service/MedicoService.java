package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.Medico;


public interface MedicoService {

	public List<Medico> listMedici();
	public Medico findByCodice(String codice);
	
}
