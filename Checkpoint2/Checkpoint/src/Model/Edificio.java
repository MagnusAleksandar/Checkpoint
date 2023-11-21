package Model;

import java.util.ArrayList;
import View.VIAlready;
import View.VAlreadyV;
import View.VAccepted;
import View.VSalio;
import View.VAlert_vehiEquiv;
import View.VAlert_noIndiv;
import View.VAlert_noTienV;
import View.VTabReporte;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.crypto.AEADBadTagException;
import javax.swing.DefaultListModel;

public class Edificio {
    private static VIAlready via = new VIAlready();
    private static VAlreadyV vav = new VAlreadyV();
    private static VAccepted va = new VAccepted();
    private static VSalio vs = new VSalio();
    private static VAlert_vehiEquiv wv = new VAlert_vehiEquiv();
    private static VAlert_noIndiv vni = new VAlert_noIndiv();
    private static VAlert_noTienV ntnv = new VAlert_noTienV();
    
    //Hi :v v:
    
    private static ArrayList<Vehic> arrve = new ArrayList<>();
    private static ArrayList<Vehic> arrvn = new ArrayList<>();
    private static ArrayList<Indiv> arrin = new ArrayList<>();
    private static ArrayList<Indiv> arrie = new ArrayList<>();
    
    private static ArrayList<String> allalrts = new ArrayList<>();
    private static ArrayList<String> alrtsal1 = new ArrayList<>();
    private static ArrayList<String> alrtsal2 = new ArrayList<>();
    private static ArrayList<String> alrtsal3 = new ArrayList<>();
    private static ArrayList<String> alrtsal4 = new ArrayList<>();
    private static ArrayList<String> alrtsal5 = new ArrayList<>();
    private static ArrayList<String> alrtent1 = new ArrayList<>();
    private static ArrayList<String> alrtent2 = new ArrayList<>();
    private static ArrayList<String> alrtent3 = new ArrayList<>();
    private static ArrayList<String> alrtent4 = new ArrayList<>();
    private static ArrayList<String> alrtent5 = new ArrayList<>();
    
    public static void ingPeat(String id, String rol) {
        boolean flagi = false, flagv = false;
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
        if (!flagi && !flagv) {
            
            Indiv i = new Indiv();
            i.setId(id);
            i.setRol(rol);
            //arri.add(i);
            va.setVisible(true);
        } else if (flagi)
            via.setVisible(true);
        else if (flagv)
            vav.setVisible(true);
    }

    public static void ingVeh(String id, String placa, String rol) {
        boolean flagv = false, flagi = false;
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
        if (flagv)
            vav.setVisible(true);
        else if (flagi)
            via.setVisible(true);
        else if (!flagi && !flagv) {
            Vehic v = new Vehic();
            v.setId(id);
            v.setPlaca(placa);
            v.setRol(rol);
            //arrv.add(v);
            va.setVisible(true);
        }
    }
    
    public static void alrtSalida(String salida, String id, String placa){
        char numSal=salida.charAt(4);
        String alert="";
        
        switch (numSal){
            case '1':
                alert.concat("Salió el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat("por la salida 1.");
                alrtsal1.add(alert);
                alert="";
                break;
            case '2':
                alert.concat("Salió el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat("por la salida 2.");
                alrtsal2.add(alert);
                alert="";
                break;
            case '3':
                alert.concat("Salió el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat("por la salida 3.");
                alrtsal3.add(alert);
                alert="";
                break;
            case '4':
                alert.concat("Salió el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat("por la salida 4.");
                alrtsal4.add(alert);
                alert="";
                break;
            case '5':
                alert.concat("Salió el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat("por la salida 5.");
                alrtsal5.add(alert);
                alert="";
                break;
            default:
                System.out.println("T'fuck?");
                break;
        }
    }
    
    
    
    public static void alrtEntrda(String entrada, String id, String placa){
        char numSal=entrada.charAt(3);
        String alert="";
        
        switch (numSal){
            case '1':
                alert.concat("Ingresó el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat(" por la entrada 1.");
                alrtent1.add(alert);
                alert="";
                break;
            case '2':
                alert.concat("Ingresó el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat(" por la entrada 2.");
                alrtent2.add(alert);
                alert="";
                break;
            case '3':
                alert.concat("Ingresó el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat(" por la entrada 3.");
                alrtent3.add(alert);
                alert="";
                break;
            case '4':
                alert.concat("Ingresó el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat(" por la entrada 4.");
                alrtent4.add(alert);
                alert="";
                break;
            case '5':
                alert.concat("Ingresó el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat(" por la entrada 5.");
                alrtent5.add(alert);
                alert="";
                break;
            default:
                System.out.println("T'fuck?");
                break;
        }
    }
    
    public static void reporteFinal (){
        File file = new File("reporte.txt"); 
        addRep();
        
        try{
            FileWriter fileW = new FileWriter(file);
            for(String alrt:allalrts)
                fileW.write(alrt);
            fileW.close();
        }catch(IOException e){
            System.out.println("No se pudo crear el archivo. Error: "+e.getMessage());
        }
    }
    
    public static void addRep(){
        //Inicio entradas
        allalrts.add("Entradas:\n - Entrada 1:");
        for(String alrt:alrtent1)
            allalrts.add(alrt);
        allalrts.add(" - Entrada 2:");
        for(String alrt:alrtent2)
            allalrts.add(alrt);
        allalrts.add(" - Entrada 3:");
        for(String alrt:alrtent3)
            allalrts.add(alrt);
        allalrts.add(" - Entrada 4:");
        for(String alrt:alrtent4)
            allalrts.add(alrt);
        allalrts.add(" - Entrada 5:");
        for(String alrt:alrtent5)
            allalrts.add(alrt);
        
        //Fin entradas e inicio salidas
        allalrts.add("Salidas:\n - Salida 1:");
        for(String alrt:alrtsal1)
            allalrts.add(alrt);
        allalrts.add(" - Salida 2:");
        for(String alrt:alrtsal2)
            allalrts.add(alrt);
        allalrts.add(" - Salida 3:");
        for(String alrt:alrtsal3)
            allalrts.add(alrt);
        allalrts.add(" - Salida 4:");
        for(String alrt:alrtsal4)
            allalrts.add(alrt);
        allalrts.add(" - Salida 5:");
        for(String alrt:alrtsal5)
            allalrts.add(alrt);
    }
    
    public static void reporte (String que){
        char num=que.charAt(4);
        String qu=que.substring(0, 3);  
        
        switch (qu){
            case "rent":
                switch (num){
                    case '1':
                        for(String alrt:alrtent1)
                            VTabReporte.listModel.addElement(alrt);
                        break;
                    case '2':
                        for(String alrt:alrtent2)
                            VTabReporte.listModel.addElement(alrt);
                        break;
                    case '3':
                        for(String alrt:alrtent3)
                            VTabReporte.listModel.addElement(alrt);
                        break;
                    case '4':
                        for(String alrt:alrtent4)
                            VTabReporte.listModel.addElement(alrt);
                        break;
                    case '5':
                        for(String alrt:alrtent5)
                            VTabReporte.listModel.addElement(alrt);
                        break;
                    default:
                        System.out.println("ké (ent)");
                        System.exit(1);
                }
                break;
            case "rsal":
                switch (num){
                    case '1':
                        for(String alrt:alrtsal1)
                            VTabReporte.listModel.addElement(alrt);
                        break;
                    case '2':
                        for(String alrt:alrtsal2)
                            VTabReporte.listModel.addElement(alrt);
                        break;
                    case '3':
                        for(String alrt:alrtsal3)
                            VTabReporte.listModel.addElement(alrt);
                        break;
                    case '4':
                        for(String alrt:alrtsal4)
                            VTabReporte.listModel.addElement(alrt);
                        break;
                    case '5':
                        for(String alrt:alrtsal5)
                            VTabReporte.listModel.addElement(alrt);
                        break;
                    default:
                        System.out.println("ké (sal)");
                        System.exit(1);
                }
                break;
            default:
                System.out.println("No hay");
                break;
        }
    }

    public static boolean buscar(String id, String placa) {
        boolean found = false;
        for (Vehic veh : arrve) {
            if (id.equalsIgnoreCase(veh.getId()) && placa.equalsIgnoreCase(veh.getPlaca())) {
                found = true;
                break;
            }
        }for (Vehic veh : arrvn) {
            if (id.equalsIgnoreCase(veh.getId()) && placa.equalsIgnoreCase(veh.getPlaca())) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static boolean noHayGente() {
        if (arrin.isEmpty() && arrvn.isEmpty())
            return true;
        else
            return false;
    }

    public static boolean indF(String id) {
        boolean found = false;
        for (Indiv indiv : arrin) {
            if (id.equalsIgnoreCase(indiv.getId())) {
                found = true;
                break;
            }
        }for (Indiv indiv : arrie) {
            if (id.equalsIgnoreCase(indiv.getId())) {
                found = true;
                break;
            }
        }
        if (!found)
            vni.setVisible(true);
        return found;
    }

    public static void salVeh(String id, String placa) {
        boolean notV = false, wrV = false;
        for (Vehic veh:arrve) {
            if (id.equalsIgnoreCase(veh.getId()) && placa.isEmpty()) {
                notV = true;
                break;
            } else if (id.equalsIgnoreCase(veh.getId()) && placa.equalsIgnoreCase(veh.getPlaca())) {
                vs.setVisible(true);
                arrve.remove(veh);
                break;
            } else if (id.equalsIgnoreCase(veh.getId()) && !placa.equalsIgnoreCase(veh.getPlaca()))
                wrV = true;
        }
        for (Vehic veh:arrvn) {
            if (id.equalsIgnoreCase(veh.getId()) && placa.isEmpty()) {
                notV = true;
                break;
            } else if (id.equalsIgnoreCase(veh.getId()) && placa.equalsIgnoreCase(veh.getPlaca())) {
                vs.setVisible(true);
                arrvn.remove(veh);
                break;
            } else if (id.equalsIgnoreCase(veh.getId()) && !placa.equalsIgnoreCase(veh.getPlaca()))
                wrV = true;
        }
        if (notV)
            ntnv.setVisible(true);
        else if (wrV)
            wv.setVisible(true);
    }

    public static void salPeat(String id) {
        for (Indiv ind:arrie)
            if (id.equalsIgnoreCase(ind.getId())) {
                vs.setVisible(true);
                arrie.remove(ind);
                break;
            }
        for (Indiv ind:arrin)
            if (id.equalsIgnoreCase(ind.getId())) {
                vs.setVisible(true);
                arrin.remove(ind);
                break;
            }
        
    }

    public static void show() {
        for (Indiv ind : arrie)
            System.out.println(ind.getId());
        for (Vehic veh : arrve)
            System.out.println(veh.getId() + "\t" + veh.getPlaca());
    }

}
