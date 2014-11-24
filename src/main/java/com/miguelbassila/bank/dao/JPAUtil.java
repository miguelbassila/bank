package com.miguelbassila.bank.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JPAUtil {
  
  @PersistenceContext
  private EntityManager manager;

  public EntityManager getManager() {
    return manager;
  }

}
