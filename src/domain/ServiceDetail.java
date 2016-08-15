
package domain;

public class ServiceDetail {
    
    private Service service;
    private Staff staffIC;
    private String Remarks;

    public ServiceDetail() {
    }

    public ServiceDetail(Service service, Staff staffIC, String Remarks) {
        this.service = service;
        this.staffIC = staffIC;
        this.Remarks = Remarks;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Staff getStaffIC() {
        return staffIC;
    }

    public void setStaffIC(Staff staffIC) {
        this.staffIC = staffIC;
    }
}
