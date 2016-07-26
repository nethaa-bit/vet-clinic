
package control;

import da.ServiceDA;
import domain.Service;

public class MaintainService {
    
    private ServiceDA serviceDA;
    
    public MaintainService()
    {
        serviceDA = new ServiceDA();
    }
    
    public void addRecord(Service ser)
    {
        serviceDA.addRecord(ser);
    }
    
    public Service searchRecord(String ID)
    {
        return serviceDA.getRecord(ID);
    }
    
    public void updateRecord(Service ser)
    {
        serviceDA.updateRecord(ser);
    }
    
    public void deleteRecord(String ID)
    {
        serviceDA.deleteRecord(ID);
    }
    
}
