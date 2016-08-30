/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;
import domain.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class TransactionDA {
    
    private String host = "jdbc:derby://localhost:1527/vetdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Transaction1";
    
    private Connection conn;
    private PreparedStatement stmt;
    private PetDA petDA;
    
    public TransactionDA()
    {
        createConnection();
        petDA = new PetDA();
    }
    
    public void createConnection()
    {
        try
        {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***Vet : Connection established.");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
public void addRecord(Transaction transaction)
    {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?)";
        try
        {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, transaction.getTransID());
            stmt.setDate(2, convertJavaDateToSqlDate(transaction.getTransDate()));
            stmt.setTime(3, transaction.getTransTime());
            stmt.setString(4, transaction.getPet().getPetID());
            
            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
        
 public void updateRecord(Transaction transaction)
    {
        String updateStr = "UPDATE " + tableName + " SET transid = ?, transdate = ?, transtime = ?, petid = ? "+" WHERE transid = ? ";
        try
        {
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, transaction.getTransID());
            stmt.setDate(2, convertJavaDateToSqlDate(transaction.getTransDate()));
            stmt.setTime(3, transaction.getTransTime());
            stmt.setString(4, transaction.getPet().getPetID());
            stmt.setString(5, transaction.getTransID());
            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage()+"1","Error",JOptionPane.ERROR_MESSAGE);
        }
    }    
    
 public Transaction getRecord(String transID)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE transID = ?";
        Transaction transaction = null;
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,transID);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
            Pet pet = petDA.getRecord(rs.getString("petid"));
         
            transaction = new Transaction(rs.getString("transID"),rs.getDate("transdate"),rs.getTime("transtime"),pet); 
                
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return transaction;
    }
 
 public ArrayList<Transaction> getRecord(String transID, int option)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE transID = ?";
        Transaction transaction = null;
        
        switch(option){
            case 0: queryStr= "SELECT * FROM "+ tableName ;
            break;
            case 1: queryStr= "SELECT * FROM "+ tableName +" WHERE transID = ?";
            break;
            case 2: queryStr="SELECT * FROM "+ tableName +" WHERE staffname = ?";
            break;
            
        }
        
    ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
    try
    {
        stmt = conn.prepareStatement(queryStr);
        if(option!=0){
        stmt.setString(1,transID);
        }
        ResultSet rs = stmt.executeQuery();

        while(rs.next())
        {
            Pet pet = petDA.getRecord(rs.getString("petid"));
            transaction = new Transaction(rs.getString("transID"),rs.getDate("transdate"),rs.getTime("transtime"),pet); 
            transactionList.add(transaction);

        }
    }
    catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    return transactionList;
}

 public void deleteRecord(String transID)
{
    try
    {
        String deleStr = " DELETE FROM " + tableName + " WHERE transid = ? ";

        stmt = conn.prepareStatement(deleStr);
        stmt.setString(1, transID);
        stmt.executeUpdate();
    }
    catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }
}
//Converts java.util.Date object to  java.sql.Date
public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
    return new java.sql.Date(date.getTime());
}
   


}
