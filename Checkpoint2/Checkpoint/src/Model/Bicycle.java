
package Model;

public class Bicycle extends Vehicle {
    private String serialNumber;
    private String rol;
    private int idUsuario;

    public Bicycle( String id, int idUsuario, String rol) {
        super("Bicycle",id);
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
