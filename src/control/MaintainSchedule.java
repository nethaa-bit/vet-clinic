
package control;

import da.ScheduleDA;
import domain.Schedule;
import java.util.ArrayList;

public class MaintainSchedule {
    
    private ScheduleDA scheduleDA;
    
    public MaintainSchedule()
    {
        scheduleDA = new ScheduleDA();
    }
    
    public void addRecord(Schedule sch)
    {
        scheduleDA.addRecord(sch);
    }
    
    public Schedule searchRecord(String IC)             
    {
        return scheduleDA.getRecord(IC);
    }
    
     public ArrayList<Schedule> searchRecord(String queryStr, int option)             
    {
        return scheduleDA.getRecord(queryStr, option);
    }
    
    public void updateRecord(Schedule sch)
    {
        scheduleDA.updateRecord(sch);
    }
    
    public void deleteRecord(String IC)
    {
        scheduleDA.deleteRecord(IC);
    }
}
