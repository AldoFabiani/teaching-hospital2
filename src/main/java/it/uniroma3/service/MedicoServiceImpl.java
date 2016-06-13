package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.MedicoDao;
import it.uniroma3.model.Medico;

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
	

}
