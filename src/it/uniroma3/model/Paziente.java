package it.uniroma3.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Paziente {

	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String indirizzo;
	private Date dataNascita;
	private String password;
	private String email;
	private String telefono;
	private List<Prenotazione> prenotazioni;

	public Paziente(String nome, String cognome, String codiceFiscale, String indirizzo, Date dataNascita,
			String telefono, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
		this.dataNascita = dataNascita;
		this.password = null; 
		this.email = email;
		this.telefono = telefono;
		this.prenotazioni = new ArrayList<>();
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

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void addPrenotazione(Prenotazione prenotazione) {
		this.prenotazioni.add(prenotazione);
	}
	
	// TODO equals e hashcode sul codiceFiscale

	@Override
	public boolean equals(Object obj) {
		Paziente paziente = (Paziente) obj;
		return this.getCodiceFiscale().equals(paziente.getCodiceFiscale());
	}

	@Override
	public int hashCode() {
		return this.getCodiceFiscale().hashCode();
	}

}
