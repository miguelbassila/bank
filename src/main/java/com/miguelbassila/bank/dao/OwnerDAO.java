package com.miguelbassila.bank.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.miguelbassila.bank.model.Owner;

@Transactional
public class OwnerDAO {
  
  private final EntityManager manager;
  
  @Inject
  public OwnerDAO(EntityManager manager){
    this.manager = manager;
  }
  
  public OwnerDAO() {this(null);}
  
  public void add(Owner owner){
    if (owner.getId() == null) {
      this.manager.persist(owner);
    } else {
      this.manager.merge(owner);
    }
  }

}
