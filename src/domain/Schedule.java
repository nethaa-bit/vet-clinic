/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author lysan
 */
public class Schedule {
    
    private String staffIC;
    private int timeSlotNum;
    private Time appTime;
    private Date appDate;
    private String custName;
    private String custPhoneNum;

    public Schedule() {
    }

    public Schedule(String staffIC, int timeSlotNum, Time appTime, Date appDate, String custName, String custPhoneNum) {
        this.staffIC = staffIC;
        this.timeSlotNum = timeSlotNum;
        this.appTime = appTime;
        this.appDate = appDate;
        this.custName = custName;
        this.custPhoneNum = custPhoneNum;
    }

    public String getStaffIC() {
        return staffIC;
    }

    public void setStaffIC(String staffIC) {
        this.staffIC = staffIC;
    }

    public int getTimeSlotNum() {
        return timeSlotNum;
    }

    public void setTimeSlotNum(int timeSlotNum) {
        this.timeSlotNum = timeSlotNum;
    }

    public Time getAppTime() {
        return appTime;
    }

    public void setAppTime(Time appTime) {
        this.appTime = appTime;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhoneNum() {
        return custPhoneNum;
    }

    public void setCustPhoneNum(String custPhoneNum) {
        this.custPhoneNum = custPhoneNum;
    }
}
