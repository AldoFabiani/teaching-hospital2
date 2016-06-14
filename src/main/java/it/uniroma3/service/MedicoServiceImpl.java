package it.uniroma3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.dao.MedicoDao;
import it.uniroma3.model.Medico;
import it.uniroma3.model.Prenotazione;

@Service
public class MedicoServiceImpl implements MedicoService {
	@Autowired
	private MedicoDao medicoDao;

	@Override
	public List<Medico> listMedici() {
		return this.medicoDao.findAll();
	}

	@Override
	public Medico findByCodice(String codice) {
		return this.medicoDao.findByCodice(codice);
	}

	@Override
	@Transactional
	public List<Prenotazione> listPrenotazioniMedico(String codiceMedico) {
		return new ArrayList<>(this.findByCodice(codiceMedico).getPrenotazioni());
	}
}
