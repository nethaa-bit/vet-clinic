/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import da.Transaction_ServiceDA;
import domain.Service;
import domain.ServiceDetail;
import domain.Transaction;
import java.util.ArrayList;

public class MaintainTransactionService {
       private Transaction_ServiceDA transDA;
    
    public MaintainTransactionService()
    {
        transDA = new Transaction_ServiceDA();
    }
    
    public void addRecord(Transaction trans)
    {
        transDA.addRecord(trans);
    }
    
    public ServiceDetail searchRecord(Transaction trans, Service service)        
    {
        return transDA.getRecord(trans,service);              
    }
    
    public ArrayList<ServiceDetail> searchRecord(String queryStr, int option) 
    {
        return transDA.getRecord(queryStr, option);
    }
    
    public void updateRecord(Transaction trans)
    {
        transDA.updateRecord(trans);
    }
    
    public void deleteRecord(String ID)          
    {
        transDA.deleteRecord(ID);        //
    } 
}
