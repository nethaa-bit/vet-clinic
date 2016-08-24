
package domain;

public class ServiceDetail {
    
    private Service service;
    private Staff staffIC;
    private String remarks;

    public ServiceDetail() {
    }

    public ServiceDetail(Service service, Staff staffIC, String Remarks) {
        this.service = service;
        this.staffIC = staffIC;
        this.remarks = Remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String Remarks) {
        this.remarks = Remarks;
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
    
    public Object[] getObjects(){
        Object[] objList = {service.getServiceID(),staffIC.getStaffName(),remarks};
        return objList;
    }
}
