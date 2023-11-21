package ViewCont;

import Model.Edificio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.VInicial;
import View.VSalio;
import View.VCerrado;
import View.VNoEntry;
import View.VAlert_noVacio;
import View.VPrincipal;
import View.VRep;
import View.VNoEntryYet;

public class CtlPrn implements ActionListener {
    private VInicial in;
    private VSalio out;
    private VPrincipal pr;
    private VAlert_noVacio nv;
    private VCerrado vc;
    private VNoEntry vne;
    private VRep vr;
    private VNoEntryYet ney;

    public CtlPrn(VInicial in, VSalio out, VPrincipal pr, VAlert_noVacio nv, VCerrado vc, VNoEntry vne, VRep vr, VNoEntryYet ney) {
        this.in = in;
        this.out = out;
        this.pr = pr;
        this.nv = nv;
        this.vc = vc;
        this.vne = vne;
        this.vr = vr;
        this.ney = ney;

        this.pr.entBtn.addActionListener(this);
        this.pr.salBtn.addActionListener(this);
        this.pr.cerrBtn.addActionListener(this);
        this.pr.reprBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(pr.entBtn))
            in.setVisible(true);
        else if (e.getSource().equals(pr.cerrBtn))
            if (Edificio.noHayGente())
                vc.setVisible(true);
            else
                nv.setVisible(true);
        else if (e.getSource().equals(pr.salBtn)) {
            Edificio.show();
            if (Edificio.noHayGente())
                vne.setVisible(true);
            else
                out.setVisible(true);
            
        }else if (e.getSource().equals(pr.reprBtn)) {
            vr.setVisible(true);
        }
    }
}