package com.miguelbassila.bank.model;

import java.math.BigDecimal;

public class FeeB extends ConditionalFee {

  @Override
  public BigDecimal feeByDays(long days, Transfer transfer) {
    if (days <=30){
      return new BigDecimal(10.00);
    }
    
    return new BigDecimal(8.00);
  }

}
