package com.adaming.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role extends Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String libelleRole;

	public Role() {
		super();
	}

	public Role(String emailUtilisateur, String nomUtilisateur, String prenomUtilisateur, String libelleRole) {
		super(emailUtilisateur, nomUtilisateur, prenomUtilisateur);
		this.libelleRole = libelleRole;
	}

	public Role(String emailUtilisateur, String nomUtilisateur, String prenomUtilisateur, Set<Tache> taches,
			String libelleRole) {
		super(emailUtilisateur, nomUtilisateur, prenomUtilisateur, taches);
		this.libelleRole = libelleRole;
	}

	public String getLibelleRole() {
		return libelleRole;
	}

	public void setLibelleRole(String libelleRole) {
		this.libelleRole = libelleRole;
	}

	@Override
	public String toString() {
		return "Role [libelleRole=" + libelleRole + "]" + super.toString();
	}

}
