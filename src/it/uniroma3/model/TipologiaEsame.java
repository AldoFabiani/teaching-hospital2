package it.uniroma3.model;


public class TipologiaEsame {
	private String nome;
	private String descrizione;
	private Float costo;
	private Long id;


	// TODO il codice per il momento è null
	public TipologiaEsame() {
	}
	
	public TipologiaEsame(String nome, String descrizione, Float costo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.costo = costo;

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

	@Override
	public boolean equals(Object obj) {
		TipologiaEsame tipologia = (TipologiaEsame)obj;
		return this.getNome().equals(tipologia.getNome());
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}
}
