package com.miguelbassila.bank.business;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import com.miguelbassila.bank.model.Owner;

@SuppressWarnings("serial")
@SessionScoped
public class OwnerLogged implements Serializable {

  private Owner owner;

  public void login(Owner owner){
    this.owner = owner;
  }
  
  public boolean isLogged(){
    return this.owner != null;
  }
  
  public Owner getOwner(){
    return owner;
  }
  
  public void logout(){
    this.owner = null;
  }
}
