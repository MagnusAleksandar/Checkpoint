package Model;

import java.util.ArrayList;
import View.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Edificio {
    private static VAlreadyU via = new VAlreadyU(); // Vista para cuando un individuo ya está adentro
    private static VAlreadyV vav = new VAlreadyV(); // Vista para cuando un vehículo ya está adentro
    private static VAccepted va = new VAccepted(); // Vista para cuando un vehículo/individuo logra entrar
    private static VSalio vs = new VSalio(); // Vista para cuando un vehículo/individuo logra salir
    private static VAlert_vehiEquiv wv = new VAlert_vehiEquiv(); // Vista para cuando alguien va a salir con el vehículo
                                                                 // equivocado
    private static VAlert_noIndiv vni = new VAlert_noIndiv(); //
    private static VAlert_noTienV ntnv = new VAlert_noTienV(); // Vista para un individuo que no tiene vehículo
    private static VNoEntryYet ney = new VNoEntryYet(); // Vista para cuando no se puede generar reportes porque no ha
                                                        // entrado nadie
    private static VTabReEntSal vtes = new VTabReEntSal(); // Vista de reporte de esntrada y salida
    private static VTabReAlert vtal = new VTabReAlert(); // Vista de reporte de alertas de seguridad

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Genera la fecha y hora para los
                                                                               // reportes
    static String fechaHora = sdf.format(new Date());// Convierte fecha y hora a string

    private static ArrayList<Vehic> arrve = new ArrayList<>();// Vehiculos con permisos epeciales
    private static ArrayList<Vehic> arrvn = new ArrayList<>();// Vehiculos sin permisos epeciales
    private static ArrayList<Indiv> arrin = new ArrayList<>();// Individuos con permisos epeciales
    private static ArrayList<Indiv> arrie = new ArrayList<>();// Individuos sin permisos epeciales

    private static ArrayList<String> allalrts = new ArrayList<>();// Todas las alertas
    private static ArrayList<String> alrtsal1 = new ArrayList<>();// Alertas para la salida 1
    private static ArrayList<String> alrtsal2 = new ArrayList<>();// Alertas para la salida 2
    private static ArrayList<String> alrtsal3 = new ArrayList<>();// Alertas para la salida 3
    private static ArrayList<String> alrtsal4 = new ArrayList<>();// Alertas para la salida 4
    private static ArrayList<String> alrtsal5 = new ArrayList<>();// Alertas para la salida 5
    private static ArrayList<String> alrtent1 = new ArrayList<>();// Alertas para la entrada 1
    private static ArrayList<String> alrtent2 = new ArrayList<>();// Alertas para la entrada 2
    private static ArrayList<String> alrtent3 = new ArrayList<>();// Alertas para la entrada 3
    private static ArrayList<String> alrtent4 = new ArrayList<>();// Alertas para la entrada 4
    private static ArrayList<String> alrtent5 = new ArrayList<>();// Alertas para la entrada 5
    private static ArrayList<String> alrtseg = new ArrayList<>(); // Alertas de seguridad

    public static void ingPeat(String id, String rol) {
        // Ingreso peatonal
        boolean flagi = false, flagv = false;

        // Revisan si ya está adentro el individuo
        for (Indiv indiv : arrin) {
            if (indiv.getId().equals(id))
                flagi = true;
        }
        for (Vehic vehic : arrvn) {
            if (vehic.getId().equals(id))
                flagv = true;
        }
        for (Indiv indiv : arrie) {
            if (indiv.getId().equals(id))
                flagi = true;
        }
        for (Vehic vehic : arrve) {
            if (vehic.getId().equals(id))
                flagv = true;
        }

        if (!flagi && !flagv) { // Si no está adentro, crea el objeto y lo agrega al arreglo según permisos
            Indiv i = new Indiv();
            i.setId(id);
            i.setRol(rol);
            if (rol == "Visitante" || rol.contains("sin")) // Cuando no tiene permisos
                arrin.add(i);
            else // Cuando sí
                arrie.add(i);
            va.setVisible(true);
        } else if (flagi) // Si el individuo ya entró por la entrada peatonal
            via.setVisible(true);
        else if (flagv) // Si el individuo ya entró por la entrada vehicular
            vav.setVisible(true);
    }

    public static void ingVeh(String id, String placa, String rol) {
        // Ingreso vehícular
        boolean flagv = false, flagi = false;

        // Revisan si ya está adentro el individuo
        for (Vehic vehic : arrvn) {
            if (vehic.getId().equals(id))
                flagv = true;
        }
        for (Indiv indiv : arrin) {
            if (indiv.getId().equals(id))
                flagi = true;
        }
        for (Indiv indiv : arrie) {
            if (indiv.getId().equals(id))
                flagi = true;
        }
        for (Vehic vehic : arrve) {
            if (vehic.getId().equals(id))
                flagv = true;
        }

        if (!flagi && !flagv) { // Si no está adentro, crea el objeto y lo agrega al arreglo según permisos
            Vehic v = new Vehic();
            v.setId(id);
            v.setPlaca(placa);
            v.setRol(rol);
            if (rol == "Visitante" || rol.contains("sin")) // Si el individuo ya entró por la entrada peatonal
                arrvn.add(v);
            else
                arrve.add(v);

            va.setVisible(true);
        } else if (flagv) // Si el individuo ya entró por la entrada vehicular
            vav.setVisible(true);
        else if (flagi) // Si el individuo ya entró por la entrada peatonal
            via.setVisible(true);

    }

    public static void alrtSalida(String salida, String id, String placa, String rol, String tipoV) {
        // Crea las alertas de salidas y las agrega a un arreglo dependiendo de la
        // salida
        char numSal = salida.charAt(salida.length() - 1);
        String alert = "Salió el usuario ";

        if (placa == null) {
            placa = "";
            tipoV = "";
        }

        alert = alert.concat(id);

        if (!placa.isEmpty()) {
            if (!tipoV.equals("Bicicleta"))
                alert = alert.concat(" en el vehículo de placa " + placa);
            else
                alert = alert.concat(" la bicicleta con matrícula " + placa);
        }

        switch (numSal) {
            case '1':
                alert = alert.concat(" por la salida 1. Fecha y hora: " + fechaHora);
                alrtsal1.add(alert);
                alert = "";
                break;
            case '2':
                alert = alert.concat(" por la salida 2. Fecha y hora: " + fechaHora);
                alrtsal2.add(alert);
                alert = "";
                break;
            case '3':
                alert = alert.concat(" por la salida 3. Fecha y hora: " + fechaHora);
                alrtsal3.add(alert);
                alert = "";
                break;
            case '4':
                alert = alert.concat(" por la salida 4. Fecha y hora: " + fechaHora);
                alrtsal4.add(alert);
                alert = "";
                break;
            case '5':
                alert = alert.concat(" por la salida 5. Fecha y hora: " + fechaHora);
                alrtsal5.add(alert);
                alert = "";
                break;
            default:
                System.out.println("T'fuck?"); // En caso de bug :v
                break;
        }
    }

    public static void alrtEntrda(String entrada, String id, String placa, String rol, String tipoV) {
        // Crea las alertas de salidas y las agrega a un arreglo dependiendo de la
        // salida
        char numSal = entrada.charAt(entrada.length() - 1);
        String alert = "Ingresó el usuario ";

        if (placa == null) {
            placa = "";
            tipoV = "";
        }

        alert = alert.concat(id);

        if (!placa.isEmpty()) {
            if (!tipoV.equals("Bicicleta"))
                alert = alert.concat(" en el vehículo de placa " + placa);
            else
                alert = alert.concat(" la bicicleta con matrícula " + placa);
        }

        switch (numSal) {
            case '1':
                alert = alert.concat(" por la entrada 1. Fecha y hora: " + fechaHora);
                alrtent1.add(alert);
                alert = "";
                break;
            case '2':
                alert = alert.concat(" por la entrada 2. Fecha y hora: " + fechaHora);
                alrtent2.add(alert);
                alert = "";
                break;
            case '3':
                alert = alert.concat(" por la entrada 3. Fecha y hora: " + fechaHora);
                alrtent3.add(alert);
                alert = "";
                break;
            case '4':
                alert = alert.concat(" por la entrada 4. Fecha y hora: " + fechaHora);
                alrtent4.add(alert);
                alert = "";
                break;
            case '5':
                alert = alert.concat(" por la entrada 5. Fecha y hora: " + fechaHora);
                alrtent5.add(alert);
                alert = "";
                break;
            default:
                System.out.println("T'fuck?"); // En caso de bug :v
                break;
        }
    }

    public static void reporteFinal() {
        // Crea el archivo que contiene el reporte final
        File file = new File("reporte.txt");
        addRep();
        try {
            FileWriter fileW = new FileWriter(file);
            for (String alrt : allalrts)
                fileW.write(alrt);
            fileW.close();
        } catch (IOException e) {
            System.out.println("No se pudo crear el archivo. Error: " + e.getMessage());
        }
    }

    public static void addRep() {
        // Agrega todas las alertas a un solo arreglo
        // Inicio entradas
        allalrts.add("Entradas:\n");
        for (String alrt : alrtent1)
            allalrts.add(alrt);
        allalrts.add("\n");
        for (String alrt : alrtent2)
            allalrts.add(alrt);
        allalrts.add("\n");
        for (String alrt : alrtent3)
            allalrts.add(alrt);
        allalrts.add("\n");
        for (String alrt : alrtent4)
            allalrts.add(alrt);
        allalrts.add("\n");
        for (String alrt : alrtent5)
            allalrts.add(alrt);
        allalrts.add("\n");

        // Fin entradas e inicio salidas
        allalrts.add("Salidas:\n");
        for (String alrt : alrtsal1)
            allalrts.add(alrt);
        allalrts.add("\n");
        for (String alrt : alrtsal2)
            allalrts.add(alrt);
        allalrts.add("\n");
        for (String alrt : alrtsal3)
            allalrts.add(alrt);
        allalrts.add("\n");
        for (String alrt : alrtsal4)
            allalrts.add(alrt);
        allalrts.add("\n");
        for (String alrt : alrtsal5)
            allalrts.add(alrt);
        allalrts.add("\n");

        // Fin salidas e inicio alertas de seguridad
        allalrts.add("Alertas de seguridad:\n");
        for (String alrt : alrtseg)
            allalrts.add(alrt);
    }

    public static void reporteEntSal() {
        // Muestra el reporte para la vista de reporte de entradas y salidas
        if (alrtent1.isEmpty() && alrtent2.isEmpty() && alrtent3.isEmpty() && alrtent4.isEmpty() && alrtent5.isEmpty())
            ney.setVisible(true);
        else {
            ArrayList<String> alrtent = new ArrayList<>();// Crea un arreglo local con todas para facilitar la adición
            ArrayList<String> alrtsal = new ArrayList<>();// a las columnas respectivas, según si son entradas o salidas

            // Entradas
            for (String alrt : alrtent1)
                alrtent.add(alrt);
            for (String alrt : alrtent2)
                alrtent.add(alrt);
            for (String alrt : alrtent3)
                alrtent.add(alrt);
            for (String alrt : alrtent4)
                alrtent.add(alrt);
            for (String alrt : alrtent5)
                alrtent.add(alrt);

            // Salidas
            for (String alrt : alrtsal1)
                alrtsal.add(alrt);
            for (String alrt : alrtsal2)
                alrtsal.add(alrt);
            for (String alrt : alrtsal3)
                alrtsal.add(alrt);
            for (String alrt : alrtsal4)
                alrtsal.add(alrt);
            for (String alrt : alrtsal5)
                alrtsal.add(alrt);

            vtes.tableModel.setRowCount(0);
            vtes.tableModel.addColumn("Entradas"); // Crea y le pone el nombre a la columna de entradas
            vtes.tableModel.addColumn("Salidas"); // Crea y le pone el nombre a la columna de salidas
            String[] rowData = new String[2]; // Arreglo que va a contener cada fila de la tabla

            for (int i = 0; i < Math.max(alrtent.size(), alrtsal.size()); i++) {// Agrega las entradas y salidas a las
                                                                                // filas
                if (i < alrtent.size()) {
                    rowData[0] = alrtent.get(i);
                }
                if (i < alrtsal.size()) {
                    rowData[1] = alrtsal.get(i);
                }
                vtes.tableModel.addRow(rowData);
            }

            vtes.frame.setModel(vtes.tableModel); // Pone los datos de las filas en la tabla
            vtes.setVisible(true); // Muestra la vista
        }
    }

    public static void reporte2() {
        // Muestra el reporte de alertas de seguridad
        if (alrtseg.isEmpty())
            ney.setVisible(true);
        else {
            for (String alrt : alrtseg)
                vtal.listModel.addElement(alrt);
            vtal.listRep.setModel(vtal.listModel);
            vtal.setVisible(true);
        }
    }

    public static boolean buscar(String id, String placa) {
        // Busca un vehículo en particular donde la placa y el id coincidan con el mismo
        // objeto
        // Retorna verdadero si lo encuentra, falso si no
        boolean found = false;
        for (Vehic veh : arrve) {
            if (id.equalsIgnoreCase(veh.getId()) && placa.equalsIgnoreCase(veh.getPlaca())) {
                found = true;
                break;
            }
        }
        for (Vehic veh : arrvn) {
            if (id.equalsIgnoreCase(veh.getId()) && placa.equalsIgnoreCase(veh.getPlaca())) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static boolean noHayGente() {
        // Busca si hay gente sin permisos dentro
        if (arrin.isEmpty() && arrvn.isEmpty())
            return true;
        else
            return false;
    }

    public static boolean noHayAdmon() {
        // Busca si hay gente (con o sin permisos) dentro
        if (arrin.isEmpty() && arrvn.isEmpty() && arrie.isEmpty() && arrve.isEmpty())
            return true;
        else
            return false;
    }

    public static boolean indF(String id) {
        // Busca un individuo en particular
        // Retorna verdadero si lo encuentra, falso si no
        boolean found = false;
        for (Indiv indiv : arrin) {
            if (id.equalsIgnoreCase(indiv.getId())) {
                found = true;
                break;
            }
        }
        for (Indiv indiv : arrie) {
            if (id.equalsIgnoreCase(indiv.getId())) {
                found = true;
                break;
            }
        }
        if (!found)
            vni.setVisible(true);
        return found;
    }

    public static void salVeh(String id, String placa, String salida) {
        // Salida vehicular
        boolean notV = true, wrV = false;
        String rol = "", tipoV = "";

        for (Vehic veh : arrve) {// Recorre el arreglo de vehículos con permisos especiales
            if (id.equalsIgnoreCase(veh.getId()) && placa.equalsIgnoreCase(veh.getPlaca())) {
                vs.setVisible(true);
                rol = veh.getRol();
                tipoV = veh.getTipo();
                arrve.remove(veh);
                notV = false;
                wrV = false;
                break;
            } else if (id.equalsIgnoreCase(veh.getId()) && !placa.equalsIgnoreCase(veh.getPlaca())
                    || placa.equalsIgnoreCase(veh.getPlaca()) && !id.equalsIgnoreCase(veh.getId()))
                wrV = true; // La placa no coincide con el id
        }
        for (Vehic veh : arrvn) {// Recorre el arreglo de vehículos sin permisos especiales
            if (id.equalsIgnoreCase(veh.getId()) && placa.equalsIgnoreCase(veh.getPlaca())) {
                vs.setVisible(true);
                rol = veh.getRol();
                arrvn.remove(veh);
                wrV = false;
                notV = false;
                break;
            } else if (id.equalsIgnoreCase(veh.getId()) && !placa.equalsIgnoreCase(veh.getPlaca())
                    || placa.equalsIgnoreCase(veh.getPlaca()) && !id.equalsIgnoreCase(veh.getId()))
                wrV = true; // La placa no coincide con el id
        }
        for (Indiv ind : arrie)// Recorre el arreglo de individuos con permisos especiales
            if (id.equalsIgnoreCase(ind.getId()))
                notV = true; // Encontró el id pero entró por la vehicular
        for (Indiv ind : arrin)// Recorre el arreglo de individuos sin permisos especiales
            if (id.equalsIgnoreCase(ind.getId()))
                notV = true;// Encontró el id pero entró por la vehicular
        if (notV) {
            ntnv.setVisible(true); // Muestra la vista para cuando encontró el id pero entró por la vehicular
            alrtseg.add("Un usuario que no tiene vehículo intentó salir por la salida vehicular. Fecha y hora: "
                    + fechaHora); // Guarda la alerta
        } else if (wrV) {
            wv.setVisible(true); // Muestra la vista para cuando la placa no coincide con el id
            alrtseg.add("Un usuario intentó salir con un vehiculo que no le pertenece. Fecha y hora: " + fechaHora);
        } else // Crea la alerta de salida
            alrtSalida(salida, id, placa, rol, tipoV);
    }

    public static void salPeat(String id, String salida) {
        // Salida vehicular
        boolean noTa = true, noInd = true;
        String rol = "";

        for (Indiv ind : arrie)
            if (id.equalsIgnoreCase(ind.getId())) {
                vs.setVisible(true);
                rol = ind.getRol();
                arrie.remove(ind);
                noTa = false;
                noInd = false;
                break;
            }
        for (Indiv ind : arrin)
            if (id.equalsIgnoreCase(ind.getId())) {
                vs.setVisible(true);
                rol = ind.getRol();
                arrin.remove(ind);
                noTa = false;
                break;
            }
        for (Vehic veh : arrve)// Recorre el arreglo de vehiculos con permisos especiales
            if (id.equalsIgnoreCase(veh.getId()))
                noInd = true; // Encontró el id pero entró por la peatonal
        for (Vehic veh : arrvn)// Recorre el arreglo de vehiculos con permisos especiales
            if (id.equalsIgnoreCase(veh.getId()))
                noInd = true; // Encontró el id pero entró por la peatonal

        if (noTa) {
            vni.setVisible(true);
            // vsl.setVisible(true);
            alrtseg.add("Un ususario que no existe intentó salir. Fecha y hora: " + fechaHora);
        } // else if()

        else
            alrtSalida(salida, id, null, rol, null);

    }

    public static void blocSeg() { // Lo que se hace cuando hay un bloqueo de seguridad
        alrtseg.add("El sistema se cerró por exceso de intentos. Fecha y hora: " + fechaHora);
        reporteFinal();
        System.exit(0);
    }

    public static void show() {
        // Muestra vehículos e individuos en consola
        for (Indiv ind : arrie)
            System.out.println(ind.getId());
        for (Vehic veh : arrve)
            System.out.println(veh.getId() + "\t" + veh.getPlaca());
        for (Indiv ind : arrin)
            System.out.println(ind.getId());
        for (Vehic veh : arrvn)
            System.out.println(veh.getId() + "\t" + veh.getPlaca());
    }

}
