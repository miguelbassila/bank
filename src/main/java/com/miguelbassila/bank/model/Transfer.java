package com.miguelbassila.bank.model;

import java.math.BigDecimal;
import java.util.Calendar;

public class Transfer {
  
  private Account originAccount;
  private Account destinationAccount;
  private BigDecimal ammount;
  private Calendar dateSchedule;

  public Transfer (Account originAccount, Account destinationAccount, BigDecimal ammount, Calendar dateSchedule){
    this.originAccount = originAccount;
    this.destinationAccount = destinationAccount;
    this.ammount = ammount;
    this.dateSchedule = dateSchedule;
  }

  public Account getOriginAccount() {
    return originAccount;
  }

  public Account getDestinationAccount() {
    return destinationAccount;
  }

  public BigDecimal getAmmount() {
    return ammount;
  }

  public Calendar getDateSchedule() {
    return dateSchedule;
  }
  
  public void calculateFee (Transfer transfer, Fee fee){
    
  }
  
  

}
