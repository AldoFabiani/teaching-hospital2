package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAllIndicatoriDiRisulato", query = "SELECT i FROM IndicatoreDiRisultato i")
public class IndicatoreDiRisultato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nome;
	
	public IndicatoreDiRisultato() {
		// TODO Auto-generated constructor stub
	}
	
	public IndicatoreDiRisultato(String nome) {
		this.nome = nome;
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
	
	@Override
	public boolean equals(Object obj) {
		IndicatoreDiRisultato that = (IndicatoreDiRisultato) obj;
		return this.nome.equals(that.nome);
	}
	
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}
	
}
