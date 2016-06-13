package it.uniroma3.dao;

import java.util.List;

import it.uniroma3.model.TipologiaEsame;

public interface TipologiaEsameDao {
	
	public void save(TipologiaEsame tipologiaEsame);  // Create
	public TipologiaEsame findByPrimaryKey(Long id);     // Retrieve
	public List<TipologiaEsame> findAll();       
	public void update(TipologiaEsame tipologiaEsame); //Update
	public void delete(TipologiaEsame tipologiaEsame); //Delete	
	public TipologiaEsame findByNome(String nomeTipologia);

	
}