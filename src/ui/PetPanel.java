/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import control.*;
import domain.*;
import java.awt.Color;
import java.util.*;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class PetPanel extends javax.swing.JPanel {

    
    MaintainPet petControl;
    MaintainCustomer customerControl;
    
    /**
     * Creates new form Pet
     */
    public PetPanel() {
        initComponents();
        petControl = new MaintainPet();
        customerControl = new MaintainCustomer();
        jtfSearch.setOpaque(false);
        jtfSearch.setBackground(new Color(255,255,255,127));
        jtfSearch.setBorder(null);        
        setDynamicPanel();
    }
    
    public Pet validateInput(){
    
    Pet pet;
    boolean valid =true; 
    
    String breed = jtfBreed.getText();
    Double height = Double.parseDouble(jtfHeight.getText());
    Double length = Double.parseDouble(jtfLength.getText());
    String owneric = jtfOwnerIc.getText();
    String petid = jtfPetId.getText();
    String petname = jtfPetName.getText();
    Double weight = Double.parseDouble(jtfWeight.getText());
    char gender = ((String)jcbGender.getSelectedItem()).charAt(0);
    Date birthdate = jdpBirthDate.getDate();
    
    valid = breed.equals(null)?false:true; //need
    valid = height.equals(null)?false:true;
    valid = length.equals(null)?false:true;
    valid = petid.equals(null)?false:true;
    valid = petname.equals(null)?false:true;
    valid = weight.equals(null)?false:true;
    if(!Pattern.matches("\\d{12}", owneric)){valid =false;} 
    
    if(valid==true){
        pet=null;
        try{ 
            Customer customer = customerControl.searchRecord(owneric);
            pet = new Pet(petid,petname,height,weight,length,(String)jcbType.getSelectedItem(),breed,birthdate,gender,customer);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }  
    }
    else {
             pet=null;
    }
         
         return pet;
    }
    
    public void resetFields(){
    
    jtfBreed.setText("");
    jtfHeight.setText("");
    jtfLength.setText("");
    jtfOwnerIc.setText("");
    jtfPetId.setText("");
    jtfPetName.setText("");
    jtfWeight.setText("");
    }
 
    public String generatePetId(){
        ArrayList<Pet> petList = petControl.searchRecord("", 0);
        
        //implement sorting 
        
        String idStr = petList.get(petList.size()-1).getPetID();
        int idNo = Integer.parseInt(idStr.split("A")[1])+1;
        
        return "A"+idNo;
    }
    public void setDynamicPanel() {
        JPanel targetPanel = new JPanel();
        jtfPetId.setEnabled(false);
        if(MainMenu.action.equals("add")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(false);
             jbtAddPet.setVisible(true);
             jtfPetId.setText(generatePetId());
        }
        else if (MainMenu.action.equals("search")){
            targetPanel=jpSearch;
            jbtDeletePet.setVisible(false);
            jbtModifyPet.setVisible(false);
        }
        else if(MainMenu.action.equals("modifySelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(true);
             jbtConfirmDelete.setVisible(false);
             jbtAddPet.setVisible(false);
        
        }else if(MainMenu.action.equals("deleteSelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(true);
             jbtAddPet.setVisible(false);
        }else if(MainMenu.action.equals("modify")){
                targetPanel=jpSearch;
                jbtDeletePet.setVisible(false);
                jbtModifyPet.setVisible(true);
        }
        else if(MainMenu.action.equals("delete")){
                targetPanel=jpSearch;
                jbtDeletePet.setVisible(true);
                jbtModifyPet.setVisible(false);
        }
        
        dynamicPanel.removeAll();
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
            
        //Adding Pannel
        dynamicPanel.add(targetPanel);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }
    
    public void fillFields(Pet pet){
    
    jtfBreed.setText(pet.getBreed());
    jtfHeight.setText("" + pet.getPetHeight());
    jtfLength.setText("" + pet.getPetLength());
    jtfOwnerIc.setText(pet.getCustomer().getCustIC());
    jtfPetId.setText(pet.getPetID());
    jtfPetName.setText(pet.getPetName());
    jtfWeight.setText("" + pet.getPetWeight());
    jcbGender.setSelectedItem(pet.getPetGender());
    jcbType.setSelectedItem(pet.getAnimalType());
    jdpBirthDate.setDate(pet.getPetDOB());
    
    // End of variables declaration            
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
        jlblPet = new javax.swing.JLabel();
        dynamicPanel = new javax.swing.JPanel();
        jpSearch = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPet = new javax.swing.JTable();
        jbtModifyPet = new javax.swing.JButton();
        jbtDeletePet = new javax.swing.JButton();
        jpAdd = new javax.swing.JPanel();
        jlblId = new javax.swing.JLabel();
        jtfPetId = new javax.swing.JTextField();
        jlblName = new javax.swing.JLabel();
        jtfPetName = new javax.swing.JTextField();
        jlblHeight = new javax.swing.JLabel();
        jlblWeight = new javax.swing.JLabel();
        jlblLength = new javax.swing.JLabel();
        jlblType = new javax.swing.JLabel();
        jlblBreed = new javax.swing.JLabel();
        jcbType = new javax.swing.JComboBox<>();
        jlblPBD = new javax.swing.JLabel();
        jlblGender = new javax.swing.JLabel();
        jlblOwnIc = new javax.swing.JLabel();
        jtfHeight = new javax.swing.JTextField();
        jtfLength = new javax.swing.JTextField();
        jtfBreed = new javax.swing.JTextField();
        jcbGender = new javax.swing.JComboBox<>();
        jtfWeight = new javax.swing.JTextField();
        jtfOwnerIc = new javax.swing.JTextField();
        jbtAddPet = new javax.swing.JButton();
        jdpBirthDate = new com.toedter.calendar.JDateChooser();
        jbtConfirmChange = new javax.swing.JButton();
        jbtConfirmDelete = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jlblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSearchMouseClicked(evt);
            }
        });
        jPanel2.add(jlblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });
        jPanel2.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 260, 30));

        jlblPet.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlblPet.setText("Pet");
        jPanel2.add(jlblPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 70));

        dynamicPanel.setLayout(new java.awt.CardLayout());

        jpSearch.setBackground(new java.awt.Color(255, 255, 204));
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jtPet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Pet ID", "Name", "Height", "Length", "Animal Type", "Breed", "Birth Date", "Gender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtPet);

        jpSearch.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 660, 310));

        jbtModifyPet.setText("Modify Pet");
        jbtModifyPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtModifyPetMouseClicked(evt);
            }
        });
        jbtModifyPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModifyPetActionPerformed(evt);
            }
        });
        jpSearch.add(jbtModifyPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        jbtDeletePet.setText("Delete Pet");
        jbtDeletePet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDeletePetMouseClicked(evt);
            }
        });
        jbtDeletePet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeletePetActionPerformed(evt);
            }
        });
        jpSearch.add(jbtDeletePet, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        dynamicPanel.add(jpSearch, "card2");

        jpAdd.setBackground(new java.awt.Color(255, 255, 204));
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblId.setText("Pet ID :");
        jpAdd.add(jlblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jtfPetId.setToolTipText("Pet ID");
        jpAdd.add(jtfPetId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 90, -1));

        jlblName.setText("Pet Name :");
        jpAdd.add(jlblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jtfPetName.setToolTipText("Enter pet name");
        jtfPetName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPetNameActionPerformed(evt);
            }
        });
        jpAdd.add(jtfPetName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 90, -1));

        jlblHeight.setText("Pet Height :");
        jpAdd.add(jlblHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jlblWeight.setText("Pet Weight :");
        jpAdd.add(jlblWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        jlblLength.setText("Pet Length :");
        jpAdd.add(jlblLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jlblType.setText("Animal Type :");
        jpAdd.add(jlblType, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        jlblBreed.setText("Breed :");
        jpAdd.add(jlblBreed, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 20));

        jcbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Canine", "Feline", "Aquatic", "Reptile", "Avian" }));
        jpAdd.add(jcbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        jlblPBD.setText("Pet Birth Date :");
        jpAdd.add(jlblPBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        jlblGender.setText("Pet Gender :");
        jpAdd.add(jlblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jlblOwnIc.setText("Owner IC No. :");
        jpAdd.add(jlblOwnIc, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        jtfHeight.setToolTipText("Enter height");
        jpAdd.add(jtfHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 90, -1));

        jtfLength.setToolTipText("Enter length");
        jpAdd.add(jtfLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 70, -1));

        jtfBreed.setToolTipText("Enter breed");
        jpAdd.add(jtfBreed, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 100, -1));

        jcbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jpAdd.add(jcbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        jtfWeight.setToolTipText("Enter weight");
        jpAdd.add(jtfWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 50, -1));

        jtfOwnerIc.setToolTipText("Enter NRIC");
        jpAdd.add(jtfOwnerIc, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 90, -1));

        jbtAddPet.setText("Add Pet");
        jbtAddPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAddPetMouseClicked(evt);
            }
        });
        jbtAddPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddPetActionPerformed(evt);
            }
        });
        jpAdd.add(jbtAddPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));
        jpAdd.add(jdpBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        jbtConfirmChange.setText("Confirm Changes");
        jbtConfirmChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmChangeActionPerformed(evt);
            }
        });
        jpAdd.add(jbtConfirmChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        jbtConfirmDelete.setText("Confirm Delete");
        jbtConfirmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmDeleteActionPerformed(evt);
            }
        });
        jpAdd.add(jbtConfirmDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        dynamicPanel.add(jpAdd, "card3");

        jPanel1.add(dynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 920, 460));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 526));
    }// </editor-fold>//GEN-END:initComponents

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSearchActionPerformed

    private void jtfPetNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPetNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPetNameActionPerformed

    private void jbtModifyPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModifyPetActionPerformed
        // TODO add your handling code here:
       MainMenu.action="modifySelected";
       Pet selectedPet=null;
       if(jtPet.getSelectedRow()>=0 ) {
           String id  = (String) jtPet.getValueAt(jtPet.getSelectedRow(),0);
           selectedPet = petControl.searchRecord(id);
           if(selectedPet!=null){
                setDynamicPanel();
                fillFields(selectedPet);
           }
            else{
                JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtModifyPetActionPerformed

    private void jbtDeletePetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeletePetActionPerformed
        // TODO add your handling code here:
        MainMenu.action="deleteSelected";
       Pet selectedPet=null;
       if(jtPet.getSelectedRow()>=0 ) {
           String id  = (String) jtPet.getValueAt(jtPet.getSelectedRow(),0);
           selectedPet = petControl.searchRecord(id);
           if(selectedPet!=null){
                setDynamicPanel();
                fillFields(selectedPet); 
                jtfSearch.setEnabled(false);
                jtfBreed.setEnabled(false);
                jtfHeight.setEnabled(false);
                jtfLength.setEnabled(false);
                jtfOwnerIc.setEnabled(false);
                jtfPetId.setEnabled(false);
                jtfPetName.setEnabled(false);
                jtfWeight.setEnabled(false);
                jcbGender.setEnabled(false);
                jcbType.setEnabled(false);
                jdpBirthDate.setEnabled(false);
                
           }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtDeletePetActionPerformed

    private void jbtAddPetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddPetMouseClicked
        // TODO add your handling code here:
         // TODO add your handling code here:
    }//GEN-LAST:event_jbtAddPetMouseClicked

    private void jlblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSearchMouseClicked
       // TODO add your handling code here:
        //I used all my 洪荒之力 to make this method 

        jtPet.setModel(new DefaultTableModel());
        jtPet.repaint();
        
        if(MainMenu.action == "modifySelected"){
            MainMenu.action="modify";
        }
        else if(MainMenu.action == "deleteSelected"){
            MainMenu.action="delete";
        }else if(MainMenu.action == "add"){
               MainMenu.action="search";
        }
            setDynamicPanel();
        
        String queryStr =jtfSearch.getText();
        int option =-1;
        ArrayList<Pet> petList = null;

            if(Pattern.matches("A\\d+", queryStr)){
                petList = petControl.searchRecord(queryStr,1);
            }else if(Pattern.matches("\\d{12}", queryStr)){
                petList = petControl.searchRecord(queryStr,2);
            }else{
                petList = petControl.searchRecord(queryStr,3);
            }



            if(petList.size()!=0&&petList!=null){
                Object[][] data = new Object[100][10];
                for(int i=0; i<petList.size();i++){
                data[i] = petList.get(i).getObjects();
                } 
                String[] columnNames = {"Pet ID","Name","Height","Weight","Length ","Animal Type","Breed","Date Of Birth","Gender","Customer"};
                TableModel tModel = new TableModel(data, columnNames);
                jtPet.setModel(tModel);  
                jtPet.createDefaultColumnsFromModel();
                jtPet.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "No results found!" , "No such record.", JOptionPane.ERROR_MESSAGE);
            }     
    }//GEN-LAST:event_jlblSearchMouseClicked

    private void jbtModifyPetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtModifyPetMouseClicked
        // TODO add your handling code here:
//         MainMenu.action="modifySelected";
//       Pet selectedPet=null;
//       if(jtPet.getSelectedRow()>=0 ) {
//           String ic  = (String) jtPet.getValueAt(jtPet.getSelectedRow(),0);
//           selectedPet = petControl.searchRecord(ic);
//           if(selectedPet!=null){
//                setDynamicPanel();
//                fillFields(selectedPet);
//           }
//       }
//       else{
//           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
//       }

    }//GEN-LAST:event_jbtModifyPetMouseClicked

    private void jbtDeletePetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDeletePetMouseClicked
        // TODO add your handling code here:
//        MainMenu.action="delete";
//       Pet selectedPet=null;
//       if(jtPet.getSelectedRow()>=0 ) {
//           String ic  = (String) jtPet.getValueAt(jtPet.getSelectedRow(),0);
//           selectedPet = petControl.searchRecord(ic);
//          if(selectedPet!=null){
//                setDynamicPanel();
//                fillFields(selectedPet);
//           } 
//       }
//       else{
//           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to delete","Empty selection",JOptionPane.ERROR_MESSAGE);
//       }
    }//GEN-LAST:event_jbtDeletePetMouseClicked

    private void jbtAddPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddPetActionPerformed
        // TODO add your handling code here:
        Pet pet = validateInput();
        if(pet!=null){
         //write to database
             Pet p = petControl.searchRecord(pet.getPetID());

            if(p != null)
            {
                JOptionPane.showMessageDialog(null,"This pet already exist.", "Duplicate Record", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                p = pet;
                try{
                petControl.addRecord(p);
                resetFields();
                JOptionPane.showMessageDialog(null,"New pet is created.","Success",JOptionPane.INFORMATION_MESSAGE);
                jtfPetId.setText(generatePetId());
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
    }//GEN-LAST:event_jbtAddPetActionPerformed

    private void jbtConfirmChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmChangeActionPerformed
        // TODO add your handling code here:
        Pet pet = validateInput();
        if(pet!=null){
         //write to database ****
                Pet p = petControl.searchRecord(pet.getPetID());
                
                if(p == null)
                {
                    JOptionPane.showMessageDialog(null,"This pet does not exist.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
//                    p = pet;
                    int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Are you sure you want commit the changes made?", "Confirm changes?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
                    if(reply==JOptionPane.YES_OPTION){
                        try{
                            petControl.updateRecord(pet);
                            resetFields();
                            JOptionPane.showMessageDialog(null,"Pet details of pet "+ pet.getPetID()+" has been updated.","Success",JOptionPane.INFORMATION_MESSAGE);
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
                Pet pet = validateInput();
        if(pet!=null){
            Pet p = petControl.searchRecord(pet.getPetID());

            if(p == null)
            {
                JOptionPane.showMessageDialog(null,"This pet does not exist.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                p = pet;
                int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Are you sure you want delete pet "+pet.getPetID()+" ?", "Confirm delete?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

                if(reply==JOptionPane.YES_OPTION){
                    try{
                        petControl.deleteRecord(p.getPetID());
                        resetFields();
                        JOptionPane.showMessageDialog(null,"Pet "+ pet.getPetID()+" has been deleted.","Success",JOptionPane.INFORMATION_MESSAGE);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAddPet;
    private javax.swing.JButton jbtConfirmChange;
    private javax.swing.JButton jbtConfirmDelete;
    private javax.swing.JButton jbtDeletePet;
    private javax.swing.JButton jbtModifyPet;
    private javax.swing.JComboBox<String> jcbGender;
    private javax.swing.JComboBox<String> jcbType;
    private com.toedter.calendar.JDateChooser jdpBirthDate;
    private javax.swing.JLabel jlblBreed;
    private javax.swing.JLabel jlblGender;
    private javax.swing.JLabel jlblHeight;
    private javax.swing.JLabel jlblId;
    private javax.swing.JLabel jlblLength;
    private javax.swing.JLabel jlblName;
    private javax.swing.JLabel jlblOwnIc;
    private javax.swing.JLabel jlblPBD;
    private javax.swing.JLabel jlblPet;
    private javax.swing.JLabel jlblSearch;
    private javax.swing.JLabel jlblType;
    private javax.swing.JLabel jlblWeight;
    private javax.swing.JPanel jpAdd;
    private javax.swing.JPanel jpSearch;
    private javax.swing.JTable jtPet;
    private javax.swing.JTextField jtfBreed;
    private javax.swing.JTextField jtfHeight;
    private javax.swing.JTextField jtfLength;
    private javax.swing.JTextField jtfOwnerIc;
    private javax.swing.JTextField jtfPetId;
    private javax.swing.JTextField jtfPetName;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfWeight;
    // End of variables declaration//GEN-END:variables
}
