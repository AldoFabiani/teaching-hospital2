package it.uniroma3.persistence;

import java.util.List;

import it.uniroma3.model.Indicatore;

public interface IndicatoreDao {
	
	public void save(Indicatore indicatore);  // Create
	public Indicatore findByPrimaryKey(Long id);     // Retrieve
	public List<Indicatore> findAll();       
//	public void update(Indicatore indicatore); //Update
//	public void delete(Indicatore indicatore); //Delete	
	public Indicatore findByNome(String nomeIndicatore);
}