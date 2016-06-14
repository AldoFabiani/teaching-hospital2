package it.uniroma3.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import it.uniroma3.utils.JsonDateSerializer;

@NamedQuery(name = "findAllPazienti", query = "SELECT p FROM Paziente p")
@Entity
public class Paziente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true)
	private String codiceFiscale;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	private String indirizzo;
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	@Column(nullable = false, unique = true)
	private String email;
	private String telefono;
	@OneToMany(mappedBy="paziente",cascade={CascadeType.PERSIST})
	@JsonBackReference private Set<Prenotazione> prenotazioni;

	public Paziente() {
		prenotazioni = new HashSet<Prenotazione>();
	}
	
	public Paziente(String nome, String cognome, String codiceFiscale, String indirizzo, Date dataNascita,
			String telefono, String email) {
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.dataNascita = dataNascita;
		this.email = email;
		this.telefono = telefono;
		this.prenotazioni = new HashSet<Prenotazione>();
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

	@JsonSerialize(using=JsonDateSerializer.class)
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
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
