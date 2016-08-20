
package control;

import da.StaffDA;
import domain.Staff;
import java.util.ArrayList;

public class MaintainStaff {
    
    private StaffDA staffDA;
    
    public MaintainStaff()
    {
        staffDA = new StaffDA();
    }
    
    public void addRecord(Staff staff)
    {
        staffDA.addRecord(staff);
    }
    
    public Staff searchRecord(String IC)
    {
        return staffDA.getRecord(IC);
    }
    
    public ArrayList<Staff> searchRecord(String queryStr, int option) 
    {
        return staffDA.getRecord(queryStr, option);
    }
    
    public void updateRecord(Staff staff)
    {
        staffDA.updateRecord(staff);
    }
    
    public void updateRecordPassword(Staff staff)
    {
        staffDA.updateRecordPassword(staff);
    }
    
    public void deleteRecord(String IC)
    {
        staffDA.deleteRecord(IC);
    }
}
