package it.uniroma3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.PazienteDao;
import it.uniroma3.model.Paziente;
@Service
public class PazienteServiceImpl implements PazienteService {

	@Autowired
	private PazienteDao pazienteDao;

	@Override
	public void insertPaziente(Paziente paziente) {
		this.pazienteDao.save(paziente);
	}

	@Override
	public Paziente findPaziente(String codiceFiscale) {
		return this.pazienteDao.findByCodiceFiscale(codiceFiscale);
	}
}
