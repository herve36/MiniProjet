package com.adaming.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tache implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTache;
	@Temporal(TemporalType.DATE)
	private Date DateCreationTache;
	private String DescriptionTache;
	private String titreTache;
	private boolean StatutAudienceTache;
	private Boolean statuUtil;

	@ManyToOne
	private Affaire affaire;

	@ManyToOne
	private Tribunal tribunal;

	@OneToMany(mappedBy = "tache",fetch = FetchType.EAGER)
	private Set<Phase> phases = new HashSet<Phase>();

	public Tache() {
		super();
	}

	public Tache(Date dateCreationTache) {
		super();
		DateCreationTache = dateCreationTache;
	}

	public Tache(Date dateCreationTache, String descriptionTache, String titreTache, boolean statutAudienceTache,
			Affaire affaire, Tribunal tribunal, Set<Phase> phase) {
		super();
		DateCreationTache = dateCreationTache;
		DescriptionTache = descriptionTache;
		this.titreTache = titreTache;
		StatutAudienceTache = statutAudienceTache;
		this.affaire = affaire;
		this.tribunal = tribunal;
		this.phases = phase;
	}

	public Tache(Date dateCreationTache, String descriptionTache, String titreTache, boolean statutAudienceTache,
			Affaire affaire, Tribunal tribunal) {
		super();
		DateCreationTache = dateCreationTache;
		DescriptionTache = descriptionTache;
		this.titreTache = titreTache;
		StatutAudienceTache = statutAudienceTache;
		this.affaire = affaire;
		this.tribunal = tribunal;
	}
	

	public Tache(Long idTache, Date dateCreationTache, String descriptionTache, String titreTache,
			boolean statutAudienceTache, Boolean statuUtil, Affaire affaire, Tribunal tribunal, Set<Phase> phases) {
		super();
		this.idTache = idTache;
		DateCreationTache = dateCreationTache;
		DescriptionTache = descriptionTache;
		this.titreTache = titreTache;
		StatutAudienceTache = statutAudienceTache;
		this.statuUtil = statuUtil;
		this.affaire = affaire;
		this.tribunal = tribunal;
		this.phases = phases;
	}

	public Long getIdTache() {
		return idTache;
	}

	public void setIdTache(Long idTache) {
		this.idTache = idTache;
	}

	public Date getDateCreationTache() {
		return DateCreationTache;
	}

	public void setDateCreationTache(Date dateCreationTache) {
		DateCreationTache = dateCreationTache;
	}

	public String getDescriptionTache() {
		return DescriptionTache;
	}

	public void setDescriptionTache(String descriptionTache) {
		DescriptionTache = descriptionTache;
	}

	public String getTitreTache() {
		return titreTache;
	}

	public void setTitreTache(String titreTache) {
		this.titreTache = titreTache;
	}

	public boolean isStatutAudienceTache() {
		return StatutAudienceTache;
	}

	public void setStatutAudienceTache(boolean statutAudienceTache) {
		StatutAudienceTache = statutAudienceTache;
	}

	public Affaire getAffaire() {
		return affaire;
	}

	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}

	public Tribunal getTribunal() {
		return tribunal;
	}

	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}

	public Set<Phase> getPhases() {
		return phases;
	}

	public void setPhases(Set<Phase> phases) {
		this.phases = phases;
	}
	

	public Boolean getStatuUtil() {
		return statuUtil;
	}

	public void setStatuUtil(Boolean statuUtil) {
		this.statuUtil = statuUtil;
	}

	@Override
	public String toString() {
		return "Tache [idTache=" + idTache + ", DateCreationTache=" + DateCreationTache + ", DescriptionTache="
				+ DescriptionTache + ", titreTache=" + titreTache + ", StatutAudienceTache=" + StatutAudienceTache
				+ ", affaire=" + affaire + ", tribunal=" + tribunal + ", phases=" + phases + "]";
	}

}
