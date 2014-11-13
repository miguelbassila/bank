package com.miguelbassila.bank.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FeeC implements Fee {

  public BigDecimal calculate(Transfer transfer) {
    Calendar dateSchedule = transfer.getDateSchedule();
    Calendar today = GregorianCalendar.getInstance();
    
    long days = calculateDays(today, dateSchedule); 
    
    if (days > 30){
      1.2%;
    } else if (days > 25 || days <= 30) {
      2.1%;
    } else if (days > 20 || days <= 25) {
      4.3%;
    } else if (days > 15 || days <= 20) {
      5.4%;
    } else if (days > 10 || days <= 15) {
      6.7%;
    } else if (days > 5 || days <= 10) {
      7.4%;
    }
    
    return 8.3%;
  }
  
  private long calculateDays(Calendar today, Calendar dateSchedule) {
    
    Instant instantToday = today.toInstant();
    Instant instantDateSchedule = dateSchedule.toInstant();
    
    Duration duration = Duration.between(instantToday, instantDateSchedule);
    
    return duration.toDays();
  }

}
