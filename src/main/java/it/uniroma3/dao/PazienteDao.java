package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.Paziente;

public interface PazienteDao {
	
	public void save(Paziente paziente);  // Create
	public Paziente findByPrimaryKey(Long id);     // Retrieve
	public List<Paziente> findAll();       
	public void update(Paziente paziente); //Update
	public void delete(Paziente paziente); //Delete	
	public Paziente findByCodiceFiscale(String codiceFiscalePaziente);

}