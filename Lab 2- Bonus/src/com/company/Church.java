package com.company;

import java.sql.Time;
import java.time.*;

public class Church extends Node implements Visitable {
    private LocalTime start,end;
    public  Church (String name){
        super(name);
    }

    @Override
    public void setHour(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public LocalTime getStart() {
        return this.start;
    }

    @Override
    public LocalTime getEnd() {
        return this.end;
    }
}
