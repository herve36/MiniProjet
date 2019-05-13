package com.adaming.dao.impl;

import org.springframework.stereotype.Repository;

import com.adaming.dao.interfaces.IDaoTache;
import com.adaming.entities.Tache;

@Repository
public class TacheDao extends DaoGenericImpl<Tache> implements IDaoTache{

}
