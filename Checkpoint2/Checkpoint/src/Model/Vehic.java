package Model;

public class Vehic {
    private static String placa, id, tipo, rol;

    public static String getPlaca() {
        return placa;
    }

    public static void setPlaca(String placa) {
        Vehic.placa = placa;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Vehic.id = id;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        Vehic.tipo = tipo;
    }

    public static String getRol() {
        return rol;
    }

    public static void setRol(String rol) {
        Vehic.rol = rol;
    }
}
