/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.Staff;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class StaffDA {
    
    private String host = "jdbc:derby://localhost:1527/vetdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Staff";
    
    private Connection conn;
    private PreparedStatement stmt;
    
    public StaffDA()
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
    
    public void addRecord(Staff staff)
    {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?,?)";
        try
        {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, staff.getStaffIC());
            stmt.setString(2, staff.getStaffName());
            stmt.setString(3, staff.getStaffAddress());
            stmt.setString(4, staff.getStaffPhone());
            stmt.setString(5, staff.getStaffPosition());
            stmt.setString(6, staff.getStaffQualification());
            stmt.setString(7, staff.getPassword());
            stmt.setString(8, staff.getSecurityAns());
            
            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(Staff staff)
    {
        String updateStr = "UPDATE " + tableName + " SET staffic = ?, staffname = ?, staffaddress = ?, staffphone = ?, staffposition = ?, staffqualification = ?, password = ?, securityans = ? "+" WHERE staffic = ? ";
        try
        {
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, staff.getStaffIC());
            stmt.setString(2, staff.getStaffName());
            stmt.setString(3, staff.getStaffAddress());
            stmt.setString(4, staff.getStaffPhone());
            stmt.setString(5, staff.getStaffPosition());
            stmt.setString(6, staff.getStaffQualification());
            stmt.setString(7, staff.getPassword());
            stmt.setString(8, staff.getSecurityAns());
            stmt.setString(9, staff.getStaffIC());

            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public Staff getRecord(String staffIC)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE staffic = ?";
        Staff staff = null;
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,staffIC);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                staff = new Staff(staffIC,rs.getString("staffname"),rs.getString("staffaddress"),rs.getString("staffphone"),rs.getString("staffposition"),rs.getString("staffqualification"),rs.getString("password"),rs.getString("securityans")); 
                
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }
    
    public ResultSet getRecordSet(String staffIC) //no need
    {
        ResultSet rs=null;
        String queryStr="SELECT * FROM "+ tableName +" WHERE staffic = ?";
        Staff staff = null;
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,staffIC);
            rs = stmt.executeQuery();
            
            if(rs.next())
            {
                staff = new Staff(staffIC,rs.getString("staffname"),rs.getString("staffaddress"),rs.getString("staffphone"),rs.getString("staffposition"),rs.getString("staffqualification"),rs.getString("password"),rs.getString("securityans")); 
                
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
    public ArrayList<Staff> getRecord(String searchStr, int option) //copy this header but method body leave same 
    {   
        String queryStr=null;
        String criteria=null;
        switch(option){
            case 1: queryStr="SELECT * FROM "+ tableName +" WHERE staffic = ?";
            break;
            case 2: queryStr="SELECT * FROM "+ tableName +" WHERE LOWER(staffname)  LIKE LOWER('%' || ? || '%')";
            break;
            case 3: queryStr="SELECT * FROM "+ tableName +" WHERE LOWER(staffposition)  = LOWER(?) ";
            break;
        }
        
        
        
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,searchStr);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                staffList.add(new Staff(rs.getString("staffic"),rs.getString("staffname"),rs.getString("staffaddress"),rs.getString("staffphone"),rs.getString("staffposition"),rs.getString("staffqualification"),rs.getString("password"),rs.getString("securityans")));
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage()==null?"Unknown error":ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return staffList;
    }
    
    public void deleteRecord(String staffID)
    {
        try
        {
            String deleStr = "DELETE FROM " + tableName + " WHERE staffid = ?";
            
            stmt = conn.prepareStatement(deleStr);
            stmt.setString(1, staffID);
            stmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
