package com.miguelbassila.bank.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
    
    assertEquals("Fee should be 8.00", new BigDecimal("8.00"), feeCalculated); 
  }
  
  @Test
  public void shouldCalculteFeeBLessThan30Days() {
    FeeB fee = new FeeB();
    
    Calendar daySchedule = new GregorianCalendar(2014, 10, 20);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), daySchedule);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer, fee);
    
    assertEquals("Fee should be 10", new BigDecimal(10.00), feeCalculated);
  }
  
  @Test
  public void shouldCalculteFeeBGreaterThan30Days() {
    FeeB fee = new FeeB();
    
    Calendar daySchedule = new GregorianCalendar(2015, 0, 20);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), daySchedule);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer, fee);
    
    assertEquals("Fee should be 8", new BigDecimal(8.00), feeCalculated);
  }

}
