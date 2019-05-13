package com.adaming.dao.impl;

import org.springframework.stereotype.Repository;

import com.adaming.dao.interfaces.IDaoAffaire;
import com.adaming.entities.Affaire;

@Repository
public class AffaireDao extends DaoGenericImpl<Affaire> implements IDaoAffaire{

}
