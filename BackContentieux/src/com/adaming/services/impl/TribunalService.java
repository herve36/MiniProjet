package com.adaming.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Tribunal;
import com.adaming.services.interfaces.ITribunalService;

@Service
@Transactional
public class TribunalService extends ServiceGenericImpl<Tribunal> implements ITribunalService{

}
