package it.uniroma3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.PrenotazioneDao;
import it.uniroma3.model.Prenotazione;
@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	private PrenotazioneDao prenotazioneDao;
	
	@Override
	public void insertPrenotazione(Prenotazione prenotazione) {
		this.prenotazioneDao.save(prenotazione);
	}

	
}
