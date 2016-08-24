/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import domain.Pet;
import domain.TableModel;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author Cheng
 */
public class ViewPetsDialog extends javax.swing.JDialog {

    /**
     * Creates new form ViewPetsDialog
     */
    public ViewPetsDialog(java.awt.Frame parent, boolean modal, ArrayList<Pet> petList) {
        super(parent, modal);
        initComponents();
        setTableData(petList);
    }
    
    public void setTableData (ArrayList<Pet> petList){
 
        Object[][] data = new Object[100][10];
        for(int i=0; i<petList.size();i++){
            data[i] = petList.get(i).getObjectsSummary();
        } 
        String[] columnNames = {"Pet ID","Name","AnimalType","Birth Date","Gender"};
        TableModel tModel = new TableModel(data, columnNames);
        jtPets.setModel(tModel);  
        jtPets.createDefaultColumnsFromModel();
        jtPets.repaint();
} 
        

     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtPets = new javax.swing.JTable();
        jlblTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbtOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pets Summary");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/images/logo.png"))
        );
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtPets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtPets);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 520, 290));

        jlblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblTitle.setText("Pets Summary ");
        getContentPane().add(jlblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setText("       ");
        jLabel2.setName("Pets Summary"); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 30, 60));

        jLabel1.setText("For details of each pet, please search through the Pet module");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jbtOk.setText("OK");
        jbtOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOkActionPerformed(evt);
            }
        });
        getContentPane().add(jbtOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtOkActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtOkActionPerformed

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
            java.util.logging.Logger.getLogger(ViewPetsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPetsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPetsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPetsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewPetsDialog dialog = new ViewPetsDialog(new javax.swing.JFrame(), true, new ArrayList<Pet>());
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtOk;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JTable jtPets;
    // End of variables declaration//GEN-END:variables
}
