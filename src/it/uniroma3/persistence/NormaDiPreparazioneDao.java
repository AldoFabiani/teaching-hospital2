package it.uniroma3.persistence;

import java.util.List;

import it.uniroma3.model.NormaDiPreparazione;

public interface NormaDiPreparazioneDao {
	
//	public void save(NormaDiPreparazione normaDiPreparazione);  // Create
//	public NormaDiPreparazione findByPrimaryKey(Long id);     // Retrieve
	public List<NormaDiPreparazione> findAll();       
//	public void update(NormaDiPreparazione normaDiPreparazione); //Update
//	public void delete(NormaDiPreparazione normaDiPreparazione); //Delete	
}