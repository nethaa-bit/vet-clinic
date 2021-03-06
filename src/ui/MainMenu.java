
package ui;


import domain.Staff;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainMenu extends javax.swing.JFrame {

    public static String action ="";
    private String panelTitle;
    private String actionTitle;
    private String systemTitle="Veterinary Clinic System";;
    private Staff currentStaff = LoginFrame.getCurrentstaff();
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        setDefaultPanel();
        panelTitle="Main Menu";
        actionTitle="";
        systemTitle="Veterinary Clinic System";
        jlblWelcome.setText("Welcome, "+currentStaff.getStaffName());
        this.setTitle(panelTitle+" - "+systemTitle);
        addPopupOptions(jPopupMenu1,"staff");
        addPopupOptions(jPopupMenu2,"appointment");
        addPopupOptions(jPopupMenu3,"pet");
        addPopupOptions(jPopupMenu4,"customer");
        addPopupOptions(jPopupMenu5,"service");
        addPopupOptions(jPopupMenu6,"transaction");
        addPopupOptions(jPopupMenu7,"payment");
        
        
//        JMenuItem sumRep = new JMenuItem("Generate summary report");
//        JMenuItem excRep = new JMenuItem("Generate exception report");
//        JMenuItem detRep = new JMenuItem("Generate detail report");
        JMenuItem calcBil = new JMenuItem("Generate bill");
        JMenuItem changePw = new JMenuItem("Change password");
        
        calcBil.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    action="bill";
                    jpContent.removeAll();
                    jpContent.repaint();
                    jpContent.revalidate();
            
                    //Adding Pannel
                    jpContent.add(new PaymentPanel());
                    jpContent.repaint();
                    jpContent.revalidate();
                    setTitle("Generate Bill - Veterinary Clinic System");
                }
        });
        changePw.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jpContent.removeAll();
                    jpContent.repaint();
                    jpContent.revalidate();
            
                    //Adding Pannel
                    jpContent.add(new ChangePasswordPanel());
                    jpContent.repaint();
                    jpContent.revalidate();
                    setTitle("Change Password - Veterinary Clinic System");
                }
        });
        
        jPopupMenu7.add(calcBil);
        //
//        jPopupMenu8.add(detRep);
//        jPopupMenu8.add(excRep);
//        jPopupMenu8.add(sumRep);
//        jPopupMenu9.add(auth);
        jPopupMenu9.add(changePw);
        
        this.setLocationRelativeTo(null);
        
    }
    
    public void setFrameTitle(String title){
        this.setTitle(title);
    }
    private void addPopupOptions(javax.swing.JPopupMenu jp, String moduleObject){
        
        JMenuItem addItem = new JMenuItem("Add new "+moduleObject);
        JMenuItem modifyItem = new JMenuItem("Modify existing "+moduleObject);
        JMenuItem deleteItem = new JMenuItem("Delete existing "+moduleObject);
        JMenuItem searchItem = new JMenuItem("Search for "+moduleObject);
        JMenuItem[] menuItems={addItem, searchItem, modifyItem, deleteItem};
        
        
        
        for(int i=0; i<menuItems.length;i++){
            jp.add(menuItems[i]);
            
            menuItems[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                JPanel targetPanel= new DefaultPanel();
                
                if(e.getSource()==addItem){
                    
                    action="add";
                    actionTitle="Add";
                }
                else if (e.getSource()==searchItem){
                    action="search";
                    actionTitle="Search";
                }else if(e.getSource()==modifyItem){
                    action="modify";
                    actionTitle="Modify";
                }else if(e.getSource()==deleteItem){
                    action="delete";
                    actionTitle="Delete";
                }
                
                
                
                if(moduleObject.equals("staff")){ 
                    targetPanel= new StaffPanel();
                    
                }
                else if(moduleObject.equals("customer")){ 
                    targetPanel= new CustomerPanel();
                }
                else if(moduleObject.equals("transaction")){
                    targetPanel= new TransactionPanel();
                }
                else if(moduleObject.equals("service")){
                    targetPanel= new ServicePanel();
                }
                else if(moduleObject.equals("appointment")){
                    targetPanel= new SchedulePanel();
                }
                else if(moduleObject.equals("pet")){
                    targetPanel= new PetPanel();
                }
                else if(moduleObject.equals("payment")){
                    targetPanel= new PaymentPanel();
                }
                
                //Set Frame Title
                if(targetPanel instanceof StaffPanel){ 
                    panelTitle = "Staff";                   
                }
                else if(targetPanel instanceof CustomerPanel){ 
                    panelTitle = "Customer";
                }
                else if(targetPanel instanceof TransactionPanel){
                    panelTitle = "Transaction";
                }
                else if(targetPanel instanceof ServicePanel){
                    panelTitle = "Service";
                }
                else if(targetPanel instanceof SchedulePanel){
                    panelTitle = "Appointment";
                }
                else if(targetPanel instanceof PetPanel){
                    panelTitle = "Pet";
                }
                else if(targetPanel instanceof PaymentPanel){
                    panelTitle = "Payment";;
                } 
                
                //Remove all panel
                jpContent.removeAll();
                jpContent.repaint();
                jpContent.revalidate();
            
                //Adding Pannel
                jpContent.add(targetPanel);
                jpContent.repaint();
                jpContent.revalidate();      
                setFrameTitle(actionTitle +" "+panelTitle+" - "+systemTitle);
                
                
                }
                
            }
            );
            
        }
        //Remove Modify and Delete functions from Payment 
        if(moduleObject.equals("payment")){
            jp.remove(modifyItem);
            jp.remove(deleteItem);
        }
        
        
    };
    private void setDefaultPanel(){
        jpContent.removeAll();
        jpContent.repaint();
        jpContent.revalidate();
        jpContent.add(new DefaultPanel());
        jpContent.repaint();
        jpContent.revalidate();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jPopupMenu5 = new javax.swing.JPopupMenu();
        jPopupMenu6 = new javax.swing.JPopupMenu();
        jPopupMenu7 = new javax.swing.JPopupMenu();
        jPopupMenu8 = new javax.swing.JPopupMenu();
        jPopupMenu9 = new javax.swing.JPopupMenu();
        jpMain = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jpMenu = new javax.swing.JPanel();
        jlblSec = new javax.swing.JLabel();
        jlblReport = new javax.swing.JLabel();
        jlblPayment = new javax.swing.JLabel();
        jlblStaff = new javax.swing.JLabel();
        jlblService = new javax.swing.JLabel();
        jlblCust = new javax.swing.JLabel();
        jlblTrans = new javax.swing.JLabel();
        jlblSchedule = new javax.swing.JLabel();
        jlblPet = new javax.swing.JLabel();
        jlblStaffIcon = new javax.swing.JLabel();
        jlblIcon = new javax.swing.JLabel();
        jlblTitle = new javax.swing.JLabel();
        jlblScheduleIcon = new javax.swing.JLabel();
        jlblPetIcon = new javax.swing.JLabel();
        jlblCustIcon = new javax.swing.JLabel();
        jlblServiceIcon = new javax.swing.JLabel();
        jlblPaymentIcon = new javax.swing.JLabel();
        jlblSecIcon = new javax.swing.JLabel();
        jlblTransIcon = new javax.swing.JLabel();
        jlblReportIcon = new javax.swing.JLabel();
        jpContent = new javax.swing.JPanel();
        jlblWelcome = new javax.swing.JLabel();

        jPopupMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPopupMenu1MouseClicked(evt);
            }
        });
        jPopupMenu1.getAccessibleContext().setAccessibleDescription("");
        jPopupMenu1.getAccessibleContext().setAccessibleParent(jlblStaff);

        jPopupMenu2.getAccessibleContext().setAccessibleParent(jlblSchedule);

        jPopupMenu3.getAccessibleContext().setAccessibleParent(jlblPet);

        jPopupMenu4.getAccessibleContext().setAccessibleParent(jlblCust);

        jPopupMenu5.getAccessibleContext().setAccessibleParent(jlblService);

        jPopupMenu6.getAccessibleContext().setAccessibleParent(jlblTrans);

        jPopupMenu7.getAccessibleContext().setAccessibleParent(jlblPayment);

        jPopupMenu8.getAccessibleContext().setAccessibleParent(jlblReport);

        jPopupMenu9.getAccessibleContext().setAccessibleParent(jlblSec);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/images/logo.png"))
        );

        jpMain.setBackground(new java.awt.Color(255, 255, 255));
        jpMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exit.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jpMain.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 60, -1));

        jpMenu.setBackground(new java.awt.Color(255, 255, 255));
        jpMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblSec.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jlblSec.setText("Security");
        jlblSec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSecMouseClicked(evt);
            }
        });
        jpMenu.add(jlblSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 50, -1));

        jlblReport.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jlblReport.setText(" Report");
        jlblReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblReportMouseClicked(evt);
            }
        });
        jpMenu.add(jlblReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 40, -1));

        jlblPayment.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jlblPayment.setText("Payment");
        jlblPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblPaymentMouseClicked(evt);
            }
        });
        jpMenu.add(jlblPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, -1));

        jlblStaff.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jlblStaff.setText("Staff");
        jlblStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblStaffMouseClicked(evt);
            }
        });
        jpMenu.add(jlblStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jlblService.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jlblService.setText("Service");
        jlblService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblServiceMouseClicked(evt);
            }
        });
        jpMenu.add(jlblService, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        jlblCust.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jlblCust.setText("Customer");
        jlblCust.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblCustMouseClicked(evt);
            }
        });
        jpMenu.add(jlblCust, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jlblTrans.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jlblTrans.setText("Transaction");
        jlblTrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblTransMouseClicked(evt);
            }
        });
        jpMenu.add(jlblTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        jlblSchedule.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jlblSchedule.setText("Schedule");
        jlblSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblScheduleMouseClicked(evt);
            }
        });
        jpMenu.add(jlblSchedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jlblPet.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jlblPet.setText("Pet");
        jlblPet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblPetMouseClicked(evt);
            }
        });
        jpMenu.add(jlblPet, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 30, -1));

        jlblStaffIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Staff.png"))); // NOI18N
        jlblStaffIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblStaffIconMouseClicked(evt);
            }
        });
        jpMenu.add(jlblStaffIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jlblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        jlblIcon.setText("jLabel8");
        jlblIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblIconMouseClicked(evt);
            }
        });
        jpMenu.add(jlblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 64));

        jlblTitle.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        jlblTitle.setText(" AMC");
        jlblTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblTitleMouseClicked(evt);
            }
        });
        jpMenu.add(jlblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, -1));

        jlblScheduleIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Schedule.png"))); // NOI18N
        jlblScheduleIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblScheduleIconMouseClicked(evt);
            }
        });
        jpMenu.add(jlblScheduleIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jlblPetIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pet.png"))); // NOI18N
        jlblPetIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblPetIconMouseClicked(evt);
            }
        });
        jpMenu.add(jlblPetIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jlblCustIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Customer.png"))); // NOI18N
        jlblCustIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblCustIconMouseClicked(evt);
            }
        });
        jpMenu.add(jlblCustIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jlblServiceIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/service (1).png"))); // NOI18N
        jlblServiceIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblServiceIconMouseClicked(evt);
            }
        });
        jpMenu.add(jlblServiceIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jlblPaymentIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Payment.png"))); // NOI18N
        jlblPaymentIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblPaymentIconMouseClicked(evt);
            }
        });
        jpMenu.add(jlblPaymentIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        jlblSecIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Security.png"))); // NOI18N
        jlblSecIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSecIconMouseClicked(evt);
            }
        });
        jpMenu.add(jlblSecIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        jlblTransIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Transaction.png"))); // NOI18N
        jlblTransIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblTransIconMouseClicked(evt);
            }
        });
        jpMenu.add(jlblTransIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jlblReportIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Report.png"))); // NOI18N
        jlblReportIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblReportIconMouseClicked(evt);
            }
        });
        jpMenu.add(jlblReportIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        jpMain.add(jpMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 820, 114));

        jpContent.setBackground(new java.awt.Color(255, 255, 255));
        jpContent.setMinimumSize(new java.awt.Dimension(800, 430));
        jpContent.setLayout(new java.awt.CardLayout());
        jpMain.add(jpContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 820, 480));

        jlblWelcome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblWelcome.setText("Welcome, Xiao Liow");
        jpMain.add(jlblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    private void jlblStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblStaffMouseClicked
        // TODO add your handling code here:
         jPopupMenu1.show(evt.getComponent(), 0, 15);   
        
    }//GEN-LAST:event_jlblStaffMouseClicked

    private void jlblStaffIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblStaffIconMouseClicked
        // TODO add your handling code here:
        evt.setSource(jlblStaff);
        jlblStaffMouseClicked(evt);
    }//GEN-LAST:event_jlblStaffIconMouseClicked

    private void jlblScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblScheduleMouseClicked
        jPopupMenu2.show(evt.getComponent(), 0, 15);
    }//GEN-LAST:event_jlblScheduleMouseClicked

    private void jlblScheduleIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblScheduleIconMouseClicked
        // TODO add your handling code here:
        evt.setSource(jlblSchedule);
        jlblScheduleMouseClicked(evt);
    }//GEN-LAST:event_jlblScheduleIconMouseClicked

    private void jlblPetIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblPetIconMouseClicked
        evt.setSource(jlblPet);
        jlblPetMouseClicked(evt);
    }//GEN-LAST:event_jlblPetIconMouseClicked

    private void jlblPetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblPetMouseClicked
        jPopupMenu3.show(evt.getComponent(), 0, 15);
    }//GEN-LAST:event_jlblPetMouseClicked

    private void jlblCustIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblCustIconMouseClicked
        evt.setSource(jlblCust);
        jlblCustMouseClicked(evt);
    }//GEN-LAST:event_jlblCustIconMouseClicked

    private void jlblServiceIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblServiceIconMouseClicked
        evt.setSource(jlblService);
        jlblServiceMouseClicked(evt);
    }//GEN-LAST:event_jlblServiceIconMouseClicked

    private void jlblTransIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblTransIconMouseClicked
        // TODO add your handling code here:
        evt.setSource(jlblTrans);
        jlblTransMouseClicked(evt);
    }//GEN-LAST:event_jlblTransIconMouseClicked

    private void jlblPaymentIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblPaymentIconMouseClicked
        // TODO add your handling code here:
        evt.setSource(jlblPayment);
        jlblPaymentMouseClicked(evt);
    }//GEN-LAST:event_jlblPaymentIconMouseClicked

    private void jlblPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblPaymentMouseClicked
        // TODO add your handling code here:
        jPopupMenu7.show(evt.getComponent(), 0, 15);
    }//GEN-LAST:event_jlblPaymentMouseClicked

    private void jlblCustMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblCustMouseClicked
        // TODO add your handling code here:
        jPopupMenu4.show(evt.getComponent(), 0, 15);
    }//GEN-LAST:event_jlblCustMouseClicked

    private void jlblServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblServiceMouseClicked
        // TODO add your handling code here:
        jPopupMenu5.show(evt.getComponent(), 0, 15);
    }//GEN-LAST:event_jlblServiceMouseClicked

    private void jlblTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblTransMouseClicked
        // TODO add your handling code here:
         jPopupMenu6.show(evt.getComponent(), 0, 15);
    }//GEN-LAST:event_jlblTransMouseClicked

    private void jlblReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblReportMouseClicked
        // TODO add your handling code here:
        jpContent.removeAll();
        jpContent.repaint();
        jpContent.revalidate();
            
        //Adding Pannel
        jpContent.add(new ReportPanel());
        jpContent.repaint();
        jpContent.revalidate();
        
        setTitle("Generate Report - Veterinary Clinic System");
    }//GEN-LAST:event_jlblReportMouseClicked

    private void jlblSecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSecMouseClicked
        // TODO add your handling code here:
        jPopupMenu9.show(evt.getComponent(), 0, 15);
    }//GEN-LAST:event_jlblSecMouseClicked

    private void jlblReportIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblReportIconMouseClicked
        // TODO add your handling code here:
        evt.setSource(jlblReport);
        jlblReportMouseClicked(evt);
    }//GEN-LAST:event_jlblReportIconMouseClicked

    private void jlblSecIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSecIconMouseClicked
        // TODO add your handling code here:
        evt.setSource(jlblSec);
        jlblSecMouseClicked(evt);
    }//GEN-LAST:event_jlblSecIconMouseClicked

    private void jPopupMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPopupMenu1MouseClicked

    }//GEN-LAST:event_jPopupMenu1MouseClicked

    private void jlblIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblIconMouseClicked
        // TODO add your handling code here:
                jpContent.removeAll();
                jpContent.repaint();
                jpContent.revalidate();
            
                //Adding Pannel
                jpContent.add(new DefaultPanel());
                jpContent.repaint();
                jpContent.revalidate();         
    }//GEN-LAST:event_jlblIconMouseClicked

    private void jlblTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblTitleMouseClicked
        // TODO add your handling code here:
        jlblIconMouseClicked(evt);
    }//GEN-LAST:event_jlblTitleMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        //call new login frame
        
        JFrame l = new LoginFrame();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    
    
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

           
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JPopupMenu jPopupMenu5;
    private javax.swing.JPopupMenu jPopupMenu6;
    private javax.swing.JPopupMenu jPopupMenu7;
    private javax.swing.JPopupMenu jPopupMenu8;
    private javax.swing.JPopupMenu jPopupMenu9;
    private javax.swing.JLabel jlblCust;
    private javax.swing.JLabel jlblCustIcon;
    private javax.swing.JLabel jlblIcon;
    private javax.swing.JLabel jlblPayment;
    private javax.swing.JLabel jlblPaymentIcon;
    private javax.swing.JLabel jlblPet;
    private javax.swing.JLabel jlblPetIcon;
    private javax.swing.JLabel jlblReport;
    private javax.swing.JLabel jlblReportIcon;
    private javax.swing.JLabel jlblSchedule;
    private javax.swing.JLabel jlblScheduleIcon;
    private javax.swing.JLabel jlblSec;
    private javax.swing.JLabel jlblSecIcon;
    private javax.swing.JLabel jlblService;
    private javax.swing.JLabel jlblServiceIcon;
    private javax.swing.JLabel jlblStaff;
    private javax.swing.JLabel jlblStaffIcon;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JLabel jlblTrans;
    private javax.swing.JLabel jlblTransIcon;
    private javax.swing.JLabel jlblWelcome;
    private javax.swing.JPanel jpContent;
    private javax.swing.JPanel jpMain;
    private javax.swing.JPanel jpMenu;
    // End of variables declaration//GEN-END:variables
}
