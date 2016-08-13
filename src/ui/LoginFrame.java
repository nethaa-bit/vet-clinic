/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.PasswordHash;
import java.awt.Color;
import javafx.scene.layout.Background;
import java.awt.Toolkit;
import control.MaintainStaff;
import domain.*;
import javax.swing.JOptionPane;

public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    MaintainStaff staffControl;
    public static Staff currentstaff;
    
    public LoginFrame() {
        initComponents();
        staffControl = new MaintainStaff();
        this.setLocationRelativeTo(null);
    }
    
    public void resetFields(){
    
        jtfPassword.setText("");
        jtfUsername.setText("");
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
        jtfUsername = new javax.swing.JTextField();
        jlblUsername = new javax.swing.JLabel();
        jlblPassword = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JPasswordField();
        jlblLogin2 = new javax.swing.JLabel();
        jlblLogin = new javax.swing.JLabel();
        jlblReset2 = new javax.swing.JLabel();
        jlblReset = new javax.swing.JLabel();
        jlblLogo = new javax.swing.JLabel();
        jlblTitle = new javax.swing.JLabel();
        jblForgot = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - Veterinary Clinic System");
        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/logo.png")));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfUsername.setToolTipText("Enter your username (staff IC) here");
        jtfUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(jtfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 140, 30));

        jlblUsername.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jlblUsername.setForeground(new java.awt.Color(255, 255, 255));
        jlblUsername.setText("Username :");
        jPanel1.add(jlblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jlblPassword.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jlblPassword.setForeground(new java.awt.Color(255, 255, 255));
        jlblPassword.setText("Password :");
        jPanel1.add(jlblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        jtfPassword.setToolTipText("Enter your password here");
        jtfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(jtfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 140, 30));

        jlblLogin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key.png"))); // NOI18N
        jlblLogin2.setToolTipText("Click to login.");
        jPanel1.add(jlblLogin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        jlblLogin.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jlblLogin.setForeground(new java.awt.Color(255, 255, 255));
        jlblLogin.setText("Login");
        jlblLogin.setToolTipText("Click to login.");
        jlblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblLoginMouseClicked(evt);
            }
        });
        jPanel1.add(jlblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        jlblReset2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        jlblReset2.setToolTipText("Click to reset above fields.");
        jlblReset2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblReset2MouseClicked(evt);
            }
        });
        jPanel1.add(jlblReset2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        jlblReset.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jlblReset.setForeground(new java.awt.Color(255, 255, 255));
        jlblReset.setText("Reset");
        jlblReset.setToolTipText("Click to reset above fields.");
        jlblReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblResetMouseClicked(evt);
            }
        });
        jPanel1.add(jlblReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        jlblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jlblLogo.setText("jLabel8");
        jPanel1.add(jlblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 64, 64));

        jlblTitle.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jlblTitle.setText("Animal Medical Centre\n");
        jlblTitle.setToolTipText("");
        jPanel1.add(jlblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        jblForgot.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jblForgot.setForeground(new java.awt.Color(255, 255, 255));
        jblForgot.setText("<html><u>Forgot Password?</u></html>");
        jblForgot.setToolTipText("Click to recover your password.");
        jblForgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jblForgotMouseClicked(evt);
            }
        });
        jPanel1.add(jblForgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login background.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 538, 401));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 280, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUsernameActionPerformed

    private void jtfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPasswordActionPerformed

    private void jblForgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jblForgotMouseClicked
        // TODO add your handling code here:
        PasswordRecoveryDialog d = new PasswordRecoveryDialog(this, false);
        d.setVisible(true);
    }//GEN-LAST:event_jblForgotMouseClicked

    private void jlblResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblResetMouseClicked
        // TODO add your handling code here:
        jtfPassword.setText("");
        jtfUsername.setText("");
    }//GEN-LAST:event_jlblResetMouseClicked

    private void jlblReset2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblReset2MouseClicked
        // TODO add your handling code here:
        jlblResetMouseClicked(evt);
    }//GEN-LAST:event_jlblReset2MouseClicked

    private void jlblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblLoginMouseClicked
        // TODO add your handling code here:
        
        if(validateLogin()==true){
        MainMenu m =new MainMenu();
        m.setVisible(true);
        this.setVisible(false);
        }
        else{
            
        JOptionPane.showMessageDialog(null,"Login unsuccessful. Please enter correct credentials.","Access Denied",JOptionPane.ERROR_MESSAGE);  
        jtfPassword.setText("");
        jtfUsername.setText("");
        }
        
    }//GEN-LAST:event_jlblLoginMouseClicked

    private boolean validateLogin(){
        
        boolean valid=false;
        
        String username = jtfUsername.getText();
        String password = String.copyValueOf(jtfPassword.getPassword());
        currentstaff = staffControl.searchRecord(username);
        String hash = currentstaff.getPassword();

        
        if(currentstaff!=null){
            
            try{
                valid = PasswordHash.validatePassword(password,hash );
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage(),"Failure",JOptionPane.ERROR_MESSAGE);
            }    
        }
        
        return valid;
    }
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jblForgot;
    private javax.swing.JLabel jlblLogin;
    private javax.swing.JLabel jlblLogin2;
    private javax.swing.JLabel jlblLogo;
    private javax.swing.JLabel jlblPassword;
    private javax.swing.JLabel jlblReset;
    private javax.swing.JLabel jlblReset2;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JLabel jlblUsername;
    private javax.swing.JPasswordField jtfPassword;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}
