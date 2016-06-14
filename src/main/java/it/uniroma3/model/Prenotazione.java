package it.uniroma3.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import it.uniroma3.utils.JsonDateSerializer;

@NamedQuery(name = "findAllPrenotazioni", query = "SELECT p FROM Prenotazione p")

@Entity

public class Prenotazione {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true)
	private String codice;
	@Temporal(TemporalType.DATE)
	private Date dataAvvenutaPrenotazione;
	@Temporal(TemporalType.DATE)
	private Date dataEsame;
	@ManyToOne
	@JsonManagedReference private Medico medico;
	@ManyToOne
	@JsonManagedReference private Paziente paziente;
	@ManyToOne
	@JsonManagedReference private TipologiaEsame tipologiaEsame;
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private Risultato risultato;

	public Prenotazione() {
	}

	// E' davvero utile passare subito nel costruttore Medico e Paziente (in
	// relazione ai casi d'uso?)
	public Prenotazione(Date dataEsame, Medico medico, Paziente paziente, TipologiaEsame tipologiaEsameCorrente) {
		this.codice = UUID.randomUUID().toString();
		this.dataAvvenutaPrenotazione = Calendar.getInstance().getTime();
		this.dataEsame = dataEsame;
		this.medico = medico;
		this.paziente = paziente;
		this.tipologiaEsame=tipologiaEsameCorrente;
		//this.paziente.addPrenotazione(this);
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDataAvvenutaPrenotazione() {
		return dataAvvenutaPrenotazione;
	}

	public void setDataAvvenutaPrenotazione(Date dataAvvenutaPrenotazione) {
		this.dataAvvenutaPrenotazione = dataAvvenutaPrenotazione;
	}
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(Date dataEsame) {
		this.dataEsame = dataEsame;
	}
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}
	

	// TODO equals e hashcode sul codice

	public Risultato getRisultato() {
		return risultato;
	}

	public void setRisultato(Risultato risultato) {
		this.risultato = risultato;
	}

	@Override
	public boolean equals(Object obj) {
		Prenotazione exam = (Prenotazione) obj;
		return this.getCodice().equals(exam.getCodice());
	}

	@Override
	public int hashCode() {
		return this.getCodice().hashCode();
	}
	@Override
	public String toString() {
		return this.codice.toString();
	}
}
