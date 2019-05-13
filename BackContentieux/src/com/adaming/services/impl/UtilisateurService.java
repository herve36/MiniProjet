package com.adaming.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Utilisateur;
import com.adaming.services.interfaces.IUtilisateurService;

@Service
@Transactional
public class UtilisateurService extends ServiceGenericImpl<Utilisateur> implements IUtilisateurService{

}
