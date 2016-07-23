
package domain;

public class Customer {
    private String custIC;
    private String custName;
    private char custGender;
    private String custAddress;
    private String custPhoneNum;

    public Customer() {
    }

    public Customer(String custIC, String custName, char custGender, String custAddress, String custPhoneNum) {
        this.custIC = custIC;
        this.custName = custName;
        this.custGender = custGender;
        this.custAddress = custAddress;
        this.custPhoneNum = custPhoneNum;
    }

    public String getCustIC() {
        return custIC;
    }

    public void setCustIC(String custIC) {
        this.custIC = custIC;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public char getCustGender() {
        return custGender;
    }

    public void setCustGender(char custGender) {
        this.custGender = custGender;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhoneNum() {
        return custPhoneNum;
    }

    public void setCustPhoneNum(String custPhoneNum) {
        this.custPhoneNum = custPhoneNum;
    }

    public Object[] getObjects() {
        Object[] objList ={custIC, custName, custGender, custAddress, custPhoneNum};
        
        return objList;
    }
    
    
}
