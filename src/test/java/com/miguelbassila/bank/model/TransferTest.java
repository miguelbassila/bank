package com.miguelbassila.bank.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class TransferTest {

  private Account originAccount;
  private Account destinationAccount;
  private Transfer transfer;

  @Before
  public void setUp() {
    originAccount = new Account("40322-9", new BigDecimal(1000.0));
    destinationAccount = new Account("60854-8", new BigDecimal(2000.0));
  }
  
  @Test
  public void shouldTransferAndSubtractFee(){
    FeeB fee = new FeeB();
    
    Calendar daySchedule = new GregorianCalendar();
    
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), fee, daySchedule);
    transfer.send();
    
    assertEquals(new BigDecimal(2200.00).setScale(2, RoundingMode.CEILING), destinationAccount.getBalance());
    assertEquals(new BigDecimal(790.00).setScale(2, RoundingMode.CEILING), originAccount.getBalance()); 
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void shouldNotTransferWhenAmountGreaterThanBalance(){
    FeeC fee = new FeeC();
    
    Calendar daySchedule = new GregorianCalendar();
    daySchedule.add(Calendar.DATE, 35);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(1500.00), fee, daySchedule);
    transfer.send();
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void shouldNotTransferWhenAmountEqualZero(){
    FeeC fee = new FeeC();
    
    Calendar daySchedule = new GregorianCalendar();
    daySchedule.add(Calendar.DATE, 35);
    transfer = new Transfer(originAccount, destinationAccount, BigDecimal.ZERO, fee, daySchedule);
    transfer.send();
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void shouldNotTransferWhenAmountIsNegative(){
    FeeC fee = new FeeC();
    
    Calendar daySchedule = new GregorianCalendar();
    daySchedule.add(Calendar.DATE, 35);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal("-200.00"), fee, daySchedule);
    transfer.send();
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void shouldNotTransferWhenDateScheduleIsInPast(){
    FeeC fee = new FeeC();
    
    Calendar daySchedule = new GregorianCalendar();
    daySchedule.add(Calendar.DATE, -5);
    
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), fee, daySchedule);
    transfer.send();
  }
  
  

}
