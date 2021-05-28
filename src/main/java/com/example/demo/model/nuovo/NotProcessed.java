package com.example.demo.model.nuovo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "not_processed")
public class NotProcessed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "codice_fiscale")
	private String codiceFiscale;

	@Column(name = "old_id")
	private Long oldId;

	public NotProcessed() {
	}

	public NotProcessed(String codiceFiscale, Long oldId) {
		this.codiceFiscale = codiceFiscale;
		this.oldId = oldId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Long getOldId() {
		return oldId;
	}

	public void setOldId(Long oldId) {
		this.oldId = oldId;
	}

	@Override
	public String toString() {
		return "NotProcessed{" + "id=" + id + ", codiceFiscale='" + codiceFiscale + '\'' + ", oldId=" + oldId + '}';
	}

}
