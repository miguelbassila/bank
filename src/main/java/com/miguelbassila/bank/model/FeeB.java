package com.miguelbassila.bank.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FeeB implements Fee {

  public BigDecimal calculate(Transfer transfer) {
    Calendar dateSchedule = transfer.getDateSchedule();
    Calendar today = GregorianCalendar.getInstance();
    
    long days = calculateDays(today, dateSchedule); 
    
    if (days >=30){
      return BigDecimal.valueOf(10);
    }
    
    return BigDecimal.valueOf(8);
  }

  private long calculateDays(Calendar today, Calendar dateSchedule) {
    
    Instant instantToday = today.toInstant();
    Instant instantDateSchedule = dateSchedule.toInstant();
    
    Duration duration = Duration.between(instantToday, instantDateSchedule);
    
    return duration.toDays();
  }

}
