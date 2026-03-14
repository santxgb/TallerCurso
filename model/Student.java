public class Student {
    private int id;
    private String name;
    private String code;
    private int semester;
    private double average;
    public Student(int id, String name, String code, int semester, double average) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.semester = semester;
        this.average = average;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
        return "Student [id=" + id + ", name=" + name + ", code=" + code + ", semester=" + semester + ", average="
                + average + "]";
    }
    
}
