
package control;

import da.ServiceDA;
import domain.Service;
import java.util.ArrayList;

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
 
    public ArrayList<Service> searchRecord(String queryStr, int option)
    {
        return serviceDA.getRecord(queryStr, option);
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
