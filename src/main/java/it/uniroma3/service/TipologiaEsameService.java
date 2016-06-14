package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.TipologiaEsame;

public interface TipologiaEsameService {
	
	public List<TipologiaEsame> listTipologie();
	public void insertTipologia(TipologiaEsame tipologia);
	public TipologiaEsame findByNome(String nome);
}
