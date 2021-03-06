/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.Customer;
import domain.Service;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class ServiceDA {
    
    private String host = "jdbc:derby://localhost:1527/vetdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Service";
    
    private Connection conn;
    private PreparedStatement stmt;
    
    public ServiceDA()
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
     public void addRecord(Service service)
    {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?)";
        try
        {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, service.getServiceID());
            stmt.setString(2, service.getServiceTitle());
            stmt.setDouble(3, service.getUnitPrice());
            stmt.setString(4, service.getServiceDesp());
            
            
            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public void updateRecord(Service service)
    {
        String updateStr = "UPDATE " + tableName + "SET serviceid = ?, servicetitle = ?, unitprice = ?, servicedescription = ? "+" WHERE serviecid = ? ";
        try
        {
            stmt = conn.prepareStatement(updateStr);
              stmt.setString(1, service.getServiceID());
            stmt.setString(2, service.getServiceTitle());
            stmt.setDouble(3, service.getUnitPrice());
            stmt.setString(4, service.getServiceDesp());

            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public Service getRecord(String serviceID)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE serviceid = ?";
        Service service = null;
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,serviceID);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                service = new Service(serviceID,rs.getString("servicetitle"),rs.getDouble("unitprice"),rs.getString("servicedesp")); 
                
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return service;
    }
     
     public ArrayList<Service> getRecord(String searchStr, int option)
    {
        String queryStr=null;
        Service service = null;
        
        switch(option){
            case 0: queryStr= "SELECT * FROM "+ tableName ;
            break;
            case 1: queryStr= "SELECT * FROM "+ tableName +" WHERE LOWER(serviceid) = LOWER(?) ";
            break;
            case 2: queryStr="SELECT * FROM "+ tableName +" WHERE LOWER(servicetitle)  LIKE LOWER('%' || ? || '%')";
            break;

        }
        
        ArrayList<Service> serviceList = new ArrayList<Service>();
        try
        {
            stmt = conn.prepareStatement(queryStr);
            if(option!=0){
            stmt.setString(1,searchStr);
            }
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                serviceList.add(new Service(rs.getString("serviceID"),rs.getString("servicetitle"),rs.getDouble("unitprice"),rs.getString("servicedesp"))); 
                
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return serviceList;
    }
     
       public void deleteRecord(String serviceID)
    {
        try
        {
            String deleStr = "DELETE FROM " + tableName + " WHERE serviceid = ?";
            
            stmt = conn.prepareStatement(deleStr);
            stmt.setString(1, serviceID);
            stmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
