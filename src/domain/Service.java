
package domain;

public class Service {
    private String serviceID;
    private String serviceTitle;
    private Double unitPrice;
    private String serviceDesp;

    public Service() {
    }

    public Service(String serviceID, String serviceTitle, Double unitPrice, String serviceDesp) {
        this.serviceID = serviceID;
        this.serviceTitle = serviceTitle;
        this.unitPrice = unitPrice;
        this.serviceDesp = serviceDesp;
    }

    public String getServiceDesp() {
        return serviceDesp;
    }

    public void setServiceDesp(String serviceDesp) {
        this.serviceDesp = serviceDesp;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
}
