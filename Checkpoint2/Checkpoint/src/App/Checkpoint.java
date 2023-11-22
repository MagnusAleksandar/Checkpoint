package App;

import View.*;
import ViewCont.*;
import Model.*;

public class Checkpoint {

    public static void main(String[] args) {
        Indiv ind = new Indiv();
        Vehic veh = new Vehic();

        VIn vin = new VIn();
        VOut vout = new VOut();
        VPrincipal pr = new VPrincipal();
        VAlert_noVacio nv = new VAlert_noVacio();
        VCerrado vc = new VCerrado();
        VNoEntryYet ney = new VNoEntryYet();
        VRep vr = new VRep();
        VNoEntry vne = new VNoEntry();
        VTipoVeh vtv = new VTipoVeh();
        VTipoUs vtu = new VTipoUs();
        VPermEsp vpesp = new VPermEsp();
        VAccepted va = new VAccepted();
        VAlreadyU vu = new VAlreadyU();
        VIDNoValid vid = new VIDNoValid();
        VPlacaNoValid vpnv = new VPlacaNoValid();
        VSalio vs = new VSalio();
        VAlert_noIndiv vni = new VAlert_noIndiv();
        VTipoUsSal vtus = new VTipoUsSal();
        VTipoVehSal vtvs = new VTipoVehSal();

        CtlPrn ctp = new CtlPrn(vin, vout, pr, nv, vc, vne, vr, ney);
        CtlVin cin = new CtlVin(vin, vtv, vtu, vpesp);
        CtlTipoUs ctu = new CtlTipoUs(va, vu, vpesp, vtu, vid);
        CtlTipoVeh ctv = new CtlTipoVeh(va, vu, vpesp, vpnv, vtv, vid);
        CtlSalUs ctsu = new CtlSalUs(vout, vtus, vs, vni, vid, vpesp);
        CtlSalVeh ctsv = new CtlSalVeh(vout, vtvs, vs, vni, vid, vpnv, vpesp);
        CtlVOut cto = new CtlVOut(vout, vtvs, vtus, vpesp);

        pr.setVisible(true);
    }

}
