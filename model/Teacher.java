public class Teacher extends Person{
    private String email;
    private String lastName;
    private String speciality;
    public Teacher() {
    }
    public Teacher(String id, String name, String email, String lastName, String speciality) {
        super(id, name);
        this.email = email;
        this.lastName = lastName;
        this.speciality = speciality;
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
        return "Teacher [email=" + email + ", lastName=" + lastName + ", speciality=" + speciality + "]";
    }
    
}