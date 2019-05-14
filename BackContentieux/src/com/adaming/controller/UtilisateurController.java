package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Utilisateur;
import com.adaming.utils.ServiceGeneric;

@RestController
public class UtilisateurController {

	@Autowired
	ServiceGeneric<Utilisateur> utilisateurService;

	@RequestMapping(value = "utilisateur", method = RequestMethod.GET)
	public List<Utilisateur> findAll(Class<Utilisateur> obj) {
		return utilisateurService.findAll(obj);
	}

	@RequestMapping(value = "utilisateur/{id}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("id") Long id) {
		return utilisateurService.getById(Utilisateur.class, id);
	}

	@RequestMapping(value = "utilisateur", method = RequestMethod.POST)
	public void saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateurService.update(utilisateur);
	}

	@RequestMapping(value = "utilisateur/{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") Long id) {
		Utilisateur ph = utilisateurService.getById(Utilisateur.class, id);
		utilisateurService.delete(ph);
	}

	@RequestMapping(value = "utilisateur", method = RequestMethod.PUT)
	public void updateUtilisateur(@PathVariable("id") Long id, @RequestBody Utilisateur utilisateur) {

		Utilisateur currentUser = utilisateurService.getById(Utilisateur.class, id);
		currentUser.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUser.setEmailUtilisateur(utilisateur.getEmailUtilisateur());
		currentUser.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		utilisateurService.update(currentUser);
	}

}
