/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import control.*;
import domain.*;
import java.awt.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cheng
 */
public class TransactionPanel extends javax.swing.JPanel {

    /**
     * Creates new form TransactionPanel
     */
    private MaintainTransaction transControl;
    private MaintainService serviceControl;
    private MaintainStaff staffControl;
    private MaintainPet petControl;
    private MaintainTransactionService transServControl;
    private MaintainAppointment appControl;
    private MaintainCustomer custControl;
    private ArrayList<ServiceDetail> servList;
    private String action;
    private AddServiceDialog asd;
    private static ServiceDetail serviceDetail;
    Date date;
    
    public static void setService(ServiceDetail service) {
        TransactionPanel.serviceDetail = service;
    }
    
   
    public TransactionPanel() {
        initComponents();
        transControl = new MaintainTransaction();
        serviceControl = new MaintainService ();
        staffControl = new MaintainStaff();
        petControl = new MaintainPet();
        transServControl = new MaintainTransactionService();
        servList = new ArrayList<ServiceDetail>();
        appControl = new MaintainAppointment();
        custControl = new MaintainCustomer();
        serviceDetail=null;
        jtfSearch.setOpaque(false);
        jtfSearch.setBackground(new Color(255,255,255,127));
//        jtfSearch.setBorder(null);
        setDynamicPanel();
    }

    public void resetFields(){
         jtfTransId.setText("");
         jtfPetId.setText("");
         jtfSearch.setText("");
         jtService.setModel(new DefaultTableModel());
         jtService.repaint();
         
      for(int i=0; i<servList.size();i++){
         servList.remove(i);
       }
    
     
     }
    
    public void disableFields(){
    
        jtfTransId.setEditable(false);
        jtfTransTime.setEditable(false);
        jdpTransDate.setEnabled(false);
        jtfPetId.setEditable(false);
        
    }
    
    public void fillFields(Transaction transaction){

    DateFormat formatter = new SimpleDateFormat("HH:mm");
    String timeFormatted = formatter.format(transaction.getTransTime());
    jtfTransTime.setText(timeFormatted);

    jtfPetId.setText(transaction.getPet().getPetID());
    jtfTransId.setText(transaction.getTransID());

    jdpTransDate.setDate(transaction.getTransDate());
    ArrayList<ServiceDetail> servList = transaction.getServiceList();
        if(servList.size()!=0&&servList!=null){
                Object[][] data = new Object[100][8];
                for(int i=0; i<servList.size();i++){
                data[i] = servList.get(i).getObjects();
                } 
                String[] columnNames = {"Service","Staff","Remarks"};
                TableModel tModel = new TableModel(data, columnNames);
                jtService.setModel(tModel);  
                jtService.createDefaultColumnsFromModel();
                jtService.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "No results found!" , "No such record.", JOptionPane.ERROR_MESSAGE);
            }     
   
    }
     
    public ArrayList<ServiceDetail> getServList() {
        return servList;
    }

    public void setServList(ArrayList<ServiceDetail> servList) {
        this.servList = servList;
    }
    
    public boolean addService (ServiceDetail serviceD){
        boolean valid =true;
        for(int i=0; i<servList.size();i++){
           if(servList.get(i).getService().getServiceID().equals(serviceD.getService().getServiceID())){
               valid=false;
           }
        }
        if(valid){
            servList.add(serviceD);
        }
        
        return valid;
    }
    
    public void editService(ServiceDetail serviceD){
        for(int i=0; i<servList.size();i++){
           if(servList.get(i).getService().getServiceID().equals(serviceD.getService().getServiceID())){
               servList.remove(i);
               servList.add(i, serviceD);
           }
        }
    }
    
    public void removeService(ServiceDetail serviceD){
    for(int i=0; i<servList.size();i++){
       if(servList.get(i).getService().getServiceID().equals(serviceD.getService().getServiceID())){
           servList.remove(i);
       }
    }
}
    public void initFields(){
    
        jtfTransId.setEditable(false);
        jdpTransDate.setEnabled(false);
        jtfTransTime.setEditable(false);
        
        date = new Date();
        jdpTransDate.setDateFormatString("dd-MM-yyyy");
        jdpTransDate.setDate(date);
        
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        String timeFormatted = formatter.format(date.getTime());
        jtfTransTime.setText(timeFormatted);
    
    }
    public void setDynamicPanel() {
        JPanel targetPanel = new JPanel();  
        initFields();
        
        if(MainMenu.action.equals("add")){
             targetPanel=jpAdd;
             jtfTransId.setText(generateTransId());
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(false);
             jbtAddTrans.setVisible(true);
        }
        else if (MainMenu.action.equals("search")){
            targetPanel=jpTrans1;
                jbtDeleteTrans.setVisible(false);
                jbtModifyTrans.setVisible(false);
                jbtView.setVisible(true);
                
        }else if(MainMenu.action.equals("modifySelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(true);
             jbtConfirmDelete.setVisible(false);
             jbtAddTrans.setVisible(false);
             jtfPetId.setEnabled(false);
            
        
        }else if(MainMenu.action.equals("deleteSelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(true);
             jbtAddTrans.setVisible(false);
             jtfPetId.setEnabled(false);
             
        }else if(MainMenu.action.equals("modify")){
                targetPanel=jpTrans1;
                jbtDeleteTrans.setVisible(false);
                jbtModifyTrans.setVisible(true);
        }
        else if(MainMenu.action.equals("delete")){
                targetPanel=jpTrans1;
                jbtDeleteTrans.setVisible(true);
                jbtModifyTrans.setVisible(false);
                jbtView.setVisible(false);
                
        }else if(MainMenu.action.equals("viewSelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(false);
             jbtAddTrans.setVisible(false);

        }
        
        dynamicPanel.removeAll();
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
            
        //Adding Pannel
        dynamicPanel.add(targetPanel);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }
    
    public String generateTransId(){
        
        ArrayList<Transaction> transList = transControl.searchRecord("", 0);
        ArrayList<Integer> idList = new ArrayList<Integer>();
        
        for(int i=0; i<transList.size(); i++){
        String idStr = transList.get(i).getTransID();
        int idNo = Integer.parseInt(idStr.split("T")[1]);
        idList.add(idNo);
        }
        
        Collections.sort(idList);
        int idNo = 1; 
        for(int i=0; i<idList.size(); i++){
            if(idList.get(i)!=i+1){
                idNo=i+1; 
                break;
            }
            if(i==idList.size()-1){
                idNo=idList.size()+1; 
            }
            
        } 
        return "T"+idNo;
    }
    
    private void updateAppointment(Transaction t){
    
        ArrayList<Appointment> appList= appControl.searchRecord("Open", 5);
        Pet pet = petControl.searchRecord(t.getPet().getPetID());
        Customer c = custControl.searchRecord(pet.getCustomer().getCustIC());
        String phoneNo = c.getCustPhoneNum();
        
        for(int i=0; i<appList.size();i++){
            Appointment app = appList.get(i);
           if( app.getCustPhoneNum().equals(phoneNo)){
               app.setTransID(t);
               app.setStatus("Completed");
               appControl.updateRecord(app);
           }
        }
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
        jlblTrans = new javax.swing.JLabel();
        dynamicPanel = new javax.swing.JPanel();
        jpAdd = new javax.swing.JPanel();
        jlblTransId = new javax.swing.JLabel();
        jtfTransId = new javax.swing.JTextField();
        jlblTransDate = new javax.swing.JLabel();
        jlblTransTime = new javax.swing.JLabel();
        jlblPetID = new javax.swing.JLabel();
        jtfPetId = new javax.swing.JTextField();
        jdpTransDate = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtService = new javax.swing.JTable();
        jbtRemoveService = new javax.swing.JButton();
        jbtAddService = new javax.swing.JButton();
        jbtEditService = new javax.swing.JButton();
        jbtAddTrans = new javax.swing.JButton();
        jbtRefresh = new javax.swing.JButton();
        jbtConfirmChange = new javax.swing.JButton();
        jbtConfirmDelete = new javax.swing.JButton();
        jtfTransTime = new javax.swing.JTextField();
        jpTrans1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTransList = new javax.swing.JTable();
        jbtModifyTrans = new javax.swing.JButton();
        jbtDeleteTrans = new javax.swing.JButton();
        jbtView = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jlblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSearchMouseClicked(evt);
            }
        });
        jPanel2.add(jlblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });
        jPanel2.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 260, 30));

        jlblTrans.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlblTrans.setText("Transaction");
        jPanel2.add(jlblTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, 20));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 70));

        dynamicPanel.setLayout(new java.awt.CardLayout());

        jpAdd.setBackground(new java.awt.Color(255, 204, 204));
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblTransId.setText("Transaction ID :");
        jpAdd.add(jlblTransId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 87, 23));

        jtfTransId.setToolTipText("Enter transaction ID");
        jtfTransId.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpAdd.add(jtfTransId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 80, -1));

        jlblTransDate.setText("Transaction Date :");
        jpAdd.add(jlblTransDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        jlblTransTime.setText("Transaction Time :");
        jpAdd.add(jlblTransTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jlblPetID.setText("Pet ID :");
        jpAdd.add(jlblPetID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        jtfPetId.setToolTipText("Enter pet ID");
        jtfPetId.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpAdd.add(jtfPetId, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 90, 20));
        jpAdd.add(jdpTransDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 100, -1));

        jtService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Service", "Staff ", "Remarks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtService.setColumnSelectionAllowed(true);
        jtService.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtService);
        jtService.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jtService.getColumnModel().getColumnCount() > 0) {
            jtService.getColumnModel().getColumn(0).setPreferredWidth(20);
            jtService.getColumnModel().getColumn(1).setPreferredWidth(20);
            jtService.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jpAdd.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 530, 190));

        jbtRemoveService.setText("Remove Service Item");
        jbtRemoveService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRemoveServiceActionPerformed(evt);
            }
        });
        jpAdd.add(jbtRemoveService, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        jbtAddService.setText("Add Service Item");
        jbtAddService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAddServiceMouseClicked(evt);
            }
        });
        jbtAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddServiceActionPerformed(evt);
            }
        });
        jpAdd.add(jbtAddService, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        jbtEditService.setText("Edit Service Item");
        jbtEditService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEditServiceActionPerformed(evt);
            }
        });
        jpAdd.add(jbtEditService, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, -1, -1));

        jbtAddTrans.setText("Add transaction");
        jbtAddTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddTransActionPerformed(evt);
            }
        });
        jpAdd.add(jbtAddTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 110, -1));

        jbtRefresh.setText("Refresh");
        jbtRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRefreshActionPerformed(evt);
            }
        });
        jpAdd.add(jbtRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        jbtConfirmChange.setText("Confirm Changes");
        jbtConfirmChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmChangeActionPerformed(evt);
            }
        });
        jpAdd.add(jbtConfirmChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, -1, -1));

        jbtConfirmDelete.setText("Confirm Delete");
        jbtConfirmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmDeleteActionPerformed(evt);
            }
        });
        jpAdd.add(jbtConfirmDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, -1, -1));
        jpAdd.add(jtfTransTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 80, -1));

        dynamicPanel.add(jpAdd, "card3");

        jpTrans1.setBackground(new java.awt.Color(255, 204, 204));
        jpTrans1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtTransList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Date", "Time", "Pet ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTransList);

        jpTrans1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 570, 230));

        jbtModifyTrans.setText("Modify Transaction");
        jbtModifyTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModifyTransActionPerformed(evt);
            }
        });
        jpTrans1.add(jbtModifyTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        jbtDeleteTrans.setText("Delete Transaction");
        jbtDeleteTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteTransActionPerformed(evt);
            }
        });
        jpTrans1.add(jbtDeleteTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, -1, -1));

        jbtView.setText("View Transaction");
        jbtView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewActionPerformed(evt);
            }
        });
        jpTrans1.add(jbtView, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        dynamicPanel.add(jpTrans1, "card2");

        add(dynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 960, 440));
    }// </editor-fold>//GEN-END:initComponents

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSearchActionPerformed

    private void jbtRemoveServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRemoveServiceActionPerformed
        // TODO add your handling code here:
        //
        action="delete";
        if(jtService.getSelectedRow()>=0 ) {
          
           Service service = serviceControl.searchRecord((String) jtService.getValueAt(jtService.getSelectedRow(),0));
           Staff staff = staffControl.searchRecord((String) jtService.getValueAt(jtService.getSelectedRow(),1),2).get(0);
           
            serviceDetail = new ServiceDetail();
           serviceDetail.setStaffIC(staff);
           serviceDetail.setService(service);
           removeService(serviceDetail);
           jbtRefreshActionPerformed(evt);
           JOptionPane.showMessageDialog(null,"Item deleted succesfully.","Success",JOptionPane.INFORMATION_MESSAGE);
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to delete","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtRemoveServiceActionPerformed

    private void jbtAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddServiceActionPerformed
        // TODO add your handling code here:
        action="add";
        asd = new AddServiceDialog((JFrame)this.getParent().getParent().getParent().getParent().getParent().getParent(), false);
        asd.setVisible(true);
    }//GEN-LAST:event_jbtAddServiceActionPerformed

    private void jbtEditServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEditServiceActionPerformed
        // TODO add your handling code here:
        action="edit";
        if(jtService.getSelectedRow()>=0 ) {
            String serviceID = (String) jtService.getValueAt(jtService.getSelectedRow(),0);
            String staffId =(String) jtService.getValueAt(jtService.getSelectedRow(),1);
            String remarks = (String) jtService.getValueAt(jtService.getSelectedRow(),2);
            
            asd = new AddServiceDialog((JFrame)this.getParent().getParent().getParent().getParent().getParent().getParent(), false);
            asd.fillFields(serviceID, staffId, remarks);
            asd.setVisible(true);   
        }
        else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
        
        
            
    }//GEN-LAST:event_jbtEditServiceActionPerformed

    private void jbtModifyTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModifyTransActionPerformed
        // TODO add your handling code here:
       MainMenu.action="modifySelected";
       Transaction selectedTrans=null;
       servList = new ArrayList<ServiceDetail>();
       if(jtTransList.getSelectedRow()>=0 ) {
           String id  = (String) jtTransList.getValueAt(jtTransList.getSelectedRow(),0);
           selectedTrans = transControl.searchRecord(id);
           servList = transServControl.searchRecord(id, 1);

           if(selectedTrans!= null&&servList.size()!=0&&servList!=null){
           selectedTrans.setServiceList(servList);
           
            fillFields(selectedTrans);
            setDynamicPanel();
           }else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }

    }//GEN-LAST:event_jbtModifyTransActionPerformed

    private void jbtAddServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddServiceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAddServiceMouseClicked

    private void jlblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSearchMouseClicked
        // TODO add your handling code here:
        //I used all my 洪荒之力 to make this method 
        ///// jtService is jttransList
        jtTransList.setModel(new DefaultTableModel());
        jtTransList.repaint();
        
        if(MainMenu.action == "modifySelected"){
            MainMenu.action="modify";
        }
        else if(MainMenu.action == "deleteSelected"){
            MainMenu.action="delete";
        }else if(MainMenu.action == "add"||MainMenu.action == "viewSelected" ){
               MainMenu.action="search";
        }
        setDynamicPanel();
        String queryStr =jtfSearch.getText();
        int option =-1;
        

            if(Pattern.matches("T\\d+", queryStr)){
                option=1;
            }
            
            else if(Pattern.matches("A\\d+", queryStr)){
                option=2;
            }
            
            ArrayList<Transaction> transactionList = transControl.searchRecord(queryStr,option);

//            MainMenu.action="search";

            if(transactionList.size()!=0&&transactionList!=null){
                Object[][] data = new Object[100][8];
                for(int i=0; i<transactionList.size();i++){
                    data[i] = transactionList.get(i).getObjects();
                    Time time = (Time)data[i][2];
                    DateFormat formatter = new SimpleDateFormat("HH:mm");
                    String timeFormatted = formatter.format(time);
                    data [i][2] = timeFormatted;
                    data[i][3] = transactionList.get(i).getPet().getPetID()+": "+transactionList.get(i).getPet().getPetName();
                } 
                String[] columnNames = {"Transaction ID","Date","Time","Pet ID: Name"};
                TableModel tModel = new TableModel(data, columnNames);
                jtTransList.setModel(tModel);  
                jtTransList.createDefaultColumnsFromModel();
                jtTransList.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "No results found!" , "No such record.", JOptionPane.ERROR_MESSAGE);
            }     
    }//GEN-LAST:event_jlblSearchMouseClicked

    private void jbtAddTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddTransActionPerformed
        // TODO add your handling code here:
        Transaction trans = validateInput();
        
        if(trans!=null){
            Transaction t = transControl.searchRecord(trans.getTransID());

                
                if(t != null)
                {
                    JOptionPane.showMessageDialog(null,"This transaction already exist.", "Duplicate Record", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    t = trans;
                    try{
                    transControl.addRecord(t);
                    transServControl.addRecord(t);
                    resetFields();
                    updateAppointment(t);
                    JOptionPane.showMessageDialog(null,"New transaction has been created.","Success",JOptionPane.INFORMATION_MESSAGE);
                    jtfTransId.setText(generateTransId());
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

    }//GEN-LAST:event_jbtAddTransActionPerformed

    private void jbtRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRefreshActionPerformed
        // TODO add your handling code here:
        //check if null 
        jtService.setModel(new DefaultTableModel());
        jtService.repaint();
        if(serviceDetail!=null){
            if(action=="add"||action=="edit"){
                if(addService(serviceDetail)==false){
                    int option = JOptionPane.showConfirmDialog(null, "This service already exists. Are you sure you want to overwrite it?", "Overwrite service details?", JOptionPane.YES_NO_OPTION);
                    if(option==JOptionPane.YES_OPTION){
                        editService(serviceDetail);
                        JOptionPane.showMessageDialog(null,"Service item edited successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else    {
                    JOptionPane.showMessageDialog(null,"Service item added succesfully","Success",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
           if(servList.size()!=0&&servList!=null){
                Object[][] data = new Object[100][8];
                for(int i=0; i<servList.size();i++){
                    data[i] = servList.get(i).getObjects();
                } 
                String[] columnNames = {"Service","Staff","Remarks"};
                TableModel tModel = new TableModel(data, columnNames);
                jtService.setModel(tModel);  
                jtService.createDefaultColumnsFromModel();
                jtService.repaint();
            }
        }
        else{
        
            JOptionPane.showMessageDialog(null,"No item found!","Error",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jbtRefreshActionPerformed

    private void jbtConfirmChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmChangeActionPerformed
        // TODO add your handling code here:
        Transaction transaction = validateInput();
        if(transaction!=null){
         //write to database ****
                Transaction t = transControl.searchRecord(transaction.getTransID());
                
                if(t == null)
                {
                    JOptionPane.showMessageDialog(null,"This transaction does not exist.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
                }
                else
                {                
                    int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Are you sure you want commit the changes made?", "Confirm changes?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
                    if(reply==JOptionPane.YES_OPTION){
                        try{
                            transControl.updateRecord(transaction);
                            
                            transServControl.updateRecord(transaction); //this problem
                            resetFields();
                            JOptionPane.showMessageDialog(null,"Transaction details "+ t.getTransID()+" has been updated.","Success",JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch (Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage()+"9","Failure",JOptionPane.ERROR_MESSAGE);
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
        Transaction transaction = validateInput();
        if(transaction!=null){
         //write to database ****
                Transaction t = transControl.searchRecord(transaction.getTransID());
                
                if(t == null)
                {
                    JOptionPane.showMessageDialog(null,"This transaction does not exist.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
                }
                else
                {                
                    int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Are you sure you want commit the changes made?", "Confirm changes?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
                    if(reply==JOptionPane.YES_OPTION){
                        try{
                            transServControl.deleteRecord(transaction.getTransID());
                            transControl.deleteRecord(transaction.getTransID());
                            
                            resetFields();
                            JOptionPane.showMessageDialog(null,"Transaction "+ t.getTransID()+" has been deleted.","Success",JOptionPane.INFORMATION_MESSAGE);
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
        
    }//GEN-LAST:event_jbtConfirmDeleteActionPerformed

    private void jbtDeleteTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteTransActionPerformed
        // TODO add your handling code here:
       MainMenu.action="deleteSelected";
       Transaction selectedTrans=null;
       servList = new ArrayList<ServiceDetail>();
       if(jtTransList.getSelectedRow()>=0 ) {
           String id  = (String) jtTransList.getValueAt(jtTransList.getSelectedRow(),0);
           selectedTrans = transControl.searchRecord(id);
           servList = transServControl.searchRecord(id, 1);

           if(selectedTrans!= null&&servList.size()!=0&&servList!=null){
           selectedTrans.setServiceList(servList);
           
            fillFields(selectedTrans);
            jbtAddService.setEnabled(false);
            jbtRemoveService.setEnabled(false);
            jbtEditService.setEnabled(false);
            jbtRefresh.setEnabled(false);
            jtService.setEnabled(false);
            setDynamicPanel();
           }else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtDeleteTransActionPerformed

    private void jbtViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewActionPerformed
        // TODO add your handling code here:
        MainMenu.action="viewSelected";
       Transaction selectedTrans=null;
       if(jtTransList.getSelectedRow()>=0 ) {
           String id = (String) jtTransList.getValueAt(jtTransList.getSelectedRow(),0);
           selectedTrans = transControl.searchRecord(id);
           if(selectedTrans!=null){
                setDynamicPanel();
                fillFields(selectedTrans);
                disableFields();
           }
           else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to view.","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to view.","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtViewActionPerformed

    public Transaction validateInput(){
        
        boolean valid = true;
        Transaction transaction = null;

        
        Date transDate = jdpTransDate.getDate();
        Time transTime = new Time(transDate.getTime());
        String petID = jtfPetId.getText();
        Pet pet = petControl.searchRecord(petID);
        String transID = jtfTransId.getText(); //auto gen
        
        if(pet==null){
            valid=false;
        }
        if(valid){
            transaction = new Transaction (transID, transDate, transTime, pet, servList);
        }
        else{
            transaction = null;
        }
        
        return transaction;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtAddService;
    private javax.swing.JButton jbtAddTrans;
    private javax.swing.JButton jbtConfirmChange;
    private javax.swing.JButton jbtConfirmDelete;
    private javax.swing.JButton jbtDeleteTrans;
    private javax.swing.JButton jbtEditService;
    private javax.swing.JButton jbtModifyTrans;
    private javax.swing.JButton jbtRefresh;
    private javax.swing.JButton jbtRemoveService;
    private javax.swing.JButton jbtView;
    private com.toedter.calendar.JDateChooser jdpTransDate;
    private javax.swing.JLabel jlblPetID;
    private javax.swing.JLabel jlblSearch;
    private javax.swing.JLabel jlblTrans;
    private javax.swing.JLabel jlblTransDate;
    private javax.swing.JLabel jlblTransId;
    private javax.swing.JLabel jlblTransTime;
    private javax.swing.JPanel jpAdd;
    private javax.swing.JPanel jpTrans1;
    private javax.swing.JTable jtService;
    private javax.swing.JTable jtTransList;
    private javax.swing.JTextField jtfPetId;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfTransId;
    private javax.swing.JTextField jtfTransTime;
    // End of variables declaration//GEN-END:variables

    public static ServiceDetail getService() {
        return serviceDetail;
    }
}
