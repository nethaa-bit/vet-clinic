/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.CreditCard;
import domain.Payment;
import domain.Staff;
import domain.Transaction;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class PaymentDA {
    
    private String host = "jdbc:derby://localhost:1527/vetdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Payment";
    
    private Connection conn;
    private PreparedStatement stmt;
    
    public PaymentDA()
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
    
     public void addRecord(Payment payment)
    {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?)";
        try
        {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, payment.getPaymentID());
            stmt.setDouble(2, payment.getAmountPaid());
            stmt.setString(3, payment.getMethodOfPayment());
            stmt.setDate(4, convertJavaDateToSqlDate(payment.getPaymentDate()));
            stmt.setString(5, payment.getTransaction().getTransID());
            stmt.setString(6, payment.getStaff().getStaffIC());
            stmt.setString(7, payment.getCc().getCcNum());
            
            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public void updateRecord(Payment payment)
    {
        String updateStr = "UPDATE " + tableName + "SET paymentid = ?, amountpaid = ?, methodofpayment = ?, paymentdate = ?, TransID = ?, StaffIC = ?, CcNum = ? "+" WHERE paymentid = ? ";
        try
        {
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, payment.getPaymentID());
            stmt.setDouble(2, payment.getAmountPaid());
            stmt.setString(3, payment.getMethodOfPayment());
            stmt.setDate(4, convertJavaDateToSqlDate(payment.getPaymentDate()));
            stmt.setString(5, payment.getTransaction().getTransID());
            stmt.setString(6, payment.getStaff().getStaffIC());
            stmt.setString(7, payment.getCc().getCcNum());
            

            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
     
     public Payment getRecord(String paymentID)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE paymentID = ?";
        Payment payment = null;
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,paymentID);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                payment = new Payment(paymentID,rs.getDouble("amountpaid"),rs.getString("methodofpayment"),rs.getDate("paymentdate"),new Transaction(),new Staff(),new CreditCard());
                payment.getTransaction().setTransID(rs.getString("transid"));
                payment.getStaff().setStaffIC(rs.getString("staffic"));
                payment.getCc().setCcNum(rs.getString("ccnum"));
                
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return payment;
    }
     
     public ArrayList<Payment> getRecord(String searchStr, int option)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE paymentID = ?";
        Payment payment = null;
        
        switch(option){
            case 0: queryStr= "SELECT * FROM "+ tableName ;
            break;
            case 1: queryStr= "SELECT * FROM "+ tableName +" WHERE petID = ?";
            break;
            case 2: queryStr="SELECT * FROM "+ tableName +" WHERE LOWER(staffname)  LIKE LOWER('%' || ? || '%')";
            break;
            case 3: queryStr="SELECT * FROM "+ tableName +" WHERE LOWER(staffposition)  = LOWER(?) ";
            break;
        }
        
        ArrayList<Payment> paymentList = new ArrayList<Payment>();
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,searchStr);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                payment = new Payment(searchStr,rs.getDouble("amountpaid"),rs.getString("methodofpayment"),rs.getDate("paymentdate"),new Transaction(),new Staff(),new CreditCard());
                payment.getTransaction().setTransID(rs.getString("transid"));
                payment.getStaff().setStaffIC(rs.getString("staffic"));
                payment.getCc().setCcNum(rs.getString("ccnum"));
                
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return paymentList;
    }
     
     public void deleteRecord(String paymentID)
    {
        try
        {
            String deleStr = "DELETE FROM " + tableName + " WHERE paymentid = ?";
            
            stmt = conn.prepareStatement(deleStr);
            stmt.setString(1, paymentID);
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
