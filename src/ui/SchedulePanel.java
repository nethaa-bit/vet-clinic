/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import control.MaintainSchedule;
import domain.Schedule;
import domain.TableModel;
import java.awt.Color;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cheng
 */
public class SchedulePanel extends javax.swing.JPanel {

    
    
        MaintainSchedule scheduleControl;
        ArrayList<String> appStatuses;
    /**
     * Creates new form SchedulePanel
     */
        public void setDynamicPanel() {
        JPanel targetPanel = new JPanel();
        if(MainMenu.action.equals("add")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(false);
             jbtAddApp.setVisible(true);
        }
        else if (MainMenu.action.equals("search")){
            targetPanel=jpSearch;
            jbtDeleteAppointment.setVisible(false);
            jbtModifyAppointment.setVisible(false);
            jbtView.setVisible(true);
        }
        else if(MainMenu.action.equals("modifySelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(true);
             jbtConfirmDelete.setVisible(false);
             jbtAddApp.setVisible(false);
        
        }else if(MainMenu.action.equals("deleteSelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(true);
             jbtAddApp.setVisible(false);
             
        }else if(MainMenu.action.equals("modify")){
                targetPanel=jpSearch;
                jbtDeleteAppointment.setVisible(false);
                jbtModifyAppointment.setVisible(true);
                jbtView.setVisible(false);
        }
        else if(MainMenu.action.equals("delete")){
                targetPanel=jpSearch;
                jbtDeleteAppointment.setVisible(true);
                jbtModifyAppointment.setVisible(false);
                jbtView.setVisible(false);
        }else if(MainMenu.action.equals("viewSelected")){
             targetPanel=jpAdd;
             jbtConfirmChange.setVisible(false);
             jbtConfirmDelete.setVisible(false);
             jbtAddApp.setVisible(false);

        }
        
        dynamicPanel.removeAll();
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
            
        //Adding Pannel
        dynamicPanel.add(targetPanel);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }
        
public void fillFields(Schedule schedule){
         
    jtfCusName.setText(schedule.getCustName());
    jtfCusPhoneNum.setText(schedule.getCustPhoneNum());
    jtfAppID.setText(schedule.getAppID());
    Date apptime = (Date)schedule.getAppTime();
    Calendar cal = Calendar.getInstance();
    cal.setTime(apptime);
    jcbHours.setSelectedItem(""+cal.get(Calendar.HOUR));
    jcbMin.setSelectedItem(""+cal.get(Calendar.MINUTE));
    jdpAppDate.setDate(schedule.getAppDate());

}
         
public void disableFields(){

  jtfAppID.setEditable(false);
  jtfCusName.setEditable(false);
  jdpAppDate.setEnabled(false);
  jtfCusName.setEditable(false);
  jtfCusPhoneNum.setEditable(false);
}
        
    public SchedulePanel() {
        initComponents();
        appStatuses = new ArrayList<String>();
        appStatuses.add("open");
        appStatuses.add("cancelled");
        appStatuses.add("completed");
        scheduleControl = new MaintainSchedule();
        jtfSearch.setOpaque(false);
        jtfSearch.setBackground(new Color(255,255,255,127));
//        jtfSearch.setBorder(null);
        setDynamicPanel();
    }

    public Schedule validateInput(){
    
    Schedule schedule=null;
    boolean valid =true; 
    
    String custName = jtfCusName.getText();
    String custPhoneNum = jtfCusPhoneNum.getText();
    String appID = jtfAppID.getText();
    int hours = Integer.parseInt((String)jcbHours.getSelectedItem());
    int minutes = Integer.parseInt((String)jcbMin.getSelectedItem());
    
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.MINUTE, minutes);
    cal.set(Calendar.HOUR, hours);
    Date at = cal.getTime();
    Time appTime = new Time(at.getTime());
    Date appDate = jdpAppDate.getDate();

    
    valid = custName.equals("")?false:true; //need
    valid = appID.equals("")?false:true;
    if(!Pattern.matches("\\d{2,4}-\\d{7,8}", custPhoneNum)){valid =false;} //need if got phone number
    
     if(valid==true){
        
           
           schedule = new Schedule(appID,appTime, appDate, custName,custPhoneNum,"Open");
    }
    else{
       schedule=null;
    }
         
         return schedule;
    }
    
    public void resetFields(){
    
    jtfCusName.setText("");
    jtfCusPhoneNum.setText("");
    jtfSearch.setText("");
    jtfAppID.setText("");
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
        jlblSchedule = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jlblSearch1 = new javax.swing.JLabel();
        jtfSearch1 = new javax.swing.JTextField();
        jlblSchedule1 = new javax.swing.JLabel();
        dynamicPanel = new javax.swing.JPanel();
        jpSearch = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtSchedule = new javax.swing.JTable();
        jbtModifyAppointment = new javax.swing.JButton();
        jbtDeleteAppointment = new javax.swing.JButton();
        jbtView = new javax.swing.JButton();
        jpAdd = new javax.swing.JPanel();
        jlblID = new javax.swing.JLabel();
        jtfAppID = new javax.swing.JTextField();
        jlblAppTime = new javax.swing.JLabel();
        jlblAppDate = new javax.swing.JLabel();
        jlblCustPhoneNum = new javax.swing.JLabel();
        jlblCustName = new javax.swing.JLabel();
        jtfCusPhoneNum = new javax.swing.JTextField();
        jtfCusName = new javax.swing.JTextField();
        jdpAppDate = new com.toedter.calendar.JDateChooser();
        jcbHours = new javax.swing.JComboBox<>();
        jlbmins = new javax.swing.JLabel();
        jcbMin = new javax.swing.JComboBox<>();
        jbtAddApp = new javax.swing.JButton();
        jbtConfirmChange = new javax.swing.JButton();
        jbtConfirmDelete = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jlblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSearchMouseClicked(evt);
            }
        });
        jPanel2.add(jlblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });
        jPanel2.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 260, 30));

        jlblSchedule.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlblSchedule.setText("Schedule");
        jPanel2.add(jlblSchedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 98));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblSearch1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jlblSearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSearch1MouseClicked(evt);
            }
        });
        jPanel3.add(jlblSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        jtfSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearch1ActionPerformed(evt);
            }
        });
        jPanel3.add(jtfSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 260, 30));

        jlblSchedule1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlblSchedule1.setText("Schedule");
        jPanel3.add(jlblSchedule1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 98));

        dynamicPanel.setLayout(new java.awt.CardLayout());

        jpSearch.setBackground(new java.awt.Color(204, 255, 204));
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Staff IC", "Time Slot Number", "Apppointment Time", "Appointment Date", "Customer Name", "Phone Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtSchedule);

        jpSearch.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 620, 180));

        jbtModifyAppointment.setText("Modify Schedule");
        jbtModifyAppointment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtModifyAppointmentMouseClicked(evt);
            }
        });
        jbtModifyAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModifyAppointmentActionPerformed(evt);
            }
        });
        jpSearch.add(jbtModifyAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, -1, -1));

        jbtDeleteAppointment.setText("Delete Schedule");
        jbtDeleteAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteAppointmentActionPerformed(evt);
            }
        });
        jpSearch.add(jbtDeleteAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        jbtView.setText("View Schedule");
        jbtView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewActionPerformed(evt);
            }
        });
        jpSearch.add(jbtView, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        dynamicPanel.add(jpSearch, "card2");

        jpAdd.setBackground(new java.awt.Color(204, 255, 204));
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblID.setText("Appointment ID:");
        jpAdd.add(jlblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jtfAppID.setToolTipText("Enter staff IC");
        jtfAppID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAppIDActionPerformed(evt);
            }
        });
        jpAdd.add(jtfAppID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 120, -1));

        jlblAppTime.setText("Appointment Time :");
        jpAdd.add(jlblAppTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jlblAppDate.setText("Appointment Date :");
        jpAdd.add(jlblAppDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 110, -1));

        jlblCustPhoneNum.setText("Customer Phone No. :");
        jpAdd.add(jlblCustPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 120, -1));

        jlblCustName.setText("Customer Name :");
        jpAdd.add(jlblCustName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 90, -1));
        jpAdd.add(jtfCusPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 100, -1));
        jpAdd.add(jtfCusName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 120, -1));
        jpAdd.add(jdpAppDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 100, -1));

        jcbHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08", "09", "10", "11", "12", "13", "14", "15", "16", "17" }));
        jcbHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbHoursActionPerformed(evt);
            }
        });
        jpAdd.add(jcbHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        jlbmins.setText("hours                minutes");
        jpAdd.add(jlbmins, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 150, 20));

        jcbMin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "15", "30", "45" }));
        jpAdd.add(jcbMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        jbtAddApp.setText("Add Appointment");
        jbtAddApp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtAddAppMouseClicked(evt);
            }
        });
        jbtAddApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddAppActionPerformed(evt);
            }
        });
        jpAdd.add(jbtAddApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        jbtConfirmChange.setText("Confirm Changes");
        jbtConfirmChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmChangeActionPerformed(evt);
            }
        });
        jpAdd.add(jbtConfirmChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        jbtConfirmDelete.setText("Confirm Delete");
        jbtConfirmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmDeleteActionPerformed(evt);
            }
        });
        jpAdd.add(jbtConfirmDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        dynamicPanel.add(jpAdd, "card3");

        jPanel1.add(dynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 94, 940, 430));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSearchActionPerformed

    private void jlblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSearchMouseClicked
        // TODO add your handling code here:
        //I used all my 洪荒之力 to make this method 

        jtSchedule.setModel(new DefaultTableModel());
        jtSchedule.repaint();
        
        if(MainMenu.action == "modifySelected"){
            MainMenu.action="modify";
        }
        else if(MainMenu.action == "deleteSelected"){
            MainMenu.action="delete";
        }else if(MainMenu.action == "add"||MainMenu.action == "viewSelected" ){
               MainMenu.action="search";
        }
        
        String queryStr =jtfSearch.getText();
        int option =0;
        

            if(Pattern.matches("M\\d+", queryStr)){
                option=1;
            }
            else if(Pattern.matches("T\\d+", queryStr)){
                option=2;
            }else if(Pattern.matches("\\d{2,4}-\\d{7,8}", queryStr)){
                option=3;
            }else if(appStatuses.contains(queryStr.toLowerCase())){
                option=5;
            }else{
                option=4;
            }
            ArrayList<Schedule> scheduleList = scheduleControl.searchRecord(queryStr,option);

    //        MainMenu.action="search";
            setDynamicPanel();
            if(scheduleList.size()!=0&&scheduleList!=null){
                Object[][] data = new Object[100][8];
                for(int i=0; i<scheduleList.size();i++){
                data[i] = scheduleList.get(i).getObjects();
                    Time time = (Time)data[i][1];
                    DateFormat formatter = new SimpleDateFormat("HH:mm");
                    String timeFormatted = formatter.format(time);
                    data [i][1] = timeFormatted;
                } 
                String[] columnNames = {"Appointment ID","Time","Date","Name","Phone No","Status"};
                TableModel tModel = new TableModel(data, columnNames);
                jtSchedule.setModel(tModel);  
                jtSchedule.createDefaultColumnsFromModel();
                jtSchedule.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "No results found!" , "No such record.", JOptionPane.ERROR_MESSAGE);
            }     
    }//GEN-LAST:event_jlblSearchMouseClicked

    private void jlblSearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSearch1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlblSearch1MouseClicked

    private void jtfSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSearch1ActionPerformed

    private void jbtConfirmDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmDeleteActionPerformed
        // TODO add your handling code here:
        Schedule schedule = validateInput();
        if(schedule!=null){
            Schedule s = scheduleControl.searchRecord(schedule.getAppID());

            if(s == null)
            {
                JOptionPane.showMessageDialog(null,"This appointment does not exist.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                s = schedule;
                int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Are you sure you want delete appointment "+schedule.getAppID()+" ?", "Confirm delete?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

                if(reply==JOptionPane.YES_OPTION){
                    try{
                        scheduleControl.deleteRecord(s.getAppID());
                        resetFields();
                        JOptionPane.showMessageDialog(null,"Appointment "+ schedule.getAppID()+" has been deleted.","Success",JOptionPane.INFORMATION_MESSAGE);
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

    private void jbtAddAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddAppActionPerformed
        // TODO add your handling code here:
        Schedule schedule = validateInput();
        if(schedule!=null){
            //write to database

            Schedule s = scheduleControl.searchRecord(schedule.getAppID());

            if(s != null)
            {
                JOptionPane.showMessageDialog(null,"This schedule already exist.", "Duplicate Record", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                s = schedule;
                try{
                    scheduleControl.addRecord(s);
                    resetFields();
                    JOptionPane.showMessageDialog(null,"New appointment has been added.","Success",JOptionPane.INFORMATION_MESSAGE);
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
    }//GEN-LAST:event_jbtAddAppActionPerformed

    private void jbtAddAppMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtAddAppMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtAddAppMouseClicked

    private void jcbHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbHoursActionPerformed

    private void jtfAppIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAppIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAppIDActionPerformed

    private void jbtViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewActionPerformed
        // TODO add your handling code here:
        MainMenu.action="viewSelected";
        Schedule selectedSchedule=null;
        if(jtSchedule.getSelectedRow()>=0 ) {
            String ic  = (String) jtSchedule.getValueAt(jtSchedule.getSelectedRow(),0);
            selectedSchedule = scheduleControl.searchRecord(ic);
            if(selectedSchedule!=null){
                setDynamicPanel();
                fillFields(selectedSchedule);
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

    private void jbtDeleteAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteAppointmentActionPerformed
        // TODO add your handling code here:
       MainMenu.action="deleteSelected";
       Schedule selectedSchedule=null;
       if(jtSchedule.getSelectedRow()>=0 ) {
           String id  = (String) jtSchedule.getValueAt(jtSchedule.getSelectedRow(),0);
           selectedSchedule = scheduleControl.searchRecord(id);
           if(selectedSchedule!=null){
                setDynamicPanel();
                fillFields(selectedSchedule); 
                disableFields();
                
           }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jbtDeleteAppointmentActionPerformed

    private void jbtModifyAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModifyAppointmentActionPerformed
        // TODO add your handling code here:
        MainMenu.action="modifySelected";
       Schedule selectedschedule=null;
       if(jtSchedule.getSelectedRow()>=0 ) {
           String id  = (String) jtSchedule.getValueAt(jtSchedule.getSelectedRow(),0);
           selectedschedule = scheduleControl.searchRecord(id);
           if(selectedschedule!=null){
                setDynamicPanel();
                fillFields(selectedschedule);
           }
            else{
                JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
       }
       else{
           JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
       }
       
    }//GEN-LAST:event_jbtModifyAppointmentActionPerformed

    private void jbtModifyAppointmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtModifyAppointmentMouseClicked
        // TODO add your handling code here:
        MainMenu.action="modifySelected";
        Schedule selectedSchedule=null;
        if(jtSchedule.getSelectedRow()>=0 ) {
            String ic  = (String) jtSchedule.getValueAt(jtSchedule.getSelectedRow(),0);
            selectedSchedule= scheduleControl.searchRecord(ic);
            if(selectedSchedule!=null){
                setDynamicPanel();
                fillFields(selectedSchedule);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Please search and select the record you wish to modify","Empty selection",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jbtModifyAppointmentMouseClicked

    private void jbtConfirmChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmChangeActionPerformed
        // TODO add your handling code here:
         Schedule schedule = validateInput();
        if(schedule!=null){
         //write to database ****
                Schedule s = scheduleControl.searchRecord(schedule.getAppID());
                
                if(s == null)
                {
                    JOptionPane.showMessageDialog(null,"This schedule does not exist.", "Record Not Found", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
//                    p = pet;
                    int reply =JOptionPane.showConfirmDialog(this.getParent().getParent().getParent(), "Are you sure you want commit the changes made?", "Confirm changes?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            
                    if(reply==JOptionPane.YES_OPTION){
                        try{
                            scheduleControl.updateRecord(schedule);
                            resetFields();
                            JOptionPane.showMessageDialog(null,"Schedule details of schedule "+ schedule.getAppID()+" has been updated.","Success",JOptionPane.INFORMATION_MESSAGE);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAddApp;
    private javax.swing.JButton jbtConfirmChange;
    private javax.swing.JButton jbtConfirmDelete;
    private javax.swing.JButton jbtDeleteAppointment;
    private javax.swing.JButton jbtModifyAppointment;
    private javax.swing.JButton jbtView;
    private javax.swing.JComboBox<String> jcbHours;
    private javax.swing.JComboBox<String> jcbMin;
    private com.toedter.calendar.JDateChooser jdpAppDate;
    private javax.swing.JLabel jlblAppDate;
    private javax.swing.JLabel jlblAppTime;
    private javax.swing.JLabel jlblCustName;
    private javax.swing.JLabel jlblCustPhoneNum;
    private javax.swing.JLabel jlblID;
    private javax.swing.JLabel jlblSchedule;
    private javax.swing.JLabel jlblSchedule1;
    private javax.swing.JLabel jlblSearch;
    private javax.swing.JLabel jlblSearch1;
    private javax.swing.JLabel jlbmins;
    private javax.swing.JPanel jpAdd;
    private javax.swing.JPanel jpSearch;
    private javax.swing.JTable jtSchedule;
    private javax.swing.JTextField jtfAppID;
    private javax.swing.JTextField jtfCusName;
    private javax.swing.JTextField jtfCusPhoneNum;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfSearch1;
    // End of variables declaration//GEN-END:variables
}
