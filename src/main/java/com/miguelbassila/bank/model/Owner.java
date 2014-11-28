package com.miguelbassila.bank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Owner {

  @Id @GeneratedValue
  private Long id;
  private String login;
  private String password;
  @OneToOne(cascade=CascadeType.ALL)
  private Account account;
  
  public Owner(String login, String password, Account account) {
    this.login = login;
    this.password = password;
    this.account = account;
  }
  
  public Owner() {
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }
  
  public void setLogin(String login) {
    this.login = login;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public Account getAccount() {
    return account;
  }
  
  public void setAccount(Account account) {
    this.account = account;
  }
 
}
