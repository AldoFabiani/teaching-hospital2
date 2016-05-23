package it.uniroma3.persistence;

import java.util.List;

import it.uniroma3.model.Medico;

public interface MedicoDao {
	
	public void save(Medico medico);  // Create
	public Medico findByPrimaryKey(Long id);     // Retrieve
	public List<Medico> findAll();       
	public void update(Medico medico); //Update
	public void delete(Medico medico); //Delete	
}