package com.miguelbassila.bank.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FeeD implements Fee {

  public BigDecimal calculate(Transfer transfer) {
  
    if (transfer.getAmount().c <= 25000){
      calculate with fee A
    } else if (amount > 25000 && amount <= 120.000){
      calculate with fee B
    } else {
      calculate with fee C
    }
    
    return new BigDecimal(0);
  }
 }
