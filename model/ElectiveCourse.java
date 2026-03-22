public class ElectiveCourse extends Course{
    private String area;
    private int minCreditsRequired;
    private String approvalDate;
    private boolean isOpen;
    private String department;
    public ElectiveCourse(){
        
    }
    public ElectiveCourse(String id, String name, String code, int credits, String modality, String description, String area, int minCreditsRequired, String approvalDate, boolean isOpen, String department) {
        super(id, name, code, credits, modality, description);
        this.area = area;
        this.minCreditsRequired = minCreditsRequired;
        this.approvalDate = approvalDate;
        this.isOpen = isOpen;
        this.department = department;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public int getMinCreditsRequired() {
        return minCreditsRequired;
    }
    public void setMinCreditsRequired(int minCreditsRequiredM) {
        this.minCreditsRequired = minCreditsRequiredM;
    }
    public String getApprovalDate() {
        return approvalDate;
    }
    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }
    public boolean isOpen() {
        return isOpen;
    }
    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return "ElectiveCourse [area=" + area + ", minCreditsRequiredM=" + minCreditsRequired + ", approvalDate="
                + approvalDate + ", isOpen=" + isOpen + ", department=" + department + "]";
    }
    
    
}
