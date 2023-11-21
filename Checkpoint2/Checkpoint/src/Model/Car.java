
package Model;

public class Car extends Vehicle {
    private String rol;
    private int idUsuario;

    public Car(String id, int idUsuario, String rol) {
        super("Car",id);
        this.idUsuario = idUsuario;
        this.rol = rol;
    }
 public String getRol() {
        return rol;
    }
  public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
