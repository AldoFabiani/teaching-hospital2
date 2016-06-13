package it.uniroma3.service;

import java.util.List;

import it.uniroma3.model.Indicatore;

public interface IndicatoreService {
	public void insertIndicatore(Indicatore indicatore);
	public List<Indicatore> listIndicatore();
	public Indicatore findIndicatoreByNome(String nome);
}
