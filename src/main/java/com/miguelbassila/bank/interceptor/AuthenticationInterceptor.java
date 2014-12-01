package com.miguelbassila.bank.interceptor;

import javax.inject.Inject;

import com.miguelbassila.bank.business.OwnerLogged;
import com.miguelbassila.bank.controller.IndexController;
import com.miguelbassila.bank.controller.LoginController;
import com.miguelbassila.bank.controller.SignupController;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
public class AuthenticationInterceptor {
  
  private OwnerLogged owner;
  private Result result;
  
  @Inject
  public AuthenticationInterceptor(OwnerLogged owner, Result result) {
    this.owner = owner;
    this.result = result;
  }
  
  @Deprecated public AuthenticationInterceptor() {}
  
  @AroundCall
  public void authenticate(SimpleInterceptorStack stack){
    if (owner.isLogged()){
      stack.next();
    } else {
      result.redirectTo(LoginController.class).login();
    }
  }
  
  @Accepts
  public boolean isRestrict(ControllerMethod method){
    if (method.getController().getType().equals(LoginController.class) || 
        method.getController().getType().equals(IndexController.class) ||
        method.getController().getType().equals(SignupController.class)){
      return false;
    }
    return true;
  }
}
