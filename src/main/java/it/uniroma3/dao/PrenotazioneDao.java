package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Prenotazione;

public interface PrenotazioneDao {
	
	public void save(Prenotazione prenotazione);  // Create
	public Prenotazione findByPrimaryKey(Long id);     // Retrieve
	public List<Prenotazione> findAll();       
	public void update(Prenotazione prenotazione); //Update
	public void delete(Prenotazione prenotazione); //Delete	
	
}