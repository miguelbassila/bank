package com.miguelbassila.bank.model;

import java.math.BigDecimal;

public class FeeD implements Fee {

  public BigDecimal calculate(Transfer transfer) {
    
    Fee fee;
    
    if (transfer.getAmount().compareTo(BigDecimal.valueOf(25001)) == -1){
      fee = new FeeA();
      
    } else if (transfer.getAmount().compareTo(BigDecimal.valueOf(25000)) == 1 && 
               transfer.getAmount().compareTo(BigDecimal.valueOf(120001)) == -1){
      fee = new FeeB();
      
    } else {
      fee = new FeeC();
      
    }
    
    return fee.calculate(transfer);
  }
 }
