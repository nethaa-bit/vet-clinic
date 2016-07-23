/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.Schedule;
import java.sql.*;
import javax.swing.*;

public class ScheduleDA {
    
    private String host = "jdbc:derby://localhost:1527/vetdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Schedule";
    
    private Connection conn;
    private PreparedStatement stmt;
    
    public ScheduleDA()
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
    
     public void addRecord(Schedule schedule)
    {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?)";
        try
        {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, schedule.getStaffIC());
            stmt.setInt(2, schedule.getTimeSlotNum());
            stmt.setTime(3, schedule.getAppTime());
            stmt.setDate(4, convertJavaDateToSqlDate(schedule.getAppDate()));
            stmt.setString(5, schedule.getCustName());
            stmt.setString(6, schedule.getCustPhoneNum());
            
            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     
      public void updateRecord(Schedule schedule)
    {
        String updateStr = "UPDATE " + tableName + "SET staffic = ?, timeslotnum = ?, apptime = ?, appdate = ?, custname = ?, custphonenum = ? "+" WHERE custic = ? ";
        try
        {
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, schedule.getStaffIC());
            stmt.setInt(2, schedule.getTimeSlotNum());
            stmt.setTime(3, schedule.getAppTime());
            stmt.setDate(4, convertJavaDateToSqlDate(schedule.getAppDate()));
            stmt.setString(5, schedule.getCustName());
            stmt.setString(6, schedule.getCustPhoneNum());

            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
      
      public Schedule getRecord(String staffIC)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE staffIC = ?";
        Schedule schedule = null;
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,staffIC);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                schedule = new Schedule(staffIC,rs.getInt("timeslotnum"),rs.getTime("apptime"),rs.getDate("appdate"),rs.getString("custname"),rs.getString("custphonenum")); 
                
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return schedule;
    }
      
        public void deleteRecord(String staffIC)
    {
        try
        {
            String deleStr = "DELETE FROM " + tableName + " WHERE staffic = ?";
            
            stmt = conn.prepareStatement(deleStr);
            stmt.setString(1, staffIC);
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
