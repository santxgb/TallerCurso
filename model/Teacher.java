public class Teacher{
    private int id;
    private String name;
    private String email;
    private String lastName;
    private String speciality;
    public Teacher(int id, String name, String email, String lastName, String speciality) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.speciality = speciality;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    @Override
    public String toString() {
        return "Teacher [id=" + id + ", name=" + name + ", email=" + email + ", lastName=" + lastName + ", speciality="
                + speciality + "]";
    }
    
}