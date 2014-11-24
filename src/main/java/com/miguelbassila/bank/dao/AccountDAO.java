package com.miguelbassila.bank.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.miguelbassila.bank.model.Account;

@Transactional
public class AccountDAO {
  
  private final EntityManager manager;

  @Inject
  public AccountDAO(EntityManager manager) {
    this.manager = manager;
  }

  public AccountDAO() {this(null);}
  
  public void add(Account account){
    if (account.getId() == null) {
      this.manager.persist(account);
    } else {
      this.manager.merge(account);
    }
  }
  
}
