/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import da.TransactionDA;
import domain.Transaction;
import java.util.ArrayList;

/**
 *
 * @author Cheng
 */
public class MaintainTransaction {
    private TransactionDA transDA;
    
    public MaintainTransaction()
    {
        transDA = new TransactionDA();
    }
    
    public void addRecord(Transaction trans)
    {
        transDA.addRecord(trans);
    }
    
    public Transaction searchRecord(String ID)        
    {
        return transDA.getRecord(ID);              
    }
    
    public ArrayList<Transaction> searchRecord(String queryStr, int option) 
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
