package it.uniroma3.model;

import java.util.List;

import it.uniroma3.dao.MedicoDaoJPA;
import it.uniroma3.dao.PazienteDaoJPA;
import it.uniroma3.dao.PrenotazioneDaoJPA;
import it.uniroma3.dao.TipologiaEsameDaoJPA;

public class THWeb {

	
	
	public Medico findMedico(String codiceMedico){
		MedicoDaoJPA medicoDao = new MedicoDaoJPA();
		return medicoDao.findByCodice(codiceMedico);
		}
	
	public Paziente findPaziente(String codiceFiscale){
		PazienteDaoJPA pazienteDao = new PazienteDaoJPA();
		return pazienteDao.findByCodiceFiscale(codiceFiscale);
		}
	
	public List<Medico> getMedici(){
		MedicoDaoJPA medicoDao = new MedicoDaoJPA();
		return medicoDao.findAll();
		}
	
	public List<TipologiaEsame> getTipologieEsame(){
		TipologiaEsameDaoJPA tipologiaDao = new TipologiaEsameDaoJPA();
		return tipologiaDao.findAll();
	}
	
	public void addPrenotazione(Prenotazione prenotazione){
		PrenotazioneDaoJPA prenotazioneDao = new PrenotazioneDaoJPA();
		prenotazioneDao.save(prenotazione);
	}
}
