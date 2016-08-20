/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import da.PaymentDA;
import domain.Payment;
import java.util.ArrayList;


/**
 *
 * @author Cheng
 */
public class MaintainPayment {
    private PaymentDA paymentDA;
    
    public MaintainPayment()
    {
        paymentDA = new PaymentDA();
    }
    
    public void addRecord(Payment pay)
    {
        paymentDA.addRecord(pay);
    }
    
    public Payment searchRecord(String ID)        
    {
        return paymentDA.getRecord(ID);              
    }
    
    public ArrayList<Payment> searchRecord(String queryStr, int option) 
    {
        return paymentDA.getRecord(queryStr, option);
    }
    
    public void updateRecord(Payment pay)
    {
        paymentDA.updateRecord(pay);
    }
    
    public void deleteRecord(String ID)          
    {
        paymentDA.deleteRecord(ID);        
    }
}
