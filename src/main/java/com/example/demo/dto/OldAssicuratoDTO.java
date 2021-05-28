package com.example.demo.dto;

import java.util.Date;

public class OldAssicuratoDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private Date data;
	private Integer numeroSinistri;

	public OldAssicuratoDTO() {
		super();
	}
	

	public OldAssicuratoDTO(Long id, String nome, String cognome, String codiceFiscale, Date data,
			Integer numeroSinistri) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.data = data;
		this.numeroSinistri = numeroSinistri;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getNumeroSinistri() {
		return numeroSinistri;
	}

	public void setNumeroSinistri(Integer numeroSinistri) {
		this.numeroSinistri = numeroSinistri;
	}

	@Override
	public String toString() {
		return "OldAssicurato [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codiceFiscale="
				+ codiceFiscale + ", data=" + data + ", numeroSinistri=" + numeroSinistri + "]";
	}

}
