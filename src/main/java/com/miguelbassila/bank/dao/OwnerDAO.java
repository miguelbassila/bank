package com.miguelbassila.bank.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

  public Owner searchOwnerWithPassword(String login, String password) {
    try {
      return this.manager
          .createQuery("select o from Owner o where o.login = :login and o.password = :password", Owner.class)
          .setParameter("login", login)
          .setParameter("password", password)
          .getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }

}
