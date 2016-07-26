
package control;

import da.CreditCardDA;
import domain.CreditCard;

public class MaintainCreditCard {
    
    private CreditCardDA creditcardDA;
    
    public MaintainCreditCard()
    {
        creditcardDA = new CreditCardDA();
    }
    
    public void addRecord(CreditCard cc)
    {
        creditcardDA.addRecord(cc);
    }
    
    public CreditCard searchRecord(String IC)           //WTF?
    {
        return creditcardDA.getRecord(IC);              //WTF?
    }
    
    public void updateRecord(CreditCard cc)
    {
        creditcardDA.updateRecord(cc);
    }
    
    public void deleteRecord(String IC)                 //WTF?
    {
        creditcardDA.deleteRecord(IC);                  //WTF?
    }
}
