package com.company;

import java.time.*;

public interface Visitable {
   public void setHour(LocalTime start,LocalTime end);
   public LocalTime getStart();
   public LocalTime getEnd();
}
