public class Student extends Person{
    private String code;
    private int semester;
    private double average;
    public Student() {
    }
    public Student(String id, String name, String code, int semester, double average) {
        super(id, name);
        this.code = code;
        this.semester = semester;
        this.average = average;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public double getAverage() {
        return average;
    }
    public void setAverage(double average) {
        this.average = average;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", code=" + code + ", name=" + name + ", semester=" + semester + ", average="
                + average + "]";
    }
    
    
    
}