/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author lysan
 */
public class Payment {
       
    private String paymentID;
    private Double amountPaid;
    private String methodOfPayment;
    private Date paymentDate;
    private Transaction transaction;
    private Staff staff;
    private CreditCard cc;

    public Payment() {
    }

    public Payment(String paymentID, Double amountPaid, String methodOfPayment, Date paymentDate, Transaction transaction, Staff staff, CreditCard cc) {
        this.paymentID = paymentID;
        this.amountPaid = amountPaid;
        this.methodOfPayment = methodOfPayment;
        this.paymentDate = paymentDate;
        this.transaction = transaction;
        this.staff = staff;
        this.cc = cc;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getMethodOfPayment() {
        return methodOfPayment;
    }

    public void setMethodOfPayment(String methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public CreditCard getCc() {
        return cc;
    }

    public void setCc(CreditCard cc) {
        this.cc = cc;
    }
    
}
