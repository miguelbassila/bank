package com.miguelbassila.bank.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class LoginController {
  
  @Path("/login")
  public void login(){
    System.out.println("Login screen");
  }

}
