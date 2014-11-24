package com.miguelbassila.bank.model;

public class Owner {

  private String login;
  private String password;
  private Account account;
  
  public Owner(String login, String password, Account account) {
    this.login = login;
    this.password = password;
    this.account = account;
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
