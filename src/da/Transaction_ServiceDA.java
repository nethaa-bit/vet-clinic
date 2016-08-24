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

public class Transaction_ServiceDA {
    
    private String host = "jdbc:derby://localhost:1527/vetdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Transaction_service";
    
    private Connection conn;
    private PreparedStatement stmt;
    
    public Transaction_ServiceDA()
    {
        createConnection();
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
        
        ArrayList<ServiceDetail> servList = transaction.getServiceList();
        try
        {
            for(int i=0; i<servList.size();i++){
                stmt = conn.prepareStatement(insertStr);
                stmt.setString(1, transaction.getTransID());
                stmt.setString(2, servList.get(i).getService().getServiceID());
                stmt.setString(3, servList.get(i).getStaffIC().getStaffIC());
                stmt.setString(4, servList.get(i).getRemarks());
                stmt.executeUpdate();
             }
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
        
 public void updateRecord(Transaction transaction)
    {
        String updateStr = "UPDATE " + tableName + "SET transid = ?, serviceid = ?, staffic = ?, remarks = ? "+" WHERE transid = ? AND serviceid = ? ";
         ArrayList<ServiceDetail> servList = transaction.getServiceList();
        try
        {   for(int i=0; i<servList.size();i++){
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, transaction.getTransID());
            stmt.setString(2, servList.get(i).getService().getServiceID());
            stmt.setString(3, servList.get(i).getStaffIC().getStaffIC());
            stmt.setString(4, servList.get(i).getRemarks());
            stmt.setString(5, transaction.getTransID());
            stmt.setString(6, servList.get(i).getService().getServiceID());

            stmt.executeUpdate();
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
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
                Pet pet =  (Pet)rs.getObject("petid");
                transaction = new Transaction(transID,rs.getDate("transdate"),rs.getTime("transtime"),pet);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return transaction;
    }
 public ServiceDetail getRecord(Transaction trans, Service service)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE transID = ? AND serviceid = ?";
        ServiceDetail servDetail = null;
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,trans.getTransID());
            stmt.setString(1,service.getServiceID());
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                Pet pet =  (Pet)rs.getObject("petid");
                servDetail = new ServiceDetail( service,(Staff)rs.getObject("staffic"),rs.getString("remarks"));
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return servDetail;
    }
 public ArrayList<ServiceDetail> getRecord(String transID, int option)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE transID = ?";
        ServiceDetail servDetail = null;
        
        switch(option){
            case 0: queryStr= "SELECT * FROM "+ tableName ;
            break;
            case 1: queryStr= "SELECT * FROM "+ tableName +" WHERE transid = ?";
            break;
            case 2: queryStr="SELECT * FROM "+ tableName +" WHERE LOWER(staffic) = ? ";
            break;
            case 3: queryStr="SELECT * FROM "+ tableName +" WHERE LOWER(serviceid)  = ? ";
            break;
        }
        
    ArrayList<ServiceDetail> servList = new ArrayList<ServiceDetail>();
    try
    {
        stmt = conn.prepareStatement(queryStr);
        stmt.setString(1,transID);
        ResultSet rs = stmt.executeQuery();

        while(rs.next())
        {
            Pet pet =  (Pet)rs.getObject("petid");
            servDetail = new ServiceDetail((Service)rs.getObject("serviceid"),(Staff)rs.getObject("staffic"),rs.getString("remarks"));
            servList.add(servDetail);
        }
    }
    catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
    return servList;
}

 public void deleteRecord(String transID)
{
    try
    {
        String deleStr = "DELETE FROM " + tableName + " WHERE transid = ?";

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
