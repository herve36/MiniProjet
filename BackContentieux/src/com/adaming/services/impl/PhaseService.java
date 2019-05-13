package com.adaming.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.entities.Phase;
import com.adaming.services.interfaces.IPhaseService;

@Service
@Transactional
public class PhaseService extends ServiceGenericImpl<Phase> implements IPhaseService{

}
