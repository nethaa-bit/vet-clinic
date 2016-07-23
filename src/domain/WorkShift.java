/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Time;

/**
 *
 * @author lysan
 */
public class WorkShift {
    
    private int timeSlotNum;
    private Time startTime;
    private Time endTime;

    public WorkShift() {
    }

    public WorkShift(int timeSlotNum, Time startTime, Time endTime) {
        this.timeSlotNum = timeSlotNum;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getTimeSlotNum() {
        return timeSlotNum;
    }

    public void setTimeSlotNum(int timeSlotNum) {
        this.timeSlotNum = timeSlotNum;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
    
}
