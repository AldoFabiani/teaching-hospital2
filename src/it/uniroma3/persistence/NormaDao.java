package it.uniroma3.persistence;

import java.util.List;

import it.uniroma3.model.Norma;

public interface NormaDao {
	
	public void save(Norma norma);  // Create
	public Norma findByPrimaryKey(Long id);     // Retrieve
	public List<Norma> findAll();       
//	public void update(Norma norma); //Update
//	public void delete(Norma norma); //Delete	
	public Norma findByNome(String nomeNorma);
}