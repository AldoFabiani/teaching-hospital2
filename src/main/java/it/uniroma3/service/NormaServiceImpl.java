package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.NormaDao;
import it.uniroma3.model.Norma;
@Service
public class NormaServiceImpl implements NormaService {

	@Autowired
	private NormaDao normaDao;

	@Override
	public List<Norma> listNorme() {
		return this.normaDao.findAll();
	}

	@Override
	public void insertNorma(Norma norma) {
		this.normaDao.save(norma);
	}

	@Override
	public Norma findNormaByNome(String nome) {
		return this.normaDao.findByNome(nome);
	}

}
