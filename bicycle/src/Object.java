public class Object {
    private String name;

    public Object(String name) {
        this.name = name;
    }

    public Object() {
        this.name = "Unknown Object";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}