package com.miguelbassila.bank.model;

import java.math.BigDecimal;
import java.util.Calendar;

public class Transfer {
  
  private Account originAccount;
  private Account destinationAccount;
  private BigDecimal amount;
  private Calendar dateSchedule;
  private Fee fee;

  public Transfer (Account originAccount, Account destinationAccount, BigDecimal amount, Fee fee, Calendar dateSchedule){
    this.originAccount = originAccount;
    this.destinationAccount = destinationAccount;
    this.amount = amount;
    this.fee = fee;
    this.dateSchedule = dateSchedule;
  }

  public Account getOriginAccount() {
    return originAccount;
  }

  public Account getDestinationAccount() {
    return destinationAccount;
  }

  public BigDecimal getAmount() {
    return amount;
  }
  
  public Fee getFee() {
    return fee;
  }

  public Calendar getDateSchedule() {
    return dateSchedule;
  }

  public BigDecimal calculateFee(){
    return fee.calculate(this);
  }
  
  public void send(){
    verifyAmount();
    
    this.originAccount.withdraw(this.amount);
    this.destinationAccount.deposit(this.amount);
    this.originAccount.withdraw(calculateFee());
  }

  private void verifyAmount() {
    if (this.amount.compareTo(this.originAccount.getBalance()) == 1){
      throw new IllegalArgumentException("Amount can not be greater than balance");
    }
    
    if (this.amount.compareTo(BigDecimal.ZERO) == -1) {
      throw new IllegalArgumentException("Amount can not be negative");
    }
    
    if (this.amount.compareTo(BigDecimal.ZERO) == 0) {
      throw new IllegalArgumentException("Amount can not be zero");
    }
  }

}
