package domain;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    
    private String transID;
    private Date transDate;
    private Time transTime;
    private Pet pet;
    private ArrayList<ServiceDetail> serviceList;

    public Transaction() {
    }

    public Transaction(String transID, Date transDate, Time transTime, Pet pet, ArrayList<ServiceDetail> serviceList) {
        this.transID = transID;
        this.transDate = transDate;
        this.transTime = transTime;
        this.pet = pet;
        this.serviceList = serviceList;
    }

    
    public Transaction(String transID, Date transDate, Time transTime, Pet pet) {
        this.transID = transID;
        this.transDate = transDate;
        this.transTime = transTime;
        this.pet = pet;
        
    }
    
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Time getTransTime() {
        return transTime;
    }

    public void setTransTime(Time transTime) {
        this.transTime = transTime;
    }

    public ArrayList<ServiceDetail> getServiceList() {
        return serviceList;
    }

    public void setServiceList(ArrayList<ServiceDetail> serviceList) {
        this.serviceList = serviceList;
    }
    
    public Object[] getObjects() {
        Object[] objList ={transID,transDate,transTime,pet.getPetID()};
        return objList;
    }
}