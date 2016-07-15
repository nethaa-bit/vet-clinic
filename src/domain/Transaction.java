package domain;

import java.sql.Time;
import java.util.Date;

public class Transaction {
    
    private String transID;
    private Date transDate;
    private Time transTime;
    private Pet pet;

    public Transaction() {
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
    
    
}
