package it.uniroma3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class LineaRisultato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JsonManagedReference private Indicatore indicatore;
	private Integer valore;
	
	public LineaRisultato() {
		// TODO Auto-generated constructor stub
	}
	
	public LineaRisultato(Indicatore indicatore, Integer valore) {
		this.indicatore = indicatore;
		this.valore = valore;
	}

	public Indicatore getIndicatore() {
		return indicatore;
	}

	public void setIndicatore(Indicatore indicatore) {
		this.indicatore = indicatore;
	}

	public Integer getValore() {
		return valore;
	}

	public void setValore(Integer valore) {
		this.valore = valore;
	}
	
	
}
