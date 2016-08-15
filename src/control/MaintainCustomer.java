/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import da.CustomerDA;
import domain.Customer;
import java.util.ArrayList;

public class MaintainCustomer {
 
    private CustomerDA customerDA;
    
    public MaintainCustomer()
    {
        customerDA = new CustomerDA();
    }
    
    public void addRecord(Customer cus)
    {
        customerDA.addRecord(cus);
    }
    
    public Customer searchRecord(String IC)
    {
        return customerDA.getRecord(IC);
    }
    
    public ArrayList<Customer> searchRecord(String queryStr, int option)
    {
        return customerDA.getRecord(queryStr, option);
    }
    
    public void updateRecord(Customer cus)
    {
        customerDA.updateRecord(cus);
    }
    
    public void deleteRecord(String IC)
    {
        customerDA.deleteRecord(IC);
    }
}
