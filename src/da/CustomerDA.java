/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.Customer;
import java.sql.*;
import javax.swing.*;

public class CustomerDA {
    
    private String host = "jdbc:derby://localhost:1527/vetdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Customer";
    
    private Connection conn;
    private PreparedStatement stmt;
    
    public CustomerDA()
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
    
    public void addRecord(Customer cust)
    {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?)";
        try
        {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, cust.getCustIC());
            stmt.setString(2, cust.getCustName());
            stmt.setString(3, String.valueOf(cust.getCustGender()));
            stmt.setString(4, cust.getCustAddress());
            stmt.setString(5, cust.getCustPhoneNum());
            
            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(Customer cust)
    {
        String updateStr = "UPDATE " + tableName + "SET custic = ?, custname = ?, custgender = ?, custaddress = ?, custphonenum = ?, cardname = ? "+" WHERE custic = ? ";
        try
        {
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, cust.getCustIC());
            stmt.setString(2, cust.getCustName());
            stmt.setString(3, String.valueOf(cust.getCustGender()));
            stmt.setString(4, cust.getCustAddress());
            stmt.setString(5, cust.getCustPhoneNum());

            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Customer getRecord(String custIC)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE custIC = ?";
        Customer customer = null;
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,custIC);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                customer = new Customer(custIC,rs.getString("custname"),rs.getString("custgender").charAt(0),rs.getString("custaddress"),rs.getString("custphonenum")); 
                
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return customer;
    }
    
     public void deleteRecord(String custIC)
    {
        try
        {
            String deleStr = "DELETE FROM " + tableName + " WHERE custic = ?";
            
            stmt = conn.prepareStatement(deleStr);
            stmt.setString(1, custIC);
            stmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}

    