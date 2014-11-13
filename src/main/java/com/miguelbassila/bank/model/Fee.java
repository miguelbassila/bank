package com.miguelbassila.bank.model;

import java.math.BigDecimal;

public interface Fee {
  
  public BigDecimal calculate(Transfer transfer);

}
