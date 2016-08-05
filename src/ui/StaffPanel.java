/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import javax.swing.*;
import control.MaintainStaff;
import domain.Staff;
import java.util.regex.*;


public class StaffPanel extends javax.swing.JPanel {
    
    MaintainStaff staffControl;
//    List<Staff> staffList = new ArrayList<Staff>();
    /**
     * Creates new form StaffFrame
     */


    public StaffPanel() {
        
        initComponents();
        staffControl = new MaintainStaff();
        
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
        }
        else if (MainMenu.action.equals("search")){
            targetPanel=jpSearch;
        }else if(MainMenu.action.equals("modify")){
             targetPanel=jpSearch;
        }
        else if (MainMenu.action.equals("delete")){
            targetPanel=jpSearch;
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
        
        Staff staff;
        boolean valid =true;
        
        String ic=jtfIc.getText();
        String name = jtfName.getText();
        String postcode = jtfPostCode.getText();
        String door = jtfDoor.getText();
        String neighbour = jtfNeighbour.getText();
        String city = jtfCity.getText();
        String state = jtfState.getText();
        String password =jtfPassword.getText();
        String phone = jtfPhoneNum.getText();
        
        valid = password.equals(jtfConfirmPass.getText())?true:false;
        if(!Pattern.matches("\\d{12}", ic)){valid =false;}
        if(!Pattern.matches("\\d{2,4}-\\d{7,8}", phone)){valid =false;}
        if(!Pattern.matches("\\d{5}", postcode)){valid =false;}
  
        //Prepare answer string
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
 
         if(valid==true){
           String fulladdress = ""+door+"_"+neighbour+"_"+postcode+"_"+city+"_"+state;
           staff = new Staff(ic,name,fulladdress,phone,(String)jcbPosition.getSelectedItem(),(String)jcbQualification.getSelectedItem(),password,answer);
         }
         else {
             staff=null;
         }
         
         return staff;
    }
    
    public void resetFields(){
        jtfAnswer.setText("");
        jtfCity.setText("");;
        jtfConfirmPass.setText("");;
        jtfDoor.setText("");;
        jtfIc.setText("");;
        jtfName.setText("");;
        jtfNeighbour.setText("");;
        jtfPassword.setText("");;
        jtfPhoneNum.setText("");;
        jtfPostCode.setText("");;
        jtfSearch.setText("");;
        jtfState.setText("");;
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
        dynamicPanel = new javax.swing.JPanel();
        jpAddUpdate = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jcbQualification = new javax.swing.JComboBox<>();
        jcbPosition = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcbQuestion = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JTextField();
        jtfAnswer = new javax.swing.JTextField();
        jtfConfirmPass = new javax.swing.JTextField();
        jlblCheck = new javax.swing.JLabel();
        jlblCross = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jtfDoor = new javax.swing.JTextField();
        jtfPostCode = new javax.swing.JTextField();
        jtfState = new javax.swing.JTextField();
        jtfNeighbour = new javax.swing.JTextField();
        jtfPhoneNum = new javax.swing.JTextField();
        jtfIc = new javax.swing.JTextField();
        jtfCity = new javax.swing.JTextField();
        jbtAdd = new javax.swing.JButton();
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
        jPanel2.add(jlblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jtfSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 260, 30));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 80));

        dynamicPanel.setLayout(new java.awt.CardLayout());

        jpAddUpdate.setBackground(new java.awt.Color(202, 233, 239));
        jpAddUpdate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("NRIC :");
        jpAddUpdate.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        jLabel3.setText("Name :");
        jpAddUpdate.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel4.setText("Door & Street :");
        jpAddUpdate.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel5.setText("Neighbourhood :");
        jpAddUpdate.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        jLabel6.setText("Postal Code:");
        jpAddUpdate.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel7.setText("City :");
        jpAddUpdate.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jLabel9.setText("State :");
        jpAddUpdate.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel10.setText("Phone Number :");
        jpAddUpdate.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        jLabel11.setText("Staff Position : ");
        jpAddUpdate.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel12.setText("Staff Qualification :");
        jpAddUpdate.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jcbQualification.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PMR", "SPM", "Diploma or equivalent", "Advanced Diploma", "Bachelor's Degree", "Graduate Diploma", "Masters Degree", "PhD" }));
        jpAddUpdate.add(jcbQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        jcbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senior Veterinerian", "Veterinerian", "Receptionist", "Laboratory Technician ", "Medical Assistant", "Clerk", "General Staff" }));
        jpAddUpdate.add(jcbPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        jPanel1.setBackground(new java.awt.Color(202, 233, 239));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Password :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 21, -1, -1));

        jLabel14.setText("Confirm Password :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jLabel15.setText("Security Question :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 69, -1, -1));

        jcbQuestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your first pet's name?", "What is your favourite colour?", "Where is your hometown?" }));
        jPanel1.add(jcbQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 66, -1, -1));

        jLabel16.setText("Security Answer :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));
        jPanel1.add(jtfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 120, -1));
        jPanel1.add(jtfAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 120, -1));

        jtfConfirmPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfConfirmPassKeyReleased(evt);
            }
        });
        jPanel1.add(jtfConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 120, -1));

        jlblCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checkmark.png"))); // NOI18N
        jlblCheck.setToolTipText("Passwords match!");
        jPanel1.add(jlblCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 20, 20));

        jlblCross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/crossmark.png"))); // NOI18N
        jlblCross.setToolTipText("Passwords do not match!");
        jPanel1.add(jlblCross, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 20, 20));

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
        jbtAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAddMouseClicked(evt);
            }
        });
        jpAddUpdate.add(jbtAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, -1, -1));

        dynamicPanel.add(jpAddUpdate, "card3");

        jpSearch.setBackground(new java.awt.Color(202, 233, 239));
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jpSearch.add(jbtModifyStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));

        jbtDeleteStaff.setText("Delete Staff");
        jbtDeleteStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteStaffActionPerformed(evt);
            }
        });
        jpSearch.add(jbtDeleteStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, -1, -1));

        dynamicPanel.add(jpSearch, "card2");

        add(dynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 77, 930, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void jlblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSearchMouseClicked
        // TODO add your handling code here:
//        String queryStr =jTextField1.getText();
//        Staff s = staffControl.searchRecord(queryStr);
//        
////        MainMenu.action="search";
////        setDynamicPanel();
//        
//        Binding b = bindingGroup.getBinding("jTable1");
//        b.unbind();
//        staffList.clear();
//        staffList.add(s); // Whatever you do to refill the list
//        b.bind();
//        jTable1.repaint();
////        TableModel tModel = new TableModel();
//        Object[][] data = {s.getObjects()};
//        String[] columnNames = {"m","n","j","nw","m","n","j","nw"};
//        jTable1.setModel(new TableModel(data, colunmNames) {});
 
        
        
        
        
    }//GEN-LAST:event_jlblSearchMouseClicked

    private void jbtModifyStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModifyStaffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtModifyStaffActionPerformed

    private void jbtDeleteStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteStaffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtDeleteStaffActionPerformed

    private void jbtAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddMouseClicked
        // TODO add your handling code here:
        Staff staff = validateInput();
        if(staff!=null){
         //write to database
        }
        else{
            int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Your input seems to have data that is invalid or in incorrect format. Would you like to reset all fields?", "Invalid Data!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
            if(reply==JOptionPane.YES_OPTION){
                resetFields();
            }              
        }   
    }//GEN-LAST:event_jbtAddMouseClicked

    private void jtfConfirmPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfConfirmPassKeyReleased
        // TODO add your handling code here:
        if(jtfPassword.getText()==null){
            jlblCross.setVisible(false);
            jlblCheck.setVisible(false);
        }
        else if(jtfPassword.getText().equals(jtfConfirmPass.getText())){
            jlblCross.setVisible(false);
            jlblCheck.setVisible(true);
        }
        else{
            jlblCross.setVisible(true);
            jlblCheck.setVisible(false);
        }
    }//GEN-LAST:event_jtfConfirmPassKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAdd;
    private javax.swing.JButton jbtDeleteStaff;
    private javax.swing.JButton jbtModifyStaff;
    private javax.swing.JComboBox<String> jcbPosition;
    private javax.swing.JComboBox<String> jcbQualification;
    private javax.swing.JComboBox<String> jcbQuestion;
    private javax.swing.JLabel jlblCheck;
    private javax.swing.JLabel jlblCross;
    private javax.swing.JLabel jlblSearch;
    private javax.swing.JPanel jpAddUpdate;
    private javax.swing.JPanel jpSearch;
    private javax.swing.JTable jtStaff;
    private javax.swing.JTextField jtfAnswer;
    private javax.swing.JTextField jtfCity;
    private javax.swing.JTextField jtfConfirmPass;
    private javax.swing.JTextField jtfDoor;
    private javax.swing.JTextField jtfIc;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfNeighbour;
    private javax.swing.JTextField jtfPassword;
    private javax.swing.JTextField jtfPhoneNum;
    private javax.swing.JTextField jtfPostCode;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfState;
    // End of variables declaration//GEN-END:variables
}
