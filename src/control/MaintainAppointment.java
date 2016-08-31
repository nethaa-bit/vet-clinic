
package control;

import da.AppointmentDA;
import domain.Appointment;
import java.util.ArrayList;

public class MaintainAppointment {
    
    private AppointmentDA scheduleDA;
    
    public MaintainAppointment()
    {
        scheduleDA = new AppointmentDA();
    }
    
    public void addRecord(Appointment sch)
    {
        scheduleDA.addRecord(sch);
    }
    
    public Appointment searchRecord(String IC)             
    {
        return scheduleDA.getRecord(IC);
    }
    
     public ArrayList<Appointment> searchRecord(String queryStr, int option)             
    {
        return scheduleDA.getRecord(queryStr, option);
    }
    
    public void updateRecord(Appointment sch)
    {
        scheduleDA.updateRecord(sch);
    }
    
    public void deleteRecord(String IC)
    {
        scheduleDA.deleteRecord(IC);
    }
}
