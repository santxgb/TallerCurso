public class Person extends BaseClass {
    protected String name;
    
    public Person() {
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }
    
}
