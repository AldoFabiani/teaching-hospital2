package it.uniroma3.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@NamedQuery(name = "findAllTipologie", query = "SELECT t FROM TipologiaEsame t")

@Entity
public class TipologiaEsame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nome;
	private String descrizione;
	@Column(nullable = false)
	private Float costo;
//	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
//	private Set<Norma> norme;
//	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
//	private Set<IndicatoreDiRisultato> indicatoriDiRisultato;


	public TipologiaEsame() {
//		this.normeDiPreparazione = new HashSet<Norma>();
//		this.indicatoriDiRisultato = new HashSet<IndicatoreDiRisultato>();
	}
	
	public TipologiaEsame(String nome, String descrizione, Float costo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.costo = costo;
//		this.norme = new HashSet<Norma>();
//		this.indicatoriDiRisultato = new HashSet<IndicatoreDiRisultato>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}
	

//	public Set<Norma> getNorme() {
//		return normeDiPreparazione;
//	}
//
//	public void setNorme(Set<Norma> norme) {
//		this.norme = norme;
//	}
//
//	public Set<IndicatoreDiRisultato> getIndicatoriRisultato() {
//		return indicatoriDiRisultato;
//	}
//
//	public void setIndicatoriRisultato(Set<IndicatoreDiRisultato> indicatoriRisultato) {
//		this.indicatoriDiRisultato = indicatoriRisultato;
//	}

	@Override
	public boolean equals(Object obj) {
		TipologiaEsame tipologia = (TipologiaEsame)obj;
		return this.getNome().equals(tipologia.getNome());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

//	public void addNorma(Norma norma) {
//		this.norme.add(norma);
//		
//	}
//
//	public void addIndicatoreDiRisultato(IndicatoreDiRisultato indicatoreDiRisultato) {
//		this.indicatoriDiRisultato.add(indicatoreDiRisultato);
//	}
}
