package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAllNorme", query = "SELECT n FROM Norma n")
public class Norma {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nome;
	@Column(nullable = false)
	private String descrizione;
	
	public Norma() {
		// TODO Auto-generated constructor stub
	}
	
	public Norma(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
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
	
	@Override
	public boolean equals(Object obj) {
		Norma that = (Norma) obj;
		return this.nome.equals(that.nome);
	}
	
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}
}
