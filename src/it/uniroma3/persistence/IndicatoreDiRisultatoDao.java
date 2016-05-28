package it.uniroma3.persistence;

import java.util.List;

import it.uniroma3.model.IndicatoreDiRisultato;

public interface IndicatoreDiRisultatoDao {
	
//	public void save(IndicatoreDiRisultato indicatoreDiRisultato);  // Create
//	public IndicatoreDiRisultato findByPrimaryKey(Long id);     // Retrieve
	public List<IndicatoreDiRisultato> findAll();       
//	public void update(IndicatoreDiRisultato indicatoreDiRisultato); //Update
//	public void delete(IndicatoreDiRisultato indicatoreDiRisultato); //Delete	
}