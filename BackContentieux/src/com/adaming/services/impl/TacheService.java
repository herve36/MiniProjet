package com.adaming.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Tache;
import com.adaming.services.interfaces.ITacheService;

@Service
@Transactional
public class TacheService extends ServiceGenericImpl<Tache> implements ITacheService{

}
