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
    
    //Not sure if this method will work as intended
    
    private class ServiceDetail{
        
        private Service service;
        private Staff staffIC;
        private String Remarks;

        public ServiceDetail() {
        }

        public ServiceDetail(Service service, Staff staffIC, String Remarks) {
            this.service = service;
            this.staffIC = staffIC;
            this.Remarks = Remarks;
        }

        public String getRemarks() {
            return Remarks;
        }

        public void setRemarks(String Remarks) {
            this.Remarks = Remarks;
        }

        public Service getService() {
            return service;
        }

        public void setService(Service service) {
            this.service = service;
        }

        public Staff getStaffIC() {
            return staffIC;
        }

        public void setStaffIC(Staff staffIC) {
            this.staffIC = staffIC;
        }
        
        
    }
    
}
