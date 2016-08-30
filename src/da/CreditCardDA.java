
package da;

import domain.CreditCard;
import domain.Customer;
import java.sql.*;
import javax.swing.*;

public class CreditCardDA {
    
    private String host = "jdbc:derby://localhost:1527/vetdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "CreditCard";
    
    private Connection conn;
    private PreparedStatement stmt;
    
    public CreditCardDA()
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
    
    public void addRecord(CreditCard cc)
    {
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?)";
        try
        {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, cc.getCcNum());
            stmt.setDate(2, convertJavaDateToSqlDate(cc.getCcExpiryDate()));
            stmt.setString(3, cc.getIssuingAgent());
            stmt.setString(4, cc.getCvc());
            stmt.setString(5, cc.getCardHolderName());
            stmt.setString(6, cc.getCardName());
            stmt.setString(7, cc.getCustomer().getCustIC());
            
            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(CreditCard cc)
    {
        String updateStr = "UPDATE " + tableName + " SET ccNum = ?, ccExpiryDate = ?, issuingagent = ?, cvc = ?, cardholdername = ?, cardname = ?, custic = ? "+" WHERE ccnum = ? ";
        try
        {
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, cc.getCcNum());
            stmt.setDate(2, convertJavaDateToSqlDate(cc.getCcExpiryDate()));
            stmt.setString(3, cc.getIssuingAgent());
            stmt.setString(4, cc.getCvc());
            stmt.setString(5, cc.getCardHolderName());
            stmt.setString(6, cc.getCardName());
            stmt.setString(7, cc.getCustomer().getCustIC());
            stmt.setString(7, cc.getCcNum());
            
            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public CreditCard getRecord(String ccNum)
    {
        String queryStr="SELECT * FROM "+ tableName +" WHERE ccNum = ?";
        CreditCard creditcard = null;
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,ccNum);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                creditcard = new CreditCard(ccNum,rs.getDate("ccExpiryDate"),rs.getString("issuingagent"),rs.getString("cvc"),rs.getString("cardholdername"),rs.getString("cardname"),new Customer()); 
                creditcard.getCustomer().setCustIC(rs.getString("custic"));
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return creditcard;
    }
    
    public void deleteRecord(String ccNum)
    {
        try
        {
            String deleStr = "DELETE FROM " + tableName + " WHERE ccNum = ?";
            
            stmt = conn.prepareStatement(deleStr);
            stmt.setString(1, ccNum);
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
