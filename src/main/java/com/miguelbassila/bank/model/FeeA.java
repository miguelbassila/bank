package com.miguelbassila.bank.model;

import java.math.BigDecimal;

public class FeeA implements Fee {

  public BigDecimal calculate(Transfer transfer) {
    BigDecimal fee = transfer.getAmmount();
    fee = fee.multiply(BigDecimal.valueOf(0.03)).add(BigDecimal.valueOf(2));
    
    return fee;
  }

}
