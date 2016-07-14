
package domain;

import java.util.Date;

public class CreditCard {
    
   private String ccNum;
   private Date ccExpiryDate;
   private String issuingAgent;
   private String cvc;
   private String cardHolderName;
   private String cardName;
   private Customer customer;

    public CreditCard() {
    }

    public CreditCard(String ccNum, Date ccExpiryDate, String issuingAgent, String cvc, String cardHolderName, String cardName, Customer customer) {
        this.ccNum = ccNum;
        this.ccExpiryDate = ccExpiryDate;
        this.issuingAgent = issuingAgent;
        this.cvc = cvc;
        this.cardHolderName = cardHolderName;
        this.cardName = cardName;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCcNum() {
        return ccNum;
    }

    public void setCcNum(String ccNum) {
        this.ccNum = ccNum;
    }

    public Date getCcExpiryDate() {
        return ccExpiryDate;
    }

    public void setCcExpiryDate(Date ccExpiryDate) {
        this.ccExpiryDate = ccExpiryDate;
    }

    public String getIssuingAgent() {
        return issuingAgent;
    }

    public void setIssuingAgent(String issuingAgent) {
        this.issuingAgent = issuingAgent;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
   
}
