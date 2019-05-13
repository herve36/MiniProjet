package com.adaming.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocument;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private String nomDocument;
	private String description;
	@ManyToOne
	private Affaire affaire;
	private Boolean statuUtil;

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(Date dateCreation, String nomDocument, String description, Affaire affaire, Boolean statuUtil) {
		super();
		this.dateCreation = dateCreation;
		this.nomDocument = nomDocument;
		this.description = description;
		this.affaire = affaire;
		this.statuUtil = statuUtil;
	}

	public Document(Long idDocument, Date dateCreation, String nomDocument, String description, Affaire affaire,
			Boolean statuUtil) {
		super();
		this.idDocument = idDocument;
		this.dateCreation = dateCreation;
		this.nomDocument = nomDocument;
		this.description = description;
		this.affaire = affaire;
		this.statuUtil = statuUtil;
	}

	public Long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getNomDocument() {
		return nomDocument;
	}

	public void setNomDocument(String nomDocument) {
		this.nomDocument = nomDocument;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Affaire getAffaire() {
		return affaire;
	}

	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}

	public Boolean getStatuUtil() {
		return statuUtil;
	}

	public void setStatuUtil(Boolean statuUtil) {
		this.statuUtil = statuUtil;
	}

}
