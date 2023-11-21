
package Model;

public class Motorcycle extends Vehicle {
   private String rol;
    private int idUsuario;

    public Motorcycle(String id, int idUsuario, String rol) {
        super("Motorcycle",id);
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