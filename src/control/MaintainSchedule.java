
package control;

import da.ScheduleDA;
import domain.Schedule;

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
    
    public Schedule searchRecord(String IC)             //WTF?
    {
        return scheduleDA.getRecord(IC);
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
