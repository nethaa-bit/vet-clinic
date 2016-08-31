/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import control.MaintainService;
import domain.Service;
import domain.Staff;
import domain.TableModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cheng
 */
public class ServicePanel extends javax.swing.JPanel {

    MaintainService serviceControl; 
    
    /**
     * Creates new form Service
     */
    public ServicePanel() {
        initComponents();
        serviceControl = new MaintainService();
        jtfServiceId.setEnabled(false);
        jtfSearch.setOpaque(false);
        
        jtfSearch.setBackground(new Color(255,255,255,127));
//        jtfSearch.setBorder(null);
        setDynamicPanel();
    }
    
    public void setDynamicPanel() {
        JPanel targetPanel = new JPanel();
        if(MainMenu.action.equals("add")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(false);
             jbtAddService.setVisible(true);
             jtfServiceId.setText(generateServiceId());
             jlblService.setText("Add Service");
        }
        else if (MainMenu.action.equals("search")){
            targetPanel=jpSearch;
            jbtModifyService.setVisible(false);
            jbtDeleteService.setVisible(false);
            jbtView.setVisible(true);
            jlblService.setText("Search Service");
        }
        else if(MainMenu.action.equals("modifySelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(true);
             jbtConfirmDelete.setVisible(false);
             jbtAddService.setVisible(false);
             jlblService.setText("Modify Service");
        
        }else if(MainMenu.action.equals("deleteSelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(true);
             jbtAddService.setVisible(false);
             jlblService.setText("Delete Service");
             
        }else if(MainMenu.action.equals("modify")){
                targetPanel=jpSearch;
                jbtDeleteService.setVisible(false);
                jbtModifyService.setVisible(true);
                jbtView.setVisible(false);
                jlblService.setText("Modify Service");
        }
        else if(MainMenu.action.equals("delete")){
                targetPanel=jpSearch;
                jbtModifyService.setVisible(false);
                jbtDeleteService.setVisible(true);
                jbtView.setVisible(false);
                jlblService.setText("Delete Service");
                
        }else if(MainMenu.action.equals("viewSelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(false);
             jbtAddService.setVisible(false);
             jlblService.setText("View Service");

        }
        
        dynamicPanel.removeAll();
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
            
        //Adding Pannel
        dynamicPanel.add(targetPanel);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }
    
    public void fillFields(Service service){
     
    jtfPrice.setText(""+service.getUnitPrice());
    jtfServiceId.setText(service.getServiceID());
    jtfTitle.setText(service.getServiceTitle());
    jtaDescrip.setText(service.getServiceDesp());
     }
    
    public void disableFields(){
    
        jtfPrice.setEditable(false);
        jtfServiceId.setEditable(false);
        jtfTitle.setEditable(false);
        jtaDescrip.setEditable(false);
    }

    public Service validateInput(){
    
    Service service;
    boolean valid =true; 
    
    Double price = Double.parseDouble(jtfPrice.getText());
    String serviceid = jtfServiceId.getText();
    String title = jtfTitle.getText();
    String descrip = jtaDescrip.getText();
    
    valid = price.equals(null)?false:true; //need
    valid = serviceid.equals(null)?false:true;
    valid = title.equals(null)?false:true;
    valid = descrip.equals(null)?false:true;
    
    if(valid==true){
         
           // take object domain constructor and initialiue (pass value) 
           service = new Service(serviceid, title, price, descrip);
         }
         else {
             service=null;
         }
         
         return service;
    }

    public void resetFields(){
    
    jtfPrice.setText("");
    jtfSearch.setText("");
    jtfServiceId.setText("");
    jtfTitle.setText("");
    jtaDescrip.setText("");
    }
    
    public String generateServiceId(){
        ArrayList<Service> sevList = serviceControl.searchRecord("", 0);
        ArrayList<Integer> idList = new ArrayList<Integer>(); 
        //implement sorting 
        
        for(int i=0; i<sevList.size(); i++){
        String idStr = sevList.get(i).getServiceID();
        int idNo = Integer.parseInt(idStr.split("S")[1]);
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
        
        String zeroes = "";
        if(idNo>999){zeroes="";}
        else if(idNo>99){zeroes="0";}
        else if(idNo>9){zeroes="00";}
        else if (idNo>0){zeroes="000";}
        return "S"+zeroes+idNo;
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
        jlblService = new javax.swing.JLabel();
        dynamicPanel = new javax.swing.JPanel();
        jpSearch = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtService = new javax.swing.JTable();
        jbtModifyService = new javax.swing.JButton();
        jbtDeleteService = new javax.swing.JButton();
        jbtView = new javax.swing.JButton();
        jpAdd = new javax.swing.JPanel();
        jlblId = new javax.swing.JLabel();
        jtfServiceId = new javax.swing.JTextField();
        jlblTitle = new javax.swing.JLabel();
        jtfPrice = new javax.swing.JTextField();
        jlblPrice = new javax.swing.JLabel();
        jtfTitle = new javax.swing.JTextField();
        jlblDescrip = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescrip = new javax.swing.JTextArea();
        jbtAddService = new javax.swing.JButton();
        jbtConfirmChange = new javax.swing.JButton();
        jbtConfirmDelete = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(229, 204, 255));
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

        jlblService.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlblService.setText("Service");
        jPanel2.add(jlblService, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 180, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 70));

        dynamicPanel.setLayout(new java.awt.CardLayout());

        jpSearch.setBackground(new java.awt.Color(229, 204, 255));
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Service ID", "Title", "Unitn Price", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
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
        jScrollPane2.setViewportView(jtService);

        jpSearch.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 550, 280));

        jbtModifyService.setText("Modify Service");
        jbtModifyService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtModifyServiceMouseClicked(evt);
            }
        });
        jbtModifyService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModifyServiceActionPerformed(evt);
            }
        });
        jpSearch.add(jbtModifyService, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));

        jbtDeleteService.setText("Delete Service");
        jbtDeleteService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDeleteServiceMouseClicked(evt);
            }
        });
        jbtDeleteService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteServiceActionPerformed(evt);
            }
        });
        jpSearch.add(jbtDeleteService, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        jbtView.setText("View Service");
        jbtView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewActionPerformed(evt);
            }
        });
        jpSearch.add(jbtView, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        dynamicPanel.add(jpSearch, "card3");

        jpAdd.setBackground(new java.awt.Color(229, 204, 255));
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblId.setText("Service ID :");
        jpAdd.add(jlblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        jtfServiceId.setToolTipText("Enter service ID");
        jpAdd.add(jtfServiceId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 90, -1));

        jlblTitle.setText("Service Title :");
        jpAdd.add(jlblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jtfPrice.setToolTipText("Enter price");
        jpAdd.add(jtfPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 70, -1));

        jlblPrice.setText("Unit Price (RM) :");
        jpAdd.add(jlblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        jtfTitle.setToolTipText("Enter service title");
        jpAdd.add(jtfTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 290, -1));

        jlblDescrip.setText("Service Description:");
        jpAdd.add(jlblDescrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jtaDescrip.setColumns(20);
        jtaDescrip.setRows(5);
        jScrollPane1.setViewportView(jtaDescrip);

        jpAdd.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 290, 120));

        jbtAddService.setText("Add Service");
        jbtAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddServiceActionPerformed(evt);
            }
        });
        jpAdd.add(jbtAddService, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

        jbtConfirmChange.setText("Confirm Changes");
        jbtConfirmChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtConfirmChangeMouseClicked(evt);
            }
        });
        jbtConfirmChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmChangeActionPerformed(evt);
            }
        });
        jpAdd.add(jbtConfirmChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        jbtConfirmDelete.setText("Confirm Delete");
        jbtConfirmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmDeleteActionPerformed(evt);
            }
        });
        jpAdd.add(jbtConfirmDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, -1, -1));

        dynamicPanel.add(jpAdd, "card2");

        jPanel1.add(dynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 69, 970, 480));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 970, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSearchActionPerformed

    private void jbtModifyServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModifyServiceActionPerformed
        // TODO add your handling code here:
       MainMenu.action="modifySelected";
       Service selectedService=null;
       if(jtService.getSelectedRow()>=0 ) {
           String id  = (String) jtService.getValueAt(jtService.getSelectedRow(),0);
           selectedService = serviceControl.searchRecord(id);
           if(selectedService!=null){
                setDynamicPanel();
                fillFields(selectedService);
           }
            else{
                JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
      }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtModifyServiceActionPerformed

    private void jlblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSearchMouseClicked
        // TODO add your handling code here:
        //I used all my 洪荒之力 to make this method 

        jtService.setModel(new DefaultTableModel());
        jtService.repaint();
        
         if(MainMenu.action == "modifySelected"){
            MainMenu.action="modify";
        }
        else if(MainMenu.action == "deleteSelected"){
            MainMenu.action="delete";
        }else if(MainMenu.action == "add"||MainMenu.action == "viewSelected" ){
               MainMenu.action="search";
        }
        setDynamicPanel();
        
        String queryStr =jtfSearch.getText().toUpperCase();
        int option =0;
        

            if(Pattern.matches("S\\d{4}", queryStr)){
                option=1;
            }
            
            else{
                option=2;
            }
            ArrayList<Service> serviceList = serviceControl.searchRecord(queryStr,option);

    //        MainMenu.action="search";

            if(serviceList.size()!=0&&serviceList!=null){
                Object[][] data = new Object[100][8];
                for(int i=0; i<serviceList.size();i++){
                data[i] = serviceList.get(i).getObjects();
                } 
                String[] columnNames = {"Service ID","Title","Unit Price","Description"};
                TableModel tModel = new TableModel(data, columnNames);
                jtService.setModel(tModel);  
                jtService.createDefaultColumnsFromModel();
                jtService.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "No results found!" , "No such record.", JOptionPane.ERROR_MESSAGE);
            }     
    }//GEN-LAST:event_jlblSearchMouseClicked

    private void jbtModifyServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtModifyServiceMouseClicked
        // TODO add your handling code here:
        MainMenu.action="modifySelected";
       Service selectedService=null;
       if(jtService.getSelectedRow()>=0 ) {
           String ic  = (String) jtService.getValueAt(jtService.getSelectedRow(),0);
           selectedService = serviceControl.searchRecord(ic);
           if(selectedService!=null){
                setDynamicPanel();
                fillFields(selectedService);
           } 
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }

    }//GEN-LAST:event_jbtModifyServiceMouseClicked

    private void jbtDeleteServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDeleteServiceMouseClicked
        // TODO add your handling code here:
         MainMenu.action="delete";
       Service selectedService=null;
       if(jtService.getSelectedRow()>=0 ) {
           String ic  = (String) jtService.getValueAt(jtService.getSelectedRow(),0);
           selectedService = serviceControl.searchRecord(ic);
            
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to delete","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtDeleteServiceMouseClicked

    private void jbtAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddServiceActionPerformed
        // TODO add your handling code here:
        Service service = validateInput();
        if(service!=null){
         //write to database
         Service s = serviceControl.searchRecord(service.getServiceID());
                
         if(s != null)
          {
                    JOptionPane.showMessageDialog(null,"This staff already exist.", "Duplicate Record", JOptionPane.ERROR_MESSAGE);
          }
         else
         {
                    s = service;
                    try{
                    serviceControl.addRecord(s);
                    resetFields();
                    JOptionPane.showMessageDialog(null,"New service is created.","Success",JOptionPane.INFORMATION_MESSAGE);
                    jtfServiceId.setText(generateServiceId());
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
    }//GEN-LAST:event_jbtAddServiceActionPerformed

    private void jbtConfirmChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmChangeActionPerformed
        // TODO add your handling code here:
        Service service = validateInput();
        if(service!=null){
         //write to database ****
                Service s = serviceControl.searchRecord(service.getServiceID());
                
                if(s == null)
                {
                    JOptionPane.showMessageDialog(null,"This service does not exist.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    s = service;
                    int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Are you sure you want commit the changes made?", "Confirm changes?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
                    if(reply==JOptionPane.YES_OPTION){
                        try{
                            serviceControl.updateRecord(s);
                            resetFields();
                            JOptionPane.showMessageDialog(null,"Service details of service "+ service.getServiceID()+" has been updated.","Success",JOptionPane.INFORMATION_MESSAGE);
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
    
    }                                                

    private void jbtConfirmDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        Service service = validateInput();
        if(service!=null){
            Service s = serviceControl.searchRecord(service.getServiceID());

            if(s == null)
            {
                JOptionPane.showMessageDialog(null,"This service does not exist.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                s = service;
                int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Are you sure you want delete service "+service.getServiceID()+" ?", "Confirm delete?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

                if(reply==JOptionPane.YES_OPTION){
                    try{
                        serviceControl.deleteRecord(s.getServiceID());
                        resetFields();
                        JOptionPane.showMessageDialog(null,"Service "+ service.getServiceID()+" has been deleted.","Success",JOptionPane.INFORMATION_MESSAGE);
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
    }//GEN-LAST:event_jbtConfirmChangeActionPerformed

    private void jbtConfirmChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtConfirmChangeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtConfirmChangeMouseClicked

    private void jbtDeleteServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteServiceActionPerformed
        // TODO add your handling code here:
       MainMenu.action="deleteSelected";
       Service selectedService=null;
       if(jtService.getSelectedRow()>=0 ) {
           String id  = (String) jtService.getValueAt(jtService.getSelectedRow(),0);
           selectedService = serviceControl.searchRecord(id);
           if(selectedService!=null){
                setDynamicPanel();
                fillFields(selectedService);
                jtfSearch.setEnabled(false);
                jtaDescrip.setEnabled(false);
                jbtDeleteService.setEnabled(false);
                jbtModifyService.setEnabled(false);
                jtfPrice.setEnabled(false);
                jtfSearch.setEnabled(false);
                jtfServiceId.setEnabled(false);
                jtfTitle.setEnabled(false);
                
           }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtDeleteServiceActionPerformed

    private void jbtViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewActionPerformed
        // TODO add your handling code here:
               MainMenu.action="viewSelected";
       Service selectedService=null;
       if(jtService.getSelectedRow()>=0 ) {
           String id  = (String) jtService.getValueAt(jtService.getSelectedRow(),0);
           selectedService = serviceControl.searchRecord(id);
           if(selectedService!=null){
                setDynamicPanel();
                fillFields(selectedService);
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtAddService;
    private javax.swing.JButton jbtConfirmChange;
    private javax.swing.JButton jbtConfirmDelete;
    private javax.swing.JButton jbtDeleteService;
    private javax.swing.JButton jbtModifyService;
    private javax.swing.JButton jbtView;
    private javax.swing.JLabel jlblDescrip;
    private javax.swing.JLabel jlblId;
    private javax.swing.JLabel jlblPrice;
    private javax.swing.JLabel jlblSearch;
    private javax.swing.JLabel jlblService;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JPanel jpAdd;
    private javax.swing.JPanel jpSearch;
    private javax.swing.JTable jtService;
    private javax.swing.JTextArea jtaDescrip;
    private javax.swing.JTextField jtfPrice;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfServiceId;
    private javax.swing.JTextField jtfTitle;
    // End of variables declaration//GEN-END:variables
}
