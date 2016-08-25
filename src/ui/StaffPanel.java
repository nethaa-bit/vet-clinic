/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import javax.swing.*;
import control.MaintainStaff;
import domain.*;
import java.awt.Container;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import javax.swing.table.DefaultTableModel;


public class StaffPanel extends javax.swing.JPanel {
    
    MaintainStaff staffControl; //***
    ArrayList<Staff> staffList;

    /**
     * Creates new form StaffFrame
     */



    public StaffPanel() {
        
        initComponents();
        staffControl = new MaintainStaff(); // *** 
        jlblCross.setVisible(false);
        jlblCheck.setVisible(false);
        jtfSearch.setOpaque(false);
        jtfSearch.setBackground(new Color(255,255,255,127));
        jtfSearch.setBorder(null);
        setDynamicPanel();
        
        
    }
    
    public void setDynamicPanel() {
        JPanel targetPanel = new JPanel();
        if(MainMenu.action.equals("add")){
             targetPanel=jpAddUpdate;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(false);
             jbtAdd.setVisible(true);
 
        }
        else if (MainMenu.action.equals("search")){
            targetPanel=jpSearch;
            jbtDeleteStaff.setVisible(false);
            jbtModifyStaff.setVisible(false);


        }else if(MainMenu.action.equals("modifySelected")){
             targetPanel=jpAddUpdate;
             jbtConfirmChange.setVisible(true);
             jbtConfirmDelete.setVisible(false);
             jbtAdd.setVisible(false);
             jtfIc.setEnabled(false);
 
        
        }else if(MainMenu.action.equals("deleteSelected")){
             targetPanel=jpAddUpdate;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(true);
             jbtAdd.setVisible(false);

        }else if(MainMenu.action.equals("modify")){
                targetPanel=jpSearch;
                jbtDeleteStaff.setVisible(false);
                jbtModifyStaff.setVisible(true);
 
        }
        else if(MainMenu.action.equals("delete")){
                targetPanel=jpSearch;
                jbtDeleteStaff.setVisible(true);
                jbtModifyStaff.setVisible(false);

        }
        
        dynamicPanel.removeAll();
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
            
        //Adding Pannel
        dynamicPanel.add(targetPanel);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }
    
    public Staff validateInput(){
        
        //Declare domain object
        Staff staff;
        String passwordhash=""; //no need
        boolean valid =true; //need
        
        //get value from input
        String ic=jtfIc.getText();
        String name = jtfName.getText();
        String postcode = jtfPostCode.getText();
        String door = jtfDoor.getText();
        String neighbour = jtfNeighbour.getText();
        String city = jtfCity.getText();
        String state = jtfState.getText();
        String password =String.copyValueOf(jtfPassword.getPassword());
        String phone = jtfPhoneNum.getText();
        
        //validate all input
        valid = password.equals(jtfConfirmPass.getText())?true:false; //no need
        valid = name.equals(null)?false:true; //need
        valid = door.equals(null)?false:true;
        valid = city.equals(null)?false:true;
        valid = state.equals(null)?false:true;
        try{passwordhash = PasswordHash.createHash(password);}catch(Exception ex){valid=false;} //no need 
        if(!Pattern.matches("\\d{12}", ic)){valid =false;} // need f got ic
        if(!Pattern.matches("\\d{2,4}-\\d{7,8}", phone)){valid =false;} //need if got phone number
        if(!Pattern.matches("\\d{5}", postcode)){valid =false;} //need if got postacode 
        
        //comment if need validations
  
        //Prepare answer string no need
        String question = (String)jcbQuestion.getSelectedItem();
        String answer = jtfAnswer.getText();
        switch(question){
             case "What is your first pet's name?"  : 
                answer="p"+answer;
                break;
             case "What is your favourite colour?"  : 
                answer="c"+answer;
                break;
             case "Where is your hometown?"         :
                 answer="h"+answer;
                break;
         }       
        
        
        
        //If all fields are valid, write to Staff Object
         if(valid==true){
           String fulladdress = ""+door+"_"+neighbour+"_"+postcode+"_"+city+"_"+state; // for cudstomer only 
           // take object domain constructor and initialiue (pass value) 
           if(jtfPassword.isEnabled()){
               staff = new Staff(ic,name,fulladdress,phone,(String)jcbPosition.getSelectedItem(),(String)jcbQualification.getSelectedItem(),passwordhash,answer);
           }
           else{
                staff = new Staff(ic,name,fulladdress,phone,(String)jcbPosition.getSelectedItem(),(String)jcbQualification.getSelectedItem());
           }
         }
         else {
             staff=null;
         }
         
         return staff;
    }
    public void resetFields(){
        jtfAnswer.setText("");
        jtfCity.setText("");
        jtfConfirmPass.setText("");
        jtfDoor.setText("");
        jtfIc.setText("");
        jtfName.setText("");
        jtfNeighbour.setText("");
        jtfPassword.setText("");
        jtfPhoneNum.setText("");
        jtfPostCode.setText("");
        jtfSearch.setText("");
        jtfState.setText("");
    }
    public void fillFields(Staff staff){
        
        jtfAnswer.setText("");
        jtfConfirmPass.setText("");
        jtfPassword.setText("");
        jtfAnswer.setEnabled(false);
        jtfConfirmPass.setEnabled(false);
        jtfPassword.setEnabled(false);
        jcbQuestion.setEnabled(false);
        
        jtfIc.setText(staff.getStaffIC());
        jtfName.setText(staff.getStaffName());
        jtfPhoneNum.setText(staff.getStaffPhone());
        
        HashMap<String, String> addressMap = reformatAddress(staff.getStaffAddress());
        jtfDoor.setText(addressMap.get("Door"));
        jtfNeighbour.setText(addressMap.get("Neighbourhood"));
        jtfPostCode.setText(addressMap.get("Postcode"));        
        jtfCity.setText(addressMap.get("City"));
        jtfState.setText(addressMap.get("State"));
        
        jcbPosition.setSelectedItem(staff.getStaffPosition());
        jcbQualification.setSelectedItem(staff.getStaffQualification());
    
    }
    public void disableFields(){
        jtfAnswer.setEnabled(false);
        jtfCity.setEnabled(false);
        jtfConfirmPass.setEnabled(false);
        jtfDoor.setEnabled(false);
        jtfIc.setEnabled(false);
        jtfName.setEnabled(false);
        jtfNeighbour.setEnabled(false);
        jtfPassword.setEnabled(false);
        jtfPhoneNum.setEnabled(false);
        jtfPostCode.setEnabled(false);
        jtfSearch.setEnabled(false);
        jtfState.setEnabled(false);
        jcbPosition.setEnabled(false);
        jcbQualification.setEnabled(false);
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
  
    public boolean isPosition (String s){
        boolean valid=false;
        String[] positionList= {"Senior Veterinerian","Veterinerian","Receptionist","Laboratory Technician","Medical Assistant","Clerk","General Staff","Manager"};
        
        for (String str : positionList){
            if (str.equalsIgnoreCase(s)){
                valid=true;
            }
        }
        return valid;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jlblSearch = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jlblStaff = new javax.swing.JLabel();
        dynamicPanel = new javax.swing.JPanel();
        jpAddUpdate = new javax.swing.JPanel();
        jlblIC = new javax.swing.JLabel();
        jlblName = new javax.swing.JLabel();
        jlblDoor = new javax.swing.JLabel();
        jlblNeighbour = new javax.swing.JLabel();
        jlblPostCode = new javax.swing.JLabel();
        jlblCity = new javax.swing.JLabel();
        jlblState = new javax.swing.JLabel();
        jlblPhoneNum = new javax.swing.JLabel();
        jlblPosition = new javax.swing.JLabel();
        jlblQualification = new javax.swing.JLabel();
        jcbQualification = new javax.swing.JComboBox<>();
        jcbPosition = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jlblPass = new javax.swing.JLabel();
        jlblConfirmPass = new javax.swing.JLabel();
        jlblQues = new javax.swing.JLabel();
        jcbQuestion = new javax.swing.JComboBox<>();
        jlblAns = new javax.swing.JLabel();
        jtfAnswer = new javax.swing.JTextField();
        jlblCheck = new javax.swing.JLabel();
        jlblCross = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JPasswordField();
        jtfConfirmPass = new javax.swing.JPasswordField();
        jtfName = new javax.swing.JTextField();
        jtfDoor = new javax.swing.JTextField();
        jtfPostCode = new javax.swing.JTextField();
        jtfState = new javax.swing.JTextField();
        jtfNeighbour = new javax.swing.JTextField();
        jtfPhoneNum = new javax.swing.JTextField();
        jtfIc = new javax.swing.JTextField();
        jtfCity = new javax.swing.JTextField();
        jbtAdd = new javax.swing.JButton();
        jbtConfirmDelete = new javax.swing.JButton();
        jbtConfirmChange = new javax.swing.JButton();
        jpSearch = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtStaff = new javax.swing.JTable();
        jbtModifyStaff = new javax.swing.JButton();
        jbtDeleteStaff = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(202, 233, 239));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jlblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSearchMouseClicked(evt);
            }
        });
        jPanel2.add(jlblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        jtfSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 260, 30));

        jlblStaff.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlblStaff.setText("Staff");
        jPanel2.add(jlblStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 40, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 80));

        dynamicPanel.setLayout(new java.awt.CardLayout());

        jpAddUpdate.setBackground(new java.awt.Color(202, 233, 239));
        jpAddUpdate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblIC.setText("NRIC :");
        jpAddUpdate.add(jlblIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        jlblName.setText("Name :");
        jpAddUpdate.add(jlblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jlblDoor.setText("Door & Street :");
        jpAddUpdate.add(jlblDoor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jlblNeighbour.setText("Neighbourhood :");
        jpAddUpdate.add(jlblNeighbour, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        jlblPostCode.setText("Postal Code:");
        jpAddUpdate.add(jlblPostCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jlblCity.setText("City :");
        jpAddUpdate.add(jlblCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jlblState.setText("State :");
        jpAddUpdate.add(jlblState, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jlblPhoneNum.setText("Phone Number :");
        jpAddUpdate.add(jlblPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        jlblPosition.setText("Staff Position : ");
        jpAddUpdate.add(jlblPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jlblQualification.setText("Staff Qualification :");
        jpAddUpdate.add(jlblQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jcbQualification.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PMR", "SPM", "Diploma", "Advanced Diploma", "Bachelor's Degree", "Graduate Diploma", "Masters Degree", "PhD" }));
        jpAddUpdate.add(jcbQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        jcbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senior Veterinerian", "Veterinerian", "Receptionist", "Laboratory Technician ", "Medical Assistant", "Clerk", "General Staff", "Manager" }));
        jpAddUpdate.add(jcbPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        jPanel1.setBackground(new java.awt.Color(202, 233, 239));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblPass.setText("Password :");
        jPanel1.add(jlblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 21, -1, -1));

        jlblConfirmPass.setText("Confirm Password :");
        jPanel1.add(jlblConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jlblQues.setText("Security Question :");
        jPanel1.add(jlblQues, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 69, -1, -1));

        jcbQuestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your first pet's name?", "What is your favourite colour?", "Where is your hometown?" }));
        jcbQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbQuestionMouseClicked(evt);
            }
        });
        jPanel1.add(jcbQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 66, -1, -1));

        jlblAns.setText("Security Answer :");
        jPanel1.add(jlblAns, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        jtfAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfAnswerMouseClicked(evt);
            }
        });
        jPanel1.add(jtfAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 120, -1));

        jlblCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checkmark.png"))); // NOI18N
        jlblCheck.setToolTipText("Passwords match!");
        jPanel1.add(jlblCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 20, 20));

        jlblCross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/crossmark.png"))); // NOI18N
        jlblCross.setToolTipText("Passwords do not match!");
        jPanel1.add(jlblCross, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 20, 20));

        jtfPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfPasswordMouseClicked(evt);
            }
        });
        jtfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPasswordKeyReleased(evt);
            }
        });
        jPanel1.add(jtfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 120, -1));

        jtfConfirmPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfConfirmPassMouseClicked(evt);
            }
        });
        jtfConfirmPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfConfirmPassActionPerformed(evt);
            }
        });
        jtfConfirmPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfConfirmPassKeyReleased(evt);
            }
        });
        jPanel1.add(jtfConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 120, -1));

        jpAddUpdate.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 234, 680, 100));
        jpAddUpdate.add(jtfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 120, -1));
        jpAddUpdate.add(jtfDoor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 180, -1));
        jpAddUpdate.add(jtfPostCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 90, -1));
        jpAddUpdate.add(jtfState, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 120, -1));
        jpAddUpdate.add(jtfNeighbour, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 120, -1));
        jpAddUpdate.add(jtfPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 110, -1));
        jpAddUpdate.add(jtfIc, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 120, -1));
        jpAddUpdate.add(jtfCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 110, -1));

        jbtAdd.setText("Add Staff");
        jbtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddActionPerformed(evt);
            }
        });
        jpAddUpdate.add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        jbtConfirmDelete.setText("Delete");
        jbtConfirmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmDeleteActionPerformed(evt);
            }
        });
        jpAddUpdate.add(jbtConfirmDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, -1, -1));

        jbtConfirmChange.setText("OK");
        jbtConfirmChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmChangeActionPerformed(evt);
            }
        });
        jpAddUpdate.add(jbtConfirmChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, -1, -1));

        dynamicPanel.add(jpAddUpdate, "card3");

        jpSearch.setBackground(new java.awt.Color(202, 233, 239));
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtStaff.setAutoCreateColumnsFromModel(false);
        jtStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtStaff.setColumnSelectionAllowed(true);
        jtStaff.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtStaff);
        jtStaff.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jpSearch.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 620, 270));

        jbtModifyStaff.setText("Modify Staff");
        jbtModifyStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModifyStaffActionPerformed(evt);
            }
        });
        jpSearch.add(jbtModifyStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        jbtDeleteStaff.setText("Delete Staff");
        jbtDeleteStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteStaffActionPerformed(evt);
            }
        });
        jpSearch.add(jbtDeleteStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        dynamicPanel.add(jpSearch, "card2");

        add(dynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 77, 930, 530));
    }// </editor-fold>//GEN-END:initComponents

    
    //copy whole change accodingly
    private void jlblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSearchMouseClicked
        // TODO add your handling code here:
        //I used all my 洪荒之力 to make this method 
        if(MainMenu.action == "modifySelected"){
            MainMenu.action="modify";
        }
        else if(MainMenu.action == "deleteSelected"){
            MainMenu.action="delete";
        }else if(MainMenu.action == "add"){
               MainMenu.action="search";
        }
//        MainMenu.action="search";
        setDynamicPanel();
        
        jtStaff.setModel(new DefaultTableModel());
        jtStaff.repaint();
        String queryStr =jtfSearch.getText();
        if(!queryStr.equals("")){
        int option =0;
        

            if(Pattern.matches("\\d{12}", queryStr)){
                option=1;
            }
            else if(isPosition(queryStr)){
                option=3;
            }
            else{
                option=2;
            }
            staffList = staffControl.searchRecord(queryStr,option);
            if(staffList.size()!=0&&staffList!=null){
                Object[][] data = new Object[100][8];             
                for(int i=0; i<staffList.size();i++){
                data[i] = staffList.get(i).getObjects();
                } 
                String[] columnNames = {"Staff IC","Name","Address","Phone No","Position","Qualification"};
                TableModel tModel = new TableModel(data, columnNames);
                jtStaff.setModel(tModel);  
                jtStaff.createDefaultColumnsFromModel();
                jtStaff.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "No results found!" , "No such record.", JOptionPane.ERROR_MESSAGE);
            }   
            
        }
    }//GEN-LAST:event_jlblSearchMouseClicked

    private void jbtModifyStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModifyStaffActionPerformed
        // TODO add your handling code here:
        MainMenu.action="modifySelected";
       Staff selectedStaff=null;
       if(jtStaff.getSelectedRow()>=0 ) {
           String ic  = (String) jtStaff.getValueAt(jtStaff.getSelectedRow(),0);
           selectedStaff = staffControl.searchRecord(ic);
           if(selectedStaff!=null){
                setDynamicPanel();
                fillFields(selectedStaff);
           }
           else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtModifyStaffActionPerformed

    private void jbtDeleteStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteStaffActionPerformed
        // TODO add your handling code here:
        MainMenu.action="deleteSelected";
       Staff selectedStaff=null;
       if(jtStaff.getSelectedRow()>=0 ) {
           String ic  = (String) jtStaff.getValueAt(jtStaff.getSelectedRow(),0);
           selectedStaff = staffControl.searchRecord(ic);
           if(selectedStaff!=null){
                setDynamicPanel();
                fillFields(selectedStaff);
                disableFields();
           }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtDeleteStaffActionPerformed

    private void jcbQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbQuestionMouseClicked
        // TODO add your handling code here:
        jtfPasswordMouseClicked(evt);
    }//GEN-LAST:event_jcbQuestionMouseClicked

    private void jtfAnswerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfAnswerMouseClicked
        // TODO add your handling code here:
         jtfPasswordMouseClicked(evt);
    }//GEN-LAST:event_jtfAnswerMouseClicked

    private void jbtConfirmChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmChangeActionPerformed
        // TODO add your handling code here:
        Staff staff = validateInput();
        if(staff!=null){
         //write to database ****
                Staff s = staffControl.searchRecord(staff.getStaffIC());
                
                if(s == null)
                {
                    JOptionPane.showMessageDialog(null,"This staff does not exist.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    s = staff;
                    int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Are you sure you want commit the changes made?", "Confirm changes?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
                    if(reply==JOptionPane.YES_OPTION){
                        try{
                            staffControl.updateRecord(s);
                            resetFields();
                            JOptionPane.showMessageDialog(null,"Staff details of staff "+ staff.getStaffIC()+" has been updated.","Success",JOptionPane.INFORMATION_MESSAGE);
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
        Staff staff = validateInput();
        if(staff!=null){
            Staff s = staffControl.searchRecord(staff.getStaffIC());

            if(s == null)
            {
                JOptionPane.showMessageDialog(null,"This staff does not exist.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                s = staff;
                int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Are you sure you want delete staff "+staff.getStaffIC()+" ?", "Confirm delete?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

                if(reply==JOptionPane.YES_OPTION){
                    try{
                        staffControl.deleteRecord(s.getStaffIC());
                        resetFields();
                        JOptionPane.showMessageDialog(null,"Staff "+ staff.getStaffIC()+" has been deleted.","Success",JOptionPane.INFORMATION_MESSAGE);
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

    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddActionPerformed
        // TODO add your handling code here:
                Staff staff = validateInput();
        if(staff!=null){
         //write to database ****
                Staff s = staffControl.searchRecord(staff.getStaffIC());
                
                if(s != null)
                {
                    JOptionPane.showMessageDialog(null,"This staff already exist.", "Duplicate Record", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    s = staff;
                    try{
                    staffControl.addRecord(s);
                    resetFields();
                    JOptionPane.showMessageDialog(null,"New staff is created.","Success",JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Failure",JOptionPane.ERROR_MESSAGE);
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
    }//GEN-LAST:event_jbtAddActionPerformed

    private void jtfPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPasswordKeyReleased
        // TODO add your handling code here:
         if(String.copyValueOf(jtfPassword.getPassword())==null){
            jlblCross.setVisible(false);
            jlblCheck.setVisible(false);
        }
        else if(String.copyValueOf(jtfPassword.getPassword()).equals(String.copyValueOf(jtfConfirmPass.getPassword()))){
            jlblCross.setVisible(false);
            jlblCheck.setVisible(true);
        }
        else{
            jlblCross.setVisible(true);
            jlblCheck.setVisible(false);
        }
    }//GEN-LAST:event_jtfPasswordKeyReleased

    private void jtfPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfPasswordMouseClicked
        // TODO add your handling code here:
        if(!jtfPassword.isEnabled()){
            JOptionPane.showMessageDialog(null,"<html><center>The option to set password and security question and answer are currently disabled.<br>To change your password and/or security question and answer, <br>please use the <b>Change Password</b> submodule under the <b>Security menu</b>.</center></html>", "Fields Disabled", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jtfPasswordMouseClicked

    private void jtfConfirmPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfConfirmPassKeyReleased
        // TODO add your handling code here:
         if(String.copyValueOf(jtfPassword.getPassword())==null){
            jlblCross.setVisible(false);
            jlblCheck.setVisible(false);
        }
        else if(String.copyValueOf(jtfPassword.getPassword()).equals(String.copyValueOf(jtfConfirmPass.getPassword()))){
            jlblCross.setVisible(false);
            jlblCheck.setVisible(true);
        }
        else{
            jlblCross.setVisible(true);
            jlblCheck.setVisible(false);
        }
    }//GEN-LAST:event_jtfConfirmPassKeyReleased

    private void jtfConfirmPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfConfirmPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfConfirmPassActionPerformed

    private void jtfConfirmPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfConfirmPassMouseClicked
        // TODO add your handling code here:
                jtfPasswordMouseClicked(evt);
    }//GEN-LAST:event_jtfConfirmPassMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAdd;
    private javax.swing.JButton jbtConfirmChange;
    private javax.swing.JButton jbtConfirmDelete;
    private javax.swing.JButton jbtDeleteStaff;
    private javax.swing.JButton jbtModifyStaff;
    private javax.swing.JComboBox<String> jcbPosition;
    private javax.swing.JComboBox<String> jcbQualification;
    private javax.swing.JComboBox<String> jcbQuestion;
    private javax.swing.JLabel jlblAns;
    private javax.swing.JLabel jlblCheck;
    private javax.swing.JLabel jlblCity;
    private javax.swing.JLabel jlblConfirmPass;
    private javax.swing.JLabel jlblCross;
    private javax.swing.JLabel jlblDoor;
    private javax.swing.JLabel jlblIC;
    private javax.swing.JLabel jlblName;
    private javax.swing.JLabel jlblNeighbour;
    private javax.swing.JLabel jlblPass;
    private javax.swing.JLabel jlblPhoneNum;
    private javax.swing.JLabel jlblPosition;
    private javax.swing.JLabel jlblPostCode;
    private javax.swing.JLabel jlblQualification;
    private javax.swing.JLabel jlblQues;
    private javax.swing.JLabel jlblSearch;
    private javax.swing.JLabel jlblStaff;
    private javax.swing.JLabel jlblState;
    private javax.swing.JPanel jpAddUpdate;
    private javax.swing.JPanel jpSearch;
    private javax.swing.JTable jtStaff;
    private javax.swing.JTextField jtfAnswer;
    private javax.swing.JTextField jtfCity;
    private javax.swing.JPasswordField jtfConfirmPass;
    private javax.swing.JTextField jtfDoor;
    private javax.swing.JTextField jtfIc;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfNeighbour;
    private javax.swing.JPasswordField jtfPassword;
    private javax.swing.JTextField jtfPhoneNum;
    private javax.swing.JTextField jtfPostCode;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfState;
    // End of variables declaration//GEN-END:variables
}
