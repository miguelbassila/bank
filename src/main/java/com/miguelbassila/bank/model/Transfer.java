package com.miguelbassila.bank.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Transfer {
  
  private Account originAccount;
  private Account destinationAccount;
  private BigDecimal amount;
  private Calendar dateSchedule;
  private Fee fee;

  public Transfer (Account originAccount, Account destinationAccount, BigDecimal amount, Fee fee, Calendar dateSchedule){
    this.originAccount = originAccount;
    this.destinationAccount = destinationAccount; 
    
    if(verifyAmountExceptions(amount)){
      this.amount = amount;
    }
    
    this.fee = fee;
    
    if (verifyDateExcepetion(dateSchedule)){
      this.dateSchedule = dateSchedule;
    }
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
    this.originAccount.withdraw(this.amount);
    this.destinationAccount.deposit(this.amount);
    this.originAccount.withdraw(calculateFee());
  }

  private boolean verifyDateExcepetion(Calendar dateSchedule) {
    Calendar today = new GregorianCalendar();
    
    if (dateSchedule.compareTo(today) == -1){
      throw new IllegalArgumentException("Date schedule can not be in the past");
    }
    
    return true;
  }

  private boolean verifyAmountExceptions(BigDecimal amount) {
    if (amount.compareTo(this.originAccount.getBalance()) == 1){
      throw new IllegalArgumentException("Amount can not be greater than balance");
    }
    
    if (amount.compareTo(BigDecimal.ZERO) == -1) {
      throw new IllegalArgumentException("Amount can not be negative");
    }
    
    if (amount.compareTo(BigDecimal.ZERO) == 0) {
      throw new IllegalArgumentException("Amount can not be zero");
    }
    
    return true;
  }

}
