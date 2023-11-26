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
        VPermEsp vpe = new VPermEsp();
        VAccepted va = new VAccepted();
        VAlreadyU vu = new VAlreadyU();
        VIDNoValid vid = new VIDNoValid();
        VPlacaNoValid vpnv = new VPlacaNoValid();
        VSalio vs = new VSalio();
        VAlert_noIndiv vni = new VAlert_noIndiv();
        VTipoUsSal vtus = new VTipoUsSal();
        VTipoVehSal vtvs = new VTipoVehSal();

        CtlPrn ctp = new CtlPrn(vin, vout, pr, nv, vc, vne);
        CtlVin cin = new CtlVin(vin, vtv, vtu, vpe);
        CtlTipoUs ctu = new CtlTipoUs(va, vpe, vtu, vid);
        CtlTipoVeh ctv = new CtlTipoVeh(vpe, vpnv, vtv, vid);
        CtlSalUs ctsu = new CtlSalUs(vout, vtus, vs, vni, vid, vpe);
        CtlSalVeh ctsv = new CtlSalVeh(vout, vtvs, vs, vni, vid, vpnv, vpe);
        CtlVOut cto = new CtlVOut(vout, vtvs, vtus, vpe);

        pr.setVisible(true);
    }

}
