package com.miguelbassila.bank.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class ConditionalFee implements Fee {

  @Override
  public final BigDecimal calculate(Transfer transfer) {
    Calendar dateSchedule = transfer.getDateSchedule();
    Calendar today = GregorianCalendar.getInstance();
    
    long days = calculateDays(today, dateSchedule); 
    
    return feeByDays(days, transfer);
  }
  
  public abstract BigDecimal feeByDays(long days, Transfer transfer);

  protected long calculateDays(Calendar today, Calendar dateSchedule) {
    Instant instantToday = today.toInstant();
    Instant instantDateSchedule = dateSchedule.toInstant();
    
    Duration duration = Duration.between(instantToday, instantDateSchedule);
    
    return duration.toDays();
  }

}
