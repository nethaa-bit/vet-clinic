/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Cheng
 */
public class ChangePasswordPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChangePasswordPanel
     */
    public ChangePasswordPanel() {
        initComponents();
        jcbRecoveryQ.setEnabled(false);
        jtfRecoveryA.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblOld = new javax.swing.JLabel();
        jtfOld = new javax.swing.JPasswordField();
        jtfNew = new javax.swing.JPasswordField();
        jtfConfirm = new javax.swing.JPasswordField();
        jchkSetRecQ = new javax.swing.JCheckBox();
        jcbRecoveryQ = new javax.swing.JComboBox<>();
        jtfRecoveryA = new javax.swing.JTextField();
        jlblRecoveryA = new javax.swing.JLabel();
        jlblRecoveryQ = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        jlblConfirm = new javax.swing.JLabel();
        jlblNew = new javax.swing.JLabel();

        setBackground(new java.awt.Color(209, 169, 149));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblOld.setText("Old Password :");
        add(jlblOld, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));
        add(jtfOld, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 180, -1));
        add(jtfNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 180, -1));
        add(jtfConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 180, -1));

        jchkSetRecQ.setBackground(new java.awt.Color(209, 169, 149));
        jchkSetRecQ.setText("Set new recovery question and answer");
        jchkSetRecQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchkSetRecQActionPerformed(evt);
            }
        });
        add(jchkSetRecQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        jcbRecoveryQ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your first pet's name?", "What is your favourite colour?", "Where is your hometown?" }));
        add(jcbRecoveryQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 180, -1));
        add(jtfRecoveryA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 180, -1));

        jlblRecoveryA.setText("Recovery Answer   : ");
        add(jlblRecoveryA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        jlblRecoveryQ.setText("Recovery Question : ");
        add(jlblRecoveryQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        button1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        button1.setLabel("Confirm");
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 70, -1));

        jlblConfirm.setText("Confirm New Password :");
        add(jlblConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jlblNew.setText("New Password :");
        add(jlblNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jchkSetRecQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkSetRecQActionPerformed
        // TODO add your handling code here:
        
        if(jchkSetRecQ.isSelected()==true){
            jcbRecoveryQ.setEnabled(true);
            jtfRecoveryA.setEnabled(true);
        }
        else {
            jtfRecoveryA.setText("");
            jcbRecoveryQ.setEnabled(false);
            jtfRecoveryA.setEnabled(false);  

        
        }
    }//GEN-LAST:event_jchkSetRecQActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JComboBox<String> jcbRecoveryQ;
    private javax.swing.JCheckBox jchkSetRecQ;
    private javax.swing.JLabel jlblConfirm;
    private javax.swing.JLabel jlblNew;
    private javax.swing.JLabel jlblOld;
    private javax.swing.JLabel jlblRecoveryA;
    private javax.swing.JLabel jlblRecoveryQ;
    private javax.swing.JPasswordField jtfConfirm;
    private javax.swing.JPasswordField jtfNew;
    private javax.swing.JPasswordField jtfOld;
    private javax.swing.JTextField jtfRecoveryA;
    // End of variables declaration//GEN-END:variables
}
