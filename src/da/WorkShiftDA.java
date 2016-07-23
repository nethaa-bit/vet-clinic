/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.WorkShift;
import java.sql.*;
import javax.swing.*;

public class WorkShiftDA {
    
    private String host = "jdbc:derby://localhost:1527/vetdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "WorkShift";
    
    private Connection conn;
    private PreparedStatement stmt;
    
    public WorkShiftDA()
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
    
    public void addRecord(WorkShift workshift)
    {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?)";
        try
        {
            stmt = conn.prepareStatement(insertStr);
            stmt.setInt(1, workshift.getTimeSlotNum());
            stmt.setTime(2, workshift.getStartTime());
            stmt.setTime(3, workshift.getEndTime());
            
            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public void updateRecord(WorkShift workshift)
    {
        String updateStr = "UPDATE " + tableName + "SET timeslotnum = ?, starttime = ?, endtime = ?, "+" WHERE timeslotnum = ? ";
        try
        {
            stmt = conn.prepareStatement(updateStr);
            stmt.setInt(1, workshift.getTimeSlotNum());
            stmt.setTime(2, workshift.getStartTime());
            stmt.setTime(3, workshift.getEndTime());

            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public WorkShift getRecord(Integer timeSlotNum)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE timeslotnum = ?";
        WorkShift workshift = null;
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setInt(1,timeSlotNum);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                workshift = new WorkShift(timeSlotNum,rs.getTime("starttime"),rs.getTime("endtime")); 
                
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return workshift;
    }
      
    public void deleteRecord(Integer timeSlotNum)
    {
        try
        {
            String deleStr = "DELETE FROM " + tableName + " WHERE timeSlotNum = ?";
            
            stmt = conn.prepareStatement(deleStr);
            stmt.setInt(1,timeSlotNum);
            stmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
