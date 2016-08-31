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
public class Appointment {
    
    private String appID;
    private Time appTime;
    private Date appDate;
    private String custName;
    private String custPhoneNum;
    private String status;
    private Transaction transID;

    public Appointment() {
    }
    
    //for add
    public Appointment(String appID, Time appTime, Date appDate, String custName, String custPhoneNum, String status) {
        this.appID = appID;
        this.appTime = appTime;
        this.appDate = appDate;
        this.custName = custName;
        this.custPhoneNum = custPhoneNum;
        this.status = status;
    }

    //for update
    public Appointment(String appID, Time appTime, Date appDate, String custName, String custPhoneNum, String status, Transaction transID) {
        this.appID = appID;
        this.appTime = appTime;
        this.appDate = appDate;
        this.custName = custName;
        this.custPhoneNum = custPhoneNum;
        this.status = status;
        this.transID = transID;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Transaction getTransID() {
        return transID;
    }

    public void setTransID(Transaction transID) {
        this.transID = transID;
    }

   public Object[] getObjects(){
   
       Object[] objList = {appID, appTime, appDate, custName, custPhoneNum, status, transID};
       return objList;
   }
    
}
