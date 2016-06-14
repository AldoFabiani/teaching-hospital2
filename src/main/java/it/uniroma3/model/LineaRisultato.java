package it.uniroma3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LineaRisultato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JsonManagedReference private Indicatore indicatore;
	private int valore;
	
	public LineaRisultato() {
		// TODO Auto-generated constructor stub
	}
	
	public LineaRisultato(Indicatore indicatore, int valore) {
		this.indicatore = indicatore;
		this.valore = valore;
	}

	public Indicatore getIndicatore() {
		return indicatore;
	}

	public void setIndicatore(Indicatore indicatore) {
		this.indicatore = indicatore;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}
	
	
}
