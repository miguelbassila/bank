package com.miguelbassila.bank.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

import com.miguelbassila.bank.dao.AccountDAO;
import com.miguelbassila.bank.dao.OwnerDAO;
import com.miguelbassila.bank.model.Account;
import com.miguelbassila.bank.model.Owner;

@Controller
public class SignupController {
  
  private OwnerDAO ownerDAO;
  private AccountDAO accountDAO;
  
  @Inject
  public SignupController(OwnerDAO ownerDAO, AccountDAO accountDAO) {
    this.ownerDAO = ownerDAO;
    this.accountDAO = accountDAO;
  }
  
  public SignupController() {}
  
  @Path("/signup")
  public void signup(){
    System.out.println("Signup form");
  }
  
  public void save(Owner owner, Account account){
        
  }

}
