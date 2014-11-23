package com.miguelbassila.bank.model;

import java.math.BigDecimal;

public class Account {
  
  private String number;
  private BigDecimal balance;

  public Account (String number, BigDecimal balance){
    this.number = number;
    this.balance = balance;
  }

  public String getNumber() {
    return number;
  }

  public BigDecimal getBalance() {
    return balance;
  }
  
  public void deposit(BigDecimal amount){
    balance = balance.add(amount);
  }
  
  public void withdraw(BigDecimal amount){
    balance = balance.subtract(amount);
  }
  
}
