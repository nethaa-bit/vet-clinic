/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import control.MaintainCreditCard;
import control.MaintainPayment;
import control.MaintainService;
import control.MaintainStaff;
import control.MaintainTransaction;
import control.MaintainTransactionService;
import domain.CreditCard;
import domain.Payment;
import domain.Service;
import domain.ServiceDetail;
import domain.Staff;
import domain.TableModel;
import domain.Transaction;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Cheng
 */
public class PaymentPanel extends javax.swing.JPanel {

    /**
     * Creates new form PaymentPanel
     */
    private MaintainPayment paymentControl;
    private MaintainTransaction transControl;
    private MaintainService servControl;
    private MaintainTransactionService transServControl;
    private MaintainStaff staffControl;
    private MaintainCreditCard ccControl;
    private static CreditCard creditcard;

    public static void setCreditcard(CreditCard creditcard) {
        PaymentPanel.creditcard = creditcard;
    }
    
    public PaymentPanel() {
        initComponents();
        paymentControl = new MaintainPayment();
        transControl = new MaintainTransaction();
        transServControl = new MaintainTransactionService();
        servControl = new MaintainService();
        staffControl = new MaintainStaff();
        ccControl = new MaintainCreditCard();
        jtfSearch.setOpaque(false);
        jtfSearch.setBackground(new Color(255,255,255,127));
//        jtfSearch.setBorder(null);
        initFields();
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
        jlblSearch = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jlblPayment = new javax.swing.JLabel();
        dynamicPanel = new javax.swing.JPanel();
        jpAdd = new javax.swing.JPanel();
        jlblId = new javax.swing.JLabel();
        jtfPayId = new javax.swing.JTextField();
        jlblAmount = new javax.swing.JLabel();
        jtfAmount = new javax.swing.JTextField();
        jlblMethodPay = new javax.swing.JLabel();
        jcbMethodPay = new javax.swing.JComboBox<>();
        jlblDate = new javax.swing.JLabel();
        jlblTransId = new javax.swing.JLabel();
        jlblStaffName = new javax.swing.JLabel();
        jlblCCNum = new javax.swing.JLabel();
        jtfCcNum = new javax.swing.JTextField();
        jdpPayDate = new com.toedter.calendar.JDateChooser();
        jbtAddPay = new javax.swing.JButton();
        jcbTransId = new javax.swing.JComboBox<>();
        jtfStaff = new javax.swing.JTextField();
        jtfChange = new javax.swing.JTextField();
        jlblChange = new javax.swing.JLabel();
        jlblAmountPayable = new javax.swing.JLabel();
        jtfAmountPayable = new javax.swing.JTextField();
        jbtGenBill = new javax.swing.JButton();
        jbtCredit = new javax.swing.JButton();
        jtfTransID = new javax.swing.JTextField();
        jpSearch = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPayment = new javax.swing.JTable();
        jbtView = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jlblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblSearchMouseClicked(evt);
            }
        });
        jPanel2.add(jlblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));
        jPanel2.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 260, 30));

        jlblPayment.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jlblPayment.setText("Payment");
        jPanel2.add(jlblPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 220, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 103));

        dynamicPanel.setLayout(new java.awt.CardLayout());

        jpAdd.setBackground(new java.awt.Color(204, 204, 255));
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblId.setText("Payment ID :");
        jpAdd.add(jlblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jtfPayId.setToolTipText("Enter payment ID");
        jtfPayId.setEnabled(false);
        jpAdd.add(jtfPayId, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 140, -1));

        jlblAmount.setText("Amount Paid (RM) :");
        jpAdd.add(jlblAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jtfAmount.setToolTipText("Enter amount paid");
        jtfAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfAmountKeyReleased(evt);
            }
        });
        jpAdd.add(jtfAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 140, -1));

        jlblMethodPay.setText("Method Of Payment :");
        jpAdd.add(jlblMethodPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jcbMethodPay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Credit Card" }));
        jpAdd.add(jcbMethodPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 140, -1));

        jlblDate.setText("Payment Date :");
        jpAdd.add(jlblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        jlblTransId.setText("Transaction ID :");
        jpAdd.add(jlblTransId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jlblStaffName.setText("Staff Name:");
        jpAdd.add(jlblStaffName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 60, -1));

        jlblCCNum.setText("Credit Card No. :");
        jpAdd.add(jlblCCNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jtfCcNum.setToolTipText("Enter credit card no.");
        jtfCcNum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfCcNumFocusGained(evt);
            }
        });
        jpAdd.add(jtfCcNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 140, -1));
        jpAdd.add(jdpPayDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 140, -1));

        jbtAddPay.setText("Add Payment");
        jbtAddPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddPayActionPerformed(evt);
            }
        });
        jpAdd.add(jbtAddPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        jpAdd.add(jcbTransId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 140, -1));
        jpAdd.add(jtfStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 140, -1));
        jpAdd.add(jtfChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 140, -1));

        jlblChange.setText("Change Rendered:");
        jpAdd.add(jlblChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        jlblAmountPayable.setText("Amount Payable (RM) :");
        jpAdd.add(jlblAmountPayable, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jtfAmountPayable.setToolTipText("Enter amount paid");
        jpAdd.add(jtfAmountPayable, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 140, -1));

        jbtGenBill.setText("Generate Bill");
        jbtGenBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGenBillActionPerformed(evt);
            }
        });
        jpAdd.add(jbtGenBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, 20));

        jbtCredit.setText("Manage Credit Card");
        jbtCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCreditActionPerformed(evt);
            }
        });
        jpAdd.add(jbtCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));
        jpAdd.add(jtfTransID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 140, -1));

        dynamicPanel.add(jpAdd, "card3");

        jpSearch.setBackground(new java.awt.Color(204, 204, 255));
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtPayment.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtPayment);

        jpSearch.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 690, 140));

        jbtView.setText("View Payment");
        jbtView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtViewActionPerformed(evt);
            }
        });
        jpSearch.add(jbtView, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

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
    public void setDynamicPanel() {
        JPanel targetPanel = new JPanel();
        if(MainMenu.action.equals("add")){
             targetPanel=jpAdd;
             jtfPayId.setText(generatePaymentId());
             jlblPayment.setText("Add Payment");
        }
        else if (MainMenu.action.equals("search")){
            targetPanel=jpSearch;
            jbtView.setVisible(true);
            jlblPayment.setText("Search Payment");
        }else if(MainMenu.action.equals("bill")){
            targetPanel=jpAdd;
            jlblAmount.setVisible(false);
            jlblAmountPayable.setVisible(false);
            jlblCCNum.setVisible(false);
            jlblChange.setVisible(false);
            jlblDate.setVisible(false);
            jlblId.setVisible(false);
            jlblMethodPay.setVisible(false);
            jlblStaffName.setVisible(false);
            jbtAddPay.setVisible(false);
            jtfAmount.setVisible(false);
            jtfCcNum.setVisible(false);
            jtfChange.setVisible(false);
            jtfPayId.setVisible(false);
            jtfStaff.setVisible(false);
            jcbMethodPay.setVisible(false);
            jtfAmountPayable.setVisible(false);
            jdpPayDate.setVisible(false);
            jbtCredit.setVisible(false);
            jbtGenBill.setVisible(true);
            
            jlblPayment.setText("Generate Bill");
        
        }else if(MainMenu.action.equals("viewSelected")){
            targetPanel=jpAdd;
            jbtAddPay.setVisible(false);
            jlblAmount.setVisible(false);
            jlblChange.setVisible(false);
            jbtCredit.setVisible(false);
            jcbMethodPay.setEnabled(false);
            jlblPayment.setText("View Payment");
        }
        
        dynamicPanel.removeAll();
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
            
        //Adding Pannel
        dynamicPanel.add(targetPanel);
        dynamicPanel.repaint();
        dynamicPanel.revalidate();
    }
    
    public void fillFields(Payment  payment){
        jtfTransID.setVisible(true);
        jtfTransID.setEditable(false);
        jtfTransID.setText((payment.getTransaction().getTransID()));
        jcbTransId.setVisible(false);
        jtfStaff.setText(payment.getStaff().getStaffName());
        jcbMethodPay.setSelectedItem(payment.getMethodOfPayment());
        jtfPayId.setText(payment.getPaymentID());
        jdpPayDate.setDate(payment.getPaymentDate());
        jtfAmountPayable.setText(""+payment.getAmountPaid());
        if(payment.getCc()!=null){
            jtfCcNum.setText(payment.getCc().getCcNum());
        }
        jtfAmount.setVisible(false);
        jtfChange.setVisible(false);
        jbtCredit.setVisible(false);
    }
    
    public void initFields(){
        jtfCcNum.setVisible(false);
        jlblCCNum.setVisible(false);
        jtfAmountPayable.setEditable(false);
       jbtCredit.setVisible(false);
       jtfTransID.setVisible(false);
       ArrayList<Transaction> transactionList = transControl.searchRecord("", 0);
       ArrayList<Payment> paymentList = paymentControl.searchRecord("",0);
       
       for(int j=0; j<transactionList.size();j++){
       for(int i=0; i<paymentList.size();i++){
           
             if(paymentList.get(i).getTransaction().getTransID().equals(transactionList.get(j).getTransID())){
                 transactionList.remove(transactionList.get(j));
             }
           }
       }
       jcbTransId.addItem("");
       for(int j=0; j<transactionList.size();j++){
             jcbTransId.addItem(transactionList.get(j).getTransID());
       }
       
       jtfStaff.setText(LoginFrame.getCurrentstaff().getStaffName());
       jtfStaff.setEditable(false);
       
       jcbMethodPay.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                JComboBox cb = (JComboBox) evt.getSource();
                String item = (String) evt.getItem();
                if(item.equals("Credit Card")){
                    jtfCcNum.setVisible(true);
                    jlblCCNum.setVisible(true);
                    jlblAmount.setVisible(false);
                    jtfAmount.setVisible(false);
                    jlblChange.setVisible(false);
                    jtfChange.setVisible(false);
                    jbtCredit.setVisible(true);
                }else{
                    jtfCcNum.setVisible(false);
                    jlblCCNum.setVisible(false);
                    jlblAmount.setVisible(true);
                    jtfAmount.setVisible(true);
                    jlblChange.setVisible(true);
                    jtfChange.setVisible(true);
                }
            }});
       
       jdpPayDate.setDateFormatString("dd-MM-yyyy");
       jdpPayDate.setDate(new Date());
       jdpPayDate.setEnabled(false);
       jcbTransId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                JComboBox cb = (JComboBox) evt.getSource();
                String item = (String) evt.getItem();
                ArrayList<ServiceDetail> servDList = transServControl.searchRecord(item,1);
                Double amountPayable= 0.0;
                for(int i=0;i<servDList.size();i++){
                    Service ser = servControl.searchRecord(servDList.get(i).getService().getServiceID());
                    amountPayable+=ser.getUnitPrice();
                }
                
                jtfAmountPayable.setText(""+amountPayable+0);
            }});
       jbtGenBill.setVisible(false);
    }
    
    public Payment validateInput(){
    
        Payment payment;
        boolean valid =true;
    
        String transID = (String)jcbTransId.getSelectedItem();
        String id = jtfPayId.getText();
        String name = jtfStaff.getText();
        Double pay = Double.parseDouble(jtfAmountPayable.getText());
        Double amount =0.0;
        Double change =0.0;
        
        String methodPay = (String)jcbMethodPay.getSelectedItem();
        Date payDate = jdpPayDate.getDate();
        if(!jtfAmount.getText().equals("")&&!jtfChange.getText().equals("")){
            amount = Double.parseDouble(jtfAmount.getText());
            change = Double.parseDouble(jtfChange.getText());
        }
        String ccNum = jtfCcNum.getText();
        
        valid = id.equals(null)?false:true;
        valid = name.equals(null)?false:true; //need
        valid = pay.equals(null)?false:true;
        valid = amount.equals(null)?false:true;
        valid = change.equals(null)?false:true;
        
        if(valid==true){
           // take object domain constructor and initialiue (pass value) 
               Transaction transaction = transControl.searchRecord(transID);
               if(methodPay.equals("Cash")){
                    payment = new Payment(id,pay,methodPay,payDate,transaction,LoginFrame.getCurrentstaff(),null);
               }
               else{
                   CreditCard cc = ccControl.searchRecord(ccNum);
                   payment = new Payment(id,pay,methodPay,payDate,transaction,LoginFrame.getCurrentstaff(),cc);
               }
           
         }
         else {
             payment=null;
         }
         
         return payment;
    }
    
    public void resetFields(){
        
        jtfPayId.setText("");
        jtfStaff.setText("");
        jtfAmountPayable.setText("");
        jtfAmount.setText("");
        jtfChange.setText("");
    
        }
    
    public void disableFields(){
        
        jtfAmount.setEditable(false);
        jtfCcNum.setEditable(false);
        jtfChange.setEditable(false);
        jtfPayId.setEditable(false);
        jtfStaff.setEditable(false);
        jcbMethodPay.setEditable(false);
        jcbTransId.setEditable(false);
        jdpPayDate.setEnabled(false);
        jtfAmountPayable.setEditable(false);
    
    }
    public String generatePaymentId(){
        
        ArrayList<Payment> paymentList = paymentControl.searchRecord("", 0);
        ArrayList<Integer> idList = new ArrayList<Integer>();  //fixed

        for(int i=0; i<paymentList.size(); i++){
            String idStr = paymentList.get(i).getPaymentID();//
            int idNo = Integer.parseInt(idStr.split("P")[1]); ///
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
        return "P"+idNo; //uhfeuh
        
    }
    
    private void jlblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblSearchMouseClicked
        // TODO add your handling code here:
        jtPayment.setModel(new DefaultTableModel());
        jtPayment.repaint();
        
       
        if(MainMenu.action == "add"||MainMenu.action == "viewSelected" ){
               MainMenu.action="search";
        }
        setDynamicPanel();
        String queryStr =jtfSearch.getText();
        int option =-1;
        

            if(Pattern.matches("P\\d+", queryStr)){
                option=1;
            }
            
            else if(Pattern.matches("T\\d+", queryStr)){
                option=2;
            }
            ArrayList<Payment> paymentList = paymentControl.searchRecord(queryStr,option);

//            MainMenu.action="search";

            if(paymentList.size()!=0&&paymentList!=null){
                Object[][] data = new Object[100][8];
                for(int i=0; i<paymentList.size();i++){
                    data[i] = paymentList.get(i).getObjects();
                    
                    if(paymentList.get(i).getCc()!=null){
                        CreditCard cc = (CreditCard)data[i][6];
                        data[i][6] = cc.getCcNum();
                    }else {
                        data[i][6] = "";
                    }
                    Staff ic = (Staff)data[i][5];
                    data[i][5] = ic.getStaffIC();
                    Transaction t = (Transaction) data[i][4];
                    data[i][4] = t.getTransID();
                } 
                String[] columnNames = {"Payment ID","Amount Paid","Method of Payment","Date","Transaction ID","Staff IC","Credit Card No."};
                TableModel tModel = new TableModel(data, columnNames);
                jtPayment.setModel(tModel);  
                jtPayment.createDefaultColumnsFromModel();
                jtPayment.repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "No results found!" , "No such record.", JOptionPane.ERROR_MESSAGE);
            }     
    }//GEN-LAST:event_jlblSearchMouseClicked

    private void jbtViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtViewActionPerformed
        // TODO add your handling code here:
         MainMenu.action="viewSelected";
       Payment selectedPayment=null;
       if(jtPayment.getSelectedRow()>=0 ) {
           String id  = (String) jtPayment.getValueAt(jtPayment.getSelectedRow(),0);
           selectedPayment = paymentControl.searchRecord(id);
           if(selectedPayment!=null){
                setDynamicPanel();
                fillFields(selectedPayment);
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

    private void jbtAddPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddPayActionPerformed
        // TODO add your handling code here:
        Payment payment = validateInput();
        if(payment!=null){
         //write to database ****
                Payment p = paymentControl.searchRecord(payment.getPaymentID());
                
                if(p != null)
                {
                    JOptionPane.showMessageDialog(null,"This payment already exist.", "Duplicate Record", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    p = payment;
                    try{
                    paymentControl.addRecord(p);
                    
                    resetFields();
                    JOptionPane.showMessageDialog(null,"New payment is created.","Success",JOptionPane.INFORMATION_MESSAGE);
                       String host = "jdbc:derby://localhost:1527/vetdb";
                       String user = "nbuser";
                       String password = "nbuser";
                       Connection conn = null;

                       String reportSource = "src/reportTemplates/Receipt.jrxml"; 

                       String transID = (String) jcbTransId.getSelectedItem();

                       Map<String, Object> params = new HashMap<String, Object>(); 
                       params.put("rTransID",transID);
                       try    {	 
                         Class.forName("org.apache.derby.jdbc.ClientDriver");
                         conn = DriverManager.getConnection(host, user, password);
                               JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

                      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
                      JasperViewer.viewReport(jasperPrint, false); 


                      } catch (JRException jrex) {
                            JOptionPane.showMessageDialog(this, "Error in generating report");
                              jrex.printStackTrace();
                      }  catch(Exception ex) {
                            JOptionPane.showMessageDialog(this, "Unble to generate report~!");
                              ex.printStackTrace();
                      }
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Failure",JOptionPane.ERROR_MESSAGE);
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
        
    }//GEN-LAST:event_jbtAddPayActionPerformed

    private void jbtGenBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGenBillActionPerformed
        // TODO add your handling code here:
        
        String host = "jdbc:derby://localhost:1527/vetdb";
       String user = "nbuser";
       String password = "nbuser";
       Connection conn = null;
       
       String reportSource = "src/reportTemplates/Bill.jrxml"; 
       
       String transID = (String) jcbTransId.getSelectedItem();

       Map<String, Object> params = new HashMap<String, Object>(); 
       params.put("rTransID",transID);
       try    {	 
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         conn = DriverManager.getConnection(host, user, password);
               JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
      JasperViewer.viewReport(jasperPrint, false); 
        

      } catch (JRException jrex) {
            JOptionPane.showMessageDialog(this, "Error in generating report");
  	      jrex.printStackTrace();
      }  catch(Exception ex) {
            JOptionPane.showMessageDialog(this, "Unble to generate report~!");
	      ex.printStackTrace();
      }
    }//GEN-LAST:event_jbtGenBillActionPerformed

    private void jtfAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAmountKeyReleased
        // TODO add your handling code here
        Double paid = jtfAmount.getText().equals("")?0.0:Double.parseDouble(jtfAmount.getText());
        Double payable = jtfAmountPayable.getText().equals("")?0.0:Double.parseDouble(jtfAmountPayable.getText());
        
        jtfChange.setText(""+(paid-payable)+0);
    }//GEN-LAST:event_jtfAmountKeyReleased

    private void jbtCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCreditActionPerformed
        // TODO add your handling code here:
        
        AddCreditCardDialog addCC = new AddCreditCardDialog(null, false);
        addCC.setVisible(true);
       
        
    }//GEN-LAST:event_jbtCreditActionPerformed

    private void jtfCcNumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCcNumFocusGained
        // TODO add your handling code here:
        
       
        if(creditcard!=null){
            jtfCcNum.setText(creditcard.getCcNum());
        }
        else{
  
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try{
            String  ccNum  = (String)clipboard.getData(DataFlavor.stringFlavor);
            if(Pattern.matches("\\d{12,16}", ccNum)){jtfCcNum.setText(ccNum);}
        }
        catch (Exception ex){}
        }
    }//GEN-LAST:event_jtfCcNumFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAddPay;
    private javax.swing.JButton jbtCredit;
    private javax.swing.JButton jbtGenBill;
    private javax.swing.JButton jbtView;
    private javax.swing.JComboBox<String> jcbMethodPay;
    private javax.swing.JComboBox<String> jcbTransId;
    private com.toedter.calendar.JDateChooser jdpPayDate;
    private javax.swing.JLabel jlblAmount;
    private javax.swing.JLabel jlblAmountPayable;
    private javax.swing.JLabel jlblCCNum;
    private javax.swing.JLabel jlblChange;
    private javax.swing.JLabel jlblDate;
    private javax.swing.JLabel jlblId;
    private javax.swing.JLabel jlblMethodPay;
    private javax.swing.JLabel jlblPayment;
    private javax.swing.JLabel jlblSearch;
    private javax.swing.JLabel jlblStaffName;
    private javax.swing.JLabel jlblTransId;
    private javax.swing.JPanel jpAdd;
    private javax.swing.JPanel jpSearch;
    private javax.swing.JTable jtPayment;
    private javax.swing.JTextField jtfAmount;
    private javax.swing.JTextField jtfAmountPayable;
    private javax.swing.JTextField jtfCcNum;
    private javax.swing.JTextField jtfChange;
    private javax.swing.JTextField jtfPayId;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfStaff;
    private javax.swing.JTextField jtfTransID;
    // End of variables declaration//GEN-END:variables
}
