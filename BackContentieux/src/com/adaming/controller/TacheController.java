package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Tache;
import com.adaming.utils.ServiceGeneric;

@RestController
public class TacheController {

	@Autowired
	ServiceGeneric<Tache> phaseService;
	
	@RequestMapping(value="tache", method=RequestMethod.GET)
	public List<Tache> findAll(Class<Tache> obj ){
		return phaseService.findAll(obj);
	}
	
	@RequestMapping(value ="tache/{id}", method=RequestMethod.GET)
	public Tache findOne(@PathVariable("id") Long id) {
		return phaseService.getById(Tache.class , id);
	}
	
	@RequestMapping(value="tache", method=RequestMethod.POST)
	public void savePhase(@RequestBody Tache tache) {
		phaseService.update(tache);
	}
	
	@RequestMapping(value="tache/{id}", method=RequestMethod.DELETE)
	public void deletePhase(@PathVariable("id") Long id) {
		Tache ph=phaseService.getById(Tache.class, id);
		phaseService.delete(ph);
	}
	
	@RequestMapping(value="tache", method=RequestMethod.PUT)
	public void updatePhase(@PathVariable("id") Long id, @RequestBody Tache tache) {
		
		Tache currentUser= phaseService.getById(Tache.class, id);
		currentUser.setDateCreationTache(tache.getDateCreationTache());
		currentUser.setDescriptionTache(tache.getDescriptionTache());
		currentUser.setTitreTache(tache.getTitreTache());
		currentUser.setStatutAudienceTache(tache.getStatuUtil());
		currentUser.setAffaire(tache.getAffaire());
		currentUser.setTribunal(tache.getTribunal());
		
		phaseService.update(currentUser);;
	}
}
