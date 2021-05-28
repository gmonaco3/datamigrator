package com.example.demo.model.nuovo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assicurato")
public class Assicurato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cognome", nullable = false)
	private String cognome;

	@Column(name = "data_nascita")
	private Date dataNascita;

	@Column(name = "totale_sinistri")
	private Byte totaleSinistri;

	@Column(name = "codice_fiscale", unique = true, nullable = false)
	private String codiceFiscale;

	public Assicurato() {
		super();
	}
	

	public Assicurato(Long id, String nome, String cognome, Date dataNascita, Byte totaleSinistri,
			String codiceFiscale) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.totaleSinistri = totaleSinistri;
		this.codiceFiscale = codiceFiscale;
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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Byte getTotaleSinistri() {
		return totaleSinistri;
	}

	public void setTotaleSinistri(Byte totaleSinistri) {
		this.totaleSinistri = totaleSinistri;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@Override
	public String toString() {
		return "Assicurato [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", totaleSinistri=" + totaleSinistri + ", codiceFiscale=" + codiceFiscale + "]";
	}

}
