package com.miguelbassila.bank.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

import com.miguelbassila.bank.business.OwnerLogged;
import com.miguelbassila.bank.dao.OwnerDAO;
import com.miguelbassila.bank.model.Owner;

@Controller
public class LoginController {
  
  private OwnerDAO ownerDAO;
  private OwnerLogged logged;
  private Result result;
  private Validator validator;
  
  @Inject
  public LoginController(OwnerDAO ownerDAO, OwnerLogged logged, Result result,
      Validator validator) {
    this.ownerDAO = ownerDAO;
    this.logged = logged;
    this.result = result;
    this.validator = validator;
  }
  
  @Deprecated public LoginController() {}
  
  @Get("/login")
  public void login(){
    System.out.println("Login screen");
  }
  
  @Post("/login")
  public void login(String login, String password){
    Owner owner = ownerDAO.searchOwnerWithPassword(login, password);
    validator.ensure(owner != null, new I18nMessage("usuario", "login ou senha inválidos"));
    validator.onErrorRedirectTo(this).login();
    logged.login(owner);
    
    result.redirectTo(TransferController.class).list();
  }
  
  @Get("/logout")
  public void logout(){
    logged.logout();
    result.redirectTo(this).login();
  }

}
