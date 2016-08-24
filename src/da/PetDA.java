/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import domain.Customer;
import domain.Pet;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class PetDA {
    
    private String host = "jdbc:derby://localhost:1527/vetdb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Pet";
    
    private Connection conn;
    private PreparedStatement stmt;
    
    public PetDA()
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
    
public void addRecord(Pet pet){
        String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        try
        {
            stmt = conn.prepareStatement(insertStr);
            stmt.setString(1, pet.getPetID());
            stmt.setString(2, pet.getPetName());
            stmt.setDouble(3, pet.getPetHeight());
            stmt.setDouble(4, pet.getPetWeight());
            stmt.setDouble(5, pet.getPetLength());
            stmt.setString(6, pet.getAnimalType());
            stmt.setString(7, pet.getBreed());
            stmt.setDate(8, convertJavaDateToSqlDate(pet.getPetDOB()));
            stmt.setString(9,String.valueOf(pet.getPetGender()));
            stmt.setString(10, pet.getCustomer().getCustIC());
            
            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
public void updateRecord(Pet pet){
        String updateStr = "UPDATE " + tableName + " SET petid = ?, petname = ?, petheight = ?, petweight = ?, petlength = ?, animaltype = ?, breed = ?, petbirthdate = ?, petgender = ?, custic = ? "+" WHERE petid = ? ";
        try
        {
            stmt = conn.prepareStatement(updateStr);
            stmt.setString(1, pet.getPetID());
            stmt.setString(2, pet.getPetName());
            stmt.setDouble(3, pet.getPetHeight());
            stmt.setDouble(4, pet.getPetWeight());
            stmt.setDouble(5, pet.getPetLength());
            stmt.setString(6, pet.getAnimalType());
            stmt.setString(7, pet.getBreed());
            stmt.setDate(8, convertJavaDateToSqlDate(pet.getPetDOB()));
            stmt.setString(9,String.valueOf(pet.getPetGender()));
            stmt.setString(10, pet.getCustomer().getCustIC());
            stmt.setString(11, pet.getPetID());

            stmt.executeUpdate();
   
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
public Pet getRecord(String petID){
        String queryStr="SELECT * FROM "+ tableName +" WHERE petID = ?";
        Pet pet = null;
        try
        {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,petID);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                pet = new Pet(petID,rs.getString("petname"),rs.getDouble("petheight"),rs.getDouble("petweight"),rs.getDouble("petlength"),rs.getString("animaltype"),rs.getString("breed"),rs.getDate("petbirthdate"),rs.getString("petgender").charAt(0),new Customer()); 
                pet.getCustomer().setCustIC(rs.getString("custic"));
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return pet;
    }
 
public ArrayList<Pet> getRecord(String searchStr, int option){
    
        String queryStr=null;
        Pet pet = null;
        switch(option){
            case 0: queryStr= "SELECT * FROM "+ tableName ;
            break;
            case 1: queryStr= "SELECT * FROM "+ tableName +" WHERE petID = ?";
            break;
            case 2: queryStr= "SELECT * FROM "+ tableName +" WHERE custIC = ?";
            break;
            case 3: queryStr="SELECT * FROM "+ tableName +" WHERE LOWER(petname)  LIKE LOWER('%' || ? || '%')";
            break;
        }

        
        ArrayList<Pet> petList = new ArrayList<Pet>();
        try
        {
            stmt = conn.prepareStatement(queryStr);
            if(option!=0){
            stmt.setString(1,searchStr);
            }
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {   
                Customer c = new Customer();
                c.setCustIC(rs.getString("custic"));
                petList.add(new Pet(rs.getString("petid"),rs.getString("petname"),rs.getDouble("petheight"),rs.getDouble("petweight"),rs.getDouble("petlength"),rs.getString("animaltype"),rs.getString("breed"),rs.getDate("petbirthdate"),rs.getString("petgender").charAt(0),c)); 
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return petList;
    }
          
public void deleteRecord(String petID)
    {
        try
        {
            String deleStr = "DELETE FROM " + tableName + " WHERE petid = ?";
            
            stmt = conn.prepareStatement(deleStr);
            stmt.setString(1, petID);
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
