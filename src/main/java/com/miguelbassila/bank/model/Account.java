package com.miguelbassila.bank.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Account {
  
  @Id @GeneratedValue
  private Long id;
  @Pattern(regexp="[0-9]{5}-[0-9]")
  private String number;
  private BigDecimal balance;

  public Account (String number, BigDecimal balance){
    this.number = number;
    this.balance = balance;
  }
  
  public Account (){
  }
    
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public BigDecimal getBalance() {
    return balance.setScale(2, RoundingMode.CEILING);
  }
  
  public void deposit(BigDecimal amount){
    balance = balance.add(amount);
  }
  
  public void withdraw(BigDecimal amount){
    balance = balance.subtract(amount);
  }
  
}
