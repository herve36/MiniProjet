package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Phase;
import com.adaming.utils.ServiceGeneric;

@RestController
public class PhaseController {

	@Autowired
	ServiceGeneric<Phase> phaseService;
	
	@RequestMapping(value="phase", method=RequestMethod.GET)
	public List<Phase> findAll(Class<Phase> obj ){
		return phaseService.findAll(obj);
	}
	
	@RequestMapping(value ="phase/{id}", method=RequestMethod.GET)
	public Phase findOne(@PathVariable("id") Long id) {
		return phaseService.getById(Phase.class , id);
	}
	
	@RequestMapping(value="phase", method=RequestMethod.POST)
	public void savePhase(@RequestBody Phase phase) {
		phaseService.update(phase);
	}
	
	@RequestMapping(value="phase/{id}", method=RequestMethod.DELETE)
	public void deletePhase(@PathVariable("id") Long id) {
		Phase ph=phaseService.getById(Phase.class, id);
		phaseService.delete(ph);
	}
	
	@RequestMapping(value="phase", method=RequestMethod.PUT)
	public Phase updatePhase(@PathVariable("id") Long id, @RequestBody Phase phase) {
		
		Phase currentUser= phaseService.getById(Phase.class, id);
		currentUser.setNomPhase(phase.getNomPhase());
		currentUser.setDateDebutPhase(phase.getDateDebutPhase());
		currentUser.setDateFinPhase(phase.getDateFinPhase());
		
		return null;
	}
	
}
