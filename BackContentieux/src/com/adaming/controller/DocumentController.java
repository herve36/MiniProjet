package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Document;
import com.adaming.utils.ServiceGeneric;

@RestController
public class DocumentController {

	@Autowired
	ServiceGeneric<Document> documentService;

	@RequestMapping(value = "document", method = RequestMethod.GET)
	public List<Document> findAll(Class<Document> obj) {
		return documentService.findAll(obj);
	}

	@RequestMapping(value = "document/{id}", method = RequestMethod.GET)
	public Document findOne(@PathVariable("id") Long id) {
		return documentService.getById(Document.class, id);
	}

	@RequestMapping(value = "document", method = RequestMethod.POST)
	public void saveDocument(@RequestBody Document document) {
		documentService.update(document);
	}

	@RequestMapping(value = "document/{id}", method = RequestMethod.DELETE)
	public void deleteDocument(@PathVariable("id") Long id) {
		Document ph = documentService.getById(Document.class, id);
		documentService.delete(ph);
	}

	@RequestMapping(value = "document", method = RequestMethod.PUT)
	public void updateDocument(@PathVariable("id") Long id, @RequestBody Document document) {

		Document currentUser = documentService.getById(Document.class, id);
		currentUser.setNomDocument(document.getNomDocument());
		currentUser.setDescription(document.getDescription());
		currentUser.setAffaire(document.getAffaire());
		currentUser.setDateCreation(document.getDateCreation());
		documentService.update(currentUser);
	}

}
