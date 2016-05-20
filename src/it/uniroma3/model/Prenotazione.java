package it.uniroma3.model;

import java.util.Date;
import java.util.UUID;

public class Prenotazione {
	private String codice;
	private Date dataAvvenutaPrenotazione;
	private Date dataEsame;
	private Medico medico;
	private Paziente paziente;
	private TipologiaEsame tipologiaEsame;

	// E' davvero utile passare subito nel costruttore Medico e Paziente (in
	// relazione ai casi d'uso?)
	public Prenotazione(Date dataAvvenutaPrenotazione, Date dataEsame, Medico medico, Paziente paziente, TipologiaEsame tipologiaEsameCorrente) {
		this.codice= UUID.randomUUID().toString();
		this.dataAvvenutaPrenotazione = dataAvvenutaPrenotazione;
		this.dataEsame = dataEsame;
		this.medico = medico;
		this.paziente = paziente;
		this.paziente.addPrenotazione(this);
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Date getDataAvvenutaPrenotazione() {
		return dataAvvenutaPrenotazione;
	}

	public void setDataAvvenutaPrenotazione(Date dataAvvenutaPrenotazione) {
		this.dataAvvenutaPrenotazione = dataAvvenutaPrenotazione;
	}

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
	
	//TODO equals e hashcode sul codice

	@Override
	public boolean equals(Object obj) {
		Prenotazione exam = (Prenotazione)obj;
		return this.getCodice().equals(exam.getCodice());
	}
	@Override
	public int hashCode() {
		return this.getCodice().hashCode();
	}
}
