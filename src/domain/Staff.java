
package domain;

public class Staff {
    private String staffIC;
    private String staffName;
    private String staffAddress;
    private String staffPhone;
    private String staffPostition;
    private String staffQualification;
    private String password;
    private String securityAns;

    public Staff() {
    }

    public Staff(String staffIC, String staffName, String staffAddress, String staffPhone, String staffPostition, String staffQualification, String password, String securityAns) {
        this.staffIC = staffIC;
        this.staffName = staffName;
        this.staffAddress = staffAddress;
        this.staffPhone = staffPhone;
        this.staffPostition = staffPostition;
        this.staffQualification = staffQualification;
        this.password = password;
        this.securityAns = securityAns;
    }

    public Staff(String staffIC, String staffName, String staffAddress, String staffPhone, String staffPostition, String staffQualification) {
        this.staffIC = staffIC;
        this.staffName = staffName;
        this.staffAddress = staffAddress;
        this.staffPhone = staffPhone;
        this.staffPostition = staffPostition;
        this.staffQualification = staffQualification;
    }

    public String getStaffQualification() {
        return staffQualification;
    }

    public void setStaffQualification(String staffQualification) {
        this.staffQualification = staffQualification;
    }

    public String getStaffIC() {
        return staffIC;
    }

    public void setStaffIC(String staffIC) {
        this.staffIC = staffIC;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffPostition() {
        return staffPostition;
    }

    public void setStaffPostition(String staffPostition) {
        this.staffPostition = staffPostition;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityAns() {
        return securityAns;
    }

    public void setSecurityAns(String securityAns) {
        this.securityAns = securityAns;
    }
    
    
}
