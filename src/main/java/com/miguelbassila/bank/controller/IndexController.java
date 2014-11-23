package com.miguelbassila.bank.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class IndexController {
  
  @Path("/")
  public void index(){
    System.out.println("Welcome to Our Bank");
  }

}
