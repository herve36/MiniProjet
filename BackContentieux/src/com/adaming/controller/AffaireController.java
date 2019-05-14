package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Affaire;
import com.adaming.utils.ServiceGeneric;

@RestController
public class AffaireController {

	@Autowired
	ServiceGeneric<Affaire> phaseService;
	
	@RequestMapping(value="affaire", method=RequestMethod.GET)
	public List<Affaire> findAll(Class<Affaire> obj ){
		return phaseService.findAll(obj);
	}
	
	@RequestMapping(value ="affaire/{id}", method=RequestMethod.GET)
	public Affaire findOne(@PathVariable("id") Long id) {
		return phaseService.getById(Affaire.class , id);
	}
	
	@RequestMapping(value="affaire", method=RequestMethod.POST)
	public void savePhase(@RequestBody Affaire affaire) {
		phaseService.update(affaire);
	}
	
	@RequestMapping(value="affaire/{id}", method=RequestMethod.DELETE)
	public void deletePhase(@PathVariable("id") Long id) {
		Affaire ph=phaseService.getById(Affaire.class, id);
		phaseService.delete(ph);
	}
	
	@RequestMapping(value="affaire", method=RequestMethod.PUT)
	public void updatePhase(@PathVariable("id") Long id, @RequestBody Affaire affaire) {
		
		Affaire currentUser= phaseService.getById(Affaire.class, id);
		currentUser.setReferenceAffaire(affaire.getReferenceAffaire());
		currentUser.setTitreAffaire(affaire.getTitreAffaire());
		currentUser.setDescriptionAffaire(affaire.getDescriptionAffaire());
	
		
		phaseService.update(currentUser);
	}
}
