package com.adaming.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tribunal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTribunal;
	private String adresseTribunal;
	private String faxTribunal;
	private String telTribunal;
	private String regionTribunal;
	private Boolean statuUtil;
	
	@OneToMany(mappedBy="tribunal",fetch = FetchType.EAGER)
	private Set<Tache> taches=new HashSet<Tache>();

	public Tribunal() {
		super();
	}

	public Tribunal(String adresseTribunal, String faxTribunal, String telTribunal, String regionTribunal,
			Set<Tache> taches) {
		super();
		this.adresseTribunal = adresseTribunal;
		this.faxTribunal = faxTribunal;
		this.telTribunal = telTribunal;
		this.regionTribunal = regionTribunal;
		this.taches = taches;
	}

	public Tribunal(String adresseTribunal, String faxTribunal, String telTribunal, String regionTribunal) {
		super();
		this.adresseTribunal = adresseTribunal;
		this.faxTribunal = faxTribunal;
		this.telTribunal = telTribunal;
		this.regionTribunal = regionTribunal;
	}

	public Tribunal(Long idTribunal, String adresseTribunal, String faxTribunal, String telTribunal,
			String regionTribunal, Boolean statuUtil, Set<Tache> taches) {
		super();
		this.idTribunal = idTribunal;
		this.adresseTribunal = adresseTribunal;
		this.faxTribunal = faxTribunal;
		this.telTribunal = telTribunal;
		this.regionTribunal = regionTribunal;
		this.statuUtil = statuUtil;
		this.taches = taches;
	}

	public Long getIdTribunal() {
		return idTribunal;
	}

	public void setIdTribunal(Long idTribunal) {
		this.idTribunal = idTribunal;
	}

	public String getAdresseTribunal() {
		return adresseTribunal;
	}

	public void setAdresseTribunal(String adresseTribunal) {
		this.adresseTribunal = adresseTribunal;
	}

	public String getFaxTribunal() {
		return faxTribunal;
	}

	public void setFaxTribunal(String faxTribunal) {
		this.faxTribunal = faxTribunal;
	}

	public String getTelTribunal() {
		return telTribunal;
	}

	public void setTelTribunal(String telTribunal) {
		this.telTribunal = telTribunal;
	}

	public String getRegionTribunal() {
		return regionTribunal;
	}

	public void setRegionTribunal(String regionTribunal) {
		this.regionTribunal = regionTribunal;
	}

	public Set<Tache> getTaches() {
		return taches;
	}

	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}

	
	public Boolean getStatuUtil() {
		return statuUtil;
	}

	public void setStatuUtil(Boolean statuUtil) {
		this.statuUtil = statuUtil;
	}

	@Override
	public String toString() {
		return "Tribunal [idTribunal=" + idTribunal + ", adresseTribunal=" + adresseTribunal + ", faxTribunal="
				+ faxTribunal + ", telTribunal=" + telTribunal + ", regionTribunal=" + regionTribunal + "]";
	}
	
}
