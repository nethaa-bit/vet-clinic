/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import control.MaintainCustomer;
import control.MaintainPet;
import domain.Customer;
import domain.Pet;
import domain.TableModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lysan
 */
public class CustomerPanel extends javax.swing.JPanel {

    MaintainCustomer customerControl;
    MaintainPet petControl;
    
    /**
     * Creates new form CustomerPanel
     */
     public void setDynamicPanel() {
        JPanel targetPanel = new JPanel();
        if(MainMenu.action.equals("add")||MainMenu.action.equals("modify")||MainMenu.action.equals("delete")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(false);
             jbtAddCus.setVisible(true);
        }
        else if (MainMenu.action.equals("search")){
            targetPanel=jpSearch;
        }
        else if(MainMenu.action.equals("modifySelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(true);
             jbtConfirmDelete.setVisible(false);
             jbtAddCus.setVisible(false);
        
        }else if(MainMenu.action.equals("deleteSelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(true);
             jbtAddCus.setVisible(false);
        }
        
        dynamicPanel.removeAll();
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
            
        //Adding Pannel
        dynamicPanel.add(targetPanel);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }
     
      public void fillFields(Customer customer){
      
        jtfIc.setText(customer.getCustIC());
        jtfName.setText(customer.getCustName());
        jtfPhoneNum.setText(customer.getCustPhoneNum());
        jcbGender.setSelectedItem(customer.getCustGender());
          
        
        HashMap<String, String> addressMap = reformatAddress(customer.getCustAddress());
        jtfDoor.setText(addressMap.get("Door"));
        jtfNeighbour.setText(addressMap.get("Neighbourhood"));
        jtfPostCode.setText(addressMap.get("Postcode"));        
        jtfCity.setText(addressMap.get("City"));
        jtfState.setText(addressMap.get("State"));
       
      }
      
      public void disableFields(){
        jtfCity.setEnabled(false);
        jtfDoor.setEnabled(false);
        jtfIc.setEnabled(false);
        jtfName.setEnabled(false);
        jtfNeighbour.setEnabled(false);
        jtfPhoneNum.setEnabled(false);
        jtfPostCode.setEnabled(false);
        jtfSearch.setEnabled(false);
        jtfState.setEnabled(false);
        jcbGender.setEnabled(false);
      }
      
      public HashMap reformatAddress(String fulladdress){
       HashMap<String, String> addressMap = new HashMap<String, String>();
       String[] address = fulladdress.split("_");
       addressMap.put("Door", address[0]);
       addressMap.put("Neighbourhood", address[1]);
       addressMap.put("Postcode", address[2]);
       addressMap.put("City", address[3]);
       addressMap.put("State", address[4]);
       
       return addressMap;
    }
    
    public CustomerPanel() {
        initComponents();
        customerControl = new MaintainCustomer();
        petControl = new MaintainPet();
        jtfSearch.setOpaque(false);
        jtfSearch.setBackground(new Color(255,255,255,127));
        jtfSearch.setBorder(null);
        setDynamicPanel();
    }
    
    public Customer validateInput(){
    
    Customer customer;
    boolean valid =true;
    
    
    String city = jtfCity.getText();
    String door = jtfDoor.getText();
    String ic = jtfIc.getText();
    String name = jtfName.getText();
    String neighbour = jtfNeighbour.getText();
    String phoneNum = jtfPhoneNum.getText();
    String postCode = jtfPostCode.getText();
    String search = jtfSearch.getText();
    String state = jtfState.getText();
    char gender = ((String)jcbGender.getSelectedItem()).charAt(0);
    
    valid = name.equals(null)?false:true; //need
    valid = door.equals(null)?false:true;
    valid = city.equals(null)?false:true;
    valid = state.equals(null)?false:true;
    if(!Pattern.matches("\\d{12}", ic)){valid =false;} // need f got ic
    if(!Pattern.matches("\\d{2,4}-\\d{7,8}", phoneNum)){valid =false;} //need if got phone number
    if(!Pattern.matches("\\d{5}", postCode)){valid =false;} //need if got postacode 
    
    if(valid==true){
           String fulladdress = ""+door+"_"+neighbour+"_"+postCode+"_"+city+"_"+state; // for cudstomer only 
           // take object domain constructor and initialiue (pass value) 
           customer = new Customer(ic,name,gender,fulladdress,phoneNum);
         }
         else {
             customer=null;
         }
         
         return customer;
        
    
    }
    public void resetFields(){
        
    jtfCity.setText("");
    jtfDoor.setText("");
    jtfIc.setText("");
    jtfName.setText("");
    jtfNeighbour.setText("");
    jtfPhoneNum.setText("");
    jtfPostCode.setText("");
    jtfSearch.setText("");
    jtfState.setText("");
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlblSearch = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jlblCustomer = new javax.swing.JLabel();
        dynamicPanel = new javax.swing.JPanel();
        jpSearch = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCustomer = new javax.swing.JTable();
        jbtModifyCus = new javax.swing.JButton();
        jbtDeleteCus = new javax.swing.JButton();
        jbtViewPets = new javax.swing.JButton();
        jpAdd = new javax.swing.JPanel();
        jlblIc = new javax.swing.JLabel();
        jtfIc = new javax.swing.JTextField();
        jlblName = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jlblDoor = new javax.swing.JLabel();
        jtfState = new javax.swing.JTextField();
        jlblNeighbour = new javax.swing.JLabel();
        jlblPstCode = new javax.swing.JLabel();
        jtfDoor = new javax.swing.JTextField();
        jlblCity = new javax.swing.JLabel();
        jlblState = new javax.swing.JLabel();
        jtfPostCode = new javax.swing.JTextField();
        jtfCity = new javax.swing.JTextField();
        jtfNeighbour = new javax.swing.JTextField();
        jlblGender = new javax.swing.JLabel();
        jcbGender = new javax.swing.JComboBox<>();
        jlblPhoneNum = new javax.swing.JLabel();
        jtfPhoneNum = new javax.swing.JTextField();
        jbtAddCus = new javax.swing.JButton();
        jbtConfirmChange = new javax.swing.JButton();
        jbtConfirmDelete = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 229, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jlblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSearchMouseClicked(evt);
            }
        });
        jPanel2.add(jlblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });
        jPanel2.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 260, 30));

        jlblCustomer.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jlblCustomer.setText("Customer");
        jPanel2.add(jlblCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 110));

        dynamicPanel.setLayout(new java.awt.CardLayout());

        jpSearch.setBackground(new java.awt.Color(255, 229, 204));
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer IC", "Name", "Gender", "Address", "Phone Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtCustomer);

        jpSearch.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 630, 250));

        jbtModifyCus.setText("Modify Customer");
        jbtModifyCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtModifyCusMouseClicked(evt);
            }
        });
        jbtModifyCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModifyCusActionPerformed(evt);
            }
        });
        jpSearch.add(jbtModifyCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        jbtDeleteCus.setText("Delete Customer");
        jbtDeleteCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDeleteCusMouseClicked(evt);
            }
        });
        jbtDeleteCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteCusActionPerformed(evt);
            }
        });
        jpSearch.add(jbtDeleteCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, -1, -1));

        jbtViewPets.setText("View Pets");
        jbtViewPets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewPetsActionPerformed(evt);
            }
        });
        jpSearch.add(jbtViewPets, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, -1, -1));

        dynamicPanel.add(jpSearch, "card2");

        jpAdd.setBackground(new java.awt.Color(255, 229, 204));
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblIc.setText("NRIC :");
        jpAdd.add(jlblIc, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        jtfIc.setToolTipText("Enter your IC");
        jpAdd.add(jtfIc, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 122, -1));

        jlblName.setText("Name :");
        jpAdd.add(jlblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 29, -1, -1));

        jtfName.setToolTipText("Enter your name");
        jtfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNameActionPerformed(evt);
            }
        });
        jpAdd.add(jtfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 117, -1));

        jlblDoor.setText("Door & Street :");
        jpAdd.add(jlblDoor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jtfState.setToolTipText("Enter state");
        jpAdd.add(jtfState, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 80, -1));

        jlblNeighbour.setText("Neighbourhood :");
        jpAdd.add(jlblNeighbour, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, -1));

        jlblPstCode.setText("Postal Code :");
        jpAdd.add(jlblPstCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jtfDoor.setToolTipText("Enter address");
        jtfDoor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDoorActionPerformed(evt);
            }
        });
        jpAdd.add(jtfDoor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 130, -1));

        jlblCity.setText("City :");
        jpAdd.add(jlblCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jlblState.setText("State :");
        jpAdd.add(jlblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jtfPostCode.setToolTipText("Enter postal code");
        jtfPostCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPostCodeActionPerformed(evt);
            }
        });
        jpAdd.add(jtfPostCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 80, -1));

        jtfCity.setToolTipText("Enter city");
        jtfCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCityActionPerformed(evt);
            }
        });
        jpAdd.add(jtfCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 90, -1));

        jtfNeighbour.setToolTipText("Enter address");
        jtfNeighbour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNeighbourActionPerformed(evt);
            }
        });
        jpAdd.add(jtfNeighbour, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 120, -1));

        jlblGender.setText("Gender :");
        jpAdd.add(jlblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jcbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jpAdd.add(jcbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jlblPhoneNum.setText("Phone No. :");
        jpAdd.add(jlblPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        jtfPhoneNum.setToolTipText("Example: 01012345678");
        jtfPhoneNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPhoneNumActionPerformed(evt);
            }
        });
        jpAdd.add(jtfPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 110, -1));

        jbtAddCus.setText("Add Customer");
        jbtAddCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAddCusMouseClicked(evt);
            }
        });
        jbtAddCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddCusActionPerformed(evt);
            }
        });
        jpAdd.add(jbtAddCus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        jbtConfirmChange.setText("Confirm Changes");
        jbtConfirmChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmChangeActionPerformed(evt);
            }
        });
        jpAdd.add(jbtConfirmChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

        jbtConfirmDelete.setText("Confirm Delete");
        jbtConfirmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmDeleteActionPerformed(evt);
            }
        });
        jpAdd.add(jbtConfirmDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        dynamicPanel.add(jpAdd, "card3");

        jPanel1.add(dynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 103, 1010, 450));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 1010, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNameActionPerformed

    private void jtfPhoneNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPhoneNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPhoneNumActionPerformed

    private void jtfDoorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDoorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDoorActionPerformed

    private void jtfNeighbourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNeighbourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNeighbourActionPerformed

    private void jtfCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCityActionPerformed

    private void jtfPostCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPostCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPostCodeActionPerformed

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSearchActionPerformed

    private void jbtModifyCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModifyCusActionPerformed
        // TODO add your handling code here:
        MainMenu.action="modifySelected";
       Customer selectedCustomer=null;
       if(jtCustomer.getSelectedRow()>=0 ) {
           String id  = (String) jtCustomer.getValueAt(jtCustomer.getSelectedRow(),0);
           selectedCustomer = customerControl.searchRecord(id);
           if(selectedCustomer!=null){
                setDynamicPanel();
                fillFields(selectedCustomer);
           }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtModifyCusActionPerformed

    private void jbtDeleteCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteCusActionPerformed
        // TODO add your handling code here:
          MainMenu.action="deleteSelected";
       Customer selectedCustomer=null;
       if(jtCustomer.getSelectedRow()>=0 ) {
           String ic  = (String) jtCustomer.getValueAt(jtCustomer.getSelectedRow(),0);
           selectedCustomer = customerControl.searchRecord(ic);
           if(selectedCustomer!=null){
                setDynamicPanel();
                fillFields(selectedCustomer);
                disableFields();
                
           }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtDeleteCusActionPerformed

    private void jbtAddCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddCusMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jbtAddCusMouseClicked

    private void jlblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSearchMouseClicked
        // TODO add your handling code here:
        //I used all my 洪荒之力 to make this method 

        jtCustomer.setModel(new DefaultTableModel());
        jtCustomer.repaint();
        String queryStr =jtfSearch.getText();
        int option =0;
        

            if(Pattern.matches("\\d{12}", queryStr)){
                option=1;
            }
           
            else if(Pattern.matches("\\d{2,4}-\\d{7,8}", queryStr)){
                option=2;
            }
            else{
                option=3;
            }
            ArrayList<Customer> customerList = customerControl.searchRecord(queryStr,option);

            MainMenu.action="search";
            setDynamicPanel();
            if(customerList.size()!=0&&customerList!=null){
                Object[][] data = new Object[100][8];
                for(int i=0; i<customerList.size();i++){
                data[i] = customerList.get(i).getObjects();
                } 
                String[] columnNames = {"Customer IC","Name","Gender","Address","Phone Number"};
                TableModel tModel = new TableModel(data, columnNames);
                jtCustomer.setModel(tModel);  
                jtCustomer.createDefaultColumnsFromModel();
                jtCustomer.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "No results found!" , "No such record.", JOptionPane.ERROR_MESSAGE);
            }     
    }//GEN-LAST:event_jlblSearchMouseClicked

    private void jbtModifyCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtModifyCusMouseClicked
        // TODO add your handling code here:
       MainMenu.action="modifySelected";
       Customer selectedCustomer=null;
       if(jtCustomer.getSelectedRow()>=0 ) {
           String ic  = (String) jtCustomer.getValueAt(jtCustomer.getSelectedRow(),0);
           selectedCustomer = customerControl.searchRecord(ic);
           if(selectedCustomer!=null){
                setDynamicPanel();
                fillFields(selectedCustomer);
           }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }

    }//GEN-LAST:event_jbtModifyCusMouseClicked

    private void jbtDeleteCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDeleteCusMouseClicked
        // TODO add your handling code here:
       MainMenu.action="delete";
       Customer selectedCustomer=null;
       if(jtCustomer.getSelectedRow()>=0 ) {
           String ic  = (String) jtCustomer.getValueAt(jtCustomer.getSelectedRow(),0);
           selectedCustomer = customerControl.searchRecord(ic);
            
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to delete","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtDeleteCusMouseClicked

    private void jbtAddCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddCusActionPerformed
        // TODO add your handling code here:
        Customer customer = validateInput();
        if(customer!=null){
         //write to database
                         Customer c = customerControl.searchRecord(customer.getCustIC());
                
                if(c != null)
                {
                    JOptionPane.showMessageDialog(null,"This staff already exist.", "Duplicate Record", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    c = customer;
                    try{
                    customerControl.addRecord(c);
                    resetFields();
                    JOptionPane.showMessageDialog(null,"New customer is created.","Success",JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Failure",JOptionPane.ERROR_MESSAGE);
                    }
                }  
                
        }
        else{
            int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Your input seems to have data that is invalid or in incorrect format. Would you like to reset all fields?", "Invalid Data!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
            if(reply==JOptionPane.YES_OPTION){
                resetFields();
            }              
        }  
    }//GEN-LAST:event_jbtAddCusActionPerformed

    private void jbtConfirmChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmChangeActionPerformed
        // TODO add your handling code here:
        
                                                       
        // TODO add your handling code here:
        Customer customer = validateInput();
        if(customer!=null){
         //write to database ****
                Customer c = customerControl.searchRecord(customer.getCustIC());
                
                if(c == null)
                {
                    JOptionPane.showMessageDialog(null,"This customer does not exist.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    c = customer;
                    int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Are you sure you want commit the changes made?", "Confirm changes?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
                    if(reply==JOptionPane.YES_OPTION){
                        try{
                            customerControl.updateRecord(c);
                            resetFields();
                            JOptionPane.showMessageDialog(null,"Staff details of staff "+ customer.getCustIC()+" has been updated.","Success",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage(),"Failure",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                
                //---*****
        }
        else{
            //****
            int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Your input seems to have data that is invalid or in incorrect format. Would you like to reset all fields?", "Invalid Data!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
            if(reply==JOptionPane.YES_OPTION){
                resetFields();
            }
            //***
        }
    }//GEN-LAST:event_jbtConfirmChangeActionPerformed

    private void jbtConfirmDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmDeleteActionPerformed
        // TODO add your handling code here:
         Customer customer = validateInput();
        if(customer!=null){
            Customer c = customerControl.searchRecord(customer.getCustIC());

            if(c == null)
            {
                JOptionPane.showMessageDialog(null,"This customer does not exist.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                c = customer;
                int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Are you sure you want delete customer "+customer.getCustIC()+" ?", "Confirm delete?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

                if(reply==JOptionPane.YES_OPTION){
                    try{
                        customerControl.deleteRecord(c.getCustIC());
                        resetFields();
                        JOptionPane.showMessageDialog(null,"Customer "+ customer.getCustIC()+" has been deleted.","Success",JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Failure",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
                
        }
        else{
            //****
            int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Your input seems to have data that is invalid or in incorrect format. Would you like to reset all fields?", "Invalid Data!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
            if(reply==JOptionPane.YES_OPTION){
                resetFields();
            }
        }
    }//GEN-LAST:event_jbtConfirmDeleteActionPerformed

    private void jbtViewPetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewPetsActionPerformed
        // TODO add your handling code here:
       Customer selectedCustomer=null;
       if(jtCustomer.getSelectedRow()>=0 ) {
           String ic  = (String) jtCustomer.getValueAt(jtCustomer.getSelectedRow(),0);
           ArrayList<Pet> petList = petControl.searchRecord(ic, 2);
           if(petList.size()!=0&&petList!=null){
               ViewPetsDialog d = new ViewPetsDialog((java.awt.Frame)this.getParent().getParent().getParent().getParent().getParent().getParent(), true, petList);
               d.setVisible(true);     
           }
           else{
                JOptionPane.showMessageDialog(null, "No pets found!" , "Empty Record.", JOptionPane.ERROR_MESSAGE);
            }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to view","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtViewPetsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAddCus;
    private javax.swing.JButton jbtConfirmChange;
    private javax.swing.JButton jbtConfirmDelete;
    private javax.swing.JButton jbtDeleteCus;
    private javax.swing.JButton jbtModifyCus;
    private javax.swing.JButton jbtViewPets;
    private javax.swing.JComboBox<String> jcbGender;
    private javax.swing.JLabel jlblCity;
    private javax.swing.JLabel jlblCustomer;
    private javax.swing.JLabel jlblDoor;
    private javax.swing.JLabel jlblGender;
    private javax.swing.JLabel jlblIc;
    private javax.swing.JLabel jlblName;
    private javax.swing.JLabel jlblNeighbour;
    private javax.swing.JLabel jlblPhoneNum;
    private javax.swing.JLabel jlblPstCode;
    private javax.swing.JLabel jlblSearch;
    private javax.swing.JLabel jlblState;
    private javax.swing.JPanel jpAdd;
    private javax.swing.JPanel jpSearch;
    private javax.swing.JTable jtCustomer;
    private javax.swing.JTextField jtfCity;
    private javax.swing.JTextField jtfDoor;
    private javax.swing.JTextField jtfIc;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfNeighbour;
    private javax.swing.JTextField jtfPhoneNum;
    private javax.swing.JTextField jtfPostCode;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfState;
    // End of variables declaration//GEN-END:variables
}
