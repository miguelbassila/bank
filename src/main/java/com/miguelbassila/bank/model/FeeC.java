package com.miguelbassila.bank.model;

import java.math.BigDecimal;

public class FeeC extends ConditionalFee {

  @Override
  public BigDecimal feeByDays(long days, Transfer transfer) {
    
    BigDecimal amount = transfer.getAmount();
    
    if (days > 30){
      return multiplyAmountByPercentual(amount, 0.012);
    } else if (days > 25 && days <= 30) {
      return multiplyAmountByPercentual(amount, 0.021);
    } else if (days > 20 && days <= 25) {
      return multiplyAmountByPercentual(amount, 0.043);
    } else if (days > 15 && days <= 20) {
      return multiplyAmountByPercentual(amount, 0.054);
    } else if (days > 10 && days <= 15) {
      return multiplyAmountByPercentual(amount, 0.067);
    } else if (days > 5 && days <= 10) {
      return multiplyAmountByPercentual(amount, 0.074);
    }
    
    return multiplyAmountByPercentual(amount, 0.083);
  }
  
  private BigDecimal multiplyAmountByPercentual(BigDecimal amount, double percentual) {
    return amount.multiply(BigDecimal.valueOf(percentual));
  }

}
