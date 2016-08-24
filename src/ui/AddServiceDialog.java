/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import control.MaintainService;
import control.MaintainStaff;
import domain.Service;
import domain.ServiceDetail;
import domain.Staff;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cheng
 */
public class AddServiceDialog extends javax.swing.JDialog {

    /**
     * Creates new form AddServiceDialog
     */
    
    private MaintainService serviceControl;
    private MaintainStaff staffControl;
    private ServiceDetail service;
    
    public AddServiceDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        serviceControl = new MaintainService();
        staffControl = new MaintainStaff();
        initComponents();
        setComboBoxOptions();
    }

    
    public void setComboBoxOptions(){
        ArrayList<Service> serviceList = serviceControl.searchRecord("",0);
        ArrayList<Staff> staffList = staffControl.searchRecord("",0);
        
        for(int i=0;i<serviceList.size();i++){
            jcbService.addItem(serviceList.get(i).getServiceTitle());
        }
        for(int i=0;i<staffList.size();i++){
            jcbStaff.addItem(staffList.get(i).getStaffName());
        }
    }
    
    public void fillFields (String serviceId, String staffName, String remarks){
        ArrayList<Service> serviceList = serviceControl.searchRecord(serviceId,1);
        ArrayList<Staff> staffList = staffControl.searchRecord(staffName,2);
        jcbService.setSelectedItem(serviceList.get(0));
        jcbStaff.setSelectedItem(staffList.get(0));
        jtaRemarks.setText(remarks);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblService = new javax.swing.JLabel();
        jlblStaff = new javax.swing.JLabel();
        jlblRemarks = new javax.swing.JLabel();
        jcbService = new javax.swing.JComboBox<>();
        jcbStaff = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaRemarks = new javax.swing.JTextArea();
        jbtConfirm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add or Modify Service Item");
        setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblService.setText("Service :");
        getContentPane().add(jlblService, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jlblStaff.setText("Staff :");
        getContentPane().add(jlblStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jlblRemarks.setText(" Remarks :");
        getContentPane().add(jlblRemarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        getContentPane().add(jcbService, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 130, -1));

        getContentPane().add(jcbStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, -1));

        jtaRemarks.setColumns(20);
        jtaRemarks.setRows(5);
        jScrollPane1.setViewportView(jtaRemarks);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 180, 110));

        jbtConfirm.setText("Confirm");
        jbtConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmActionPerformed(evt);
            }
        });
        getContentPane().add(jbtConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        jLabel1.setText("                ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmActionPerformed
        // TODO add your handling code here:
            service = new ServiceDetail();   
            
            //search record by pk 
            
            
            service.setService(serviceControl.searchRecord((String)jcbService.getSelectedItem(),2).get(0));
            service.setStaffIC(staffControl.searchRecord((String)jcbStaff.getSelectedItem(),2).get(0));
            service.setRemarks(jtaRemarks.getText());
            TransactionPanel.setService(service);
             JOptionPane.showMessageDialog(null,"Please click the refresh button to reflect the changes you've made.","Refresh!",JOptionPane.INFORMATION_MESSAGE);
            dispose();
    }//GEN-LAST:event_jbtConfirmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddServiceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddServiceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddServiceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddServiceDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddServiceDialog dialog = new AddServiceDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtConfirm;
    private javax.swing.JComboBox<String> jcbService;
    private javax.swing.JComboBox<String> jcbStaff;
    private javax.swing.JLabel jlblRemarks;
    private javax.swing.JLabel jlblService;
    private javax.swing.JLabel jlblStaff;
    private javax.swing.JTextArea jtaRemarks;
    // End of variables declaration//GEN-END:variables

    public ServiceDetail getService() {
        return service;
    }

    public void setService(ServiceDetail service) {
        this.service = service;
    }
    
    
}
