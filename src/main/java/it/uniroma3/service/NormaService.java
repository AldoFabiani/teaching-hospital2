package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.Norma;

public interface NormaService {
	public void insertNorma(Norma norma);
	public List<Norma> listNorme();
	public Norma findNormaByNome(String nome);
}
