/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Cheng
 */
public class PaymentPanel extends javax.swing.JPanel {

    /**
     * Creates new form PaymentPanel
     */
     public void setDynamicPanel() {
        JPanel targetPanel = new JPanel();
        if(MainMenu.action.equals("add")){
             targetPanel=jpAdd;
        }
        else if (MainMenu.action.equals("search")){
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
    
    public PaymentPanel() {
        initComponents();
        jTextField1.setOpaque(false);
        jTextField1.setBackground(new Color(255,255,255,127));
        jTextField1.setBorder(null);
        setDynamicPanel();
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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        dynamicPanel = new javax.swing.JPanel();
        jpAdd = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jpSearch = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 260, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 103));

        dynamicPanel.setLayout(new java.awt.CardLayout());

        jpAdd.setBackground(new java.awt.Color(204, 204, 255));
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Payment ID :");
        jpAdd.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jTextField2.setToolTipText("Enter payment ID");
        jpAdd.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 100, -1));

        jLabel3.setText("Amount Paid :");
        jpAdd.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        jTextField3.setToolTipText("Enter amount paid");
        jpAdd.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 80, -1));

        jLabel4.setText("Method Of Payment :");
        jpAdd.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Credit Card" }));
        jpAdd.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jLabel5.setText("Payment Date :");
        jpAdd.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        jLabel6.setText("Transaction ID :");
        jpAdd.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jTextField4.setToolTipText("Enter transaction ID");
        jpAdd.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 100, -1));

        jLabel7.setText("Staff IC :");
        jpAdd.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jTextField5.setToolTipText("Enter staff IC");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jpAdd.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 80, -1));

        jLabel8.setText("Credit Crad No. :");
        jpAdd.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jTextField6.setToolTipText("Enter credit card no.");
        jpAdd.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 140, -1));
        jpAdd.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        jButton1.setText("Add Payment");
        jpAdd.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        dynamicPanel.add(jpAdd, "card3");

        jpSearch.setBackground(new java.awt.Color(204, 204, 255));
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Payment ID", "Amount Paid", "Method of Payment", "Date", "Transaction ID", "Staff IC", "Credit Card No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jpSearch.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 690, 140));

        jButton5.setText("Modify Payment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jpSearch.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        jButton6.setText("Delete Payment");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jpSearch.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, -1));

        dynamicPanel.add(jpSearch, "card2");

        jPanel1.add(dynamicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 970, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel jpAdd;
    private javax.swing.JPanel jpSearch;
    // End of variables declaration//GEN-END:variables
}
