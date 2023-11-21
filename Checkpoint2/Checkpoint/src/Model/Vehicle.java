
package Model;
public class Vehicle {
    private String type;
    private String id;
    public Vehicle(String type, String id) {
        this.type = type;
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}