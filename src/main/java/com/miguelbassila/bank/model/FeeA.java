package com.miguelbassila.bank.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FeeA implements Fee {

  public BigDecimal calculate(Transfer transfer) {
    BigDecimal amount = transfer.getAmount();
    BigDecimal fee = amount.multiply(BigDecimal.valueOf(0.03)).add(BigDecimal.valueOf(2.00)).setScale(2, RoundingMode.CEILING);
    
    return fee;
  }

}
