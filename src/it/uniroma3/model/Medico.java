package it.uniroma3.model;

import java.util.UUID;

public class Medico {
	private String nome;
	private String cognome;
	private String specializzazione;
	private String codice;

	public Medico(String nome, String cognome, String specializzazione) {
		this.nome = nome;
		this.cognome = cognome;
		this.specializzazione = specializzazione;
		this.codice = UUID.randomUUID().toString();
	}

	public String getCodice() {
		return codice;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	@Override
	public int hashCode() {
		return this.codice.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Medico medico = (Medico) obj;
		return this.getCodice().equals(medico.getCodice());
	}

	
}
