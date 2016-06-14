package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Risultato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@JsonManagedReference private List<LineaRisultato> linee;
	
	public Risultato() {
		linee = new ArrayList<LineaRisultato>();
	}

	public List<LineaRisultato> getLinee() {
		return linee;
	}

	public void setLinee(List<LineaRisultato> linee) {
		this.linee = linee;
	}

	public void addLinea(LineaRisultato lineaRisultato) {
		this.linee.add(lineaRisultato);
	}
	
	
}
