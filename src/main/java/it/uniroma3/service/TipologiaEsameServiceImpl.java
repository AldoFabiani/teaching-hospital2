package it.uniroma3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.dao.TipologiaEsameDao;
import it.uniroma3.model.TipologiaEsame;
@Service
public class TipologiaEsameServiceImpl implements TipologiaEsameService {

	@Autowired
	private TipologiaEsameDao tipologiaDao;

	@Transactional
	@Override
	public List<TipologiaEsame> listTipologie() {
		return tipologiaDao.findAll();
		
	}

	@Override
	public void insertTipologia(TipologiaEsame tipologia) {
		this.tipologiaDao.save(tipologia);
	}

	@Override
	public TipologiaEsame findByNome(String nome) {
		return this.tipologiaDao.findByNome(nome);
	}

}
