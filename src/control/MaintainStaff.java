
package control;

import da.StaffDA;
import domain.Staff;

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
    
    public void updateRecord(Staff staff)
    {
        staffDA.updateRecord(staff);
    }
    
    public void deleteRecord(String IC)
    {
        staffDA.deleteRecord(IC);
    }
}
