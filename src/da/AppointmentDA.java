/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import control.MaintainTransaction;
import domain.Appointment;
import domain.Transaction;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class AppointmentDA {
    
    private String host = "jdbc:derby://localhost:1527/vetdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Schedule";
    
    private Connection conn;
    private PreparedStatement stmt;
    private MaintainTransaction transControl;
    
    public AppointmentDA()
    {
        createConnection();
        transControl = new MaintainTransaction();
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
    
     public void addRecord(Appointment schedule)
    {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?)";
        try
        {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, schedule.getAppID());
            stmt.setTime(2, schedule.getAppTime());
            stmt.setDate(3, convertJavaDateToSqlDate(schedule.getAppDate()));
            stmt.setString(4, schedule.getCustName());
            stmt.setString(5, schedule.getCustPhoneNum());
            stmt.setString(6, schedule.getStatus());
            stmt.setString(7, null);
            
            
            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     
      public void updateRecord(Appointment schedule)
    {
        String updateStr = "UPDATE " + tableName + " SET appid = ?, apptime = ?, appdate = ?, custname = ?, custphonenum = ?, status = ? "+" WHERE appid = ? ";
        try
        {
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, schedule.getAppID());
            stmt.setTime(2, schedule.getAppTime());
            stmt.setDate(3, convertJavaDateToSqlDate(schedule.getAppDate()));
            stmt.setString(4, schedule.getCustName());
            stmt.setString(5, schedule.getCustPhoneNum());
            stmt.setString(6, schedule.getStatus());
            stmt.setString(7, schedule.getAppID());

            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
      
      public Appointment getRecord(String appID)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE appid = ?";
        Appointment schedule = null;
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,appID);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {   
                Transaction t = transControl.searchRecord(rs.getString("transid"));
                if(t!=null){
                    schedule = new Appointment(appID,rs.getTime("apptime"),rs.getDate("appdate"),rs.getString("custName"),rs.getString("custphonenum"),rs.getString("status"),t); 
                }
                else{
                    schedule = new Appointment(appID,rs.getTime("apptime"),rs.getDate("appdate"),rs.getString("custName"),rs.getString("custphonenum"),rs.getString("status")); 
                }
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return schedule;
    }
 
      public ArrayList<Appointment> getRecord(String searchStr, int option)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE appid = ?";
        Appointment schedule = null;
        String appID = "";
        switch(option){
            case 0: queryStr= "SELECT * FROM "+ tableName ;
            break;
            case 1: queryStr= "SELECT * FROM "+ tableName +" WHERE appid = ?";
            break;
            case 2: queryStr= "SELECT * FROM "+ tableName +" WHERE transid = ?";
            break;
            case 3: queryStr= "SELECT * FROM "+ tableName +" WHERE custphonenum = ?";
            break;
            case 4: queryStr= "SELECT * FROM "+ tableName +" WHERE LOWER(custname)  LIKE LOWER('%' || ? || '%')";
            break;
            case 5: queryStr= "SELECT * FROM "+ tableName +" WHERE LOWER(status) = LOWER(?)";
            break;
        }
        
        ArrayList<Appointment> scheduleList = new ArrayList<Appointment>();
        try
        {
            stmt = conn.prepareStatement(queryStr);
            if(option!=0){
            stmt.setString(1,searchStr);
            }
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Transaction t = transControl.searchRecord(rs.getString("transid"));
                if(t!=null){
                    schedule = new Appointment(rs.getString("appid"),rs.getTime("apptime"),rs.getDate("appdate"),rs.getString("custName"),rs.getString("custphonenum"),rs.getString("status"),t); 
                }
                else{
                    schedule = new Appointment(rs.getString("appid"),rs.getTime("apptime"),rs.getDate("appdate"),rs.getString("custName"),rs.getString("custphonenum"),rs.getString("status")); 
                }
                scheduleList.add(schedule);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return scheduleList;
    }
      
        public void deleteRecord(String appID)
    {
        try
        {
            String deleStr = "DELETE FROM " + tableName + " WHERE appid = ?";
            
            stmt = conn.prepareStatement(deleStr);
            stmt.setString(1, appID);
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
