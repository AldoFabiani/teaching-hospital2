package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.IndicatoreDao;
import it.uniroma3.model.Indicatore;
@Service
public class IndicatoreServiceImpl implements IndicatoreService{

	@Autowired
	private IndicatoreDao indicatoreDao;

	@Override
	public void insertIndicatore(Indicatore indicatore) {
		this.indicatoreDao.save(indicatore);
		
	}

	@Override
	public List<Indicatore> listIndicatore() {
		return this.indicatoreDao.findAll();
	}

	@Override
	public Indicatore findIndicatoreByNome(String nome) {
		return this.indicatoreDao.findByNome(nome);
	}

}
