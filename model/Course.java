import java.util.ArrayList;
public class Course{
    protected int id;
    protected String name;
    protected String code;
    protected int credits;
    protected String modality;
    protected String description;
    protected ArrayList<Student> students;
    protected ArrayList<Teacher> teachers;
    public Course(int id, String name, String code, int credits, String modality, String description) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.credits = credits;
        this.modality = modality;
        this.description = description;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
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
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public String getModality() {
        return modality;
    }
    public void setModality(String modality) {
        this.modality = modality;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", code=" + code + ", credits=" + credits + ", modality="
                + modality + ", description=" + description + "]";
    }
    

    
}