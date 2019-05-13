package com.adaming.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Affaire;
import com.adaming.services.impl.ServiceGenericImpl;
import com.adaming.services.interfaces.IAffaireService;

@Service
@Transactional
public class AffaireService extends ServiceGenericImpl<Affaire> implements IAffaireService {

}
