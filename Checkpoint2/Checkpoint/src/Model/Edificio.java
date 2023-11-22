package Model;

import java.util.ArrayList;
import View.VIAlready;
import View.VAlreadyV;
import View.VAccepted;
import View.VSalio;
import View.VAlert_vehiEquiv;
import View.VAlert_noIndiv;
import View.VAlert_noTienV;
import View.VAlert_noVehi;
import View.VSecurityLock;
import View.VTabReporte;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.crypto.AEADBadTagException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Edificio {
    private static VIAlready via = new VIAlready();
    private static VAlreadyV vav = new VAlreadyV();
    private static VAccepted va = new VAccepted();
    private static VSalio vs = new VSalio();
    private static VAlert_vehiEquiv wv = new VAlert_vehiEquiv();
    private static VAlert_noIndiv vni = new VAlert_noIndiv();
    private static VAlert_noTienV ntnv = new VAlert_noTienV();
    private static VAlert_noVehi vnv = new VAlert_noVehi();
    private static VSecurityLock vsl = new VSecurityLock();
    
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static String fechaHora = sdf.format(new Date());
    
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
    private static ArrayList<String> alrtseg = new ArrayList<>();
    
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
            if(rol=="visit"){
                Indiv i = new Indiv();
                i.setId(id);
                i.setRol(rol);
                arrin.add(i);
            }
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
                alert.concat("por la salida 1.Fecha y hora: "+fechaHora);
                alrtsal1.add(alert);
                alert="";
                break;
            case '2':
                alert.concat("Salió el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat("por la salida 2.Fecha y hora: "+fechaHora);
                alrtsal2.add(alert);
                alert="";
                break;
            case '3':
                alert.concat("Salió el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat("por la salida 3.Fecha y hora: "+fechaHora);
                alrtsal3.add(alert);
                alert="";
                break;
            case '4':
                alert.concat("Salió el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat("por la salida 4.Fecha y hora: "+fechaHora);
                alrtsal4.add(alert);
                alert="";
                break;
            case '5':
                alert.concat("Salió el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat("por la salida 5.Fecha y hora: "+fechaHora);
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
                alert.concat(" por la entrada 1. Fecha y hora: "+fechaHora);
                alrtent1.add(alert);
                alert="";
                break;
            case '2':
                alert.concat("Ingresó el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat(" por la entrada 2. Fecha y hora: "+fechaHora);
                alrtent2.add(alert);
                alert="";
                break;
            case '3':
                alert.concat("Ingresó el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat(" por la entrada 3. Fecha y hora: "+fechaHora);
                alrtent3.add(alert);
                alert="";
                break;
            case '4':
                alert.concat("Ingresó el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat(" por la entrada 4. Fecha y hora: "+fechaHora);
                alrtent4.add(alert);
                alert="";
                break;
            case '5':
                alert.concat("Ingresó el usuario "+ id);
                if(!placa.isEmpty())
                    alert.concat(" en el vehículo "+placa);
                alert.concat(" por la entrada 5. Fecha y hora: "+fechaHora);
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
        
        //Fin salidas e inicio alertas de seguridad
        allalrts.add("Alertas de seguridad:\n");
        for(String alrt:alrtseg)
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
        boolean notV = true, wrV = false;
        
        
        for (Vehic veh:arrve) {
            if (id.equalsIgnoreCase(veh.getId()) && placa.equalsIgnoreCase(veh.getPlaca())) {
                vs.setVisible(true);
                arrve.remove(veh);
                notV = false;
                break;
            } else if (id.equalsIgnoreCase(veh.getId()) && !placa.equalsIgnoreCase(veh.getPlaca())||placa.equalsIgnoreCase(veh.getPlaca())&&!id.equalsIgnoreCase(veh.getId()))
                wrV = true;
        }
        for (Vehic veh:arrvn) {
            if (id.equalsIgnoreCase(veh.getId()) && placa.equalsIgnoreCase(veh.getPlaca())) {
                vs.setVisible(true);
                arrvn.remove(veh);
                notV = false;
                break;
            } else if (id.equalsIgnoreCase(veh.getId()) && !placa.equalsIgnoreCase(veh.getPlaca())||placa.equalsIgnoreCase(veh.getPlaca())&&!id.equalsIgnoreCase(veh.getId()))
                wrV = true;
        }
        if (notV){
            ntnv.setVisible(true);
            verif();
            alrtseg.add("Un usuario que no tiene vehículo intentó salir por la salida vehicular. Fecha y hora: "+fechaHora);
        }
        else if (wrV){
            wv.setVisible(true);
            alrtseg.add("Un usuario intentó salir con un vehiculo que no le pertenece. Fecha y hora: "+fechaHora);
        }
    }
    
    public static void verif(){
        String cont="123456";
        vsl.setVisible(true);
        if(vsl.txtClave.getText().equals(cont))
            vsl.dispose();
        else {
            int c=1;
            do{
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Le quedan "+(4-c)+" intentos.");
                c++;
            }while(c<4);
            if(c==3){
                alrtseg.add("El sistema se cerró por exceso de intentos. Fecha y hora: "+fechaHora);
                reporteFinal();
                System.exit(0);
            }
        }
    }

    public static void salPeat(String id) {
        boolean noTa=true;
        for (Indiv ind:arrie)
            if (id.equalsIgnoreCase(ind.getId())) {
                vs.setVisible(true);
                arrie.remove(ind);
                noTa=false;
                break;
            }
        for (Indiv ind:arrin)
            if (id.equalsIgnoreCase(ind.getId())) {
                vs.setVisible(true);
                arrin.remove(ind);
                noTa=false;
                break;
            }
        if(noTa){
            vni.setVisible(true);
            alrtseg.add("Un ususario que no existe intentó salir.. Fecha y hora: "+fechaHora);
        }
    }

    public static void show() {
        for (Indiv ind : arrie)
            System.out.println(ind.getId());
        for (Vehic veh : arrve)
            System.out.println(veh.getId() + "\t" + veh.getPlaca());
    }

}
