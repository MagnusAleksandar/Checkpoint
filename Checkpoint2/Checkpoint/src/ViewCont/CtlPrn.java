package ViewCont;

import Model.Edificio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.VIn;
import View.VOut;
import View.VCerrado;
import View.VNoEntry;
import View.VAlert_noVacio;
import View.VPrincipal;
import View.VRep;
import View.VNoEntryYet;

public class CtlPrn implements ActionListener {
    private VIn vin;
    private VOut out;
    private VPrincipal pr;
    private VAlert_noVacio nv;
    private VCerrado vc;
    private VNoEntry vne;

    public CtlPrn(VIn vin, VOut out, VPrincipal pr, VAlert_noVacio nv, VCerrado vc, VNoEntry vne) {
        this.vin = vin;
        this.out = out;
        this.pr = pr;
        this.nv = nv;
        this.vc = vc;
        this.vne = vne;

        this.pr.entBtn.addActionListener(this);
        this.pr.salBtn.addActionListener(this);
        this.pr.cerrBtn.addActionListener(this);
        this.pr.reprBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(pr.entBtn))
            vin.setVisible(true);
        else if (e.getSource().equals(pr.cerrBtn))
            if (Edificio.noHayGente())
                vc.setVisible(true);
            else
                nv.setVisible(true);
        else if (e.getSource().equals(pr.salBtn)) {
            Edificio.show();
            if (Edificio.noHayAdmon())
                vne.setVisible(true);
            else
                out.setVisible(true);
        } else if (e.getSource().equals(pr.reprBtn))
            Edificio.reporteEntSal();
    }
}