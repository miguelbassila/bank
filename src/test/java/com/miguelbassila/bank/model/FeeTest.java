package com.miguelbassila.bank.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class FeeTest {

  private Account originAccount;
  private Account destinationAccount;
  private Transfer transfer;

  @Before
  public void setUp() {
    originAccount = new Account("40322-9", new BigDecimal(1000.0));
    destinationAccount = new Account("60854-8", new BigDecimal(2000.0));
  }
  
  @Test
  public void shouldCalculateFeeA() {
    FeeA fee = new FeeA();
    
    Calendar today = Calendar.getInstance();
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), today);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer,fee);
    
    assertEquals("", new BigDecimal("8.00"), feeCalculated); 
  }

}
