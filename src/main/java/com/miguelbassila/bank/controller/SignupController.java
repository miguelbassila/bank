package com.miguelbassila.bank.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

import com.miguelbassila.bank.business.OwnerLogged;
import com.miguelbassila.bank.dao.OwnerDAO;
import com.miguelbassila.bank.model.Owner;

@Controller
public class SignupController {
  
  private OwnerDAO ownerDAO;
  private OwnerLogged logged;
  
  @Inject
  public SignupController(OwnerDAO ownerDAO, OwnerLogged logged) {
    this.ownerDAO = ownerDAO;
    this.logged = logged;
  }
  
  public SignupController() {}
  
  @Path("/signup")
  public void signup(){
    System.out.println("Signup form");
  }
  
  public void save(Owner owner, Result result){
    ownerDAO.add(owner);
    logged.login(owner);
    
    result.redirectTo(TransferController.class).list();
  }
  
  public void confirm(){
    System.out.println("Signup successfully");
  }

}
