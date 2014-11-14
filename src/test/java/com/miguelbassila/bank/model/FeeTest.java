package com.miguelbassila.bank.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
  public void shouldCalculateFeeBLessThan30Days() {
    FeeB fee = new FeeB();
    
    Calendar daySchedule = new GregorianCalendar(2014, 10, 20);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), daySchedule);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer, fee);
    
    assertEquals("Fee should be 10", new BigDecimal(10.00).setScale(2, RoundingMode.CEILING), feeCalculated);
  }
  
  @Test
  public void shouldCalculateFeeBGreaterThan30Days() {
    FeeB fee = new FeeB();
    
    Calendar daySchedule = new GregorianCalendar(2015, 0, 20);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), daySchedule);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer, fee);
    
    assertEquals("Fee should be 8", new BigDecimal(8.00).setScale(2, RoundingMode.CEILING), feeCalculated);
  }
  
  @Test
  public void shouldCalculateFeeCGreaterThan30Days() {
    FeeC fee = new FeeC();
    
    Calendar daySchedule = new GregorianCalendar();
    daySchedule.add(Calendar.DATE, 35);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), daySchedule);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer, fee);
    assertEquals("Fee should be 2.4", new BigDecimal("2.40"), feeCalculated);
  }
  
  @Test
  public void shouldCalculateFeeCGreaterThan25DaysLessThan30Days() {
    FeeC fee = new FeeC();
    
    Calendar daySchedule = new GregorianCalendar();
    daySchedule.add(Calendar.DATE, 27);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), daySchedule);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer, fee);
    assertEquals("Fee should be 4.20", new BigDecimal("4.20"), feeCalculated);
  }
  
  @Test
  public void shouldCalculateFeeCGreaterThan20DaysLessThan25Days() {
    FeeC fee = new FeeC();
    
    Calendar daySchedule = new GregorianCalendar();
    daySchedule.add(Calendar.DATE, 23);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), daySchedule);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer, fee);
    assertEquals("Fee should be 8.60", new BigDecimal("8.60"), feeCalculated);
  }
  
  @Test
  public void shouldCalculateFeeCGreaterThan15DaysLessThan20Days() {
    FeeC fee = new FeeC();
    
    Calendar daySchedule = new GregorianCalendar();
    daySchedule.add(Calendar.DATE, 18);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), daySchedule);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer, fee);
    assertEquals("Fee should be 10.80", new BigDecimal("10.80"), feeCalculated);
  }
  
  @Test
  public void shouldCalculateFeeCGreaterThan10DaysLessThan15Days() {
    FeeC fee = new FeeC();
    
    Calendar daySchedule = new GregorianCalendar();
    daySchedule.add(Calendar.DATE, 13);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), daySchedule);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer, fee);
    assertEquals("Fee should be 13.40", new BigDecimal("13.40"), feeCalculated);
  }
  
  @Test
  public void shouldCalculateFeeCGreaterThan5DaysLessThan10Days() {
    FeeC fee = new FeeC();
    
    Calendar daySchedule = new GregorianCalendar();
    daySchedule.add(Calendar.DATE, 8);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), daySchedule);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer, fee);
    assertEquals("Fee should be 14.80", new BigDecimal("14.80"), feeCalculated);
  }
  
  @Test
  public void shouldCalculateFeeCLessThan5Days() {
    FeeC fee = new FeeC();
    
    Calendar daySchedule = new GregorianCalendar();
    daySchedule.add(Calendar.DATE, 3);
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), daySchedule);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer, fee);
    assertEquals("Fee should be 16.60", new BigDecimal("16.60"), feeCalculated);
  }
  
  @Test 
  public void shouldCalculateFeeDUsingFeeA() {
    FeeD fee = new FeeD();
    
    Calendar today = Calendar.getInstance();
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(200.00), today);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer,fee);
    
    assertEquals("Fee should be 8.00", new BigDecimal("8.00"), feeCalculated); 
  }
  
  @Test 
  public void shouldCalculateFeeDUsingFeeB() {
    FeeD fee = new FeeD();
    
    Calendar today = Calendar.getInstance();
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(80000.00), today);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer,fee);
    
    assertEquals("Fee should be 10.00", new BigDecimal("10.00"), feeCalculated); 
  }
  
  @Test 
  public void shouldCalculateFeeDUsingFeeC() {
    FeeD fee = new FeeD();
    
    Calendar today = Calendar.getInstance();
    transfer = new Transfer(originAccount, destinationAccount, new BigDecimal(150000.00), today);
    
    BigDecimal feeCalculated = transfer.calculateFee(transfer,fee);
    
    assertEquals("Fee should be 10.00", new BigDecimal("12450.00"), feeCalculated); 
  }

}
