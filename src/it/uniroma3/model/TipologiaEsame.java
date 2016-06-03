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
	@ManyToMany
	private Set<Norma> norme;
	@ManyToMany
	private Set<Indicatore> indicatori;


	public TipologiaEsame() {
		this.norme = new HashSet<Norma>();
		this.indicatori = new HashSet<Indicatore>();
	}
	
	public TipologiaEsame(String nome, String descrizione, Float costo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.costo = costo;
		this.norme = new HashSet<Norma>();
		this.indicatori = new HashSet<Indicatore>();
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
	

	public Set<Norma> getNorme() {
		return norme;
	}

	public void setNorme(Set<Norma> norme) {
		this.norme = norme;
	}

	public Set<Indicatore> getIndicatori() {
		return indicatori;
	}

	public void setIndicatori(Set<Indicatore> indicatori) {
		this.indicatori = indicatori;
	}

	@Override
	public boolean equals(Object obj) {
		TipologiaEsame tipologia = (TipologiaEsame)obj;
		return this.getNome().equals(tipologia.getNome());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}

	public void addNorma(Norma norma) {
		this.getNorme().add(norma);
		
	}

	public void addIndicatore(Indicatore indicatore) {
		this.getIndicatori().add(indicatore);
	}
}
